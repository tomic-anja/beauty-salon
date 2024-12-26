/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Appointment;
import domain.Client;
import domain.Employee;
import domain.Treatment;
import java.net.Socket;
import java.util.List;
import logic.Controller;
import server.Server;

/**
 *
 * @author Dell E5450
 */
public class ClientThread extends Thread {

    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private Employee employee;
    private Server server;
    private boolean end = false;

    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
        this.server = server;
    }

    @Override
    public void run() {

        while (!end) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Employee employee = (Employee) request.getArgument();
                            //Proveri da li employee vec ne postoji u listi
                            if (server.notLogin(employee)) {
                                response.setResult(controller.login(employee));
                                this.employee = employee;
                            } else {
                                throw new Exception("User je vec prijavljen.");
                                //to do
                            }
                            break;

                        case GET_ALL_CLIENTS:
                            response.setResult(controller.getAllClients());
                            break;
                        case ADD_CLIENT:
                            Client client = (Client) request.getArgument();
                            controller.createClient(client);
                            response.setResult(client);
                            break;
                        case UPDATE_CLIENT:
                            Client updatedClient = (Client) request.getArgument();
                            controller.updateClient(updatedClient);
                            response.setResult(updatedClient);
                            break;
                        case DELETE_CLIENT:
                            Client selectedClient = (Client) request.getArgument();
                            controller.deleteClient(selectedClient);
                            response.setResult(selectedClient);
                            break;
                        case GET_ALL_TREATMENT:
                            response.setResult(controller.getAllTreatment());
                            break;
                        case ADD_TREATMENT:
                            Treatment treatment = (Treatment) request.getArgument();
                            controller.createTreatment(treatment);
                            response.setResult(treatment);
                            break;
                        case UPDATE_TREATMENT:
                            Treatment updatedTreatment = (Treatment) request.getArgument();
                            controller.updateTreatment(updatedTreatment);
                            response.setResult(updatedTreatment);
                            break;
                        case DELETE_TREATMENT:
                            Treatment selectedTreatment = (Treatment) request.getArgument();
                            controller.deleteTreatment(selectedTreatment);
                            response.setResult(selectedTreatment);
                            break;
                        case GET_APPOINTMENT_BY_REQUIREMENT:
                            Appointment appointment = (Appointment) request.getArgument();
                            response.setResult(controller.getAppointmentsByRequirement(appointment));
                            break;
                        case ADD_APPOINTMENT:
                            try {
                            List<Appointment> appointments = (List<Appointment>) request.getArgument();
                            controller.addAppointments(appointments);
                            response.setResult(appointments);
                        } catch (Exception e) {
                            throw e;
                        }
                        break;
                        case UPDATE_APPOINTMENT:
                            List<Appointment> appointments1 = (List<Appointment>) request.getArgument();
                            controller.updateAppointments(appointments1);
                            response.setResult(appointments1);
                            break;
                        case GET_ALL_HALLS:
                            response.setResult(controller.getAllHalls());
                            break;
                        case LOGOUT:
                            setEmployee(null);
                            end = true;
                            break;
//                        case STOP_SERVER:
//                            end = true;
//                            break;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public Employee getLoginUser() {
        return employee;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

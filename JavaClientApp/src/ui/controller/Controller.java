/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Appointment;
import domain.Client;
import domain.Employee;
import domain.Hall;
import domain.Treatment;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class Controller {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        Request request = new Request(Operation.LOGIN, employee);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Employee) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Client> getAllClients() throws Exception {
        Request request = new Request(Operation.GET_ALL_CLIENTS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Client>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void createClient(Client client) throws Exception {
        Request request = new Request(Operation.ADD_CLIENT, client);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            client.setClientID(((Client) response.getResult()).getClientID());
        } else {
            throw response.getException();
        }
    }

    public void updateClient(Client selectedClient) throws Exception {
        Request request = new Request(Operation.UPDATE_CLIENT, selectedClient);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            selectedClient.setClientID(((Client) response.getResult()).getClientID());
        } else {
            throw response.getException();
        }

    }

    public void deleteClient(Client selectedClient) throws Exception {
        Request request = new Request(Operation.DELETE_CLIENT, selectedClient);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public Client searchClient(long phoneNumber) throws Exception {
        Request request = new Request(Operation.SEARCH_CLIENT, phoneNumber);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Client) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Treatment> getAllTreatment() throws Exception {
        Request request = new Request(Operation.GET_ALL_TREATMENT, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Treatment>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void createTreatment(Treatment treatment) throws Exception {
        Request request = new Request(Operation.ADD_TREATMENT, treatment);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            treatment.setTreatmentID(((Treatment) response.getResult()).getTreatmentID());
        } else {
            throw response.getException();
        }
    }

    public void updateTreatment(Treatment selectedTreatment) throws Exception {
        Request request = new Request(Operation.UPDATE_TREATMENT, selectedTreatment);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            selectedTreatment.setTreatmentID(((Treatment) response.getResult()).getTreatmentID());
        } else {
            throw response.getException();
        }
    }

    public void deleteTreatment(Treatment selectedTreatment) throws Exception {
        Request request = new Request(Operation.DELETE_TREATMENT, selectedTreatment);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public List<Appointment> getAppointmentsByRequirement(Appointment appointment) throws Exception {
        Request request = new Request(Operation.GET_APPOINTMENT_BY_REQUIREMENT, appointment);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Appointment>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addAppointment(Appointment appointment) throws Exception {
        Request request = new Request(Operation.ADD_APPOINTMENT, appointment);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            appointment.setAppointmentID(((Appointment) response.getResult()).getAppointmentID());
        } else {
            throw response.getException();
        }
    }

    public List<Hall> getAllHalls() throws Exception {
        Request request = new Request(Operation.GET_ALL_HALLS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Hall>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addAppointments(List<Appointment> appointmentsForClient) throws Exception {
        Request request = new Request(Operation.ADD_APPOINTMENT, appointmentsForClient);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            int i = 0;
            for (Appointment appointment : appointmentsForClient) {
                List<Appointment> a = (List<Appointment>) response.getResult();
                appointment.setAppointmentID(a.get(i).getAppointmentID());
                i++;
            }
        } else {
            throw response.getException();
        }
    }

    public void logout() throws Exception {
        Request request = new Request(Operation.LOGOUT, null);
        sender.send(request);

    }

    public void updateAppointments(List<Appointment> allAppointmentsForUpdate) throws Exception {
        Request request = new Request(Operation.UPDATE_APPOINTMENT, allAppointmentsForUpdate);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

}

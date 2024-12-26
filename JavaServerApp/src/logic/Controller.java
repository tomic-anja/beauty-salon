/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Appointment;
import domain.Client;
import domain.Employee;
import domain.Hall;
import domain.Treatment;
import java.util.List;
import so.AddAppointment;
import so.DeleteClient;
import so.DeleteTreatment;
import so.GetAllClients;
import so.GetAllHalls;
import so.GetAllTreatment;
import so.GetAppointmentsByRequirement;
import so.LoginUser;
import so.SaveClient;
import so.SaveTreatment;
import so.UpdateAppointment;
import so.UpdateClient;
import so.UpdateTreatment;

/**
 *
 * @author Dell E5450
 */
public class Controller {

    public Employee login(Employee employee) throws Exception {
        LoginUser loginUser = new LoginUser();
        loginUser.execute(employee);
        return loginUser.getEmployee();
    }

    public Object getAllClients() throws Exception {
        GetAllClients getAllClients = new GetAllClients();
        getAllClients.execute(new Client());
        return getAllClients.getClients();
    }

    public void createClient(Client client) throws Exception {
        SaveClient saveClient = new SaveClient();
        saveClient.execute(client);
    }

    public void updateClient(Client updatedClient) throws Exception {
        UpdateClient updateClient = new UpdateClient();
        updateClient.execute(updatedClient);
    }

    public void deleteClient(Client selectedClient) throws Exception {
        DeleteClient deleteClient = new DeleteClient();
        deleteClient.execute(selectedClient);
    }

    public Object getAllTreatment() throws Exception {
        GetAllTreatment getAllTreatment = new GetAllTreatment();
        getAllTreatment.execute(new Treatment());
        return getAllTreatment.getTreatments();
    }

    public void createTreatment(Treatment treatment) throws Exception {
        SaveTreatment saveTreatment = new SaveTreatment();
        saveTreatment.execute(treatment);
    }

    public void updateTreatment(Treatment updatedTreatment) throws Exception {
        UpdateTreatment updateTreatment = new UpdateTreatment();
        updateTreatment.execute(updatedTreatment);
    }

    public void deleteTreatment(Treatment selectedTreatment) throws Exception {
        DeleteTreatment deleteTreatment = new DeleteTreatment();
        deleteTreatment.execute(selectedTreatment);
    }

    public Object getAppointmentsByRequirement(Appointment appointment) throws Exception {
        GetAppointmentsByRequirement getAppointmentsByRequirement = new GetAppointmentsByRequirement();
        getAppointmentsByRequirement.execute(appointment);
        return getAppointmentsByRequirement.getAppointments();
    }

    public void addAppointment(Appointment appointment1) throws Exception {
        AddAppointment addAppointment = new AddAppointment();
        addAppointment.execute(appointment1);
    }

    public Object getAllHalls() throws Exception {
        GetAllHalls getAllHalls = new GetAllHalls();
        getAllHalls.execute(new Hall());
        return getAllHalls.getHalls();
    }

    public void addAppointments(List<Appointment> appointments) throws Exception {
        try {
            AddAppointment addAppointment = new AddAppointment();
            addAppointment.execute(appointments);

        } catch (Exception e) {
            throw e;
        }
    }

    public void updateAppointments(List<Appointment> appointments1) throws Exception {
        try {
            UpdateAppointment updateAppointment = new UpdateAppointment();
            updateAppointment.execute(appointments1);
        } catch (Exception e) {
            throw e;
        }
    }
}

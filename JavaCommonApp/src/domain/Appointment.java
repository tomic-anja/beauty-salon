/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class Appointment extends DomainObject implements Serializable {

    private int appointmentID;
    private LocalDate date;
    private LocalTime time;
    private int duration;

    private Hall hall;
    private Client client;
    private Treatment treatment;

    public Appointment() {
    }

    public Appointment(int appointmentID, LocalDate date, LocalTime time, int duration, Hall hall, Client client, Treatment treatment) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.hall = hall;
        this.client = client;
        this.treatment = treatment;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentID=" + appointmentID + ", date=" + date + ", time=" + time + ", duration=" + duration + ", hall=" + hall + ", client=" + client + ", treatment=" + treatment + '}';
    }

    @Override
    public String getTableName() {
        return "appointment";
    }

    @Override
    public String getColumnsForInsert() {
        return "treatmentID, clientID, date, time, duration, hallID";
    }

    @Override
    public String getParamsForInsert() {
//        return "(?,?,?,?,?,?) INNER JOIN client c ON c.clientID = a.clientID INNER JOIN treatment t ON t.treatmentID = a.treatmentID INNER JOIN hall h ON h.hallID = a.hallID";
        return "(?,?,?,?,?,?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "treatmentID = ?, clientID = ?, date = ?, time = ?, duration = ?, hallID = ? WHERE appointmentID = ?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Appointment) {

            Appointment appointment = (Appointment) domainObject;
            statement.setInt(1, appointment.getTreatment().getTreatmentID());
            statement.setInt(2, appointment.getClient().getClientID());
            statement.setDate(3, java.sql.Date.valueOf(appointment.getDate()));
            statement.setTime(4, Time.valueOf(appointment.getTime()));
            statement.setInt(5, appointment.getDuration());
            statement.setInt(6, appointment.getHall().getHallID());

        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Appointment.");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Appointment) {
            Appointment updatedAppointment = (Appointment) domainObject;
            statement.setInt(1, updatedAppointment.getTreatment().getTreatmentID());
            statement.setInt(2, updatedAppointment.getClient().getClientID());
            statement.setDate(3, java.sql.Date.valueOf(updatedAppointment.getDate()));
            statement.setTime(4, Time.valueOf(updatedAppointment.getTime()));
            statement.setInt(5, updatedAppointment.getDuration());
            statement.setInt(6, updatedAppointment.getHall().getHallID());
            statement.setInt(7, updatedAppointment.getAppointmentID());
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setAppointmentID(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs, DomainObject domainObject) throws SQLException {
        Appointment appointment = new Appointment();
        if (domainObject instanceof Appointment) {
            appointment = (Appointment) domainObject;
        }

        List<DomainObject> appointments = new ArrayList<>();
        while (rs.next()) {
            Appointment appointment1 = new Appointment();

            appointment1.setAppointmentID(rs.getInt("appointmentID"));
            appointment1.setDate(appointment.getDate());
//            appointment1.setDate(LocalDate.valueOf(rs.getDate("date")) );
//            appointment1.setDate(Loc);

            Treatment treatment = new Treatment();
            treatment.setTreatmentID(rs.getInt("treatmentID"));
            treatment.setPrice(rs.getLong("t.price"));
            treatment.setTreatmentType(TreatmentType.valueOf(rs.getString("t.treatmentType")));

            appointment1.setTreatment(treatment);

            Client client = new Client();
            client.setClientID(rs.getInt("c.clientID"));
            client.setName(rs.getString("c.name"));
            client.setSurname(rs.getString("c.surname"));

            appointment1.setClient(client);

            Hall hall = new Hall(rs.getInt("h.hallID"), rs.getString("h.adress"), rs.getInt("h.floor"));
            appointment1.setHall(hall);

            appointment1.setDuration(rs.getInt("duration"));

            appointment1.setTime(rs.getTime("time").toLocalTime());

            appointments.add(appointment1);
        }

        return (List<DomainObject>) appointments;
    }

    @Override
    public String getParamsForSelect() {
        return "*";
    }

    @Override
    public DomainObject getParamsForSelect1(ResultSet rs, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Appointment) {
            Appointment appointment = (Appointment) domainObject;
            statement.setDate(1, Date.valueOf(appointment.getDate()));

        }

    }

    @Override
    public String getParamsForInnerJoin() {
        return "appointment a INNER JOIN client c ON a.clientID = c.clientID INNER JOIN treatment t ON a.treatmentID = t.treatmentID INNER JOIN hall h ON a.hallID = h.hallID WHERE a.date = ? ORDER BY a.time";
    }

    @Override
    public List<DomainObject> getParamsForSelect1(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableNameForAdd() {
        return "appointment";
    }

}

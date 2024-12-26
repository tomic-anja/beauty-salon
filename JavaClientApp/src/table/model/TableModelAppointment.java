/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Appointment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dell E5450
 */
public class TableModelAppointment extends AbstractTableModel {

    private List<Appointment> appointments = new ArrayList<>();
    private String[] columns = {"Date", "Treatment", "Client", "Time", "Hall"};

    public TableModelAppointment(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public int getRowCount() {
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appointment = appointments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return appointment.getDate();
            case 1:
                return appointment.getTreatment();
            case 2:
                return appointment.getClient().getName() + " " + appointment.getClient().getSurname();
            case 3:
                return appointment.getTime();
            case 4:
                return appointment.getHall();

            default:
                return "n/a";
        }
    }

}

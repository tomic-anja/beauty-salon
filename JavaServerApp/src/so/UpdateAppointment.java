/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Appointment;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class UpdateAppointment extends AbstractSO {

    public UpdateAppointment() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<Appointment> a = (List<Appointment>) object;

        // Postavi ID samo za jednu rezervaciju
//        a.get(1).setAppointmentID(2);
        try {
            for (Appointment appointment : a) {
                // Ako ne uspe azuriranje jedne rezervacije, izbaci izuzetak
                if (!databaseBroker.update(appointment)) {
                    throw new Exception("Neuspesno azuriranje rezervacije u bazi!");

                }
            }

            // Ako sve rezervacije prođu, commituj transakciju
            committ();
        } catch (Exception ex) {
            // Ako dođe do izuzetka, rollbackuj transakciju
            rollbackk();
            throw ex;
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        List<Appointment> a = (List<Appointment>) object;

        for (Appointment appointment : a) {
            if (!(appointment instanceof Appointment)) {
                throw new Exception("Object is not valid");
            }

            if (appointment.getHall() == null) {
                throw new Exception("Hall is empty");
            }

            if (appointment.getDate().isBefore(LocalDate.now())) {
                throw new Exception("Date is not valid");
            }
        }
    }

    private void committ() throws SQLException {
        databaseBroker.getConnection().commit();
    }

    private void rollbackk() throws SQLException {
        databaseBroker.getConnection().rollback();
    }

}

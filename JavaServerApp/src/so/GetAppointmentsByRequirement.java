/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Appointment;
import domain.Client;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class GetAppointmentsByRequirement extends AbstractSO {

    private List<Appointment> appointments;

    public GetAppointmentsByRequirement() throws Exception {
        super();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAppointmentsByRequirement1((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        appointments = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Appointment) {
                appointments.add((Appointment) domainObject);
            }
        }

        if (appointments.isEmpty()) {
//            throw new Exception("Rezervacije ne postoje.");
        }

    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Appointment)) {
            throw new Exception("Object is not valid");
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Treatment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class GetAllTreatment extends AbstractSO {

    private List<Treatment> treatments;

    public GetAllTreatment() throws Exception {
        super();
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
//        treatments = databaseBroker.getTreatments();
//        if (treatments == null) {
//            throw new Exception("Klijenti ne postoje.");
//        }

        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        treatments = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Treatment) {
                treatments.add((Treatment) domainObject);
            }
        }

        if (treatments.isEmpty()) {
            throw new Exception("Tretmani ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Treatment)) {
            throw new Exception("Object is not valid");
        }
    }

}

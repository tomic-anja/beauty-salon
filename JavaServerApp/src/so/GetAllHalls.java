/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Hall;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class GetAllHalls extends AbstractSO {

    private List<Hall> halls;

    public GetAllHalls() throws Exception {
        super();
    }

    public List<Hall> getHalls() {
        return halls;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
//        halls = databaseBroker.getHalls();
//        if (halls == null) {
//            throw new Exception("Klijenti ne postoje.");
//        }
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        halls = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Hall) {
                halls.add((Hall) domainObject);
            }
        }

        if (halls.isEmpty()) {
            throw new Exception("Sale ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Hall)) {
            throw new Exception("Object is not valid");
        }
    }

}

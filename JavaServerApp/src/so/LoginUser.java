/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Employee;

/**
 *
 * @author Dell E5450
 */
public class LoginUser extends AbstractSO {

    private Employee employee;

    public LoginUser() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {

        DomainObject domainObject = databaseBroker.getUser1((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
//        Employee employee = new Employee();
        if (domainObject instanceof Employee) {
            employee = (Employee) domainObject;
        }

//        if (treatments.isEmpty()) {
//            throw new Exception("Tretmani ne postoje.");
//        }
//        employee = databaseBroker.getUser((Employee) object);
//        if (employee == null) {
//            throw new Exception("Korisnik ne postoji.");
//        }
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Employee)) {
            throw new Exception("Object is not valid");
        }
    }

}

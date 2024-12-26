/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Client;

/**
 *
 * @author Dell E5450
 */
public class UpdateClient extends AbstractSO {

    public UpdateClient() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.update((Client) object);

    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Client)) {
            throw new Exception("Object is not valid");
        }

        //dodatno izvrsi validaciju na vrednosti
        Client client = (Client) object;
        if (client.getName().isEmpty()) {
            throw new Exception("Name is empty");
        }
        if (client.getSurname().isEmpty()) {
            throw new Exception("Surname is empty");
        }
    }

}

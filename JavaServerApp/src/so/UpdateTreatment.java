/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Treatment;

/**
 *
 * @author Dell E5450
 */
public class UpdateTreatment extends AbstractSO {

    public UpdateTreatment() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.update((Treatment) object);

    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Treatment)) {
            throw new Exception("Object is not valid");
        }

        Treatment treatment = (Treatment) object;
        if (treatment.getTreatmentType() == null) {
            throw new Exception("Treatment type is empty");
        }

        if (treatment.getPrice() == 0) {
            throw new Exception("Price is empty");
        }

    }
}

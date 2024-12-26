/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import java.sql.SQLException;
import repository.db.DatabaseBroker;
import repository.db.DatabaseConnection;

/**
 *
 * @author Dell E5450
 */
public abstract class AbstractSO {

    protected DatabaseBroker databaseBroker;

    public AbstractSO() throws Exception {
        databaseBroker = new DatabaseBroker(DatabaseConnection.getInstance().pop());
    }

    public void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            committ();
        } catch (Exception ex) {
            rollbackk();
            throw ex;
        }
    }

    private void committ() throws SQLException {
        databaseBroker.getConnection().commit();
    }

    private void rollbackk() throws SQLException {
        databaseBroker.getConnection().rollback();
    }

    protected abstract void executeOperation(Object object) throws Exception;

    protected abstract void validate(Object object) throws Exception;
}

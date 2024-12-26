/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so;

import domain.Client;
import domain.DomainObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import repository.db.DatabaseBroker;
import repository.db.DatabaseConnection;

/**
 * Unit tests for SaveClient class.
 */
public class SaveClientTest {

    private SaveClient so;
    private Client client;
    private DatabaseBroker db;
    private Connection connection;
    private int sizeBefore;
    private int sizeAfter;

    public SaveClientTest() {
        try {
            String url = "jdbc:mysql://localhost:3306/ps_project";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
            DatabaseConnection.getInstance().push(connection);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db = new DatabaseBroker(connection);
    }

    @Before
    public void setUp() throws Exception {
        ArrayList<DomainObject> clientsBefore = new ArrayList<>();

        Client clientS = new Client();
        clientS.setName(null);
        List<DomainObject> results = db.getAll(clientS);

        for (DomainObject object : results) {
            Client newClient = (Client) object;
            clientsBefore.add(newClient);
        }

        sizeBefore = clientsBefore.size();
        System.out.println("Size before: " + sizeBefore);

        client = new Client();
        client.setClientID(99);
        client.setName("Name");
        client.setSurname("Surname");
        client.setPhoneNumber(Long.parseLong("631115501"));

        so = new SaveClient();
        so.validate(client);  // validate before executeOperation
        so.executeOperation(client);

        assertNotNull(client.getClientID());
        assertTrue(client.getClientID() > 0);
    }

    @Test
    public void testExecuteOperation() throws Exception {
        connection.rollback();

        ArrayList<DomainObject> clientsBefore = new ArrayList<>();
        Client client2 = new Client();
        client2.setName(null);
        List<DomainObject> results2 = db.getAll(client2);

        for (DomainObject object : results2) {
            Client newClient = (Client) object;
            clientsBefore.add(newClient);
        }

        sizeBefore = clientsBefore.size();
        System.out.println("Size before: " + sizeBefore);
        db.add(new Client(99, "Name", "Surname", Long.MIN_VALUE, null));

        clientsBefore.clear();
        results2 = db.getAll(client2);

        for (DomainObject object : results2) {
            Client newClient = (Client) object;
            clientsBefore.add(newClient);
        }

        sizeAfter = clientsBefore.size();
        System.out.println("Size after: " + sizeAfter);
        assertEquals("Expected size to be " + (sizeBefore + 1) + " but was " + sizeAfter, sizeBefore + 1, sizeAfter);
    }

    @Test
    public void testValidate() throws Exception {
        assertThrows(Exception.class, () -> {
            so.validate(new Object());
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Dell E5450
 */
public class DatabaseConnection {

    private List<Connection> connectionPool;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 50; i++) {    //promenila sa 10
            try {
                //String url = "jdbc:mysql://localhost/ps_project";
                //String user = "root";
                //String password = "";

                InputStream input = DatabaseConnection.class.getResourceAsStream("/database.properties");
                Properties properties = new Properties();
                try {
                    properties.load(input);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(DatabaseConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                String url = properties.getProperty("database.url");
                String user = properties.getProperty("database.user");
                String password = properties.getProperty("database.password");

                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");

                //iskljucujem automatsko potvrdjivanje transakcije nakon svakog upita
                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
}

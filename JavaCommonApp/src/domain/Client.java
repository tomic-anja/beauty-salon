/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dell E5450
 */
public class Client extends DomainObject implements Serializable {

    private int clientID;
    private String name;
    private String surname;
    private Long phoneNumber;

    public Client() {
    }

    public Client(int clientID, String name, String surname, Long phoneNumber, List<Appointment> appointments) {
        this.clientID = clientID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        return this.clientID == other.clientID;
    }

    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnsForInsert() {
        return "name, surname, phoneNumber";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setLong(3, client.getPhoneNumber());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setClientID(primaryKey);
    }

    @Override
    public String getParamsForUpdate() {
        return "name=?, surname=?, phoneNumber=?  WHERE clientID = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setLong(3, client.getPhoneNumber());
            statement.setInt(4, client.getClientID());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Client) {
            Client client = (Client) domainObject;
            statement.setInt(1, client.getClientID());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Client.");
        }
    }

    public boolean equals(DomainObject obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        return Objects.equals(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public String getParamsForDelete() {
        return " WHERE clientID = ?";
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect1(ResultSet rs) throws SQLException {
        List<DomainObject> clients = new ArrayList<>();

        while (rs.next()) {
            Client client = new Client();
            client.setClientID(rs.getInt("clientID"));
            client.setName(rs.getString("name"));
            client.setSurname(rs.getString("surname"));
            client.setPhoneNumber(rs.getLong("phoneNumber"));

            clients.add(client);
        }

        return (List<DomainObject>) clients;
    }

    @Override
    public String getParamsForSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect1(ResultSet rs, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInnerJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableNameForAdd() {
        return "client";
    }

}

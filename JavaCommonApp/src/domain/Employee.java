/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dell E5450
 */
public class Employee extends DomainObject implements Serializable {

    private Long employeeID;
    private String username;
    private String password;
    private String name;
    private String surname;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String getTableName() {
        return "employee";
    }

    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "employeeID, username, password, name, surname";
    }

    @Override
    public String getParamsForSelect() {
        return "username=? AND password=?";
    }

//    @Override
//    public DomainObject getParamsForSelect1(ResultSet rs, DomainObject domainObject) throws Exception {
//        if (domainObject instanceof Employee) {
//            Employee employee = (Employee) domainObject;
//            if (rs.next()) {
//                employee.setEmployeeID(rs.getLong("employeeID"));
//                employee.setName(rs.getString("name"));
//                employee.setSurname(rs.getString("surname"));
//            } else {
//                employee = null;
//            }
//
//        }
//
//    }
    @Override
    public DomainObject getParamsForSelect1(ResultSet rs, DomainObject domainObject) throws SQLException {
        Employee employee = new Employee();
        if (domainObject instanceof Employee) {
            employee = (Employee) domainObject;
            if (rs.next()) {
                employee.setEmployeeID(rs.getLong("employeeID"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
            } else {
                employee = null;
            }

        }
        return (DomainObject) employee;
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Employee) {
            Employee employee = (Employee) domainObject;
            statement.setString(1, employee.getUsername());
            statement.setString(2, employee.getPassword());
        }
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
    public List<DomainObject> getParamsForSelect1(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableNameForAdd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

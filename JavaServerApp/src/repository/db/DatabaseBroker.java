/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import domain.DomainObject;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Dell E5450
 */
public class DatabaseBroker {

    private final Connection connection;

    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public DomainObject getUser1(DomainObject domainObject) throws SQLException {
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName() + " WHERE " + domainObject.getParamsForSelect();
            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query);

            domainObject.setParamsForSelect(statement, domainObject);

            ResultSet rs = statement.executeQuery();

            DomainObject domainObject1 = domainObject.getParamsForSelect1(rs, domainObject);

            rs.close();
            statement.close();

            System.out.println("Uspesno ucitavanje objekta User iz baze!");
            return domainObject1;
        } catch (SQLException ex) {
            System.out.println("Objekat User nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAll(DomainObject domainObject) throws Exception {
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName();
            System.out.println("Upit: " + query);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            List<DomainObject> list = domainObject.getParamsForSelect1(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Objekti nisu uspesno ucitani iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean add(DomainObject domainObject) throws SQLException {
        try {
            String query = "INSERT INTO " + domainObject.getTableNameForAdd() + " (" + domainObject.getColumnsForInsert() + ") VALUES " + domainObject.getParamsForInsert();

            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //postavljanje vrednosti parametara
            domainObject.setParamsForInsert(statement, domainObject);

            //izvsi upit
            int result = statement.executeUpdate();

            if (result > 0) {
                ResultSet rsID = statement.getGeneratedKeys();
                if (rsID.next()) {
                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
                }
                rsID.close();
                statement.close();

                return true;  // Ažuriranje uspešno
            } else {
                statement.close();

                return false;  // Ažuriranje neuspešno
            }

            //pristup generisanom kljucu
//            if (domainObject.containsAutoIncrementPK()) {
//                ResultSet rsID = statement.getGeneratedKeys();
//                if (rsID.next()) {
//                    //person.setPersonID(rsID.getLong(1));
//                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
//                }
//                rsID.close();
//            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean update(DomainObject domainObject) throws SQLException {
        try {
            String query = "UPDATE " + domainObject.getTableName() + " SET " + domainObject.getParamsForUpdate();

            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            domainObject.setParamsForUpdate(statement, domainObject);

            //izvsi upit
            int result = statement.executeUpdate();

            if (result > 0) {
//                System.out.println("Rezervacija uspešno ažurirana u bazi!");
                statement.close();
                return true;  // Ažuriranje uspešno
            } else {
                System.out.println("Rezervacija nije pronađena.");
                statement.close();
                return false;  // Ažuriranje neuspešno
            }
            //pristup generisanom kljucu
//            if (domainObject.containsAutoIncrementPK()) {
//                ResultSet rsID = statement.getGeneratedKeys();
//                if (rsID.next()) {
//                    //person.setPersonID(rsID.getLong(1));
//                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
//                }
//                rsID.close();
//            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void delete(DomainObject domainObject) throws SQLException {
        try {
            String query = "DELETE FROM " + domainObject.getTableName() + domainObject.getParamsForDelete();

            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            domainObject.setParamsForDelete(statement, domainObject);

            int result = statement.executeUpdate();

            System.out.println("Objekat uspesno izbrisan iz baze!");

//            if (domainObject.containsAutoIncrementPK()) {
//                ResultSet rsID = statement.getGeneratedKeys();
//                if (rsID.next()) {
//                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
//                }
//                rsID.close();
//            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno brisanje objekta iz baze!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAppointmentsByRequirement1(DomainObject domainObject) {
        try {

            //GET ALL ALI DA VRACA ZA  INNER JOIN PRAZAN STRING
            String query = "SELECT " + domainObject.getParamsForSelect() + " FROM " + domainObject.getParamsForInnerJoin();
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query);

            domainObject.setParamsForSelect(statement, domainObject);

//            statement.setInt(2, appointment.getTreatment().getTreatmentID());
            //izvsi upit
            ResultSet rs = statement.executeQuery();

            List<DomainObject> list = domainObject.getParamsForSelect(rs, domainObject);

            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata Appointment iz baze!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Objekti Appointment nisu uspesno ucitani iz baze!");
        }
        return null;
    }

}

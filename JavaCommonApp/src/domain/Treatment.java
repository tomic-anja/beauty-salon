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

/**
 *
 * @author Dell E5450
 */
public class Treatment extends DomainObject implements Serializable {

    private int treatmentID;
    private TreatmentType treatmentType;
    private double price;

    public Treatment() {
    }

    public Treatment(int treatmentID, TreatmentType treatmentType, double price) {
        this.treatmentID = treatmentID;
        this.treatmentType = treatmentType;
        this.price = price;
    }

    public int getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return treatmentType + "";
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
        final Treatment other = (Treatment) obj;
        if (this.treatmentID != other.treatmentID) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return this.treatmentType == other.treatmentType;
    }

    @Override
    public String getTableName() {
        return "treatment";
    }

    @Override
    public String getColumnsForInsert() {
        return "treatmentType, price";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "treatmentType=?, price=? WHERE treatmentID=?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Treatment) {
            Treatment treatment = (Treatment) domainObject;
            statement.setString(1, treatment.getTreatmentType().toString());
            statement.setDouble(2, treatment.getPrice());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Treatment.");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Treatment) {
            Treatment treatment = (Treatment) domainObject;
            statement.setString(1, treatment.getTreatmentType().toString());
            statement.setDouble(2, treatment.getPrice());
            statement.setInt(3, treatment.getTreatmentID());

        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Treatment.");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Treatment) {
            Treatment treatment = (Treatment) domainObject;
            statement.setInt(1, treatment.getTreatmentID());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Treatment.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setTreatmentID(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        return " WHERE treatmentID = ?";
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
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
    public List<DomainObject> getParamsForSelect1(ResultSet rs) throws Exception {
        List<DomainObject> treatments = new ArrayList<>();

        while (rs.next()) {
            Treatment treatment = new Treatment();

            treatment.setTreatmentID(rs.getInt("treatmentID"));
            treatment.setTreatmentType(TreatmentType.valueOf(rs.getString("treatmentType")));
            treatment.setPrice(rs.getDouble("price"));

            treatments.add(treatment);
        }

        return (List<DomainObject>) treatments;
    }

    @Override
    public String getTableNameForAdd() {
        return "treatment";
    }

}

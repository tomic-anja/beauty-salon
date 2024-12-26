/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Treatment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dell E5450
 */
public class TableModelTreatment extends AbstractTableModel {

    private List<Treatment> treatments = new ArrayList<>();
    private String[] columns = {"Treatment type", "Price"};

    public TableModelTreatment(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    @Override
    public int getRowCount() {
        return treatments.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Treatment treatment = treatments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return treatment.getTreatmentType().toString();
            case 1:
                return treatment.getPrice() + "";

            default:
                return "n/a";
        }
    }

}

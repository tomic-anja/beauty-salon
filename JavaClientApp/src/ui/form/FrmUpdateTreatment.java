/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import domain.Treatment;
import domain.TreatmentType;
import javax.swing.JOptionPane;
import ui.controller.Controller;

/**
 *
 * @author Dell E5450
 */
public class FrmUpdateTreatment extends javax.swing.JFrame {

    /**
     * Creates new form FrmUpdateClient
     */
    private Treatment selectedTreatment;
    private FrmTreatment frmTreatment;

    public FrmUpdateTreatment(FrmTreatment frmTreatment) {
        initComponents();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.frmTreatment = frmTreatment;
        selectedTreatment = frmTreatment.getSelectedTreatment();
        fillForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        cmbTreatmentType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancel.setBackground(new java.awt.Color(214, 52, 132));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(64, 43, 58));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 155, 210));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(64, 43, 58));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(214, 52, 132));
        jLabel1.setText("Treatment type");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(214, 52, 132));
        jLabel2.setText("Price");

        cmbTreatmentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOKTI", "FRIZURA", "SMINKA", "DEPILACIJA" }));
        cmbTreatmentType.setSelectedIndex(-1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrice)
                                    .addComponent(cmbTreatmentType, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTreatmentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addGap(11, 11, 11)
                .addComponent(lblID))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (cmbTreatmentType.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Izaberite tip tretmana", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            TreatmentType tp = TreatmentType.valueOf((String) cmbTreatmentType.getSelectedItem());

            if (txtPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite cenu", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtPrice.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Cena mora imati samo brojeve", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }

            selectedTreatment.setTreatmentType(tp);
            selectedTreatment.setPrice(Double.parseDouble(txtPrice.getText()));

            Controller.getInstance().updateTreatment(selectedTreatment);
            JOptionPane.showMessageDialog(this, "Treatment saved!\nGenerated ID: [" + selectedTreatment.getTreatmentID() + "]", "Update Client", JOptionPane.INFORMATION_MESSAGE);

            frmTreatment.fillTable();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Person not saved!\n" + ex.getMessage(), "Create Person", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbTreatmentType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    private void fillForm() {
        cmbTreatmentType.setSelectedItem(selectedTreatment.getTreatmentType().toString());
        txtPrice.setText(selectedTreatment.getPrice() + "");

    }
}

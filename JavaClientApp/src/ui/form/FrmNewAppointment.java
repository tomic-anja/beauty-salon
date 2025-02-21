/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import domain.Appointment;
import domain.Client;
import domain.Hall;
import domain.Treatment;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import table.model.TableModelAppointment;
import ui.form.dateformatter.DateLabelFormatter;
import ui.controller.Controller;

/**
 *
 * @author Dell E5450
 */
public class FrmNewAppointment extends javax.swing.JFrame {

    /**
     * Creates new form FrmSearchTreatment1
     */
    JDatePickerImpl datePicker;
    UtilDateModel model;
    List<Appointment> appointments = new ArrayList<>();
    List<Appointment> appointmentsForClient = new ArrayList<>();
    LocalDate localDate;

    public FrmNewAppointment() {
        initComponents();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        populateCmbTreatment();
        populateCmbClient();
        populateCmbHall();

        initializeDatePicker();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelDate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTreatmentType = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbClient = new javax.swing.JComboBox();
        cmbHall = new javax.swing.JComboBox();
        btnReserve = new javax.swing.JButton();
        cmbTime = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAppointmentsForClient = new javax.swing.JTable();
        btnReserveAll = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDate.setAlignmentX(70.0F);
        panelDate.setAlignmentY(10.0F);
        panelDate.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64, 43, 58));
        jLabel1.setText("Date:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(64, 43, 58));
        jLabel2.setText("Treatment:");

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAppointment);

        jSeparator1.setBackground(new java.awt.Color(214, 52, 132));
        jSeparator1.setForeground(new java.awt.Color(214, 52, 132));

        btnSearch.setBackground(new java.awt.Color(255, 155, 210));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(64, 43, 58));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(64, 43, 58));
        jLabel3.setText("Client:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(64, 43, 58));
        jLabel4.setText("Hall:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(64, 43, 58));
        jLabel5.setText("Time:");

        btnReserve.setBackground(new java.awt.Color(255, 155, 210));
        btnReserve.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReserve.setForeground(new java.awt.Color(64, 43, 58));
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });

        cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", "15:00:00", "16:00:00" }));
        cmbTime.setSelectedIndex(-1);

        tblAppointmentsForClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblAppointmentsForClient);

        btnReserveAll.setBackground(new java.awt.Color(255, 155, 210));
        btnReserveAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReserveAll.setForeground(new java.awt.Color(64, 43, 58));
        btnReserveAll.setText("Reserve all");
        btnReserveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveAllActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(214, 52, 132));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(64, 43, 58));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 31, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSearch)
                                        .addGap(26, 26, 26)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnReserve))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5))
                                                .addGap(41, 41, 41)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbTreatmentType, 0, 197, Short.MAX_VALUE)
                                                    .addComponent(cmbHall, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReserveAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbTreatmentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbHall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(btnReserve))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserveAll)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        Date selectedDate = (Date) model.getValue();
        localDate = dateToLocalDate(selectedDate);
        System.out.println("Izabrani datum: " + localDate);

        if (localDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "Datum mora biti nakon danasnjeg", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Appointment appointment = new Appointment();
        appointment.setDate(localDate);
        Treatment treatment = (Treatment) cmbTreatmentType.getSelectedItem();
        appointment.setTreatment(treatment);

        try {
            appointments = Controller.getInstance().getAppointmentsByRequirement(appointment);
            populateTable(appointments);
        } catch (Exception ex) {
            Logger.getLogger(FrmNewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed

        if (validate1() && validate2()) {
            Appointment appointment = new Appointment();
            appointment.setDate(localDate);
            appointment.setTime(LocalTime.parse((CharSequence) cmbTime.getSelectedItem()));
            appointment.setDuration(1);
            appointment.setClient((Client) cmbClient.getSelectedItem());
            appointment.setTreatment((Treatment) cmbTreatmentType.getSelectedItem());
            appointment.setHall((Hall) cmbHall.getSelectedItem());
            appointmentsForClient.add(appointment);
            populateTableAppointmentsForClient(appointmentsForClient);
        }

    }//GEN-LAST:event_btnReserveActionPerformed

    private void btnReserveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveAllActionPerformed
        try {
            if (validate1() && validate2()) {
                if (appointmentsForClient.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Niste uneli rezervacije", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Controller.getInstance().addAppointments(appointmentsForClient);
                JOptionPane.showMessageDialog(this, "Uspesno unete rezervacije", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmNewAppointment.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Neuspesno unete rezervacije", "Uspesno", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btnReserveAllActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReserve;
    private javax.swing.JButton btnReserveAll;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbClient;
    private javax.swing.JComboBox cmbHall;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JComboBox<Object> cmbTreatmentType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel panelDate;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblAppointmentsForClient;
    // End of variables declaration//GEN-END:variables

    private void initializeDatePicker() {
        // Kreiranje modela za JDatePicker
        model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        // Kreiranje JDatePicker
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Dodavanje JDatePicker na panelDate
        panelDate.setLayout(null); // Postavljanje null layout-a

        // Postavljanje pozicije i veličine JDatePicker-a ručno
        panelDate.setBounds(35, 10, 200, 30);
        datePicker.setBounds(35, 10, 200, 30); // Prilagodite vrednosti prema potrebama

        // Dodavanje JDatePicker na panelDate
        panelDate.add(datePicker);
    }

    private void populateCmbTreatment() {
        List<Treatment> treatments = new ArrayList<>();
        try {
            treatments = Controller.getInstance().getAllTreatment();
        } catch (Exception ex) {
            Logger.getLogger(FrmNewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Treatment treatment : treatments) {
            cmbTreatmentType.addItem(treatment);
        }
        cmbTreatmentType.setSelectedIndex(-1);

    }

    private void populateCmbClient() {
        List<Client> clients = new ArrayList<>();
        try {
            clients = Controller.getInstance().getAllClients();
        } catch (Exception ex) {
            Logger.getLogger(FrmNewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Client client : clients) {
            cmbClient.addItem(client);
        }
        cmbClient.setSelectedIndex(-1);

    }

    private void populateCmbHall() {
        List<Hall> halls = new ArrayList<>();
        try {
            halls = Controller.getInstance().getAllHalls();
        } catch (Exception ex) {
            Logger.getLogger(FrmNewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Hall hall : halls) {
            cmbHall.addItem(hall);
        }
        cmbHall.setSelectedIndex(-1);
    }

    private void populateTable(List<Appointment> appointments) {

        try {
            TableModelAppointment tm = new TableModelAppointment(appointments);
            tblAppointment.setModel(tm);
        } catch (Exception ex) {
            System.out.println("Tabela nije uspesno popunjena");
            ex.printStackTrace();
        }
    }

    private void populateTableAppointmentsForClient(List<Appointment> appointments) {

        try {
            TableModelAppointment tm = new TableModelAppointment(appointments);
            tblAppointmentsForClient.setModel(tm);
        } catch (Exception ex) {
            System.out.println("Tabela nije uspesno popunjena");
            ex.printStackTrace();
        }
    }

    private LocalDate dateToLocalDate(Date selectedDate) {
        return Instant.ofEpochMilli(selectedDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private boolean validate1() {
        if (cmbClient.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Odaberite klijenta", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (cmbTreatmentType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Odaberite tretman", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean validate2() {
        if (cmbHall.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Odaberite salu", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (cmbTime.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Odaberite vreme", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //dodaj validaciju za date!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (localDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "Datum mora biti nakon danasnjeg", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

}

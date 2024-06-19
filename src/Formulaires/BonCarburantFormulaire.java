package Formulaires;

import Controleurs.BonCarburantControleur;
import Controleurs.CarburantControleur;
import Controleurs.DemandeControleur;
import Controleurs.EmployeControleur;
import Controleurs.LoginControleur;
import Controleurs.StationControleur;
import Controleurs.VehiculeControleur;
import Modeles.BonCarburant;
import Modeles.Demande;
import Modeles.Employe;
import Modeles.Station;
import Modeles.TypeCarburant;
import Modeles.Vehicule;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BonCarburantFormulaire extends javax.swing.JFrame {

    public BonCarburantFormulaire(String nom) {
        initComponents();
        afficherCombo();
        afficherBons();
        afficherDemandes();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Bon de carburant");
        session.setText(nom);
    }

    void afficherCombo() {
//        List<TypeCarburant> serviceList = new CarburantControleur().afficherTypeCaburants();
//        for (TypeCarburant carburant : serviceList) {
//            carburantCombo.addItem(carburant);
//        }
        List<Employe> employes = new EmployeControleur().afficherEmployes();
        for (Employe employe : employes) {
            employeCombo.addItem(employe);
        }
        List<Vehicule> vehicules = new VehiculeControleur().afficherVehicules();
        for (Vehicule vehicule : vehicules) {
            VehiculeCombo.addItem(vehicule);
        }
        List<Station> stations = new StationControleur().afficherStations();
        for (Station station : stations) {
            stationCombo.addItem(station);
        }
    }

    void afficherBons() {
        BonCarburantControleur controleur = new BonCarburantControleur();
        String header[] = {"ID", "DEMANDE", "VEHICULE", "QUANTITE", "STATION", "CARBURANT", "DATE", "AUTORISE PAR"};
        Object data[][] = new Object[controleur.afficherBonCommandes().size()][8];
        int i = 0;
        for (BonCarburant bon : controleur.afficherBonCommandes()) {
            data[i][0] = bon.getBonCarburantID();
            data[i][1] = bon.getBonDemandeID();
            data[i][2] = bon.getBonCarburantVehicule();
            data[i][3] = bon.getBonQuantite();
            data[i][4] = bon.getBonStation();
            data[i][5] = bon.getCarburant();
            data[i][6] = bon.getBonCarburantDate();
            data[i][7] = bon.getBonEmploye();
            i++;
        }
        tableBon.setModel(new DefaultTableModel(data, header));
    }

    private void afficherDemandes() {
        DemandeControleur controleur = new DemandeControleur();
        String header[] = {"ID", "QUANTITE", "SERVICE", "MOTIF", "DATE", "VEHICULE", "STATUS"};
        Object data[][] = new Object[controleur.afficherDemmandes().size()][7];
        int i = 0;
        for (Demande demande : controleur.afficherDemmandes()) {
            data[i][0] = demande.getDemandeID();
            data[i][1] = demande.getDemandeQuantite();
            data[i][2] = demande.getDemandeService();
            data[i][3] = demande.getDemandeMotif();
            data[i][4] = demande.getDemandeDate();
            data[i][5] = demande.getDemandeVehicule();
            data[i][6] = demande.getDemandeEtat();
            i++;
        }
        tableDemande.setModel(new DefaultTableModel(data, header));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        VehiculeCombo = new javax.swing.JComboBox<Vehicule>();
        jLabel8 = new javax.swing.JLabel();
        employeCombo = new javax.swing.JComboBox<Employe>();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDemande = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        demandeID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        qteTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stationCombo = new javax.swing.JComboBox<Station>();
        carburantText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des bons");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Vehicule:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Carburant:");

        VehiculeCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        VehiculeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                VehiculeComboItemStateChanged(evt);
            }
        });
        VehiculeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculeComboActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Autorise par:");

        employeCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("Modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        save.setText("Enregister");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        tableDemande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDemande);

        tableBon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableBon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Demande ID:");

        demandeID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Quantite:");

        qteTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Station:");

        stationCombo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        carburantText.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Liste des demandes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(delete)
                                            .addComponent(save))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(employeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 6, Short.MAX_VALUE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(qteTxt)
                                                .addComponent(carburantText)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(stationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(12, 12, 12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(demandeID, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(VehiculeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(demandeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VehiculeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carburantText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qteTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VehiculeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VehiculeComboActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        VehiculeControleur vehiculeControleur = new VehiculeControleur();
        EmployeControleur employeControleur = new EmployeControleur();
        CarburantControleur carburantControleur = new CarburantControleur();
        BonCarburantControleur bonCarburantControleur = new BonCarburantControleur();
        int ajout;
        if (demandeID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "L'ID est obligatoire", "Erreur!", JOptionPane.ERROR_MESSAGE);
        } else if (!new DemandeControleur().dejaExist(demandeID.getText())) {
            JOptionPane.showMessageDialog(this, "L'ID n'existe pas", "Erreur!", JOptionPane.ERROR_MESSAGE);
        } else {
            ajout = bonCarburantControleur.create(new BonCarburant(
                    carburantControleur.returnId("carburantID", "carburant", "carburantNom", carburantText.getText()),
                    vehiculeControleur.returnId("vehiculeID", "vehicule", "vehiculePlaque", VehiculeCombo.getSelectedItem().toString()),
                    employeControleur.returnId("employeID", "employe", "concat(employeNom,' ',employePrenom)", employeCombo.getSelectedItem().toString()), Integer.parseInt(demandeID.getText()), Double.parseDouble(qteTxt.getText()), stationCombo.getSelectedItem().toString()));
            if (ajout == 1) {
                new DemandeControleur().update(demandeID.getText());
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherBons();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void VehiculeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_VehiculeComboItemStateChanged
//        carburantCombo.setSelectedItem(
//                new BonCarburantControleur().
//                afficherCarburant(VehiculeCombo.
//                        getSelectedItem().toString()));
        carburantText.setText(
                new BonCarburantControleur().
                afficherCarburant(VehiculeCombo.
                        getSelectedItem().toString()));
    }//GEN-LAST:event_VehiculeComboItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginControleur controleur = new LoginControleur();
        if (controleur.isAdmin(session.getText())) {
            super.dispose();
            new Main(session.getText()).setVisible(true);
        } else if (controleur.isAgent(session.getText())) {
            super.dispose();
            new ChefServiceFormulaire(session.getText()).setVisible(true);
        } else if (controleur.isCharroi(session.getText())) {
            super.dispose();
            new GestionnaireFormulaire(session.getText()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "qui es-tu?", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BonCarburantFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BonCarburantFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BonCarburantFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BonCarburantFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BonCarburantFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Vehicule> VehiculeCombo;
    private javax.swing.JTextField carburantText;
    private javax.swing.JButton delete;
    private javax.swing.JTextField demandeID;
    private javax.swing.JComboBox<Employe> employeCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField qteTxt;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JLabel session;
    private javax.swing.JComboBox<Station> stationCombo;
    private javax.swing.JTable tableBon;
    private javax.swing.JTable tableDemande;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

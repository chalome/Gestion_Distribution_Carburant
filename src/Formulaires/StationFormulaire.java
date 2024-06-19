package Formulaires;

import Controleurs.LoginControleur;
import Controleurs.StationControleur;
import Modeles.Station;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StationFormulaire extends javax.swing.JFrame {

    public StationFormulaire(String nom) {
        initComponents();
        afficherStation();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Gestion des stations");
        session.setText(nom);
    }

    private void afficherStation() {
        StationControleur controleur = new StationControleur();
        String header[] = {"ID", "NOM", "NIF", "R.C", "ADRESSE"};
        Object data[][] = new Object[controleur.afficherStations().size()][5];
        int i = 0;
        for (Station station : controleur.afficherStations()) {
            data[i][0] = station.getStationID();
            data[i][1] = station.getStationNom();
            data[i][2] = station.getStationNIF();
            data[i][3] = station.getStationRC();
            data[i][4] = station.getStationAdresse();
            i++;
        }
        tableStation.setModel(new DefaultTableModel(data, header));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStation = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nifTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rcTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        adresseTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des Stations");

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        tableStation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableStation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableStationMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableStation);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("NIF:");

        nifTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("RC:");

        rcTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("NOM:");

        nomTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("ADRESSE:");

        adresseTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nifTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(rcTxt)
                            .addComponent(nomTxt)
                            .addComponent(adresseTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supprimer)
                            .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(505, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(351, 351, 351)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nifTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rcTxt)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomTxt)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adresseTxt)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(205, 205, 205))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addGap(65, 65, 65)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        String nif = nifTxt.getText();
        String rc = rcTxt.getText();
        String nom = nomTxt.getText();
        String adresse = adresseTxt.getText();
        StationControleur controleur = new StationControleur();
        int ajout;
        if (nif.trim().isEmpty()
                || rc.trim().isEmpty()
                || nom.trim().isEmpty()
                || adresse.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous Les champ sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (controleur.dejaExist(nom)) {
            JOptionPane.showMessageDialog(this, "La station deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Station station = new Station(nif, rc, nom, adresse);
            ajout = controleur.create(station);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherStation();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        String nif = nifTxt.getText();
        String rc = rcTxt.getText();
        String nom = nomTxt.getText();
        String adresse = adresseTxt.getText();
        StationControleur controleur = new StationControleur();
        int i = -1;
        while (i < 0) {
            String id = JOptionPane.showInputDialog(this, "Saisir l'ID de l'employe à modifier");
            if (id.length() > 0) {
                i++;
                int update;
                int stationID = Integer.parseInt(id);
                Station station = new Station(stationID, nif, rc, nom, adresse);
                int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (y == JOptionPane.OK_OPTION) {
                    update = controleur.update(station);

                    if (update == 1) {
                        JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        afficherStation();
                    } else {
                        JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int ligne = tableStation.getSelectedRow();
        int id = Integer.parseInt(tableStation.getValueAt(ligne, 0).toString());
        int delete;
        Station station = new Station();
        StationControleur controleur = new StationControleur();
        station.setStationID(id);
        int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la suppression ?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.OK_OPTION) {
            delete = controleur.delete(station);
            if (delete == 1) {
                JOptionPane.showMessageDialog(this, "Supprimmé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                afficherStation();
            } else {
                JOptionPane.showMessageDialog(this, "Echec de suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void tableStationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStationMouseReleased
        int row = tableStation.getSelectedRow();
        nifTxt.setText(tableStation.getValueAt(row, 2).toString());
        rcTxt.setText(tableStation.getValueAt(row, 3).toString());
        nomTxt.setText(tableStation.getValueAt(row, 1).toString());
        adresseTxt.setText(tableStation.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tableStationMouseReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        nifTxt.setText("");
        rcTxt.setText("");
        nomTxt.setText("");
        adresseTxt.setText("");
    }//GEN-LAST:event_resetActionPerformed

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
            java.util.logging.Logger.getLogger(StationFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StationFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StationFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StationFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StationFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresseTxt;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nifTxt;
    private javax.swing.JTextField nomTxt;
    private javax.swing.JTextField rcTxt;
    private javax.swing.JButton reset;
    private javax.swing.JLabel session;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tableStation;
    // End of variables declaration//GEN-END:variables
}


package Formulaires;

import Controleurs.DemandeControleur;
import Controleurs.LoginControleur;
import Controleurs.ServiceControleurs;
import Modeles.Demande;
import Modeles.Service;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DemandeFormulaire extends javax.swing.JFrame {

    public DemandeFormulaire(String nom) {
        initComponents();
        afficherDemandes();
        afficherService();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Gestion des demandes");
        session.setText(nom);
    }

    private void afficherDemandes() {
        DemandeControleur controleur = new DemandeControleur();
        String header[] = {"ID", "QUANTITE", "SERVICE", "MOTIF", "DATE","VEHICULE", "STATUS"};
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
        qteTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDemande = new javax.swing.JTable();
        serviceCombo = new javax.swing.JComboBox<Service>();
        jScrollPane2 = new javax.swing.JScrollPane();
        mofifTxt = new javax.swing.JTextArea();
        vehiculeTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des demandes");

        qteTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Quantite:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Service:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Vehicule:");

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter.setText("Envoyer");
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
        tableDemande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDemandeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDemande);

        serviceCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        mofifTxt.setColumns(20);
        mofifTxt.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        mofifTxt.setRows(5);
        jScrollPane2.setViewportView(mofifTxt);

        vehiculeTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Motif");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(supprimer)
                                    .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qteTxt)
                                    .addComponent(serviceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vehiculeTxt)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))))
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
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(qteTxt)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(serviceCombo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(vehiculeTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        double qte = Double.parseDouble(qteTxt.getText());
        String service = serviceCombo.getSelectedItem().toString();
        String motif = mofifTxt.getText();
        ServiceControleurs controleurs = new ServiceControleurs();
        DemandeControleur controleur = new DemandeControleur();
        int ajout;
        if (qteTxt.getText().trim().isEmpty()
                || service.trim().isEmpty()
                || motif.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous Les champ sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            ajout = controleur.create(new Demande(qte, controleurs.returnId("serviceID", "service", "serviceNom", service), motif,vehiculeTxt.getText()));
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherDemandes();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        double qte = Double.parseDouble(qteTxt.getText());
        String service = serviceCombo.getSelectedItem().toString();
        String motif = mofifTxt.getText();
        ServiceControleurs controleurs = new ServiceControleurs();
        DemandeControleur controleur = new DemandeControleur();
        int i = -1;
        while (i < 0) {
            String id = JOptionPane.showInputDialog(this, "Saisir l'ID de l'employe à modifier");
            if (id.length() > 0) {
                i++;
                int update;
                int demandeID = Integer.parseInt(id);
                int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (y == JOptionPane.OK_OPTION) {
                    update = controleur.update(new Demande(demandeID, qte, controleurs.returnId("serviceID", "service", "serviceNom", service), motif,vehiculeTxt.getText()));
                    if (update == 1) {
                        JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        afficherDemandes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int ligne = tableDemande.getSelectedRow();
        int id = Integer.parseInt(tableDemande.getValueAt(ligne, 0).toString());
        int delete;
        Demande sdemDemande = new Demande();
        DemandeControleur controleur = new DemandeControleur();
        sdemDemande.setDemandeID(id);
        int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la suppression ?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.OK_OPTION) {
            delete = controleur.delete(sdemDemande);
            if (delete == 1) {
                JOptionPane.showMessageDialog(this, "Supprimmé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                afficherDemandes();
            } else {
                JOptionPane.showMessageDialog(this, "Echec de suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        qteTxt.setText("");
        serviceCombo.setSelectedItem(null);
        mofifTxt.setText("");
        vehiculeTxt.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void tableDemandeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDemandeMouseReleased
        int row = tableDemande.getSelectedRow();
        qteTxt.setText(tableDemande.getValueAt(row, 1).toString());
        serviceCombo.setSelectedItem(tableDemande.getValueAt(row, 2).toString());
        mofifTxt.setText(tableDemande.getValueAt(row, 3).toString());
        vehiculeTxt.setText(tableDemande.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableDemandeMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       LoginControleur controleur = new LoginControleur();
        if (controleur.isAdmin(session.getText())) {
            super.dispose();
            new Main(session.getText()).setVisible(true);
        } else if (controleur.isChefService(session.getText())) {
            super.dispose();
            new ChefServiceFormulaire(session.getText()).setVisible(true);
        } else if (controleur.isGestionnaire(session.getText())) {
            super.dispose();
            new GestionnaireFormulaire(session.getText()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "qui es-tu?", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    void afficherService() {
        List<Service> serviceList = new ServiceControleurs().afficherServices();
        for (Service service : serviceList) {
            serviceCombo.addItem(service);
        }
    }

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
            java.util.logging.Logger.getLogger(DemandeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemandeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemandeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemandeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemandeFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifier;
    private javax.swing.JTextArea mofifTxt;
    private javax.swing.JTextField qteTxt;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<Service> serviceCombo;
    private javax.swing.JLabel session;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tableDemande;
    private javax.swing.JTextField vehiculeTxt;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import javax.swing.ImageIcon;

public class Main extends javax.swing.JFrame {

    public Main(String nom) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("page d'acceuil");
         session.setText(nom);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        station = new javax.swing.JButton();
        employe = new javax.swing.JButton();
        multitache = new javax.swing.JButton();
        vehicule = new javax.swing.JButton();
        demande = new javax.swing.JButton();
        bon = new javax.swing.JButton();
        transaction = new javax.swing.JButton();
        deconnection = new javax.swing.JButton();
        session = new javax.swing.JLabel();
        Rapport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        station.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        station.setText("Station");
        station.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationActionPerformed(evt);
            }
        });

        employe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employe.setText("Employe");
        employe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeActionPerformed(evt);
            }
        });

        multitache.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        multitache.setText("Multitache");
        multitache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multitacheActionPerformed(evt);
            }
        });

        vehicule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        vehicule.setText("Vehicule");
        vehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculeActionPerformed(evt);
            }
        });

        demande.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        demande.setText("Demande");
        demande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandeActionPerformed(evt);
            }
        });

        bon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bon.setText("Bon carburant");
        bon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonActionPerformed(evt);
            }
        });

        transaction.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        transaction.setText("Transaction");
        transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionActionPerformed(evt);
            }
        });

        deconnection.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deconnection.setText("Se deconnecter");
        deconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnectionActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Rapport.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Rapport.setText("Rapport");
        Rapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RapportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deconnection, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bon, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(demande, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(multitache, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employe, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(station, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rapport, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Rapport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(station)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multitache)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vehicule)
                .addGap(11, 11, 11)
                .addComponent(transaction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(demande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bon)
                .addGap(18, 18, 18)
                .addComponent(deconnection)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculeActionPerformed
        super.dispose();
        new VehiculeFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_vehiculeActionPerformed

    private void bonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonActionPerformed
        super.dispose();
        new BonCarburantFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_bonActionPerformed

    private void stationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stationActionPerformed
        super.dispose();
        new StationFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_stationActionPerformed

    private void employeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeActionPerformed
        super.dispose();
        new EmployeForm(session.getText()).setVisible(true);
    }//GEN-LAST:event_employeActionPerformed

    private void multitacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multitacheActionPerformed
        super.dispose();
        new MultiTacheForm(session.getText()).setVisible(true);
    }//GEN-LAST:event_multitacheActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
        super.dispose();
        new TransactionFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_transactionActionPerformed

    private void demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandeActionPerformed
        super.dispose();
        new DemandeFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_demandeActionPerformed

    private void deconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnectionActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_deconnectionActionPerformed

    private void RapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RapportActionPerformed
         super.dispose();
        new RapportFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_RapportActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Rapport;
    private javax.swing.JButton bon;
    private javax.swing.JButton deconnection;
    private javax.swing.JButton demande;
    private javax.swing.JButton employe;
    private javax.swing.JButton multitache;
    private javax.swing.JLabel session;
    private javax.swing.JButton station;
    private javax.swing.JButton transaction;
    private javax.swing.JButton vehicule;
    // End of variables declaration//GEN-END:variables
}

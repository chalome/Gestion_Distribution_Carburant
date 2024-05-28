
package Formulaires;

import javax.swing.ImageIcon;

public class GestionnaireFormulaire extends javax.swing.JFrame {

    public GestionnaireFormulaire(String nom) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Page du Gestionnaire");
       session.setText(nom);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deconnection = new javax.swing.JButton();
        bon = new javax.swing.JButton();
        transaction = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deconnection.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deconnection.setText("Se deconnecter");
        deconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnectionActionPerformed(evt);
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

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deconnection, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bon, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(transaction)
                .addGap(12, 12, 12)
                .addComponent(bon)
                .addGap(12, 12, 12)
                .addComponent(deconnection)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnectionActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_deconnectionActionPerformed

    private void bonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonActionPerformed
        super.dispose();
        new BonCarburantFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_bonActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
        super.dispose();
        new TransactionFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_transactionActionPerformed

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
            java.util.logging.Logger.getLogger(GestionnaireFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionnaireFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionnaireFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionnaireFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionnaireFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bon;
    private javax.swing.JButton deconnection;
    private javax.swing.JLabel session;
    private javax.swing.JButton transaction;
    // End of variables declaration//GEN-END:variables
}

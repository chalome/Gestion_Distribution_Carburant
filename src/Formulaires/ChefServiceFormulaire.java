
package Formulaires;

import javax.swing.ImageIcon;

public class ChefServiceFormulaire extends javax.swing.JFrame {

    public ChefServiceFormulaire(String nom) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Page du chef de service");
        session.setText(nom);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deconnection = new javax.swing.JButton();
        employe = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deconnection.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deconnection.setText("Se deconnecter");
        deconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnectionActionPerformed(evt);
            }
        });

        employe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employe.setText("Demande");
        employe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(employe, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(282, 282, 282)
                            .addComponent(deconnection, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(employe)
                .addGap(34, 34, 34)
                .addComponent(deconnection)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnectionActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_deconnectionActionPerformed

    private void employeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeActionPerformed
        super.dispose();
        new DemandeFormulaire(session.getText()).setVisible(true);
    }//GEN-LAST:event_employeActionPerformed

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
            java.util.logging.Logger.getLogger(ChefServiceFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChefServiceFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChefServiceFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChefServiceFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChefServiceFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deconnection;
    private javax.swing.JButton employe;
    private javax.swing.JLabel session;
    // End of variables declaration//GEN-END:variables
}

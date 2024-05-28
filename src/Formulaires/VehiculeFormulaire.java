package Formulaires;

import Controleurs.CarburantControleur;
import Controleurs.EmployeControleur;
import Controleurs.LoginControleur;
import Controleurs.ModeleControleur;
import Controleurs.ServiceControleurs;
import Controleurs.VehiculeControleur;
import Modeles.Employe;
import Modeles.Modele;
import Modeles.Service;
import Modeles.TypeCarburant;
import Modeles.Vehicule;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VehiculeFormulaire extends javax.swing.JFrame {

    public VehiculeFormulaire(String nom) {
        initComponents();
        afficheComboValues();
        afficherVehicules();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Gestion des vehicules");
        session.setText(nom);
    }

    public void afficherVehicules() {
        VehiculeControleur controleur = new VehiculeControleur();
        String header[] = {"ID", "PLAUE", "MODELE", "ANNEE", "CARBURANT", "MOYENNE", "SERVICE", "CHAUFFEUR"};
        Object data[][] = new Object[controleur.afficherVehicules().size()][8];
        int i = 0;
        for (Vehicule vehicule : controleur.afficherVehicules()) {
            data[i][0] = vehicule.getVehivuleID();
            data[i][1] = vehicule.getVehiculePlaque();
            data[i][2] = vehicule.getVehiculeModele();
            data[i][3] = vehicule.getVehiculeAnneeFabrication();
            data[i][4] = vehicule.getVehiculeTypeCarburant();
            data[i][5] = vehicule.getVehiculeConsommationMoyenne();
            data[i][6] = vehicule.getVehiculeService();
            data[i][7] = vehicule.getVehiculeChauffeur();
            i++;
        }
        tableVehicule.setModel(new DefaultTableModel(data, header));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plaque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modeleCombo = new javax.swing.JComboBox<Modele>();
        jLabel4 = new javax.swing.JLabel();
        annee = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        carburantCombo = new javax.swing.JComboBox<TypeCarburant>();
        jLabel6 = new javax.swing.JLabel();
        consom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        serviceCombo = new javax.swing.JComboBox<Service>();
        chauffeurCombo = new javax.swing.JComboBox<Employe>();
        jLabel8 = new javax.swing.JLabel();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVehicule = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Véhicule");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Plaque:");

        plaque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Modele:");

        modeleCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Année:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Carburant:");

        carburantCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Cons-Moy:");

        consom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Service:");

        serviceCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        chauffeurCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chauffeurCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chauffeurComboActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Chauffeur:");

        modifier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier.setText("Modifier");

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer.setText("Supprimer");

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset.setText("Reset");

        tableVehicule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableVehicule);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(plaque, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modeleCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(annee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carburantCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(consom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(serviceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chauffeurCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plaque, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(annee, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carburantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chauffeurCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        int ajout;
        String plaques = plaque.getText();
        String modele = modeleCombo.getSelectedItem().toString();
        Integer i = annee.getYear();
        String annees = i.toString();
        String carburant = carburantCombo.getSelectedItem().toString();
        double consMoy = Double.parseDouble(consom.getText());
        String service = serviceCombo.getSelectedItem().toString();
        String chauffeur = chauffeurCombo.getSelectedItem().toString();
        VehiculeControleur controleur = new VehiculeControleur();
        String serviceId =new ServiceControleurs().returnId("serviceID", "service", "serviceNom", service);
        String carburantID=new CarburantControleur().returnId("carburantID", "carburant", "carburantNom", carburant);
        String chauffeurID=new EmployeControleur().returnId("employeid", "employe", "concat(employeNom,' ',employePrenom)", chauffeur);
        String modeleID=new ModeleControleur().returnId("modeleID", "modele", "modeleNom", modele);
        if (plaques.isEmpty()
                || modele.isEmpty()
                || carburant.isEmpty()
                || consom.getText().trim().isEmpty()
                || service.isEmpty()
                || chauffeur.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous Les champ sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Vehicule vehicule = new Vehicule(plaques, modeleID, annees, carburantID, consMoy, serviceId, chauffeurID);
            ajout = controleur.create(vehicule);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherVehicules();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void chauffeurComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chauffeurComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chauffeurComboActionPerformed

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
    public void afficheComboValues() {
        List<Employe> list = new EmployeControleur().afficherEmployes();
        for (Employe employe : list) {
            chauffeurCombo.addItem(employe);
        }
        List<Service> serviceList = new ServiceControleurs().afficherServices();
        for (Service service : serviceList) {
            serviceCombo.addItem(service);
        }
        List<Modele> modeleList = new ModeleControleur().afficherModeles();
        for (Modele modele : modeleList) {
            modeleCombo.addItem(modele);
        }
        List<TypeCarburant> carburantList = new CarburantControleur().afficherTypeCaburants();
        for (TypeCarburant carburant : carburantList) {
            carburantCombo.addItem(carburant);
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
            java.util.logging.Logger.getLogger(VehiculeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehiculeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehiculeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehiculeFormulaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehiculeFormulaire("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private com.toedter.calendar.JYearChooser annee;
    private javax.swing.JComboBox<TypeCarburant> carburantCombo;
    private javax.swing.JComboBox<Employe> chauffeurCombo;
    private javax.swing.JTextField consom;
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
    private javax.swing.JComboBox<Modele> modeleCombo;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField plaque;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<Service> serviceCombo;
    private javax.swing.JLabel session;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tableVehicule;
    // End of variables declaration//GEN-END:variables
}

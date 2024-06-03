package Formulaires;

import Controleurs.CategorieEmployeCotroleur;
import Controleurs.EmployeControleur;
import Controleurs.LoginControleur;
import Controleurs.ServiceControleurs;
import Modeles.CategorieEmploye;
import Modeles.Employe;
import Modeles.Service;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeForm extends javax.swing.JFrame {
//
//    FlatDarkPurpleIJTheme darkPurpleIJTheme;

    public EmployeForm(String nom) {
        initComponents();
        afficheCategorieServices();
        afficherEmployes();
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Gestion des employés");
        session.setText(nom);
    }

    public void afficheCategorieServices() {
        List<CategorieEmploye> categorieList = new CategorieEmployeCotroleur().afficherCategorieEmployes();
        for (CategorieEmploye categorie : categorieList) {
            employeCategorie.addItem(categorie);
        }
        List<Service> serviceList = new ServiceControleurs().afficherServices();
        for (Service service : serviceList) {
            employeService.addItem(service);
        }
    }

    public void afficherEmployes() {
        EmployeControleur controleur = new EmployeControleur();
        String header[] = {"ID", "NOM", "PRENOM", "MATRICULE", "ADRESSE", "SERVICE", "CATEGORIE", "TELEPHONE"};
        Object data[][] = new Object[controleur.afficherEmployes().size()][8];
        int i = 0;
        for (Employe employe : controleur.afficherEmployes()) {
            data[i][0] = employe.getEmployeID();
            data[i][1] = employe.getEmployeNom();
            data[i][2] = employe.getEmployePrenom();
            data[i][3] = employe.getEmployeMatricule();
            data[i][4] = employe.getEmployeAdresse();
            data[i][5] = employe.getEmployeSerice();
            data[i][6] = employe.getEmployeCategorie();
            data[i][7] = employe.getEmployeTelephone();
            i++;
        }
        employeTable.setModel(new DefaultTableModel(data, header));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        employeNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        employePrenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        employeAdresse = new javax.swing.JTextField();
        employeTelephone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        employeMatricule = new javax.swing.JTextField();
        employeService = new javax.swing.JComboBox<Service>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        employeCategorie = new javax.swing.JComboBox<CategorieEmploye>();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeTable = new javax.swing.JTable();
        employeAjouter = new javax.swing.JButton();
        employeModifier = new javax.swing.JButton();
        employeSupprimer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        employeAjouter1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des employés");

        employeNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ajouter un employé");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Nom");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Prénom");

        employePrenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Tél");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Adresse");

        employeAdresse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        employeTelephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Matricule");

        employeMatricule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        employeService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeServiceItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Service");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Catégorie");

        employeCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeCategorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeCategorieItemStateChanged(evt);
            }
        });
        employeCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeCategorieActionPerformed(evt);
            }
        });

        employeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        employeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                employeTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(employeTable);

        employeAjouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeAjouter.setText("Ajouter");
        employeAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeAjouterActionPerformed(evt);
            }
        });

        employeModifier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeModifier.setText("Modifier");
        employeModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeModifierActionPerformed(evt);
            }
        });

        employeSupprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeSupprimer.setText("Supprimer");
        employeSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeSupprimerActionPerformed(evt);
            }
        });

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        employeAjouter1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeAjouter1.setText("Reset");
        employeAjouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeAjouter1ActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeAjouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeCategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeNom, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employePrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(employeAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(employeTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                        .addComponent(employeService, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(employeModifier)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(employeSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(employeMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeMatricule)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeNom)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employePrenom)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeAdresse)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeService, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeTelephone)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(employeAjouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeCategorieActionPerformed

    private void employeAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeAjouterActionPerformed
        String matricule = employeMatricule.getText();
        String nom = employeNom.getText();
        String prenom = employePrenom.getText();
        String adresse = employeAdresse.getText();
        String service = employeService.getSelectedItem().toString();
        String categorie = employeCategorie.getSelectedItem().toString();
        String telephone = employeTelephone.getText();

        EmployeControleur controleur = new EmployeControleur();
        ServiceControleurs serviceControleurs = new ServiceControleurs();
        CategorieEmployeCotroleur categorieEmployeCotroleur = new CategorieEmployeCotroleur();
        String serviceId = serviceControleurs.returnId("serviceID", "service", "serviceNom", service);
        String categorieID = categorieEmployeCotroleur.returnId("categorieEmployeID", "categorieemploye", "categorieemployeNom", categorie);

        int ajout = 0;

        if (matricule.isEmpty()
                || nom.isEmpty()
                || prenom.isEmpty()
                || adresse.isEmpty()
                || categorie.isEmpty()
                || telephone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous Les champ sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (controleur.dejaExist(matricule)) {
            JOptionPane.showMessageDialog(this, "Le matricule deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Employe employe = new Employe(matricule, nom, prenom, adresse, serviceId, categorieID, telephone);
            ajout = controleur.create(employe);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherEmployes();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_employeAjouterActionPerformed

    private void employeModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeModifierActionPerformed
        String matricule = employeMatricule.getText();
        String nom = employeNom.getText();
        String prenom = employePrenom.getText();
        String adresse = employeAdresse.getText();
        String service = employeService.getSelectedItem().toString();
        String categorie = employeCategorie.getSelectedItem().toString();
        String telephone = employeTelephone.getText();

        EmployeControleur controleur = new EmployeControleur();
        ServiceControleurs serviceControleurs = new ServiceControleurs();
        CategorieEmployeCotroleur categorieEmployeCotroleur = new CategorieEmployeCotroleur();
        String serviceId = serviceControleurs.returnId("serviceID", "service", "serviceNom", service);
        String categorieID = categorieEmployeCotroleur.returnId("categorieemployeID", "categorieemploye", "categorieemployeNom", categorie);

        int i = -1;
        while (i < 0) {
            String id = JOptionPane.showInputDialog(this, "Saisir l'ID de l'employe à modifier");
            if (id.length() > 0) {
                i++;
                int update = 0;
                int employeID = Integer.parseInt(id);
                Employe employe = new Employe(employeID, matricule, nom, prenom, adresse, serviceId, categorieID, telephone);
                int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (y == JOptionPane.OK_OPTION) {
                    update = controleur.update(employe);

                    if (update == 1) {
                        JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        afficherEmployes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_employeModifierActionPerformed

    private void employeTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeTableMouseReleased
        int ligne = employeTable.getSelectedRow();
        employeNom.setText(employeTable.getValueAt(ligne, 1).toString());
        employePrenom.setText(employeTable.getValueAt(ligne, 2).toString());
        employeMatricule.setText(employeTable.getValueAt(ligne, 3).toString());
        employeAdresse.setText(employeTable.getValueAt(ligne, 4).toString());
        employeService.setSelectedItem(employeTable.getValueAt(ligne, 5).toString());
        employeCategorie.setSelectedItem(employeTable.getValueAt(ligne, 6).toString());
        employeTelephone.setText(employeTable.getValueAt(ligne, 7).toString());
    }//GEN-LAST:event_employeTableMouseReleased

    private void employeSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeSupprimerActionPerformed
        int ligne = employeTable.getSelectedRow();
        int id = Integer.parseInt(employeTable.getValueAt(ligne, 0).toString());
        int delete = 0;
        Employe employe = new Employe();
        EmployeControleur controleur = new EmployeControleur();
        employe.setEmployeID(id);
        int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la suppression ?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.OK_OPTION) {
            delete = controleur.delete(employe);
            if (delete == 1) {
                JOptionPane.showMessageDialog(this, "Supprimmé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                afficherEmployes();

            } else {
                JOptionPane.showMessageDialog(this, "Echec de suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_employeSupprimerActionPerformed

    private void employeCategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeCategorieItemStateChanged
//        categorieTxt.setText(employeCategorie.getSelectedItem().toString());
    }//GEN-LAST:event_employeCategorieItemStateChanged

    private void employeServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeServiceItemStateChanged
//        servicetex.setText(employeService.getSelectedItem().toString());
    }//GEN-LAST:event_employeServiceItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

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

    private void employeAjouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeAjouter1ActionPerformed
        employeAdresse.setText("");
        employeMatricule.setText("");
        employeNom.setText("");
        employePrenom.setText("");
        employeTelephone.setText("");
        employeCategorie.setSelectedItem(null);
        employeService.setSelectedItem(null);
    }//GEN-LAST:event_employeAjouter1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
//        FlatDarkPurpleIJTheme.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeForm("").setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField employeAdresse;
    private javax.swing.JButton employeAjouter;
    private javax.swing.JButton employeAjouter1;
    private javax.swing.JComboBox<CategorieEmploye> employeCategorie;
    private javax.swing.JTextField employeMatricule;
    private javax.swing.JButton employeModifier;
    private javax.swing.JTextField employeNom;
    private javax.swing.JTextField employePrenom;
    private javax.swing.JComboBox<Service> employeService;
    private javax.swing.JButton employeSupprimer;
    private javax.swing.JTable employeTable;
    private javax.swing.JTextField employeTelephone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel session;
    // End of variables declaration//GEN-END:variables
}

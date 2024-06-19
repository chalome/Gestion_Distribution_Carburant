package Formulaires;

import Controleurs.CarburantControleur;
import Controleurs.CategorieEmployeCotroleur;
import Controleurs.LoginControleur;
import Controleurs.ModeleControleur;
import Controleurs.ServiceControleurs;
import Modeles.CategorieEmploye;
import Modeles.Modele;
import Modeles.Service;
import Modeles.TypeCarburant;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MultiTacheForm extends javax.swing.JFrame {

    CategorieEmployeCotroleur controleurcat = new CategorieEmployeCotroleur();
    ServiceControleurs controleurs = new ServiceControleurs();
    ModeleControleur controleur = new ModeleControleur();

    public MultiTacheForm(String nom) {
        initComponents();
        controleur.afficherListeModeles(listModele);
        controleurcat.afficherListeCategories(listCategorie);
        controleurs.afficherListeServices(listService);
        new CarburantControleur().afficherListeCarburants(listCarburant);
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Page multitache");
        session.setText(nom);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        serviceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listService = new javax.swing.JList();
        ajoutService = new javax.swing.JButton();
        modifService = new javax.swing.JButton();
        supprimerService = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modeleText = new javax.swing.JTextField();
        ajoutModele = new javax.swing.JButton();
        modifModele = new javax.swing.JButton();
        supprimerModele = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listModele = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listCategorie = new javax.swing.JList();
        ajoutCategorie = new javax.swing.JButton();
        modifCategorie = new javax.swing.JButton();
        supprimeCategorie = new javax.swing.JButton();
        CategorieText = new javax.swing.JTextField();
        ddd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listCarburant = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        carburantText = new javax.swing.JTextField();
        ddd1 = new javax.swing.JLabel();
        ajoutCarburant = new javax.swing.JButton();
        modifcarburant = new javax.swing.JButton();
        supprimeCarburant = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        session = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modele,Service,Categorie des employes");

        serviceText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Plaque:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Service");

        listService.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listServiceMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listService);

        ajoutService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutService.setText("Ajouter");
        ajoutService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutServiceActionPerformed(evt);
            }
        });

        modifService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifService.setText("Modifier");
        modifService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifServiceActionPerformed(evt);
            }
        });

        supprimerService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimerService.setText("Supprimer");
        supprimerService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerServiceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modele");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Modele:");

        modeleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ajoutModele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutModele.setText("Ajouter");
        ajoutModele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutModeleActionPerformed(evt);
            }
        });

        modifModele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifModele.setText("Modifier");
        modifModele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifModeleActionPerformed(evt);
            }
        });

        supprimerModele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimerModele.setText("Supprimer");

        listModele.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listModele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listModeleMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listModele);

        listCategorie.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listCategorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listCategorieMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(listCategorie);

        ajoutCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutCategorie.setText("Ajouter");
        ajoutCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutCategorieActionPerformed(evt);
            }
        });

        modifCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifCategorie.setText("Modifier");
        modifCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifCategorieActionPerformed(evt);
            }
        });

        supprimeCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimeCategorie.setText("Supprimer");

        CategorieText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ddd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ddd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ddd.setText("Categorie");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Plaque:");

        listCarburant.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listCarburant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listCarburantMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(listCarburant);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Nom:");

        carburantText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ddd1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ddd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ddd1.setText("Carburant");

        ajoutCarburant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutCarburant.setText("Ajouter");
        ajoutCarburant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutCarburantActionPerformed(evt);
            }
        });

        modifcarburant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifcarburant.setText("Modifier");
        modifcarburant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifcarburantActionPerformed(evt);
            }
        });

        supprimeCarburant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supprimeCarburant.setText("Supprimer");

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
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serviceText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ajoutService)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifService)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supprimerService)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modeleText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ajoutModele)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifModele)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supprimerModele)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CategorieText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ajoutCategorie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifCategorie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supprimeCategorie)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ddd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carburantText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ajoutCarburant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifcarburant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supprimeCarburant)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajoutService)
                            .addComponent(modifService)
                            .addComponent(supprimerService))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeleText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajoutModele)
                            .addComponent(modifModele)
                            .addComponent(supprimerModele))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ddd1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carburantText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ajoutCarburant)
                                    .addComponent(modifcarburant)
                                    .addComponent(supprimeCarburant)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CategorieText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ajoutCategorie)
                                    .addComponent(modifCategorie)
                                    .addComponent(supprimeCategorie))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajoutServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutServiceActionPerformed
        int ajout;
        String serviceNom = serviceText.getText();
        ServiceControleurs serviceControleurs = new ServiceControleurs();
        if (serviceNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs service est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (serviceControleurs.dejaExist(serviceNom)) {
            JOptionPane.showMessageDialog(this, "Le service deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Service service = new Service(serviceNom);
            ajout = serviceControleurs.create(service);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                serviceControleurs.afficherListeServices(listService);
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajoutServiceActionPerformed

    private void ajoutModeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutModeleActionPerformed
        int ajout;
        String modeleNom = modeleText.getText();
        ModeleControleur modeleControleur = new ModeleControleur();
        if (modeleNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs modele est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (modeleControleur.dejaExist(modeleNom)) {
            JOptionPane.showMessageDialog(this, "Le modele deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Modele modele = new Modele(modeleNom);
            ajout = modeleControleur.create(modele);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                modeleControleur.afficherListeModeles(listModele);
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajoutModeleActionPerformed

    private void ajoutCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutCategorieActionPerformed
        int ajout;
        String categorieNom = CategorieText.getText();
        CategorieEmployeCotroleur categorieEmployeCotroleur = new CategorieEmployeCotroleur();
        if (categorieNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs categorie est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (categorieEmployeCotroleur.dejaExist(categorieNom)) {
            JOptionPane.showMessageDialog(this, "La categorie deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            CategorieEmploye categorieEmploye = new CategorieEmploye(categorieNom);
            ajout = categorieEmployeCotroleur.create(categorieEmploye);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                categorieEmployeCotroleur.afficherListeCategories(listCategorie);
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajoutCategorieActionPerformed

    private void modifServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifServiceActionPerformed
        int modifier;
        String serviceNom = listService.getSelectedValue().toString();
        ServiceControleurs serviceControleurs = new ServiceControleurs();
        int id = Integer.parseInt(serviceControleurs.returnId("serviceID", "service", "serviceNom", serviceNom));
        if (serviceNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs service est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Service service = new Service(id, serviceNom);
            int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (y == JOptionPane.OK_OPTION) {
                modifier = serviceControleurs.update(service);
                if (modifier == 1) {
                    JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    serviceControleurs.afficherListeServices(listService);
                } else {
                    JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_modifServiceActionPerformed

    private void modifModeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifModeleActionPerformed
        int modifier;
        String modeleNom = listService.getSelectedValue().toString();
        ModeleControleur modeleControleur = new ModeleControleur();
        int id = Integer.parseInt(modeleControleur.returnId("modeleID", "modele", "modeleNom", modeleNom));
        if (modeleNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs service est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Modele modele = new Modele(id, modeleNom);
            int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (y == JOptionPane.OK_OPTION) {
                modifier = modeleControleur.update(modele);

                if (modifier == 1) {
                    JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    modeleControleur.afficherListeModeles(listModele);
                } else {
                    JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_modifModeleActionPerformed

    private void modifCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifCategorieActionPerformed
        int modifier;
        String categorieNom = listCategorie.getSelectedValue().toString();
        CategorieEmployeCotroleur categorieEmployeCotroleur = new CategorieEmployeCotroleur();
        int id = Integer.parseInt(categorieEmployeCotroleur.returnId("CategorieEmployeID", "Categorieemploye", "CategorieEmployeNom", categorieNom));
        if (categorieNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champs service est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            CategorieEmploye categorieEmploye = new CategorieEmploye(id, categorieNom);
            int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (y == JOptionPane.OK_OPTION) {
                modifier = categorieEmployeCotroleur.update(categorieEmploye);
                if (modifier == 1) {
                    JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    categorieEmployeCotroleur.afficherListeCategories(listCategorie);
                } else {
                    JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_modifCategorieActionPerformed

    private void supprimerServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerServiceActionPerformed
        int supprimer;
        String serviceNom = listService.getSelectedValue().toString();
        ServiceControleurs serviceControleurs = new ServiceControleurs();
        Service service = new Service();
        int id = Integer.parseInt(serviceControleurs.returnId("serviceID", "service", "serviceNom", serviceNom));
        service.setServiceID(id);
        int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la suppression ?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.OK_OPTION) {
            supprimer = serviceControleurs.delete(service);
            if (supprimer == 1) {
                JOptionPane.showMessageDialog(this, "Supprimmé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                serviceControleurs.afficherListeServices(listService);
            } else {
                JOptionPane.showMessageDialog(this, "Echec de suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_supprimerServiceActionPerformed

    private void listServiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listServiceMouseReleased
        serviceText.setText(listService.getSelectedValue().toString());
    }//GEN-LAST:event_listServiceMouseReleased

    private void listModeleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listModeleMouseReleased
        modeleText.setText(listModele.getSelectedValue().toString());
    }//GEN-LAST:event_listModeleMouseReleased

    private void listCategorieMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCategorieMouseReleased
        CategorieText.setText(listCategorie.getSelectedValue().toString());
    }//GEN-LAST:event_listCategorieMouseReleased

    private void listCarburantMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCarburantMouseReleased
        carburantText.setText(listCarburant.getSelectedValue().toString());
    }//GEN-LAST:event_listCarburantMouseReleased

    private void ajoutCarburantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutCarburantActionPerformed
        int ajout;
        String carburantNom = carburantText.getText();
        CarburantControleur carburantControleur = new CarburantControleur();
        if (carburantNom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le champ est obligatoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (carburantControleur.dejaExist(carburantNom)) {
            JOptionPane.showMessageDialog(this, "Le nom du carburant deja existe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            TypeCarburant carburant = new TypeCarburant(carburantNom);
            ajout = carburantControleur.create(carburant);
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                carburantControleur.afficherListeCarburants(listCarburant);
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajoutCarburantActionPerformed

    private void modifcarburantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifcarburantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifcarburantActionPerformed

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
            java.util.logging.Logger.getLogger(MultiTacheForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiTacheForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiTacheForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiTacheForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiTacheForm("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CategorieText;
    private javax.swing.JButton ajoutCarburant;
    private javax.swing.JButton ajoutCategorie;
    private javax.swing.JButton ajoutModele;
    private javax.swing.JButton ajoutService;
    private javax.swing.JTextField carburantText;
    private javax.swing.JLabel ddd;
    private javax.swing.JLabel ddd1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listCarburant;
    private javax.swing.JList listCategorie;
    private javax.swing.JList listModele;
    private javax.swing.JList listService;
    private javax.swing.JTextField modeleText;
    private javax.swing.JButton modifCategorie;
    private javax.swing.JButton modifModele;
    private javax.swing.JButton modifService;
    private javax.swing.JButton modifcarburant;
    private javax.swing.JTextField serviceText;
    private javax.swing.JLabel session;
    private javax.swing.JButton supprimeCarburant;
    private javax.swing.JButton supprimeCategorie;
    private javax.swing.JButton supprimerModele;
    private javax.swing.JButton supprimerService;
    // End of variables declaration//GEN-END:variables
}

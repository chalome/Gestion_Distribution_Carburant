package Forms;

import Controleurs.BonCarburantControleur;
import Controleurs.CarburantControleur;
import Controleurs.CategorieEmployeCotroleur;
import Controleurs.DemandeControleur;
import Controleurs.EmployeControleur;
import Controleurs.LoginControleur;
import Controleurs.ModeleControleur;
import Controleurs.ServiceControleurs;
import Controleurs.StationControleur;
import Controleurs.TransactionControleur;
import Controleurs.VehiculeControleur;
import Modeles.BonCarburant;
import Modeles.CategorieEmploye;
import Modeles.Demande;
import Modeles.Employe;
import Modeles.Modele;
import Modeles.Service;
import Modeles.Station;
import Modeles.Transaction;
import Modeles.TypeCarburant;
import Modeles.Vehicule;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;

public class AdminForm extends javax.swing.JFrame {

    public AdminForm(String nom) {
        initComponents();
        session.setText(nom);
        afficheCategorieServices();
        afficherEmployes();
        afficherDemandes();
        afficherStation();
        afficherVehicules();
        afficherBons();
        afficherCombo();
        afficherTransactions();
        new CategorieEmployeCotroleur().afficherCategorieEmployes();
        new ServiceControleurs().afficherListeServices(listService);
        new ModeleControleur().afficherListeModeles(listModele);
        setIconImage(new ImageIcon(getClass().getResource("/icones/pic2.jpg")).getImage());
        setTitle("Gestion des bons de carburant");
        qui(session.getText());
        new CategorieEmployeCotroleur().afficherListeCategories(listCategorie);
        new CarburantControleur().afficherListeCarburants(listCarburant);
    }

    void qui(String nom) {
        if (new LoginControleur().isGestionnaire(nom)) {
            employebtn.setVisible(false);
            rapportbtn.setVisible(false);
            stationbtn.setVisible(false);
            multibtn.setVisible(false);
            vehiculebtn.setVisible(false);
//    transactionbtn;;;;
            demandebtn.setVisible(false);
//    bonBtn;;;;
        } else if (new LoginControleur().isChefService(nom)) {
            employebtn.setVisible(false);
            rapportbtn.setVisible(false);
            stationbtn.setVisible(false);
            multibtn.setVisible(false);
            vehiculebtn.setVisible(false);
            transactionbtn.setVisible(false);
            bonBtn.setVisible(false);
        }
    }

    void afficherCombo() {
        List<TypeCarburant> serviceList = new CarburantControleur().afficherTypeCaburants();
        for (TypeCarburant carburant : serviceList) {
            carburantCombo.addItem(carburant);
        }
        List<Employe> employes = new EmployeControleur().afficherEmployes();
        for (Employe employe : employes) {
            employeCombo.addItem(employe);
            chauffeurCombo.addItem(employe);
        }
        List<Vehicule> vehicules = new VehiculeControleur().afficherVehicules();
        for (Vehicule vehicule : vehicules) {
            VehiculeCombo.addItem(vehicule);
        }
        List<Station> stations = new StationControleur().afficherStations();
        for (Station station : stations) {
            stationCombo.addItem(station);
            stationCombo1.addItem(station);
        }
        List<Modele> modeleList = new ModeleControleur().afficherModeles();
        for (Modele modele : modeleList) {
            modeleCombo.addItem(modele);
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
        tableDemande1.setModel(new DefaultTableModel(data, header));
    }

    void afficherService() {
        List<Station> serviceList = new StationControleur().afficherStations();
        for (Station station : serviceList) {
            stationCombo.addItem(station);
            stationCombo1.addItem(station);
        }
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

    private void afficherTransactions() {
        TransactionControleur controleur = new TransactionControleur();
        String header[] = {"ID", "QUANTITE", "P.U", "P.T", "DATE", "BON", "STATION", "SERVICE"};
        Object data[][] = new Object[controleur.afficherTransactions().size()][8];
        int i = 0;
        for (Transaction t : controleur.afficherTransactions()) {
            data[i][0] = t.getTransactionID();
            data[i][1] = t.getTransactionQuantite();
            data[i][2] = t.getTransactionPrixUnitaire();
            data[i][3] = t.getTransactionPrixTotal();
            data[i][4] = t.getTransactionDate();
            data[i][5] = t.getTransactionBonCommande();
            data[i][6] = t.getTransactionStation();
            data[i][7] = t.getTransactionService();
            i++;
        }
        tableTransaction.setModel(new DefaultTableModel(data, header));
    }

    private void afficherTransactionsList() {
        String service = new ServiceControleurs().returnId("serviceID", "service", "serviceNom", serviceCombo.getSelectedItem().toString());
        String datedebut = ((JTextField) dateDebut.getDateEditor().getUiComponent()).getText();
        String datefin = ((JTextField) dateFin.getDateEditor().getUiComponent()).getText();
        TransactionControleur controleur = new TransactionControleur();
        String header[] = {"ID", "QUANTITE", "P.U", "P.T", "DATE", "BON", "STATION", "SERVICE"};
        Object data[][] = new Object[controleur.afficherTransactions(service, datedebut, datefin).size()][8];
        int i = 0;
        for (Transaction t : controleur.afficherTransactions(service, datedebut, datefin)) {
            data[i][0] = t.getTransactionID();
            data[i][1] = t.getTransactionQuantite();
            data[i][2] = t.getTransactionPrixUnitaire();
            data[i][3] = t.getTransactionPrixTotal();
            data[i][4] = t.getTransactionDate();
            data[i][5] = t.getTransactionBonCommande();
            data[i][6] = t.getTransactionStation();
            data[i][7] = t.getTransactionService();
            i++;
        }
        rapportTable.setModel(new DefaultTableModel(data, header));
    }

    public void afficheCategorieServices() {
        List<CategorieEmploye> categorieList = new CategorieEmployeCotroleur().afficherCategorieEmployes();
        for (CategorieEmploye categorie : categorieList) {
            employeCategorie.addItem(categorie);
        }
        List<Service> serviceList = new ServiceControleurs().afficherServices();
        for (Service service : serviceList) {
            employeService.addItem(service);
            serviceCombo.addItem(service);
            serviceCombo3.addItem(service);
            serviceCombo1.addItem(service);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        employebtn = new javax.swing.JButton();
        rapportbtn = new javax.swing.JButton();
        multibtn = new javax.swing.JButton();
        stationbtn = new javax.swing.JButton();
        bonBtn = new javax.swing.JButton();
        vehiculebtn = new javax.swing.JButton();
        transactionbtn = new javax.swing.JButton();
        demandebtn = new javax.swing.JButton();
        deconnectionbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        session = new javax.swing.JLabel();
        session1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EmployePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        employeMatricule = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        employeNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        employePrenom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        employeAdresse = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        employeCategorie = new javax.swing.JComboBox<CategorieEmploye>();
        jLabel8 = new javax.swing.JLabel();
        employeService = new javax.swing.JComboBox<Service>();
        jLabel10 = new javax.swing.JLabel();
        employeTelephone = new javax.swing.JTextField();
        employeAjouter = new javax.swing.JButton();
        employeModifier = new javax.swing.JButton();
        employeSupprimer = new javax.swing.JButton();
        employeAjouter1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeTable = new javax.swing.JTable();
        RapportPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        serviceCombo = new javax.swing.JComboBox<Service>();
        jLabel13 = new javax.swing.JLabel();
        dateDebut = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        dateFin = new com.toedter.calendar.JDateChooser();
        okbtn = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        rapportTable = new javax.swing.JTable();
        okbtn1 = new javax.swing.JButton();
        StationPanel = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        nifTxt = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        rcTxt = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        nomTxt = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        adresseTxt = new javax.swing.JTextField();
        ajouter2 = new javax.swing.JButton();
        supprimer3 = new javax.swing.JButton();
        modifier2 = new javax.swing.JButton();
        reset3 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableStation = new javax.swing.JTable();
        MultitachePanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        serviceText = new javax.swing.JTextField();
        ajoutService = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listService = new javax.swing.JList();
        jLabel18 = new javax.swing.JLabel();
        modeleText = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ajoutModele = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listModele = new javax.swing.JList();
        jLabel20 = new javax.swing.JLabel();
        ajoutCategorie = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listCategorie = new javax.swing.JList();
        CategorieText = new javax.swing.JTextField();
        ddd = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        carburantText1 = new javax.swing.JTextField();
        ddd1 = new javax.swing.JLabel();
        ajoutCarburant = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        listCarburant = new javax.swing.JList();
        vehiculePanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        plaque = new javax.swing.JTextField();
        modeleCombo = new javax.swing.JComboBox<Modele>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        annee = new com.toedter.calendar.JYearChooser();
        jLabel24 = new javax.swing.JLabel();
        carburantCombo = new javax.swing.JComboBox<TypeCarburant>();
        jLabel25 = new javax.swing.JLabel();
        consom = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        serviceCombo1 = new javax.swing.JComboBox<Service>();
        jLabel27 = new javax.swing.JLabel();
        chauffeurCombo = new javax.swing.JComboBox<Employe>();
        ajouter = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableVehicule = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        TransactionPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        bnidTxt = new javax.swing.JTextField();
        puTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        ptTxt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        qteTxt = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        stationCombo = new javax.swing.JComboBox<Station>();
        save = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        supprimer1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTransaction = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        serviceCombo3 = new javax.swing.JComboBox<Service>();
        demandePanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        qteTxt1 = new javax.swing.JTextField();
        serviceCombo2 = new javax.swing.JComboBox<Service>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        vehiculeTxt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        mofifTxt = new javax.swing.JTextArea();
        ajouter1 = new javax.swing.JButton();
        supprimer2 = new javax.swing.JButton();
        modifier1 = new javax.swing.JButton();
        reset1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableDemande = new javax.swing.JTable();
        BonPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        demandeID = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        VehiculeCombo = new javax.swing.JComboBox<Vehicule>();
        jLabel42 = new javax.swing.JLabel();
        carburantText = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        qteTxt2 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        stationCombo1 = new javax.swing.JComboBox<Station>();
        jLabel45 = new javax.swing.JLabel();
        employeCombo = new javax.swing.JComboBox<Employe>();
        save1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset2 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableDemande1 = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableBon = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 606));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        employebtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        employebtn.setText("Employé");
        employebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employebtnActionPerformed(evt);
            }
        });

        rapportbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rapportbtn.setText("Rapport");
        rapportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapportbtnActionPerformed(evt);
            }
        });

        multibtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        multibtn.setText("MultiTache");
        multibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multibtnActionPerformed(evt);
            }
        });

        stationbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stationbtn.setText("Station");
        stationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationbtnActionPerformed(evt);
            }
        });

        bonBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bonBtn.setText("Bon");
        bonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonBtnActionPerformed(evt);
            }
        });

        vehiculebtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        vehiculebtn.setText("Véhicule");
        vehiculebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculebtnActionPerformed(evt);
            }
        });

        transactionbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        transactionbtn.setText("Transaction");
        transactionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionbtnActionPerformed(evt);
            }
        });

        demandebtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        demandebtn.setText("Demande");
        demandebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandebtnActionPerformed(evt);
            }
        });

        deconnectionbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        deconnectionbtn.setText("Déconnexion");
        deconnectionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnectionbtnActionPerformed(evt);
            }
        });

        homebtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        homebtn.setText("Acceuil");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        session.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        session.setForeground(new java.awt.Color(0, 153, 51));
        session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        session1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        session1.setForeground(new java.awt.Color(0, 153, 51));
        session1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        session1.setText("est connecté");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rapportbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stationbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(multibtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehiculebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(demandebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bonBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deconnectionbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(session1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(session1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rapportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stationbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(multibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehiculebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transactionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(demandebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deconnectionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        MainPanel.setPreferredSize(new java.awt.Dimension(110, 532));
        MainPanel.setLayout(new java.awt.CardLayout());

        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Page d'acceuil");
        Home.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 916, 31));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Application pour la Gestion des bons de carburant cas du MFBP");
        Home.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 192, 896, 31));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pic2.jpg"))); // NOI18N
        Home.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        MainPanel.add(Home, "card10");

        EmployePanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestion des employés");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ajouter un employé");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Matricule");

        employeMatricule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Nom");

        employeNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Prénom");

        employePrenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Adresse");

        employeAdresse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Service");

        employeService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeServiceItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Tél");

        employeTelephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        employeAjouter1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeAjouter1.setText("Reset");
        employeAjouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeAjouter1ActionPerformed(evt);
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

        javax.swing.GroupLayout EmployePanelLayout = new javax.swing.GroupLayout(EmployePanel);
        EmployePanel.setLayout(EmployePanelLayout);
        EmployePanelLayout.setHorizontalGroup(
            EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(employeAjouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmployePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(EmployePanelLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeCategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(EmployePanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeNom, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EmployePanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employePrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EmployePanelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EmployePanelLayout.createSequentialGroup()
                                .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(employeAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(employeTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(employeService, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(EmployePanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(employeModifier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(employeSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(EmployePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(EmployePanelLayout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
        EmployePanelLayout.setVerticalGroup(
            EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployePanelLayout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeAjouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EmployePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employeMatricule)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employeNom)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employePrenom)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employeAdresse)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeService, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employeTelephone)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(EmployePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        MainPanel.add(EmployePanel, "card2");

        RapportPanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Rapport");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Service:");

        serviceCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Date debut:");

        dateDebut.setDateFormatString("yyyy-MM-dd");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Date fin:");

        dateFin.setDateFormatString("yyyy-MM-dd");

        okbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okbtn.setText("Afficher");
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });

        rapportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(rapportTable);

        okbtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okbtn1.setText("Imprimer");
        okbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RapportPanelLayout = new javax.swing.GroupLayout(RapportPanel);
        RapportPanel.setLayout(RapportPanelLayout);
        RapportPanelLayout.setHorizontalGroup(
            RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RapportPanelLayout.createSequentialGroup()
                .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RapportPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(okbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(serviceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okbtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RapportPanelLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        RapportPanelLayout.setVerticalGroup(
            RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RapportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RapportPanelLayout.createSequentialGroup()
                        .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(RapportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(okbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okbtn1))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.add(RapportPanel, "card3");

        StationPanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("NIF:");

        nifTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel49.setText("RC:");

        rcTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setText("NOM:");

        nomTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel51.setText("ADRESSE:");

        adresseTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ajouter2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter2.setText("Ajouter");
        ajouter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter2ActionPerformed(evt);
            }
        });

        supprimer3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer3.setText("Supprimer");
        supprimer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer3ActionPerformed(evt);
            }
        });

        modifier2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier2.setText("Modifier");
        modifier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier2ActionPerformed(evt);
            }
        });

        reset3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset3.setText("Reset");
        reset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset3ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Gestion des Stations");

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
        jScrollPane11.setViewportView(tableStation);

        javax.swing.GroupLayout StationPanelLayout = new javax.swing.GroupLayout(StationPanel);
        StationPanel.setLayout(StationPanelLayout);
        StationPanelLayout.setHorizontalGroup(
            StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StationPanelLayout.createSequentialGroup()
                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StationPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(StationPanelLayout.createSequentialGroup()
                                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nifTxt)
                                    .addComponent(rcTxt)
                                    .addComponent(nomTxt)
                                    .addComponent(adresseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(StationPanelLayout.createSequentialGroup()
                                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(supprimer3)
                                    .addComponent(ajouter2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StationPanelLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StationPanelLayout.setVerticalGroup(
            StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StationPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nifTxt)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rcTxt)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomTxt)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adresseTxt)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(StationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StationPanelLayout.createSequentialGroup()
                                .addComponent(ajouter2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StationPanelLayout.createSequentialGroup()
                                .addComponent(modifier2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StationPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))))
        );

        MainPanel.add(StationPanel, "card4");

        MultitachePanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Modele,Service,Categorie des employes");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Service");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("Plaque:");

        serviceText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ajoutService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutService.setText("Ajouter");
        ajoutService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutServiceActionPerformed(evt);
            }
        });

        listService.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listServiceMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listService);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("Modele:");

        modeleText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Modele");

        ajoutModele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutModele.setText("Ajouter");
        ajoutModele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutModeleActionPerformed(evt);
            }
        });

        listModele.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listModele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listModeleMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(listModele);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Nom:");

        ajoutCategorie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ajoutCategorie.setText("Ajouter");
        ajoutCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutCategorieActionPerformed(evt);
            }
        });

        listCategorie.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listCategorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listCategorieMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(listCategorie);

        CategorieText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        ddd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ddd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ddd.setText("Categorie");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("Nom:");

        carburantText1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

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

        listCarburant.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listCarburant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listCarburantMouseReleased(evt);
            }
        });
        jScrollPane12.setViewportView(listCarburant);

        javax.swing.GroupLayout MultitachePanelLayout = new javax.swing.GroupLayout(MultitachePanel);
        MultitachePanel.setLayout(MultitachePanelLayout);
        MultitachePanelLayout.setHorizontalGroup(
            MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MultitachePanelLayout.createSequentialGroup()
                .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(ajoutService)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MultitachePanelLayout.createSequentialGroup()
                                .addComponent(ajoutModele)
                                .addGap(104, 104, 104)))
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(ajoutCategorie))
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ddd1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(serviceText, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modeleText))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CategorieText, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carburantText1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MultitachePanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ajoutCarburant)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        MultitachePanelLayout.setVerticalGroup(
            MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MultitachePanelLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(40, 40, 40)
                .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeleText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CategorieText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carburantText1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajoutService)
                            .addComponent(ajoutModele)
                            .addComponent(ajoutCategorie)
                            .addComponent(ajoutCarburant)))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ddd1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MultitachePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(17, 17, 17))
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(MultitachePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        MainPanel.add(MultitachePanel, "card5");

        vehiculePanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setText("Plaque:");

        plaque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        modeleCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("Modele:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Année:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Carburant:");

        carburantCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Cons-Moy:");

        consom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("Service:");

        serviceCombo1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Chauffeur:");

        chauffeurCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chauffeurCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chauffeurComboActionPerformed(evt);
            }
        });

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

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
        tableVehicule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVehiculeMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tableVehicule);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Véhicule");

        javax.swing.GroupLayout vehiculePanelLayout = new javax.swing.GroupLayout(vehiculePanel);
        vehiculePanel.setLayout(vehiculePanelLayout);
        vehiculePanelLayout.setHorizontalGroup(
            vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiculePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vehiculePanelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(vehiculePanelLayout.createSequentialGroup()
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehiculePanelLayout.createSequentialGroup()
                                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(plaque, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modeleCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(annee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carburantCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(consom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(serviceCombo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chauffeurCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehiculePanelLayout.createSequentialGroup()
                                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(supprimer)
                                    .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(392, 392, 392))))
        );
        vehiculePanelLayout.setVerticalGroup(
            vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiculePanelLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vehiculePanelLayout.createSequentialGroup()
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plaque, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(annee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carburantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chauffeurCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vehiculePanelLayout.createSequentialGroup()
                                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vehiculePanelLayout.createSequentialGroup()
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        MainPanel.add(vehiculePanel, "card6");

        TransactionPanel.setPreferredSize(new java.awt.Dimension(1100, 532));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Gestion des Transactions");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setText("Bon ID:");

        bnidTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bnidTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bnidTxtKeyReleased(evt);
            }
        });

        puTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        puTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                puTxtKeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel31.setText("P.U:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel32.setText("P.T:");

        ptTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("Quantite:");

        qteTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setText("Staton:");

        stationCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        save.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        save.setText("Enregistrer");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton10.setText("Modifier");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        supprimer1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer1.setText("Supprimer");
        supprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        tableTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tableTransaction);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel56.setText("Service:");

        serviceCombo3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout TransactionPanelLayout = new javax.swing.GroupLayout(TransactionPanel);
        TransactionPanel.setLayout(TransactionPanelLayout);
        TransactionPanelLayout.setHorizontalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionPanelLayout.createSequentialGroup()
                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransactionPanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TransactionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TransactionPanelLayout.createSequentialGroup()
                                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(supprimer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(TransactionPanelLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(TransactionPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bnidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(TransactionPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(puTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TransactionPanelLayout.createSequentialGroup()
                                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ptTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TransactionPanelLayout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serviceCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(454, 454, 454))
        );
        TransactionPanelLayout.setVerticalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransactionPanelLayout.createSequentialGroup()
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(puTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ptTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        MainPanel.add(TransactionPanel, "card7");

        demandePanel.setPreferredSize(new java.awt.Dimension(1100, 510));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Gestion des demandes");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("Quantite:");

        qteTxt1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        serviceCombo2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel37.setText("Service:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel38.setText("Vehicule:");

        vehiculeTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Motif");

        mofifTxt.setColumns(20);
        mofifTxt.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        mofifTxt.setRows(5);
        jScrollPane7.setViewportView(mofifTxt);

        ajouter1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter1.setText("Envoyer");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        supprimer2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer2.setText("Supprimer");
        supprimer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer2ActionPerformed(evt);
            }
        });

        modifier1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier1.setText("Modifier");
        modifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier1ActionPerformed(evt);
            }
        });

        reset1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
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
        jScrollPane8.setViewportView(tableDemande);

        javax.swing.GroupLayout demandePanelLayout = new javax.swing.GroupLayout(demandePanel);
        demandePanel.setLayout(demandePanelLayout);
        demandePanelLayout.setHorizontalGroup(
            demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(demandePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(demandePanelLayout.createSequentialGroup()
                        .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, demandePanelLayout.createSequentialGroup()
                                    .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(serviceCombo2, javax.swing.GroupLayout.Alignment.LEADING, 0, 199, Short.MAX_VALUE)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(qteTxt1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vehiculeTxt))))
                            .addGroup(demandePanelLayout.createSequentialGroup()
                                .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supprimer2)
                                    .addComponent(ajouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(demandePanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        demandePanelLayout.setVerticalGroup(
            demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, demandePanelLayout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(demandePanelLayout.createSequentialGroup()
                        .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(qteTxt1)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(serviceCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vehiculeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(demandePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(demandePanelLayout.createSequentialGroup()
                                .addComponent(ajouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(demandePanelLayout.createSequentialGroup()
                                .addComponent(modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
        );

        MainPanel.add(demandePanel, "card8");

        BonPanel.setPreferredSize(new java.awt.Dimension(1100, 530));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel40.setText("Demande ID:");

        demandeID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel41.setText("Vehicule:");

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

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("Carburant:");

        carburantText.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel43.setText("Quantite:");

        qteTxt2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel44.setText("Station:");

        stationCombo1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("Autorise par:");

        employeCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        save1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        save1.setText("Enregister");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("Modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        reset2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });

        tableDemande1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(tableDemande1);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Liste des demandes");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Gestion des bons");

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
        jScrollPane10.setViewportView(tableBon);

        jLabel57.setText("Liste des bons");

        javax.swing.GroupLayout BonPanelLayout = new javax.swing.GroupLayout(BonPanel);
        BonPanel.setLayout(BonPanelLayout);
        BonPanelLayout.setHorizontalGroup(
            BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BonPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BonPanelLayout.createSequentialGroup()
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(BonPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addGap(12, 12, 12)
                                    .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(VehiculeCombo, 0, 178, Short.MAX_VALUE)
                                        .addComponent(demandeID)))
                                .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(BonPanelLayout.createSequentialGroup()
                                    .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(carburantText, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                        .addComponent(qteTxt2)))
                                .addGroup(BonPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(stationCombo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(BonPanelLayout.createSequentialGroup()
                                    .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(delete)
                                        .addComponent(save1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(reset2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(BonPanelLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(employeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BonPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9))
                            .addGroup(BonPanelLayout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(BonPanelLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BonPanelLayout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        BonPanelLayout.setVerticalGroup(
            BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BonPanelLayout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BonPanelLayout.createSequentialGroup()
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(demandeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BonPanelLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BonPanelLayout.createSequentialGroup()
                                .addComponent(VehiculeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carburantText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qteTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stationCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(reset2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel57))
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BonPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        MainPanel.add(BonPanel, "card9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1474, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void demandebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandebtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(demandePanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_demandebtnActionPerformed

    private void employebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employebtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(EmployePanel);
        MainPanel.repaint();
        MainPanel.revalidate();// TODO add your handling code here:
    }//GEN-LAST:event_employebtnActionPerformed

    private void vehiculebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculebtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(vehiculePanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_vehiculebtnActionPerformed

    private void employeCategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeCategorieItemStateChanged
        //        categorieTxt.setText(employeCategorie.getSelectedItem().toString());
    }//GEN-LAST:event_employeCategorieItemStateChanged

    private void employeCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeCategorieActionPerformed

    private void employeServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeServiceItemStateChanged
        //        servicetex.setText(employeService.getSelectedItem().toString());
    }//GEN-LAST:event_employeServiceItemStateChanged

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

    private void employeAjouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeAjouter1ActionPerformed
        employeAdresse.setText("");
        employeMatricule.setText("");
        employeNom.setText("");
        employePrenom.setText("");
        employeTelephone.setText("");
        employeCategorie.setSelectedItem(null);
        employeService.setSelectedItem(null);
    }//GEN-LAST:event_employeAjouter1ActionPerformed

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

    private void listServiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listServiceMouseReleased
        serviceText.setText(listService.getSelectedValue().toString());
    }//GEN-LAST:event_listServiceMouseReleased

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

    private void listModeleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listModeleMouseReleased
        modeleText.setText(listModele.getSelectedValue().toString());
    }//GEN-LAST:event_listModeleMouseReleased

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

    private void listCategorieMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCategorieMouseReleased
        CategorieText.setText(listCategorie.getSelectedValue().toString());
    }//GEN-LAST:event_listCategorieMouseReleased

    private void chauffeurComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chauffeurComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chauffeurComboActionPerformed

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
        String serviceId = new ServiceControleurs().returnId("serviceID", "service", "serviceNom", service);
        String carburantID = new CarburantControleur().returnId("carburantID", "carburant", "carburantNom", carburant);
        String chauffeurID = new EmployeControleur().returnId("employeid", "employe", "concat(employeNom,' ',employePrenom)", chauffeur);
        String modeleID = new ModeleControleur().returnId("modeleID", "modele", "modeleNom", modele);
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

    private void bnidTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bnidTxtKeyReleased
        qteTxt.setText(new BonCarburantControleur().afficherQuantite(bnidTxt.getText()));
    }//GEN-LAST:event_bnidTxtKeyReleased

    private void puTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puTxtKeyReleased
        int a = Integer.parseInt(qteTxt.getText());
        int b = Integer.parseInt(puTxt.getText());
        int pt = a * b;
        Integer i = pt;
        ptTxt.setText(i.toString());
    }//GEN-LAST:event_puTxtKeyReleased

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        int ajout;
        double qte = Double.parseDouble(qteTxt.getText());
        int pu = Integer.parseInt(puTxt.getText());
        int pt = Integer.parseInt(ptTxt.getText());
        String bon = bnidTxt.getText();
        String service = new ServiceControleurs().returnId("serviceID", "service", "serviceNom", serviceCombo3.getSelectedItem().toString());
        String station = new StationControleur().returnId("stationID", "station", "stationNom", stationCombo.getSelectedItem().toString());
        if (qteTxt.getText().isEmpty() || puTxt.getText().isEmpty() || ptTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous Les champ sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
        } //        else if(!new BonCarburantControleur().dejaExist(bnidTxt.getText())){
        //            JOptionPane.showMessageDialog(this, "Le Bon n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
        //        }
        else {
            ajout = new TransactionControleur().create(new Transaction(qte, pu, pt, bon, station, service));
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherTransactions();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void supprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimer1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
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
            ajout = controleur.create(new Demande(qte, controleurs.returnId("serviceID", "service", "serviceNom", service), motif, vehiculeTxt.getText()));
            if (ajout == 1) {
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherDemandes();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ajouter1ActionPerformed

    private void supprimer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer2ActionPerformed
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
    }//GEN-LAST:event_supprimer2ActionPerformed

    private void modifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier1ActionPerformed
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
                    update = controleur.update(new Demande(demandeID, qte, controleurs.returnId("serviceID", "service", "serviceNom", service), motif, vehiculeTxt.getText()));
                    if (update == 1) {
                        JOptionPane.showMessageDialog(this, "Modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        afficherDemandes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Action failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_modifier1ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        qteTxt.setText("");
        serviceCombo.setSelectedItem(null);
        mofifTxt.setText("");
        vehiculeTxt.setText("");
    }//GEN-LAST:event_reset1ActionPerformed

    private void tableDemandeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDemandeMouseReleased
        int row = tableDemande.getSelectedRow();
        qteTxt.setText(tableDemande.getValueAt(row, 1).toString());
        serviceCombo.setSelectedItem(tableDemande.getValueAt(row, 2).toString());
        mofifTxt.setText(tableDemande.getValueAt(row, 3).toString());
        vehiculeTxt.setText(tableDemande.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableDemandeMouseReleased

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

    private void VehiculeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VehiculeComboActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
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
                    employeControleur.returnId("employeID", "employe", "concat(employeNom,' ',employePrenom)", employeCombo.getSelectedItem().toString()), Integer.parseInt(demandeID.getText()), Double.parseDouble(qteTxt2.getText()), stationCombo1.getSelectedItem().toString()));
            if (ajout == 1) {
                new DemandeControleur().update(demandeID.getText());
                JOptionPane.showMessageDialog(this, "Enregistrement Reussi", "Success", JOptionPane.INFORMATION_MESSAGE);
                afficherBons();
            } else {
                JOptionPane.showMessageDialog(this, "Echec d'enregistrement", "Erreur!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_save1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset2ActionPerformed

    private void ajouter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter2ActionPerformed
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
    }//GEN-LAST:event_ajouter2ActionPerformed

    private void supprimer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer3ActionPerformed
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
    }//GEN-LAST:event_supprimer3ActionPerformed

    private void modifier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier2ActionPerformed
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
    }//GEN-LAST:event_modifier2ActionPerformed

    private void reset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset3ActionPerformed
        nifTxt.setText("");
        rcTxt.setText("");
        nomTxt.setText("");
        adresseTxt.setText("");
    }//GEN-LAST:event_reset3ActionPerformed

    private void tableStationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStationMouseReleased
        int row = tableStation.getSelectedRow();
        nifTxt.setText(tableStation.getValueAt(row, 2).toString());
        rcTxt.setText(tableStation.getValueAt(row, 3).toString());
        nomTxt.setText(tableStation.getValueAt(row, 1).toString());
        adresseTxt.setText(tableStation.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tableStationMouseReleased

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(Home);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_homebtnActionPerformed

    private void deconnectionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnectionbtnActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_deconnectionbtnActionPerformed

    private void rapportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapportbtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(RapportPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_rapportbtnActionPerformed

    private void stationbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stationbtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(StationPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_stationbtnActionPerformed

    private void multibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multibtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(MultitachePanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_multibtnActionPerformed

    private void transactionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionbtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(TransactionPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_transactionbtnActionPerformed

    private void bonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonBtnActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(BonPanel);
        MainPanel.repaint();
        MainPanel.revalidate();// TODO add your handling code here:
    }//GEN-LAST:event_bonBtnActionPerformed

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

    private void listCarburantMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCarburantMouseReleased
        carburantText.setText(listCarburant.getSelectedValue().toString());
    }//GEN-LAST:event_listCarburantMouseReleased

    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
        afficherTransactionsList();
    }//GEN-LAST:event_okbtnActionPerformed

    private void okbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtn1ActionPerformed
        MessageFormat header = new MessageFormat("Rapport pour le service: " + serviceCombo.getSelectedItem().toString());
        MessageFormat footer = new MessageFormat("*******************************par " + session.getText() + "************************************");
        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
        set.add(OrientationRequested.PORTRAIT);
        try {
            rapportTable.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(this, "Exporte avec succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okbtn1ActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        String plaques = plaque.getText();
        String modele = modeleCombo.getSelectedItem().toString();
        Integer ann = annee.getYear();
        String annees = ann.toString();
        String carburant = carburantCombo.getSelectedItem().toString();
        double consMoy = Double.parseDouble(consom.getText());
        String service = serviceCombo.getSelectedItem().toString();
        String chauffeur = chauffeurCombo.getSelectedItem().toString();
        VehiculeControleur controleur = new VehiculeControleur();
        String serviceId = new ServiceControleurs().returnId("serviceID", "service", "serviceNom", service);
        String carburantID = new CarburantControleur().returnId("carburantID", "carburant", "carburantNom", carburant);
        String chauffeurID = new EmployeControleur().returnId("employeid", "employe", "concat(employeNom,' ',employePrenom)", chauffeur);
        String modeleID = new ModeleControleur().returnId("modeleID", "modele", "modeleNom", modele);
        int i = -1;
        while (i < 0) {
            String id = JOptionPane.showInputDialog(this, "Saisir l'ID de l'employe à modifier");
            if (id.length() > 0) {
                i++;
                int updates;
                int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la modification?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (y == JOptionPane.OK_OPTION) {
                    updates = new VehiculeControleur().update(new Vehicule(Integer.parseInt(id), plaques, modeleID, annees, carburantID, consMoy, serviceId, chauffeurID));
                    if (updates == 1) {
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
        int ligne = tableVehicule.getSelectedRow();
        int id = Integer.parseInt(tableVehicule.getValueAt(ligne, 0).toString());
        int delete;
        Vehicule vehicule = new Vehicule();
        VehiculeControleur controleur = new VehiculeControleur();
        vehicule.setVehivuleID(id);
        int y = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiement faire la suppression ?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.OK_OPTION) {
            delete = controleur.delete(vehicule);
            if (delete == 1) {
                JOptionPane.showMessageDialog(this, "Supprimmé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                afficherStation();
            } else {
                JOptionPane.showMessageDialog(this, "Echec de suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        plaque.setText("");
        modeleCombo.setSelectedItem(null);
        carburantCombo.setSelectedItem(null);
        serviceCombo1.setSelectedItem(null);
        consom.setText("");
        chauffeurCombo.setSelectedItem(null);
    }//GEN-LAST:event_resetActionPerformed

    private void tableVehiculeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculeMouseReleased
        int row = tableVehicule.getSelectedRow();
        plaque.setText(tableVehicule.getValueAt(row, 1).toString());
        modeleCombo.setSelectedItem(tableVehicule.getValueAt(row, 2).toString());
//        annee.setYear(Integer.parseInt(tableVehicule.getValueAt(row, 3).toString()));
        carburantCombo.setSelectedItem(tableVehicule.getValueAt(row, 4).toString());
        consom.setText(tableVehicule.getValueAt(row, 5).toString());
        serviceCombo1.setSelectedItem(tableVehicule.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tableVehiculeMouseReleased

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminForm("").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BonPanel;
    private javax.swing.JTextField CategorieText;
    private javax.swing.JPanel EmployePanel;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MultitachePanel;
    private javax.swing.JPanel RapportPanel;
    private javax.swing.JPanel StationPanel;
    private javax.swing.JPanel TransactionPanel;
    private javax.swing.JComboBox<Vehicule> VehiculeCombo;
    private javax.swing.JTextField adresseTxt;
    private javax.swing.JButton ajoutCarburant;
    private javax.swing.JButton ajoutCategorie;
    private javax.swing.JButton ajoutModele;
    private javax.swing.JButton ajoutService;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouter1;
    private javax.swing.JButton ajouter2;
    private com.toedter.calendar.JYearChooser annee;
    private javax.swing.JTextField bnidTxt;
    private javax.swing.JButton bonBtn;
    private javax.swing.JComboBox<TypeCarburant> carburantCombo;
    private javax.swing.JTextField carburantText;
    private javax.swing.JTextField carburantText1;
    private javax.swing.JComboBox<Employe> chauffeurCombo;
    private javax.swing.JTextField consom;
    private com.toedter.calendar.JDateChooser dateDebut;
    private com.toedter.calendar.JDateChooser dateFin;
    private javax.swing.JLabel ddd;
    private javax.swing.JLabel ddd1;
    private javax.swing.JButton deconnectionbtn;
    private javax.swing.JButton delete;
    private javax.swing.JTextField demandeID;
    private javax.swing.JPanel demandePanel;
    private javax.swing.JButton demandebtn;
    private javax.swing.JTextField employeAdresse;
    private javax.swing.JButton employeAjouter;
    private javax.swing.JButton employeAjouter1;
    private javax.swing.JComboBox<CategorieEmploye> employeCategorie;
    private javax.swing.JComboBox<Employe> employeCombo;
    private javax.swing.JTextField employeMatricule;
    private javax.swing.JButton employeModifier;
    private javax.swing.JTextField employeNom;
    private javax.swing.JTextField employePrenom;
    private javax.swing.JComboBox<Service> employeService;
    private javax.swing.JButton employeSupprimer;
    private javax.swing.JTable employeTable;
    private javax.swing.JTextField employeTelephone;
    private javax.swing.JButton employebtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList listCarburant;
    private javax.swing.JList listCategorie;
    private javax.swing.JList listModele;
    private javax.swing.JList listService;
    private javax.swing.JComboBox<Modele> modeleCombo;
    private javax.swing.JTextField modeleText;
    private javax.swing.JButton modifier;
    private javax.swing.JButton modifier1;
    private javax.swing.JButton modifier2;
    private javax.swing.JTextArea mofifTxt;
    private javax.swing.JButton multibtn;
    private javax.swing.JTextField nifTxt;
    private javax.swing.JTextField nomTxt;
    private javax.swing.JButton okbtn;
    private javax.swing.JButton okbtn1;
    private javax.swing.JTextField plaque;
    private javax.swing.JTextField ptTxt;
    private javax.swing.JTextField puTxt;
    private javax.swing.JTextField qteTxt;
    private javax.swing.JTextField qteTxt1;
    private javax.swing.JTextField qteTxt2;
    private javax.swing.JTable rapportTable;
    private javax.swing.JButton rapportbtn;
    private javax.swing.JTextField rcTxt;
    private javax.swing.JButton reset;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JButton reset3;
    private javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JComboBox<Service> serviceCombo;
    private javax.swing.JComboBox<Service> serviceCombo1;
    private javax.swing.JComboBox<Service> serviceCombo2;
    private javax.swing.JComboBox<Service> serviceCombo3;
    private javax.swing.JTextField serviceText;
    private javax.swing.JLabel session;
    private javax.swing.JLabel session1;
    private javax.swing.JComboBox<Station> stationCombo;
    private javax.swing.JComboBox<Station> stationCombo1;
    private javax.swing.JButton stationbtn;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton supprimer1;
    private javax.swing.JButton supprimer2;
    private javax.swing.JButton supprimer3;
    private javax.swing.JTable tableBon;
    private javax.swing.JTable tableDemande;
    private javax.swing.JTable tableDemande1;
    private javax.swing.JTable tableStation;
    private javax.swing.JTable tableTransaction;
    private javax.swing.JTable tableVehicule;
    private javax.swing.JButton transactionbtn;
    private javax.swing.JButton update;
    private javax.swing.JPanel vehiculePanel;
    private javax.swing.JTextField vehiculeTxt;
    private javax.swing.JButton vehiculebtn;
    // End of variables declaration//GEN-END:variables
}

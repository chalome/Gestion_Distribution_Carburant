-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 06:33 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_distribution_carburant`
--

-- --------------------------------------------------------

--
-- Table structure for table `boncarburant`
--

CREATE TABLE `boncarburant` (
  `bonCarburantID` int(11) NOT NULL,
  `carburant` int(11) NOT NULL,
  `BonCarburantDate` date NOT NULL DEFAULT current_timestamp(),
  `bonCarburantVehicule` int(11) NOT NULL,
  `bonCarburantQuantite` double NOT NULL,
  `autorise_par` int(11) NOT NULL,
  `bonCarburantIDemande` int(11) NOT NULL,
  `bonStation` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `boncarburant`
--

INSERT INTO `boncarburant` (`bonCarburantID`, `carburant`, `BonCarburantDate`, `bonCarburantVehicule`, `bonCarburantQuantite`, `autorise_par`, `bonCarburantIDemande`, `bonStation`) VALUES
(1, 1, '2024-05-23', 1, 40, 2, 2, 'King Star'),
(2, 1, '2024-05-23', 3, 45, 2, 3, 'kobil');

-- --------------------------------------------------------

--
-- Table structure for table `carburant`
--

CREATE TABLE `carburant` (
  `carburantID` int(11) NOT NULL,
  `carburantNom` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carburant`
--

INSERT INTO `carburant` (`carburantID`, `carburantNom`) VALUES
(1, 'diesel'),
(2, 'mazutou'),
(3, 'essence'),
(4, 'Gazole'),
(5, 'Kerosene');

-- --------------------------------------------------------

--
-- Table structure for table `categorieemploye`
--

CREATE TABLE `categorieemploye` (
  `CategorieEmployeID` int(11) NOT NULL,
  `CategorieEmployeNom` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorieemploye`
--

INSERT INTO `categorieemploye` (`CategorieEmployeID`, `CategorieEmployeNom`) VALUES
(1, 'Chauffeur'),
(2, 'Chef de service'),
(3, 'Simple employe'),
(4, 'Pas de servive'),
(5, 'Gestionnaire'),
(6, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `demande`
--

CREATE TABLE `demande` (
  `demandeID` int(11) NOT NULL,
  `demandeQuantite` double NOT NULL,
  `demandeService` int(11) NOT NULL,
  `demandeMotif` text NOT NULL,
  `demandeDate` date NOT NULL DEFAULT current_timestamp(),
  `demandeEtat` int(11) NOT NULL DEFAULT 3,
  `demandeVehicule` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `demande`
--

INSERT INTO `demande` (`demandeID`, `demandeQuantite`, `demandeService`, `demandeMotif`, `demandeDate`, `demandeEtat`, `demandeVehicule`) VALUES
(1, 25, 2, 'voyage ', '2024-05-22', 3, 'A202'),
(2, 40, 2, 'voyage pour mission....', '2024-05-23', 1, 'A1999'),
(3, 45, 1, 'voyage....', '2024-05-23', 1, 'B1923');

-- --------------------------------------------------------

--
-- Table structure for table `demandeetat`
--

CREATE TABLE `demandeetat` (
  `demandeEtatID` int(11) NOT NULL,
  `demandeEtatNom` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `demandeetat`
--

INSERT INTO `demandeetat` (`demandeEtatID`, `demandeEtatNom`) VALUES
(1, 'Approuver'),
(2, 'Refuser'),
(3, 'En attente');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `employeID` int(11) NOT NULL,
  `employeMatricule` varchar(50) NOT NULL,
  `employeNom` varchar(80) NOT NULL,
  `employePrenom` varchar(80) NOT NULL,
  `employeAdresse` varchar(255) NOT NULL,
  `employeService` int(11) NOT NULL,
  `employeCategorie` int(11) NOT NULL,
  `employeTelephone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`employeID`, `employeMatricule`, `employeNom`, `employePrenom`, `employeAdresse`, `employeService`, `employeCategorie`, `employeTelephone`) VALUES
(2, '0001/2024', 'IZOMPANSAVYE', 'Chalom', 'Kanyosha', 2, 2, '68894773'),
(9, '0002/2024', 'MUGISHA', 'Chalome', 'Ruyigi', 3, 1, '67584930'),
(10, '0003/2024', 'NIYUKURI', 'Didier', 'Kayanza', 3, 1, '78695040'),
(11, '0004/2024', 'BUKURU', 'Etienne', 'Kinindo', 1, 5, '67564738'),
(12, '0005/2024', 'RUKUNDO', 'Eric', 'Rohero', 2, 6, '78940304');

-- --------------------------------------------------------

--
-- Table structure for table `modele`
--

CREATE TABLE `modele` (
  `modeleID` int(11) NOT NULL,
  `modeleNom` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modele`
--

INSERT INTO `modele` (`modeleID`, `modeleNom`) VALUES
(1, 'BWM'),
(2, 'Hilux'),
(3, 'Toyota'),
(4, 'Karina'),
(5, 'Rav4'),
(6, 'Land Cruiser');

-- --------------------------------------------------------

--
-- Table structure for table `rapport`
--

CREATE TABLE `rapport` (
  `rapportID` int(11) NOT NULL,
  `rapportQuantite` int(11) NOT NULL,
  `rapportCout` int(11) NOT NULL,
  `rapportPeriode` varchar(80) NOT NULL,
  `rapportQuantiteConsomme` int(11) NOT NULL,
  `rapportCoutConsomme` int(11) NOT NULL,
  `rapportCommantaire` text NOT NULL,
  `rapportTransaction` int(11) NOT NULL,
  `rapportDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceID` int(11) NOT NULL,
  `serviceNom` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceID`, `serviceNom`) VALUES
(1, 'CAOD'),
(2, 'Cabinet du ministere'),
(3, 'Pas de service');

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE `station` (
  `stationID` int(11) NOT NULL,
  `stationNIF` varchar(255) NOT NULL,
  `stationRC` varchar(255) NOT NULL,
  `stationNom` varchar(80) NOT NULL,
  `stationAdresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`stationID`, `stationNIF`, `stationRC`, `stationNom`, `stationAdresse`) VALUES
(1, '8594/ut/4981', 'registre', 'King Star', 'kanyosha'),
(3, '5649/5784/BU', 'REG', 'kobil', 'ruziba');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` int(11) NOT NULL,
  `transactionQuantite` double NOT NULL,
  `transactionPrixUnitaire` int(11) NOT NULL,
  `transactionPrixTotal` int(11) NOT NULL,
  `transactionDate` date NOT NULL DEFAULT current_timestamp(),
  `transactionBonCommande` int(11) NOT NULL,
  `transactionStation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionID`, `transactionQuantite`, `transactionPrixUnitaire`, `transactionPrixTotal`, `transactionDate`, `transactionBonCommande`, `transactionStation`) VALUES
(1, 40, 4000, 160000, '2024-05-23', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehicule`
--

CREATE TABLE `vehicule` (
  `vehiculeID` int(11) NOT NULL,
  `vehiculePlaque` varchar(80) NOT NULL,
  `vehiculeModele` int(11) NOT NULL,
  `vehiculeAnneeFabrication` year(4) NOT NULL,
  `vehiculeTypeCarburant` int(11) NOT NULL,
  `vehiculeConsommationMoyenne` double NOT NULL,
  `vehiculeService` int(11) NOT NULL,
  `vehiculeChauffeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicule`
--

INSERT INTO `vehicule` (`vehiculeID`, `vehiculePlaque`, `vehiculeModele`, `vehiculeAnneeFabrication`, `vehiculeTypeCarburant`, `vehiculeConsommationMoyenne`, `vehiculeService`, `vehiculeChauffeur`) VALUES
(1, 'A1999', 1, 2020, 3, 20, 2, 2),
(2, 'A2020', 2, 2019, 2, 20, 2, 10),
(3, 'B1923', 2, 2022, 3, 20, 1, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `boncarburant`
--
ALTER TABLE `boncarburant`
  ADD PRIMARY KEY (`bonCarburantID`),
  ADD KEY `bonCommandeVehicule` (`bonCarburantVehicule`),
  ADD KEY `autorise_par` (`autorise_par`),
  ADD KEY `carburant` (`carburant`),
  ADD KEY `bonCarburantIDemande` (`bonCarburantIDemande`);

--
-- Indexes for table `carburant`
--
ALTER TABLE `carburant`
  ADD PRIMARY KEY (`carburantID`);

--
-- Indexes for table `categorieemploye`
--
ALTER TABLE `categorieemploye`
  ADD PRIMARY KEY (`CategorieEmployeID`);

--
-- Indexes for table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`demandeID`),
  ADD KEY `demandeService` (`demandeService`),
  ADD KEY `demandeEtat` (`demandeEtat`);

--
-- Indexes for table `demandeetat`
--
ALTER TABLE `demandeetat`
  ADD PRIMARY KEY (`demandeEtatID`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`employeID`),
  ADD KEY `employeCategorie` (`employeCategorie`),
  ADD KEY `employeService` (`employeService`);

--
-- Indexes for table `modele`
--
ALTER TABLE `modele`
  ADD PRIMARY KEY (`modeleID`);

--
-- Indexes for table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`rapportID`),
  ADD KEY `rapportTransaction` (`rapportTransaction`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`stationID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `transactionBonCommande` (`transactionBonCommande`),
  ADD KEY `transactionStation` (`transactionStation`);

--
-- Indexes for table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`vehiculeID`),
  ADD KEY `vehiculeChauffeur` (`vehiculeChauffeur`),
  ADD KEY `vehiculeModele` (`vehiculeModele`),
  ADD KEY `vehiculeTypeCarburant` (`vehiculeTypeCarburant`),
  ADD KEY `vehiculeService` (`vehiculeService`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boncarburant`
--
ALTER TABLE `boncarburant`
  MODIFY `bonCarburantID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `carburant`
--
ALTER TABLE `carburant`
  MODIFY `carburantID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `categorieemploye`
--
ALTER TABLE `categorieemploye`
  MODIFY `CategorieEmployeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `demande`
--
ALTER TABLE `demande`
  MODIFY `demandeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `demandeetat`
--
ALTER TABLE `demandeetat`
  MODIFY `demandeEtatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `employeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `modele`
--
ALTER TABLE `modele`
  MODIFY `modeleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `rapport`
--
ALTER TABLE `rapport`
  MODIFY `rapportID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `serviceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `station`
--
ALTER TABLE `station`
  MODIFY `stationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `vehiculeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boncarburant`
--
ALTER TABLE `boncarburant`
  ADD CONSTRAINT `boncarburant_ibfk_1` FOREIGN KEY (`bonCarburantVehicule`) REFERENCES `vehicule` (`vehiculeID`),
  ADD CONSTRAINT `boncarburant_ibfk_2` FOREIGN KEY (`autorise_par`) REFERENCES `employe` (`employeID`),
  ADD CONSTRAINT `boncarburant_ibfk_3` FOREIGN KEY (`carburant`) REFERENCES `carburant` (`carburantID`),
  ADD CONSTRAINT `boncarburant_ibfk_4` FOREIGN KEY (`bonCarburantIDemande`) REFERENCES `demande` (`demandeID`);

--
-- Constraints for table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande_ibfk_1` FOREIGN KEY (`demandeService`) REFERENCES `service` (`serviceID`),
  ADD CONSTRAINT `demande_ibfk_2` FOREIGN KEY (`demandeEtat`) REFERENCES `demandeetat` (`demandeEtatID`);

--
-- Constraints for table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `employe_ibfk_1` FOREIGN KEY (`employeCategorie`) REFERENCES `categorieemploye` (`CategorieEmployeID`),
  ADD CONSTRAINT `employe_ibfk_2` FOREIGN KEY (`employeService`) REFERENCES `service` (`serviceID`);

--
-- Constraints for table `rapport`
--
ALTER TABLE `rapport`
  ADD CONSTRAINT `rapport_ibfk_1` FOREIGN KEY (`rapportTransaction`) REFERENCES `transaction` (`transactionID`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`transactionBonCommande`) REFERENCES `boncarburant` (`bonCarburantID`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`transactionStation`) REFERENCES `station` (`stationID`);

--
-- Constraints for table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`vehiculeChauffeur`) REFERENCES `employe` (`employeID`),
  ADD CONSTRAINT `vehicule_ibfk_2` FOREIGN KEY (`vehiculeModele`) REFERENCES `modele` (`modeleID`),
  ADD CONSTRAINT `vehicule_ibfk_3` FOREIGN KEY (`vehiculeTypeCarburant`) REFERENCES `carburant` (`carburantID`),
  ADD CONSTRAINT `vehicule_ibfk_4` FOREIGN KEY (`vehiculeService`) REFERENCES `service` (`serviceID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

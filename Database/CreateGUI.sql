-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.16-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for gui
CREATE DATABASE IF NOT EXISTS `gui` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gui`;


-- Dumping structure for table gui.appointments
CREATE TABLE IF NOT EXISTS `appointments` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`app_id`),
  KEY `FK_appointments_patient` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.billing
CREATE TABLE IF NOT EXISTS `billing` (
  `billing_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `service` varchar(250) NOT NULL,
  `price` varchar(250) NOT NULL,
  `paid` varchar(50) NOT NULL,
  PRIMARY KEY (`billing_id`),
  KEY `FK_billing_patient` (`patient_id`),
  CONSTRAINT `FK_billing_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.calls
CREATE TABLE IF NOT EXISTS `calls` (
  `call_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL DEFAULT '0',
  `date` varchar(50) NOT NULL DEFAULT '0',
  `time` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`call_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.drugs
CREATE TABLE IF NOT EXISTS `drugs` (
  `Drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `Drug_Name` varchar(50) DEFAULT NULL,
  `Drug_Register` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.message
CREATE TABLE IF NOT EXISTS `message` (
  `mess_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL DEFAULT '0',
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `Email` varchar(50) NOT NULL DEFAULT '0',
  `Date` varchar(50) NOT NULL DEFAULT '0',
  `Time` varchar(50) NOT NULL DEFAULT '0',
  `Message` varchar(50) NOT NULL DEFAULT '0',
  `read` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mess_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.patient
CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `Email` varchar(50) NOT NULL DEFAULT '0',
  `Address` varchar(50) NOT NULL DEFAULT '0',
  `Contact` varchar(50) NOT NULL DEFAULT '0',
  `Notes` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`patient_id`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.prescription
CREATE TABLE IF NOT EXISTS `prescription` (
  `presc_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_Name` varchar(50) DEFAULT NULL,
  `Drug_id` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `prescription` varchar(550) NOT NULL,
  PRIMARY KEY (`presc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table gui.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `Username` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Type` varchar(250) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

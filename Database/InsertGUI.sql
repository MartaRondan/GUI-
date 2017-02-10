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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.appointments: ~0 rows (approximately)
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` (`app_id`, `patient_id`, `date`, `time`) VALUES
	(2, 7, '15/12/16', '13.50');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.billing: ~1 rows (approximately)
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` (`billing_id`, `patient_id`, `service`, `price`, `paid`) VALUES
	(1, 3, 'Consultation', '150', 'NO'),
	(2, 3, 'X-Ray', '250', 'NO');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;


-- Dumping structure for table gui.calls
CREATE TABLE IF NOT EXISTS `calls` (
  `call_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL DEFAULT '0',
  `date` varchar(50) NOT NULL DEFAULT '0',
  `time` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`call_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.calls: ~4 rows (approximately)
/*!40000 ALTER TABLE `calls` DISABLE KEYS */;
INSERT INTO `calls` (`call_id`, `patient_id`, `date`, `time`) VALUES
	(1, 3, '23/12/13', '13:34'),
	(2, 2, '25/12/2016', '21.30'),
	(3, 2, '25/12/2016', '21.30'),
	(4, 4, '15/12/2016', '15.30'),
	(5, 2, '15/12/16', '15.30');
/*!40000 ALTER TABLE `calls` ENABLE KEYS */;


-- Dumping structure for table gui.drugs
CREATE TABLE IF NOT EXISTS `drugs` (
  `Drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `Drug_Name` varchar(50) DEFAULT NULL,
  `Drug_Register` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.drugs: ~12 rows (approximately)
/*!40000 ALTER TABLE `drugs` DISABLE KEYS */;
INSERT INTO `drugs` (`Drug_id`, `Drug_Name`, `Drug_Register`) VALUES
	(1, 'VND 1', 'CAT A'),
	(2, 'XXV 2 ', 'CAT A'),
	(3, 'HNF 232 ', 'CAT A'),
	(4, 'GB334', 'CAT A '),
	(5, 'X34', 'CAT B'),
	(6, 'HH5 ', 'CAT B'),
	(7, 'DDF23', 'CAT B'),
	(8, 'JHH7 ', 'CAT B'),
	(9, '543H', 'CAT C'),
	(10, '344BB', 'CAT C'),
	(11, 'JUY9', 'CAT C'),
	(12, '232B', 'CAT C');
/*!40000 ALTER TABLE `drugs` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.message: ~2 rows (approximately)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`mess_id`, `patient_id`, `Name`, `Email`, `Date`, `Time`, `Message`, `read`) VALUES
	(9, 2, '0', 'patient@patient.com', '12/12/12', '12:12', 'Message01', 'NO'),
	(10, 3, '0', 'patient2@patient2.com', '12/12/12', '12:12', 'Message02', 'NO'),
	(11, 4, '0', 'patient4@patient2.com', '12/12/14', '12:14', 'Message03', 'NO');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.patient: ~3 rows (approximately)
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`patient_id`, `Name`, `Email`, `Address`, `Contact`, `Notes`) VALUES
	(1, 'Marta', 'mcrondan@gmail.com', 'Clontarf', '987', '0'),
	(3, 'Claire', 'claire@gmail.com', 'Clontarf', '1234', '0'),
	(4, 'Daniel', 'dan@gmail.com', 'Clontarf', '12345', '0'),
	(5, 'Marta', 'mcrondan', 'Clontarf', '0', 'null');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


-- Dumping structure for table gui.prescription
CREATE TABLE IF NOT EXISTS `prescription` (
  `presc_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_Name` varchar(50) DEFAULT NULL,
  `Drug_id` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `prescription` varchar(550) NOT NULL,
  PRIMARY KEY (`presc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.prescription: ~3 rows (approximately)
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` (`presc_id`, `patient_Name`, `Drug_id`, `date`, `prescription`) VALUES
	(1, NULL, '12', '15/12', 'Panadol'),
	(2, 'Marta', '12/12/12', '12', 'Panadol'),
	(5, 'Marta', '12', '12', 'Panadol'),
	(6, 'lasdl', 'alksj', 'aksjlk', 'alksj'),
	(7, 'Ma', '30/9/16', '3', 'Lemsip');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;


-- Dumping structure for table gui.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `Username` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Type` varchar(250) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.users: ~3 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `Username`, `Password`, `Type`) VALUES
	(1, 'Marta', '1234', 'doctor'),
	(2, 'Betty', '1234', 'secretary'),
	(3, 'Chris', '1234', 'billing');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

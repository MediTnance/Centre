-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 19, 2011 at 09:57 PM
-- Server version: 5.1.36
-- PHP Version: 5.3.1

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: 'pa8'
--

-- --------------------------------------------------------

--
-- Table structure for table 'clients'
--

CREATE TABLE IF NOT EXISTS clients (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  firstname varchar(40) NOT NULL,
  lastname varchar(30) NOT NULL,
  address varchar(250) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table 'employees'
--

CREATE TABLE IF NOT EXISTS employees (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID de l''employé',
  birth_date date NOT NULL COMMENT 'date de naissance',
  first_name varchar(30) NOT NULL COMMENT 'nom',
  last_name varchar(30) NOT NULL COMMENT 'prenom',
  address varchar(250) NOT NULL COMMENT 'adresse',
  role tinyint(3) NOT NULL COMMENT 'role',
  specialization varchar(40) DEFAULT NULL COMMENT 'specialisation',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table 'furnitures'
--

CREATE TABLE IF NOT EXISTS furnitures (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  client_id smallint(5) unsigned NOT NULL,
  `type` tinyint(3) NOT NULL,
  brand varchar(50) NOT NULL,
  reference varchar(30) NOT NULL,
  last_intervention date DEFAULT NULL,
  verification tinyint(4) NOT NULL COMMENT 'delai de verif en mois',
  PRIMARY KEY (id),
  KEY client_id (client_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table 'interventions'
--

CREATE TABLE IF NOT EXISTS interventions (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  id_employee smallint(5) unsigned NOT NULL,
  id_client smallint(5) unsigned NOT NULL,
  cost smallint(5) unsigned NOT NULL,
  nature tinyint(3) unsigned NOT NULL,
  annotations text NOT NULL,
  date_intervention date NOT NULL,
  intervention_begin time NOT NULL,
  intervention_end time NOT NULL,
  PRIMARY KEY (id),
  KEY id_employee (id_employee),
  KEY id_client (id_client)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table 'pieces'
--

CREATE TABLE IF NOT EXISTS pieces (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  id_intervention smallint(5) unsigned NOT NULL,
  provider varchar(40) NOT NULL,
  reference varchar(40) NOT NULL,
  PRIMARY KEY (id),
  KEY id_intervention (id_intervention)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `furnitures`
--
ALTER TABLE `furnitures`
  ADD CONSTRAINT furnitures_ibfk_1 FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `interventions`
--
ALTER TABLE `interventions`
  ADD CONSTRAINT interventions_ibfk_2 FOREIGN KEY (id_client) REFERENCES clients (id) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT interventions_ibfk_1 FOREIGN KEY (id_employee) REFERENCES employees (id) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `pieces`
--
ALTER TABLE `pieces`
  ADD CONSTRAINT pieces_ibfk_1 FOREIGN KEY (id_intervention) REFERENCES interventions (id) ON DELETE CASCADE ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;

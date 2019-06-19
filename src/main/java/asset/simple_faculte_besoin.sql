-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2019 at 02:51 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simple_faculte_besoin`
--

-- --------------------------------------------------------

--
-- Table structure for table `expression_besoin`
--

CREATE TABLE `expression_besoin` (
  `id` bigint(20) NOT NULL,
  `code_entity` varchar(255) DEFAULT NULL,
  `code_personel` varchar(255) DEFAULT NULL,
  `date_expression` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expression_besoin`
--

INSERT INTO `expression_besoin` (`id`, `code_entity`, `code_personel`, `date_expression`, `reference`) VALUES
(85, 'dep-math', 'prof-9965', '2019-05-29', 'bsn-02'),
(88, 'dep-chimie', 'prof-2201', '2019-06-16', 'bsn-03'),
(82, 'dep-info', 'prof-10326', '2019-05-29', 'bsn-01');

-- --------------------------------------------------------

--
-- Table structure for table `expression_besoin_item`
--

CREATE TABLE `expression_besoin_item` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantite_accorder` int(11) NOT NULL,
  `quantite_commander` int(11) NOT NULL,
  `quantite_demande` int(11) NOT NULL,
  `quantite_livre` int(11) NOT NULL,
  `reference_categorie_produit` varchar(255) DEFAULT NULL,
  `reference_produit` varchar(255) DEFAULT NULL,
  `expression_besoin` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expression_besoin_item`
--

INSERT INTO `expression_besoin_item` (`id`, `description`, `quantite_accorder`, `quantite_commander`, `quantite_demande`, `quantite_livre`, `reference_categorie_produit`, `reference_produit`, `expression_besoin`) VALUES
(83, 'test', 2, 0, 3, 0, 'imprimante', 'azus', 82),
(84, 'test', 5, 0, 6, 0, 'imprimante', 'hp', 82),
(86, 'desc ', 5, 0, 18, 0, 'imprimante', 'pr-3', 85),
(87, 'test', 8, 3, 40, 0, 'imprimante', 'stylo', 85),
(89, 'test', 2, 0, 3, 0, 'imprimante', 'stylo', 88);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(91),
(91);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `expression_besoin`
--
ALTER TABLE `expression_besoin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expression_besoin_item`
--
ALTER TABLE `expression_besoin_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgp3j1fyg38ic2ghf0m81icvg6` (`expression_besoin`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

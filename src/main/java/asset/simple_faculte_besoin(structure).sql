-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 29 avr. 2019 à 23:12
-- Version du serveur :  10.1.35-MariaDB
-- Version de PHP :  7.2.9

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
-- Base de données :  `simple_faculte_besoin`
--

-- --------------------------------------------------------

--
-- Structure de la table `expression_besoin`
--

CREATE TABLE `expression_besoin` (
  `id` bigint(20) NOT NULL,
  `code_entity` varchar(255) DEFAULT NULL,
  `code_personel` varchar(255) DEFAULT NULL,
  `date_expression` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `expression_besoin_item`
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

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `expression_besoin`
--
ALTER TABLE `expression_besoin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `expression_besoin_item`
--
ALTER TABLE `expression_besoin_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgp3j1fyg38ic2ghf0m81icvg6` (`expression_besoin`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

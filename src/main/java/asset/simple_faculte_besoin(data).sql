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

--
-- Déchargement des données de la table `expression_besoin`
--

INSERT INTO `expression_besoin` (`id`, `code_entity`, `code_personel`, `date_expression`, `reference`) VALUES
(79, 'dep-math', 'prof-9010', '2019-04-23', 'bsn-03'),
(76, 'dep-info', 'prof-21006', '2019-04-23', 'bsn-02'),
(73, 'dep-info', 'prof-01', '2019-04-23', 'bsn-01');

--
-- Déchargement des données de la table `expression_besoin_item`
--

INSERT INTO `expression_besoin_item` (`id`, `description`, `quantite_accorder`, `quantite_commander`, `quantite_demande`, `quantite_livre`, `reference_categorie_produit`, `reference_produit`, `expression_besoin`) VALUES
(81, 'description', 1, 0, 2, 0, 'imprimante', 'stylo', 79),
(80, 'test', 0, 0, 9, 0, 'imprimante', 'azus', 79),
(78, 'exemple', 0, 0, 8, 0, 'imprimante', 'hp', 76),
(77, 'exemple', 10, 4, 10, 0, 'imprimante', 'stylo', 76),
(75, 'test ', 0, 0, 6, 0, 'imprimante', 'hp', 73),
(74, 'test', 2, 2, 4, 0, 'imprimante', 'azus', 73);

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(82),
(82);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 18 avr. 2019 à 10:13
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

--
-- Déchargement des données de la table `expression_besoin`
--

INSERT INTO `expression_besoin` (`id`, `code_entity`, `code_personel`, `date_expression`, `reference`) VALUES
(12, 'dep-math', 'prof-69', '2019-03-14', 'bsn-02'),
(9, 'dep-info', 'zouani', '2019-03-07', 'bsn-01'),
(16, 'dep-physique', 'prof-98', '2019-03-01', 'bsn-03'),
(21, 'dep-info', 'prof-55', '2019-05-01', 'bsn-04'),
(29, 'dep-info', 'prof-6002', '2019-03-07', 'bsn-05'),
(31, 'dep-bio', 'prof-963', '2019-03-01', 'bsn-06'),
(34, 'dep-chimie', 'prof-6632', '2019-03-14', 'bsn-09'),
(37, 'entite-0012', 'cadre-36525', '2019-03-27', 'bsn-07'),
(39, 'ent-2', 'prof-66302', '2019-03-06', 'bsn-10'),
(57, 'dep-chimie', 'prof-6330002mml', '2019-04-03', 'bsn-98'),
(54, 'dep-math', 'prof-96500014m', '2019-04-10', 'bsn-33');

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

--
-- Déchargement des données de la table `expression_besoin_item`
--

INSERT INTO `expression_besoin_item` (`id`, `description`, `quantite_accorder`, `quantite_commander`, `quantite_demande`, `quantite_livre`, `reference_categorie_produit`, `reference_produit`, `expression_besoin`) VALUES
(52, 'des', 0, 0, 13, 0, 'cat2', 'pre2', 51),
(18, 'test exemple', 2, 0, 4, 0, 'cat-36', 'pr1', 16),
(22, 'azerty', 3, 0, 5, 0, 'informatique', 'pr2', 21),
(32, 'test', 2, 0, 3, 0, 'catv', 'pr2', 31),
(30, 'teeeest', 5, 0, 10, 0, 'cat-1', 'pr2', 29),
(35, 'sdfsdf', 4, 0, 7, 0, 'azd', 'pr3', 34),
(38, 'qsdf', 5, 0, 7, 0, 'qsdf', 'pr3', 37),
(40, 'dfsdfgsdfg', 1, 0, 10, 0, 'prod', 'pr3', 39),
(42, 'fghj', 1, 0, 3, 0, 'fghj', 'pr3', 41),
(44, 'sdfggfd', 0, 0, 5, 0, 'sdfg', 'pr2', 43),
(46, 'dfhg', 2, 0, 4, 0, 'dfhg', 'pr1', 45),
(48, 'dfgh', 0, 0, 9, 0, 'dfhg', 'dfhg', 47),
(50, 'fhg', 0, 0, 6, 0, 'cat', 'pr', 49),
(53, '', 0, 0, 0, 0, '', '', 51),
(55, 'teest', 0, 0, 9, 0, 'imprimante', 'hp', 54),
(56, 'test', 0, 0, 9, 0, 'imprimante', 'stylo', 54),
(58, 'kjhgf', 0, 0, 5, 0, 'imprimante', 'azus', 57);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(59),
(59);

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

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 mars 2023 à 03:13
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `khedma`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `id_client` int(20) NOT NULL,
  `id_c` int(255) NOT NULL,
  `archive` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `date`, `id_client`, `id_c`, `archive`) VALUES
(22, 'Recherche developpeur', '2023-03-01', 1, 8, 0),
(23, 'Recherche Ingenieur', '2023-03-01', 1, 7, 0),
(24, 'Recherche formateur', '2023-03-02', 1, 7, 0),
(25, 'Recherche professeur', '2023-03-03', 1, 7, 0),
(26, 'Recherche prof DS', '2023-03-08', 1, 8, 0),
(31, 'Recherche architecte', '2023-03-04', 8, 9, 0),
(32, 'Recherche devloppeur', '2023-03-24', 8, 7, 0),
(33, 'Recherche ingenieure', '2023-03-28', 8, 8, 0);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `Type` varchar(250) NOT NULL,
  `archive` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom`, `Type`, `archive`) VALUES
(1, 'Les événements caritatifs', 'Les événements caritatifs', 0),
(2, 'Événements éducatifs', 'Événements éducatifs', 0),
(3, 'Événements culturels', 'Événements culturels', 0),
(4, 'Événements en ligne', 'Événements en ligne', 0),
(5, 'Soirée ', 'Soirée ', 0),
(34, 'Evenement Mondiale', 'Evenement Mondiale', 0);

-- --------------------------------------------------------

--
-- Structure de la table `classification`
--

CREATE TABLE `classification` (
  `id` int(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `domaine` varchar(255) NOT NULL,
  `archive` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `classification`
--

INSERT INTO `classification` (`id`, `Nom`, `domaine`, `archive`) VALUES
(7, 'mobile', 'développement', 0),
(8, 'DS', 'Informatique', 0),
(9, 'design', 'architecture', 0),
(10, 'genie logiciel', 'Informatique', 0);

-- --------------------------------------------------------

--
-- Structure de la table `code`
--

CREATE TABLE `code` (
  `codeEmail` int(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `code`
--

INSERT INTO `code` (`codeEmail`, `email`) VALUES
(420152, 'jlidi.doniaa@gmail.com'),
(923572, 'jlidi.doniaa@gmail.com'),
(464782, 'jlidi.doniaa@gmail.com'),
(176752, 'jlidi.doniaa@gmail.com'),
(959475, 'jlidi.doniaa@gmail.com'),
(7903, 'jlidi.doniaa@gmail.com'),
(550100, 'jlidi.doniaa@gmail.com'),
(652478, 'jlidi.doniaa@gmail.com'),
(595852, 'jlidi.doniaa@gmail.com'),
(377146, 'jlidi.donia@esprit.tn'),
(681963, 'jlidi.donia@esprit.tn'),
(718299, 'jlidi.doniaa@gmail.com'),
(426076, 'jlidi.donia@esprit.tn'),
(171397, 'jlidi.doniaa@gmail.com'),
(922820, 'jlidi.doniaa@gmail.com'),
(797481, 'fgjdkhhfl@nj.com'),
(759049, 'jlidi.doniaa@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(255) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `Lieu` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `prix` int(255) NOT NULL,
  `archive` int(11) NOT NULL DEFAULT 0,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `titre`, `description`, `Lieu`, `date`, `id_categorie`, `prix`, `archive`, `image`) VALUES
(1, 'Orientation', 'événements cible les nouveaux bacheliers afin de les informer des possibilités de formation dans les établissements universitaires et leurs perspectives d\'emploi', 'Hotel Africa', '2023-07-20', 1, 20, 1, 'dqqd'),
(144, 'Tommorow Land', 'Tomorrowland est un festival de musique électronique qui se tient chaque année en Belgique', 'Belgique', '2023-06-21', 34, 560, 0, 'C:\\Users\\DELL\\Desktop\\khedma_rahma\\src\\Images\\Tomorrowland.jpg'),
(145, 'Tommorow Land', 'Tomorrowland est un festival de musique électronique qui se tient chaque année en Belgique', 'Belgique', '2023-06-21', 34, 560, 1, 'C:\\Users\\DELL\\Pictures\\Saved Pictures\\rahma.PNG'),
(147, 'Coachella ', 'Coachella est un festival de musique  qui se tient chaque année en Californie aux EtatsUnis Le festival est connu pour ses performances de musique en direct sa variété de genres musicaux  ses installations artistiques et ses expériences immersives', 'Calfornie', '2023-04-14', 34, 560, 0, 'C:\\Users\\DELL\\Desktop\\khedma_rahma\\src\\Images\\Coachellacrop.png'),
(148, 'kitsch arabi', 'Il sagit dune soireea theme oriental ou des chansons typiques du registre oriental kitsch généralement égyptiennes sont jouéesDe Ehab Tawfik à Hakim Heithem et Sharifa font vibrer leur public le temps d’une soirée', 'yuka', '2023-03-24', 5, 80, 0, 'C:\\Users\\DELL\\Desktop\\khedma_rahma\\src\\Images\\Kitsch2310-07-scaled.jpg'),
(149, 'Formation  en java', 'ette formation est conçue pour apprendre les bases de la programmation Javaette formation est conçue pour apprendre les bases de la programmation Java', 'RBK ghazela', '2023-04-01', 2, 300, 0, 'C:\\Users\\DELL\\Desktop\\khedma_rahma\\src\\Images\\java.png'),
(150, 'Formation en Python', ' cette formation est conçue pour apprendre les bases de la programmation Python cette formation est conçue pour apprendre les bases de la programmation Python', 'Go my code', '2023-04-24', 2, 280, 0, 'C:\\Users\\DELL\\Desktop\\khedma_rahma\\src\\Images\\python.png');

-- --------------------------------------------------------

--
-- Structure de la table `metier`
--

CREATE TABLE `metier` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `metier`
--

INSERT INTO `metier` (`id`, `nom`, `type`, `description`, `image`, `archive`) VALUES
(51, 'Couturere', 'Textile', 'L industrie textile regroupe les activites de production de fils et tissus destines a l habillement', 'C:\\\\Users\\\\Safe\\\\Documents\\\\NetBeansProjects\\\\khedma\\\\src\\\\Images\\\\couturiere.jpg', 0),
(52, 'Demenagement et transport', 'Transport', 'Votre demenageur professionnel se charge du deroulement de votre demenagement et de transport et demenagement meuble international', 'C:\\\\Users\\\\Safe\\\\Documents\\\\NetBeansProjects\\\\khedma\\\\src\\\\Images\\\\dem.jpg', 0),
(55, 'Entretien', 'Entretien', 'Activite d entretien', 'C:\\Users\\Safe\\Documents\\NetBeansProjects\\khedma\\src\\Images\\femme-de-menage.jpg', 0),
(56, 'Reparation', 'Reparation', 'Activites de reparation', 'C:\\\\Users\\\\Safe\\\\Documents\\\\NetBeansProjects\\\\khedma\\\\src\\\\Images\\\\reparation-electroportatif-000675968-product_zoom.jpg', 0),
(57, 'Services a la personne', 'Services', 'Activites exercees a domicile', 'C:\\\\Users\\\\Safe\\\\Documents\\\\NetBeansProjects\\\\khedma\\\\src\\\\Images\\\\Services-a-la-personne-SAP_0.jpg', 0),
(60, 'Travaux et batiment', 'Traveaux', 'Travaux et batiment', 'C:\\\\Users\\\\Safe\\\\Pictures\\\\logo 5edma tr.png', 0),
(61, 'Evenementiel', 'Organisation', 'Congres-soirees de gala-festivals- salons professionnels- rencontres sportives.', 'C:\\Users\\Safe\\Pictures\\5edma.png', 0),
(75, 'dqdq', 'frdf', 'sds', 'kj', 1),
(76, 'fsdf', 'lkjsvlk', 'lkdflk', 'qs', 1),
(77, '', '', '', '', 1),
(78, 'firas', 'ayari', 'sss', 'C:\\\\Users\\\\Safe\\\\Pictures\\\\images.jpg', 1);

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id` int(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `domaine` varchar(255) NOT NULL,
  `client` varchar(255) NOT NULL,
  `freelancer` varchar(255) NOT NULL,
  `freelancer_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `archive` varchar(255) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `nom`, `domaine`, `client`, `freelancer`, `freelancer_id`, `client_id`, `archive`) VALUES
(56, 'yyyy', 'y', 'y', 'y', NULL, NULL, NULL),
(60, 'ggg', 'gg', 'gg', 'gg', NULL, NULL, '0'),
(61, 'dsqd', 'dsqd', 'dqsd', 'qsd', NULL, NULL, NULL),
(62, 'new', 'new', 'new', 'new', NULL, NULL, NULL),
(63, 'zzzzz', 'zzzzz', 'zzzzzzz', 'zzzzzzzzz', NULL, NULL, NULL),
(64, 'sqs', 'sq', 'sqs', 'sq', NULL, NULL, NULL),
(65, 'qsdqsd', 'qsd', 'qsd', 'qsdqsdqd', NULL, NULL, NULL),
(66, 'llllllllll', 'lll', 'lllll', 'l', NULL, NULL, '1'),
(67, 'aaa', 'aa', 'aa', 'aa', NULL, NULL, '1'),
(68, 'yyyyyyyy', 'y', 'y', 'y', NULL, NULL, '1'),
(69, 'qdddddddddddd', 'qd', 'dqdq', 'qd', NULL, NULL, '1'),
(70, 'mmm', 'g', 'gdf', 'dg', NULL, NULL, '1'),
(71, 'iyui', 'yu', 'iyu', 'iy', NULL, NULL, '1'),
(72, 'eaze', 'zae', 'azeaze', 'aez', NULL, NULL, '1'),
(73, 'Projet Web', 'mohamed', 'azer', 'Web', NULL, NULL, '1'),
(74, 'Mobile', 'azer', 'azer', 'azz', NULL, NULL, '1'),
(75, 'Test', 'az', 'az', 'az', NULL, NULL, '1'),
(76, 'kk', 'qd', 'qd', 'qd', NULL, NULL, '1'),
(77, 'zzz', 'z', 'z', 'z', NULL, NULL, '1'),
(78, 'uu', 'dqs', 'uzedqs', 'qsd', NULL, NULL, '1'),
(79, 'Projecta', 'qsd', 'qsd', 'qsd', NULL, NULL, '1'),
(80, 'momo', 'mo', 'momo', 'mo', NULL, NULL, '1'),
(81, 'hh', 'qsd', 'dqs', 'qds', NULL, NULL, '1'),
(82, ':ll', 'l', 'll', 'l', NULL, NULL, '1'),
(83, 'hhqsd', 'sqd', 'fds', 'sqd', NULL, NULL, '1'),
(84, 'TestForFolder', 'sqd', 'sqd', 'qsd', NULL, NULL, '0'),
(85, 'Newfortest', 'dq', 'dsq', 'sdq', NULL, NULL, '0'),
(86, 'ooo', 'Azer', 'fff', 'fff', NULL, NULL, '0'),
(87, 'kkkk', 'q', 'Azer', 'sqsq', NULL, NULL, '1'),
(88, 'Trello', 'd', 'Azer', 'dqsd', NULL, NULL, '1'),
(89, 'TestAPI', 'Web', 'AzerTest', 'Mohamed', NULL, NULL, '0'),
(90, 'ProjetQT', 'C++', 'Azer', 'saif', NULL, NULL, '0'),
(91, 'ProjetJAVA', 'java', 'Azer', 'morcel', NULL, NULL, '0'),
(92, 'STM32', 'Electronix=c', 'Gass', 'morcel', NULL, NULL, '0'),
(93, '¨ProjetJava', 'java', 'Hosni', 'ezer', NULL, NULL, '0'),
(94, 'ProjetWeb', 'web', 'Hosni', 'houssem', NULL, NULL, '0'),
(95, 'KKK', 'web', 'Azer', 'azer', NULL, NULL, '0'),
(96, 'lllll', 'kk', 'Azer', 'oko', NULL, NULL, '0'),
(97, 'Morcel', 'Web', 'Azer', 'Morcel', NULL, NULL, '0'),
(98, 'Morcel2', 'AA', 'Azer', 'AA', NULL, NULL, '0'),
(99, 'TTTT', 'Déménagement et transport', 'Azer', 'TTT', NULL, NULL, '0'),
(100, 'RAHMATESING', 'Déménagement et transport', 'rahma', 'azer', NULL, NULL, '1'),
(101, 'TESTTT', 'Réparation', 'rahma', 'aaaa', NULL, NULL, '1'),
(102, 'RAHMATESTING', 'rahma', 'Déménagement et transport', 'azer', NULL, NULL, '0'),
(103, 'RAHMAWEB', 'nidhal', 'Entretien', 'rahma', NULL, NULL, '0'),
(104, 'TESTING222', 'Déménagement et transport', 'rahma', 'nidhal', NULL, NULL, '0'),
(105, 'LOLOOO', 'Entretien', 'rahma', 'loulou', NULL, NULL, '0'),
(106, 'testprojet', 'Entretien', 'ABIDI', 'donia', NULL, NULL, '0'),
(107, 'TESTTOKEN', 'Déménagement et transport', 'ABIDI', 'seif', NULL, NULL, '0'),
(108, 'TOKENTEST', 'Entretien', 'ABIDI', 'donia', NULL, NULL, '0'),
(109, 'TESTTOKENNS', 'Entretien', 'ABIDI', 'test', NULL, NULL, '0'),
(110, 'TESTTOKENS', 'Entretien', 'ABIDI', 'ffrr', NULL, NULL, '0'),
(111, 'TESTSSTOKEN', 'Déménagement et transport', 'ABIDI', 'seif', NULL, NULL, '0'),
(112, 'ZZZZZZZTEST', 'Déménagement et transport', 'ABIDI', 'doniaaaaa', NULL, NULL, '0'),
(113, 'TESTKKK', 'Déménagement et transport', 'ABIDI', 'donia', NULL, NULL, '0'),
(114, 'TESTINGSAIFAPI', 'Couturère', 'ABIDI', 'Azer', NULL, NULL, '0'),
(115, 'TESTSAIF', 'Déménagement et transport', 'ABIDI', 'SEIF', NULL, NULL, '0'),
(116, 'TESTAPIGOT', 'Déménagement et transport', 'ABIDI', 'seif', NULL, NULL, '0');

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE `rating` (
  `id_evenement` int(11) NOT NULL,
  `id_Freelancer` int(11) NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rating`
--

INSERT INTO `rating` (`id_evenement`, `id_Freelancer`, `rating`) VALUES
(1, 18, 5),
(121, 1, 3),
(144, 1, 5),
(147, 25, 5),
(148, 19, 2);

-- --------------------------------------------------------

--
-- Structure de la table `sous-metier`
--

CREATE TABLE `sous-metier` (
  `id` int(255) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `domaine` varchar(255) NOT NULL,
  `m-id` int(11) NOT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `sous-metier`
--

INSERT INTO `sous-metier` (`id`, `libelle`, `domaine`, `m-id`, `archive`) VALUES
(92, 'Entretien de voitures', 'Mécanique voiture', 55, 0),
(93, 'Entretien de la maison', 'Ménage', 55, 0),
(94, 'Reparation appareils electroniques et informatique', 'Electronique', 56, 0),
(95, 'Entretien de moto', 'Mécanique moto', 55, 0),
(96, 'Entretien de vélo', 'Mécanique de vélo', 55, 0),
(97, 'Reparation accessoires antiques', 'Vintage', 56, 0),
(98, 'Travaux ménagers', 'Ménage', 57, 0),
(99, 'Baby sitting', 'Prise en soin', 57, 0),
(100, 'Stiliste modeliste', 'Textile', 51, 0),
(101, 'Transporteur meuble', 'Transport', 52, 0),
(102, 'Remorquage', 'Transport', 52, 0),
(103, 'Travaux de maçonnerie', 'Batiments', 60, 0),
(104, 'Poncage et pollissage', 'Batiments', 60, 0),
(105, 'Forge', 'Batiments', 60, 0),
(106, 'Electricite des batiments', 'Batiments', 60, 0),
(107, 'Plomberie', 'Batiments', 60, 0),
(108, 'Tapissier', 'Batiments', 60, 0),
(109, 'system de securite et surveillance', 'Batiments', 60, 0),
(110, 'Architecture interieur et decoration', 'Batiments', 60, 0),
(111, 'Menuiserie', 'Batiments', 60, 0),
(112, 'Serrure', 'Batiments', 60, 0),
(113, 'Travaux de peintures', 'Batiments', 60, 0),
(114, 'Auxiliaire de vie sociale', 'Services', 57, 0),
(115, 'Retouches', 'Textile', 51, 0),
(116, 'Robe de mariage', 'Textile', 51, 0),
(117, 'Robe de soiree', 'Textile', 51, 0),
(118, 'Casual', 'Textile', 51, 0),
(119, 'Vider un appartement/maison', 'Transport', 52, 0),
(120, 'Coach personnel', 'Services', 57, 0),
(121, 'Education canine', 'Services', 57, 0),
(122, 'Reparation des climatiseurs', 'Electronique', 56, 0),
(123, 'Reparation electromenager', 'Electronique', 56, 0),
(124, 'Jardinage', 'Jardin', 55, 0),
(125, 'Musique', 'Evenementiel', 61, 0),
(126, 'Events planner', 'Evenementiel', 61, 0),
(127, 'Decoration des evenement', 'Evenementiel', 61, 0),
(128, 'Traiteur', 'Evenementiel', 61, 0),
(129, 'Photographie', 'Evenementiel', 61, 0);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `estimated_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `project_id`, `nom`, `status`, `description`, `priority`, `estimated_time`) VALUES
(23, 56, 'Frontend', 'TODO', 'qsd', 2, 2),
(24, 60, 'Frontend', 'DONE', 'dqsd', 2, 2),
(26, 85, 'rrrr', 'DOING', 'qsd', 1, 1),
(27, 84, 'fff', 'TODO', 'qsd', 1, 1),
(28, 88, 'ddd', 'DOING', 'dd', 1, 1),
(29, 86, 'task1', 'TODO', 'qds', 1, 1),
(30, 86, 'TASK2', 'DOING', 'qsd', 1, 1),
(31, 86, 'task3', 'TODO', 'sd', 1, 1),
(32, 89, 'Task1', 'TODO', 'aa', 1, 1),
(33, 87, 'Fronted', 'DOING', 'dqs', 1, 1),
(34, 88, 'Texting', 'DOING', 'qsd', 1, 1),
(35, 87, 'Backend', 'REVIEWING', 'sqd', 1, 1),
(36, 87, 'APIsq', 'TODO', 'd', 1, 1),
(37, 87, 'UI', 'ACCEPTED', 'dqs', 1, 1),
(38, 90, 'UI', 'ACCEPTED', 'dqs', 1, 1),
(39, 90, 'CODE', 'ACCEPTED', 'dq', 1, 1),
(40, 91, 'FrontAngular', 'ACCEPTED', 'aa', 1, 1),
(41, 91, 'SpringBack', 'ACCEPTED', 'qds', 1, 1),
(42, 92, 'Arduino', 'ACCEPTED', 'dd', 1, 1),
(43, 94, 'Front', 'ACCEPTED', 'ds', 1, 2),
(44, 94, 'Backend', 'ACCEPTED', 'as', 1, 1),
(45, 105, 'WEB', 'ACCEPTED', 'dd', 1, 1),
(46, 105, 'LOLOOWEB', 'ACCEPTED', 'TEST', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `cin` int(8) NOT NULL,
  `metier` varchar(255) DEFAULT NULL,
  `domaine` varchar(255) DEFAULT NULL,
  `archive` int(11) NOT NULL DEFAULT 0,
  `role` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `telephone` int(8) NOT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Github_UserName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `cin`, `metier`, `domaine`, `archive`, `role`, `email`, `mdp`, `adresse`, `telephone`, `Image`, `Github_UserName`) VALUES
(1, 'dONIA', 'admin', 12345678, NULL, NULL, 0, 'Admin', 'jlidi.doniaa@gmail.com', '706fa063ed9eae16b85a49ed7a9729a2 ', 'ariana', 12345678, '', ''),
(3, 'fre', 'fre', 12345678, 'raa3', NULL, 0, 'Freelancer', 'fre@gmail.com', '5e36941b3d856737e81516acd45edc50', 'B', 12345678, '', ''),
(8, 'achraf', 'abbes', 13253604, NULL, 'info', 0, 'Client', 'Abbesashraf@gmail.com', 'KFYujGu7', 'gggg', 12345678, '', ''),
(10, 'abir', 'rhouma', 12345678, 'cc', NULL, 0, 'Client', 'abirrhoumaa@gmail.com', '5e36941b3d856737e81516acd45edc50 ', 'hh', 12345678, '', ''),
(24, 'hosni', 'mohamed', 12345678, 'info', NULL, 0, 'Freelancer', 'mohamed.hosni@esprit.tn', '5e36941b3d856737e81516acd45edc50', 'ariana', 12345678, '', '');

-- --------------------------------------------------------

--
-- Structure de la table `user_sousmetier`
--

CREATE TABLE `user_sousmetier` (
  `id_user` int(255) NOT NULL,
  `id_sm` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user_sousmetier`
--

INSERT INTO `user_sousmetier` (`id_user`, `id_sm`) VALUES
(1, 110),
(25, 110),
(5, 110),
(19, 114),
(19, 114),
(10, 99),
(16, 99),
(8, 99),
(28, 110),
(15, 129);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_c` (`id_c`),
  ADD KEY `annonce_ibfk_1` (`id_client`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `classification`
--
ALTER TABLE `classification`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categorie` (`id_categorie`);

--
-- Index pour la table `metier`
--
ALTER TABLE `metier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_client` (`client_id`),
  ADD KEY `fk_freelancer` (`freelancer_id`);

--
-- Index pour la table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_evenement`,`id_Freelancer`),
  ADD KEY `id_admin` (`id_Freelancer`);

--
-- Index pour la table `sous-metier`
--
ALTER TABLE `sous-metier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `m-id` (`m-id`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD KEY `project_id` (`project_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_sousmetier`
--
ALTER TABLE `user_sousmetier`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_sousmetier` (`id_sm`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `classification`
--
ALTER TABLE `classification`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT pour la table `metier`
--
ALTER TABLE `metier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT pour la table `sous-metier`
--
ALTER TABLE `sous-metier`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_c` FOREIGN KEY (`id_c`) REFERENCES `classification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_evenement_categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `fk_client` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `fk_freelancer` FOREIGN KEY (`freelancer_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `sous-metier`
--
ALTER TABLE `sous-metier`
  ADD CONSTRAINT `m-id` FOREIGN KEY (`m-id`) REFERENCES `metier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `projet` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

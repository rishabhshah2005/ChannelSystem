-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2024 at 06:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tvms`
--

-- --------------------------------------------------------

--
-- Table structure for table `channel`
--

CREATE TABLE `channel` (
  `channel_id` int(11) NOT NULL,
  `channel_name` varchar(50) NOT NULL,
  `channel_type` varchar(50) NOT NULL,
  `channel_language` varchar(50) NOT NULL,
  `is_hd` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `channel`
--

INSERT INTO `channel` (`channel_id`, `channel_name`, `channel_type`, `channel_language`, `is_hd`) VALUES
(1, 'StarPlus', 'serial', 'hindi', 0),
(2, 'StarPlus', 'serial', 'hindi', 1),
(3, 'SonySub', 'comedy', 'hindi', 0),
(4, 'SonySub', 'comedy', 'hindi', 1),
(5, 'zeetv', 'serial', 'hindi', 0),
(6, 'zeetv', 'serial', 'hindi', 1),
(7, '&tv', 'comedy', 'hindi', 0),
(8, '&tv', 'comedy', 'hindi', 1),
(9, 'disney', 'cartoon', 'hindi', 0),
(10, 'disney', 'cartoon', 'hindi', 1),
(11, 'hungama', 'cartoon', 'hindi', 0),
(12, 'hungama', 'cartoon', 'hindi', 1),
(13, 'pogo', 'cartoon', 'hindi', 0),
(14, 'pogo', 'cartoon', 'hindi', 1),
(15, 'marvelHq', 'animation', 'english', 0),
(16, 'marvelHq', 'animation', 'english', 1),
(17, 'ajtak', 'news', 'hindi', 0),
(18, 'ajtak', 'news', 'hindi', 1),
(19, 'tv9gujarati', 'news', 'gujarati', 0),
(20, 'tv9gujarati', 'news', 'gujatari', 1),
(21, 'sandesh', 'news', 'hindi', 0),
(22, 'sandesh', 'news', 'hindi', 1),
(23, 'timesnow', 'news', 'english', 0),
(24, 'timesnow', 'news', 'english', 1),
(25, 'stargold', 'movie', 'hindi', 0),
(26, 'stargold', 'movie', 'hindi', 1),
(27, 'sonymax', 'movie', 'hindi', 0),
(28, 'sonymax', 'movie', 'hindi', 1),
(29, 'zeecinema', 'movie', 'hindi', 0),
(30, 'zeecinema', 'movie', 'hindi', 1),
(31, 'sonypix', 'movie', 'english', 0),
(32, 'sonypix', 'movie', 'english', 1),
(33, 'starsport1', 'sport', 'hindi', 0),
(34, 'starsport1', 'sport', 'hindi', 1),
(35, 'sonysport', 'sport', 'hindi', 0),
(36, 'sonysport', 'sport', 'hindi', 1),
(37, 'starsport2', 'sport', 'english', 0),
(38, 'starsport2', 'sport', 'english', 1),
(39, 'foxsports', 'sport', 'english', 0),
(40, 'foxsports', 'sport', 'english', 1),
(41, 'DDnational', 'serial', 'hindi', 0),
(42, 'DDnational', 'serial', 'hindi', 1),
(43, 'DDsport', 'sport', 'hindi', 0),
(44, 'DDsport', 'sport', 'hindi', 1),
(45, 'DDmovie', 'movie', 'hindi', 0),
(46, 'DDmovie', 'movie', 'hindi', 1),
(47, 'DDinternational', 'news', 'english', 0),
(48, 'DDinternational', 'news', 'english', 1);

-- --------------------------------------------------------

--
-- Table structure for table `free_channel`
--

CREATE TABLE `free_channel` (
  `free_channel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `free_channel`
--

INSERT INTO `free_channel` (`free_channel_id`) VALUES
(41),
(42),
(43),
(44),
(45),
(46),
(47),
(48);

-- --------------------------------------------------------

--
-- Table structure for table `hd_channel`
--

CREATE TABLE `hd_channel` (
  `hd_channel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hd_channel`
--

INSERT INTO `hd_channel` (`hd_channel_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40);

-- --------------------------------------------------------

--
-- Table structure for table `normal_channel`
--

CREATE TABLE `normal_channel` (
  `noraml_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `program_routine`
--

CREATE TABLE `program_routine` (
  `programe_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `time_slot_id` int(11) NOT NULL,
  `programe_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `program_routine`
--

INSERT INTO `program_routine` (`programe_id`, `channel_id`, `time_slot_id`, `programe_name`) VALUES
(1, 1, 1, 'naaptol'),
(2, 1, 2, 'sath nibhana sathiya'),
(3, 1, 3, 'maati se bandhi'),
(4, 1, 4, 'anupama'),
(5, 1, 5, 'yeh rishata kya kahelata hai'),
(6, 1, 6, 'mahabharat'),
(7, 1, 7, 'yeh jadu hai jin ka'),
(8, 1, 8, 'gum hai kisike pyar main'),
(9, 2, 9, 'naaptol'),
(10, 2, 10, 'sath nibhana sathiya'),
(11, 2, 11, 'maati se bandhi'),
(12, 2, 12, 'anupama'),
(13, 2, 13, 'yeh rishata kya kahelata hai'),
(14, 2, 14, 'mahabharat'),
(15, 2, 15, 'yeh jadu hai jin ka'),
(16, 2, 16, 'gum hai kisike pyar main'),
(17, 3, 17, 'naaptol'),
(18, 3, 18, 'vanshaj'),
(19, 3, 19, 'dhruv tara'),
(20, 3, 20, 'tmkoc'),
(21, 3, 21, 'pushpa impossible'),
(22, 3, 22, 'tmkoc'),
(23, 3, 23, 'jijaji chhat par hai '),
(24, 4, 24, 'naaptol'),
(25, 4, 25, 'vanshaj'),
(26, 4, 26, 'dhruv tara'),
(27, 4, 27, 'tmkoc'),
(28, 4, 28, 'pushpa impossible'),
(29, 4, 29, 'tmkoc'),
(30, 4, 30, 'jijaji chhat par hai'),
(31, 5, 31, 'naaptol'),
(32, 5, 32, 'kumkum bhagya'),
(33, 5, 33, 'kundli bhagya'),
(34, 5, 34, 'jodha akbar'),
(35, 5, 35, 'sa re gama pa'),
(36, 5, 36, 'kaun banega crorepati'),
(37, 6, 37, 'naaptol'),
(38, 6, 38, 'kumkum  bhagya'),
(39, 6, 39, 'kumdali bhagya'),
(40, 6, 40, 'jodha akbar'),
(41, 6, 41, 'sa re gamapa'),
(42, 6, 42, 'kaun banega crorepati'),
(43, 7, 43, 'naaptol'),
(44, 7, 44, 'bhabhi ji ghar pe hai'),
(45, 7, 45, 'happu ki ultan paltan'),
(46, 8, 46, 'naaptol'),
(47, 8, 47, 'bhabhi ji ghar pai hai'),
(48, 8, 48, 'happu ki ultan paltan'),
(49, 9, 49, 'doremon'),
(50, 9, 50, 'doremon movie'),
(51, 9, 51, 'classic doremon'),
(52, 9, 52, 'best of luck nikki'),
(53, 9, 53, 'doremon'),
(54, 10, 54, 'doremon'),
(55, 10, 55, 'doremon movie'),
(56, 10, 56, 'classic doremon'),
(57, 10, 57, 'best of luck nikki'),
(58, 10, 58, 'doremon'),
(59, 11, 59, 'shinchan'),
(60, 11, 60, 'pokemon'),
(61, 11, 61, 'shinchan movie'),
(62, 11, 62, 'old shinchan'),
(63, 12, 63, 'shinchan'),
(64, 12, 64, 'pokemon'),
(65, 12, 65, 'shinchan movie'),
(66, 12, 66, 'old shinchan'),
(67, 13, 67, 'chhota bheem'),
(68, 13, 68, 'super bheem'),
(69, 13, 69, 'karishna and balram'),
(70, 13, 70, 'takeshis castle'),
(71, 14, 71, 'chhota bheem'),
(72, 14, 72, 'super bheem'),
(73, 14, 73, 'karishna and balram'),
(74, 14, 74, 'takeshis castle'),
(75, 15, 75, 'Avengers Assemble'),
(76, 15, 76, 'Spider man '),
(77, 15, 77, 'Iron Man'),
(78, 15, 78, 'Pokemon'),
(79, 15, 79, 'Bayblade'),
(80, 16, 80, 'Avengers Assemble'),
(81, 16, 81, 'Spider man '),
(82, 16, 82, 'Iron Man'),
(83, 16, 83, 'Pokemon'),
(84, 16, 84, 'Bayblade'),
(85, 17, 85, 'News'),
(86, 17, 86, 'Bhakti '),
(87, 17, 87, 'News'),
(88, 17, 88, 'CrimeNews'),
(89, 18, 89, 'News'),
(90, 18, 90, 'Bhakti'),
(91, 18, 91, 'News  '),
(92, 18, 92, 'CrimeNews'),
(93, 19, 93, 'News'),
(94, 19, 94, 'Bhakti ma thai jao lin '),
(95, 19, 95, 'News'),
(96, 19, 96, 'Crime Report'),
(97, 20, 97, 'News'),
(98, 20, 98, 'Bhakti ma thai jao lin'),
(99, 20, 99, 'News  '),
(100, 20, 100, 'Crime Report'),
(101, 21, 101, 'News'),
(102, 21, 102, 'news now '),
(103, 21, 103, 'todays news'),
(104, 22, 104, 'News'),
(105, 22, 105, 'news now'),
(106, 22, 106, 'todays news'),
(107, 23, 107, 'Today Times News  '),
(108, 23, 108, 'News'),
(109, 24, 109, 'Today Times News'),
(110, 24, 110, 'News '),
(111, 25, 111, 'prem ratan dhanpayo'),
(112, 25, 112, 'singham'),
(113, 25, 113, 'dil to pagal hai'),
(114, 25, 114, 'DDLJ'),
(115, 25, 115, 'Shangh-chi  '),
(116, 25, 116, 'golmaal return'),
(117, 25, 117, 'bhool bhulya'),
(118, 25, 118, 'bhool bhulyam 2 '),
(119, 26, 119, 'prem ratan dhanpayo'),
(120, 26, 120, 'singham'),
(121, 26, 121, 'dil to pagal hai'),
(122, 26, 122, 'DDLJ  '),
(123, 26, 123, 'Shangh-chi '),
(124, 26, 124, 'golmaal return'),
(125, 26, 125, 'bhool bhulya'),
(126, 26, 126, 'bhool bhulyam 2'),
(127, 27, 127, 'Kantara'),
(128, 27, 128, 'Sultan '),
(129, 27, 129, 'Sooryavansham'),
(130, 27, 130, 'TZH'),
(131, 27, 131, 'Bahubali'),
(132, 27, 132, 'Bahubali 2'),
(133, 27, 133, ' KGF '),
(134, 27, 134, 'KGF 2'),
(135, 28, 135, 'Kantara'),
(136, 28, 136, 'Sultan '),
(137, 28, 137, 'Sooryavansham'),
(138, 28, 138, 'TZH'),
(139, 28, 139, 'Bahubali'),
(140, 28, 140, 'Bahubali 2'),
(141, 28, 141, 'KGF  '),
(142, 28, 142, 'KGF 2'),
(143, 29, 143, 'Spyder'),
(144, 29, 144, 'Holiday'),
(145, 29, 145, 'geeta govinda'),
(146, 29, 146, 'dear comrade'),
(147, 29, 147, 'Vivvah'),
(148, 29, 148, 'hum sath sath hai  '),
(149, 29, 149, 'hum apake hai kon'),
(150, 29, 150, 'ek vivaah esa bhi'),
(151, 30, 151, 'Spyder'),
(152, 30, 152, 'Holiday'),
(153, 30, 153, 'geeta govinda'),
(154, 30, 154, 'dear comrade '),
(155, 30, 155, 'Vivvah'),
(156, 30, 156, 'hum sath sath hai'),
(157, 30, 157, 'hum apake hai kon '),
(158, 30, 158, 'ek vivaah esa bhi'),
(159, 31, 159, 'F & F'),
(160, 31, 160, 'Incredible 2'),
(161, 31, 161, 'Avenger'),
(162, 31, 162, 'Avenger Age of ultron '),
(163, 31, 163, 'Thor'),
(164, 31, 164, 'Avenger infinity war'),
(165, 31, 165, 'Avenger End Game'),
(166, 31, 166, 'john wick'),
(167, 32, 167, 'F & F  '),
(168, 32, 168, 'Incredible 2'),
(169, 32, 169, 'Avenger'),
(170, 32, 170, 'Avenger Age of ultron '),
(171, 32, 171, 'Thor'),
(172, 32, 172, 'Avenger infinity war'),
(173, 32, 173, 'Avenger End Game'),
(174, 32, 174, 'john wick  '),
(175, 33, 175, 'Ads'),
(176, 33, 176, 'Cricket countdown '),
(177, 33, 177, 'IND VS AUS ODI'),
(178, 34, 178, 'Ads'),
(179, 34, 179, 'Cricket countdown '),
(180, 34, 180, 'IND VS AUS ODI '),
(181, 35, 181, ' WWE '),
(182, 35, 182, ' SA VS ENG TEST'),
(183, 35, 183, 'WWE RAMP PAGE'),
(184, 36, 184, 'WWE '),
(185, 36, 185, 'SA VS ENG TEST'),
(186, 36, 186, 'WWE RAMP PAGE'),
(187, 37, 187, 'ADS'),
(188, 37, 188, 'Cricket countdown'),
(189, 37, 189, 'SL VS BAN ODI  '),
(190, 37, 190, 'High Light(wc)'),
(191, 38, 191, 'ADS'),
(192, 38, 192, 'Cricket countdown'),
(193, 38, 193, 'SL VS BAN ODI'),
(194, 38, 194, 'High Light(wc)'),
(195, 39, 195, 'SPORTS'),
(196, 39, 196, 'Cricket'),
(197, 39, 197, 'PARIS OLYMIC'),
(198, 40, 198, 'SPORTS'),
(199, 40, 199, 'Cricket'),
(200, 40, 200, 'PARIS OLYMIC'),
(201, 41, 201, 'INDIAN HISTORY'),
(202, 41, 202, 'Story of india'),
(203, 41, 203, 'RAMAYAN'),
(204, 42, 204, 'INDIAN HISTORY'),
(205, 42, 205, 'Story of india '),
(206, 42, 206, 'RAMAYAN'),
(207, 43, 207, 'SPORTS'),
(208, 43, 208, 'KHELMAHA KUMBH'),
(209, 43, 209, 'SPORTS'),
(210, 44, 210, 'SPORTS'),
(211, 44, 211, 'KHELMAHA KUMBH'),
(212, 44, 212, 'SPORTS'),
(213, 45, 213, 'MOVIE'),
(214, 46, 214, 'MOVIE'),
(215, 47, 215, 'NEWS INTERNATIONAL'),
(216, 47, 216, 'INTERNATIONAL CRIME NEWS'),
(217, 47, 217, 'MAN VS WILD'),
(218, 48, 218, 'NEWS INTERNATIONAL'),
(219, 48, 219, 'INTERNATIONAL CRIME NEWS'),
(220, 48, 220, 'MAN VS WILD');

-- --------------------------------------------------------

--
-- Table structure for table `record_shows`
--

CREATE TABLE `record_shows` (
  `record_id` int(11) NOT NULL,
  `programe_name` varchar(50) NOT NULL,
  `time_slot_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `time_slot`
--

CREATE TABLE `time_slot` (
  `time_slot_id` int(11) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `time_slot`
--

INSERT INTO `time_slot` (`time_slot_id`, `start_time`, `end_time`) VALUES
(1, '12:00:00', '06:00:00'),
(2, '06:00:00', '09:00:00'),
(3, '09:00:00', '11:00:00'),
(4, '11:00:00', '12:00:00'),
(5, '12:00:00', '06:00:00'),
(6, '06:00:00', '08:00:00'),
(7, '08:00:00', '09:00:00'),
(8, '09:00:00', '12:00:00'),
(9, '12:00:00', '06:00:00'),
(10, '06:00:00', '09:00:00'),
(11, '09:00:00', '11:00:00'),
(12, '11:00:00', '12:00:00'),
(13, '12:00:00', '06:00:00'),
(14, '06:00:00', '08:00:00'),
(15, '08:00:00', '09:00:00'),
(16, '09:00:00', '12:00:00'),
(17, '12:00:00', '06:00:00'),
(18, '06:00:00', '07:00:00'),
(19, '07:00:00', '08:00:00'),
(20, '08:00:00', '09:00:00'),
(21, '09:00:00', '10:00:00'),
(22, '10:00:00', '11:00:00'),
(23, '11:00:00', '12:00:00'),
(24, '12:00:00', '06:00:00'),
(25, '06:00:00', '07:00:00'),
(26, '07:00:00', '08:00:00'),
(27, '08:00:00', '09:00:00'),
(28, '09:00:00', '10:00:00'),
(29, '10:00:00', '11:00:00'),
(30, '11:00:00', '12:00:00'),
(31, '12:00:00', '06:00:00'),
(32, '06:00:00', '09:00:00'),
(33, '09:00:00', '12:00:00'),
(34, '12:00:00', '06:00:00'),
(35, '06:00:00', '09:00:00'),
(36, '09:00:00', '12:00:00'),
(37, '12:00:00', '06:00:00'),
(38, '06:00:00', '09:00:00'),
(39, '09:00:00', '12:00:00'),
(40, '12:00:00', '06:00:00'),
(41, '06:00:00', '09:00:00'),
(42, '09:00:00', '12:00:00'),
(43, '12:00:00', '06:00:00'),
(44, '06:00:00', '06:00:00'),
(45, '06:00:00', '12:00:00'),
(46, '12:00:00', '06:00:00'),
(47, '06:00:00', '06:00:00'),
(48, '06:00:00', '12:00:00'),
(49, '12:00:00', '12:00:00'),
(50, '12:00:00', '03:00:00'),
(51, '03:00:00', '06:00:00'),
(52, '06:00:00', '09:00:00'),
(53, '09:00:00', '12:00:00'),
(54, '12:00:00', '12:00:00'),
(55, '12:00:00', '03:00:00'),
(56, '03:00:00', '06:00:00'),
(57, '06:00:00', '09:00:00'),
(58, '09:00:00', '12:00:00'),
(59, '12:00:00', '12:00:00'),
(60, '12:00:00', '06:00:00'),
(61, '06:00:00', '09:00:00'),
(62, '09:00:00', '12:00:00'),
(63, '12:00:00', '12:00:00'),
(64, '12:00:00', '06:00:00'),
(65, '06:00:00', '09:00:00'),
(66, '09:00:00', '12:00:00'),
(67, '12:00:00', '06:00:00'),
(68, '06:00:00', '12:00:00'),
(69, '12:00:00', '06:00:00'),
(70, '06:00:00', '12:00:00'),
(71, '12:00:00', '06:00:00'),
(72, '06:00:00', '12:00:00'),
(73, '12:00:00', '06:00:00'),
(74, '06:00:00', '12:00:00'),
(75, '12:00:00', '06:00:00'),
(76, '06:00:00', '09:00:00'),
(77, '09:00:00', '12:00:00'),
(78, '12:00:00', '06:00:00'),
(79, '06:00:00', '12:00:00'),
(80, '12:00:00', '06:00:00'),
(81, '06:00:00', '09:00:00'),
(82, '09:00:00', '12:00:00'),
(83, '12:00:00', '06:00:00'),
(84, '06:00:00', '12:00:00'),
(85, '12:00:00', '06:00:00'),
(86, '06:00:00', '09:00:00'),
(87, '09:00:00', '09:00:00'),
(88, '09:00:00', '12:00:00'),
(89, '12:00:00', '06:00:00'),
(90, '06:00:00', '09:00:00'),
(91, '09:00:00', '09:00:00'),
(92, '09:00:00', '12:00:00'),
(93, '12:00:00', '07:00:00'),
(94, '07:00:00', '09:00:00'),
(95, '09:00:00', '09:00:00'),
(96, '09:00:00', '12:00:00'),
(97, '12:00:00', '07:00:00'),
(98, '07:00:00', '09:00:00'),
(99, '09:00:00', '09:00:00'),
(100, '09:00:00', '12:00:00'),
(101, '12:00:00', '12:00:00'),
(102, '12:00:00', '06:00:00'),
(103, '06:00:00', '12:00:00'),
(104, '12:00:00', '12:00:00'),
(105, '12:00:00', '06:00:00'),
(106, '06:00:00', '12:00:00'),
(107, '12:00:00', '12:00:00'),
(108, '12:00:00', '12:00:00'),
(109, '12:00:00', '12:00:00'),
(110, '12:00:00', '12:00:00'),
(111, '12:00:00', '03:00:00'),
(112, '03:00:00', '06:00:00'),
(113, '06:00:00', '09:00:00'),
(114, '09:00:00', '12:00:00'),
(115, '12:00:00', '03:00:00'),
(116, '03:00:00', '06:00:00'),
(117, '06:00:00', '09:00:00'),
(118, '09:00:00', '12:00:00'),
(119, '12:00:00', '03:00:00'),
(120, '03:00:00', '06:00:00'),
(121, '06:00:00', '09:00:00'),
(122, '09:00:00', '12:00:00'),
(123, '12:00:00', '03:00:00'),
(124, '03:00:00', '06:00:00'),
(125, '06:00:00', '09:00:00'),
(126, '09:00:00', '12:00:00'),
(127, '12:00:00', '03:00:00'),
(128, '03:00:00', '06:00:00'),
(129, '06:00:00', '09:00:00'),
(130, '09:00:00', '12:00:00'),
(131, '12:00:00', '03:00:00'),
(132, '03:00:00', '06:00:00'),
(133, '06:00:00', '09:00:00'),
(134, '09:00:00', '12:00:00'),
(135, '12:00:00', '03:00:00'),
(136, '03:00:00', '06:00:00'),
(137, '06:00:00', '09:00:00'),
(138, '09:00:00', '12:00:00'),
(139, '12:00:00', '03:00:00'),
(140, '03:00:00', '06:00:00'),
(141, '06:00:00', '09:00:00'),
(142, '09:00:00', '12:00:00'),
(143, '12:00:00', '03:00:00'),
(144, '03:00:00', '06:00:00'),
(145, '06:00:00', '09:00:00'),
(146, '09:00:00', '12:00:00'),
(147, '12:00:00', '03:00:00'),
(148, '03:00:00', '06:00:00'),
(149, '06:00:00', '09:00:00'),
(150, '09:00:00', '12:00:00'),
(151, '12:00:00', '03:00:00'),
(152, '03:00:00', '06:00:00'),
(153, '06:00:00', '09:00:00'),
(154, '09:00:00', '12:00:00'),
(155, '12:00:00', '03:00:00'),
(156, '03:00:00', '06:00:00'),
(157, '06:00:00', '09:00:00'),
(158, '09:00:00', '12:00:00'),
(159, '12:00:00', '03:00:00'),
(160, '03:00:00', '06:00:00'),
(161, '06:00:00', '09:00:00'),
(162, '09:00:00', '12:00:00'),
(163, '12:00:00', '03:00:00'),
(164, '03:00:00', '06:00:00'),
(165, '06:00:00', '09:00:00'),
(166, '09:00:00', '12:00:00'),
(167, '12:00:00', '03:00:00'),
(168, '03:00:00', '06:00:00'),
(169, '06:00:00', '09:00:00'),
(170, '09:00:00', '12:00:00'),
(171, '12:00:00', '03:00:00'),
(172, '03:00:00', '06:00:00'),
(173, '06:00:00', '09:00:00'),
(174, '09:00:00', '12:00:00'),
(175, '12:00:00', '06:00:00'),
(176, '06:00:00', '09:00:00'),
(177, '09:00:00', '12:00:00'),
(178, '12:00:00', '06:00:00'),
(179, '06:00:00', '09:00:00'),
(180, '09:00:00', '12:00:00'),
(181, '12:00:00', '06:00:00'),
(182, '06:00:00', '06:00:00'),
(183, '06:00:00', '12:00:00'),
(184, '12:00:00', '06:00:00'),
(185, '06:00:00', '06:00:00'),
(186, '06:00:00', '12:00:00'),
(187, '12:00:00', '06:00:00'),
(188, '06:00:00', '09:00:00'),
(189, '09:00:00', '09:00:00'),
(190, '09:00:00', '12:00:00'),
(191, '12:00:00', '06:00:00'),
(192, '06:00:00', '09:00:00'),
(193, '09:00:00', '09:00:00'),
(194, '09:00:00', '12:00:00'),
(195, '12:00:00', '12:00:00'),
(196, '12:00:00', '06:00:00'),
(197, '06:00:00', '12:00:00'),
(198, '12:00:00', '12:00:00'),
(199, '12:00:00', '06:00:00'),
(200, '06:00:00', '12:00:00'),
(201, '12:00:00', '09:00:00'),
(202, '09:00:00', '12:00:00'),
(203, '12:00:00', '12:00:00'),
(204, '12:00:00', '09:00:00'),
(205, '09:00:00', '12:00:00'),
(206, '12:00:00', '12:00:00'),
(207, '12:00:00', '06:00:00'),
(208, '06:00:00', '06:00:00'),
(209, '06:00:00', '12:00:00'),
(210, '12:00:00', '06:00:00'),
(211, '06:00:00', '06:00:00'),
(212, '06:00:00', '12:00:00'),
(213, '12:00:00', '12:00:00'),
(214, '12:00:00', '12:00:00'),
(215, '12:00:00', '12:00:00'),
(216, '12:00:00', '06:00:00'),
(217, '06:00:00', '12:00:00'),
(218, '12:00:00', '12:00:00'),
(219, '12:00:00', '06:00:00'),
(220, '06:00:00', '12:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `package_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `package_id`) VALUES
(1, 'rishabh', 'rishabh', 1),
(4, 'admin', 'root', 1),
(5, 'k@1234', '1234', 1),
(6, 'kavya@123', '1234', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`channel_id`);

--
-- Indexes for table `free_channel`
--
ALTER TABLE `free_channel`
  ADD PRIMARY KEY (`free_channel_id`);

--
-- Indexes for table `hd_channel`
--
ALTER TABLE `hd_channel`
  ADD PRIMARY KEY (`hd_channel_id`);

--
-- Indexes for table `normal_channel`
--
ALTER TABLE `normal_channel`
  ADD PRIMARY KEY (`noraml_id`);

--
-- Indexes for table `program_routine`
--
ALTER TABLE `program_routine`
  ADD PRIMARY KEY (`programe_id`);

--
-- Indexes for table `record_shows`
--
ALTER TABLE `record_shows`
  ADD PRIMARY KEY (`record_id`);

--
-- Indexes for table `time_slot`
--
ALTER TABLE `time_slot`
  ADD PRIMARY KEY (`time_slot_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channel`
--
ALTER TABLE `channel`
  MODIFY `channel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `free_channel`
--
ALTER TABLE `free_channel`
  MODIFY `free_channel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `hd_channel`
--
ALTER TABLE `hd_channel`
  MODIFY `hd_channel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `normal_channel`
--
ALTER TABLE `normal_channel`
  MODIFY `noraml_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `record_shows`
--
ALTER TABLE `record_shows`
  MODIFY `record_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `time_slot`
--
ALTER TABLE `time_slot`
  MODIFY `time_slot_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=221;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

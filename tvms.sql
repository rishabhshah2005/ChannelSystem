-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2024 at 03:42 PM
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
(74, 14, 74, 'takeshis castle');

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
(16, '09:00:00', '12:00:00');

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
(5, 'k@1234', '1234', 1);

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
  MODIFY `time_slot_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2024 at 07:29 PM
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
  `is_hd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `free_channel`
--

CREATE TABLE `free_channel` (
  `free_channel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hd_channel`
--

CREATE TABLE `hd_channel` (
  `hd_channel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(4, 'admin', 'root', 1);

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
  MODIFY `channel_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `free_channel`
--
ALTER TABLE `free_channel`
  MODIFY `free_channel_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hd_channel`
--
ALTER TABLE `hd_channel`
  MODIFY `hd_channel_id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `time_slot_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

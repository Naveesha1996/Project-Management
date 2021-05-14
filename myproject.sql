-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 07:17 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `myproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `projectCode` varchar(100) NOT NULL,
  `projectName` varchar(100) NOT NULL,
  `projectDesc` varchar(100) NOT NULL,
  `projectstartdate` varchar(100) NOT NULL,
  `projectenddate` varchar(100) NOT NULL,
  `projectID` int(100) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`projectCode`, `projectName`, `projectDesc`, `projectstartdate`, `projectenddate`, `projectID`) VALUES
('P11', 'Car', 'Built', '20/1/10', '21/5/20', 6),
('P13', 'Robo2', 'Make', '2021/1/8', '2021/12/30', 7),
('P30', 'Robot 9', 'Built', '2020/12/08', '2021/10/6', 9);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

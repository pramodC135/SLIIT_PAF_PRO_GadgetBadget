-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 08:10 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
`orderID` int(11) NOT NULL,
  `orderCode` varchar(15) NOT NULL,
  `customerID` varchar(20) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `customerEmail` varchar(50) DEFAULT NULL,
  `customerAddress` varchar(50) DEFAULT NULL,
  `orderTotalAmount` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
`paymentID` int(11) NOT NULL,
  `app_Code` varchar(15) NOT NULL,
  `cardType` varchar(15) NOT NULL,
  `nameOnCard` varchar(20) DEFAULT NULL,
  `cardno` int(20) DEFAULT NULL,
  `phone` int(10) DEFAULT NULL,
  `expdate` datetime NOT NULL,
  `amount` decimal(9,2) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `app_Code`, `cardType`, `nameOnCard`, `cardno`, `phone`, `expdate`, `amount`) VALUES
(2, 'PMU002', 'VisaU', 'SakunaYash', 123456333, 711234333, '2023-04-20 00:00:00', '1533.98');

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
`projectID` int(15) NOT NULL,
  `projectCode` varchar(10) NOT NULL,
  `projectName` varchar(40) NOT NULL,
  `projectPrice` decimal(9,2) NOT NULL,
  `projectDesc` varchar(200) DEFAULT NULL,
  `projectBy` varchar(20) DEFAULT NULL,
  `projectCtg` varchar(15) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`projectID`, `projectCode`, `projectName`, `projectPrice`, `projectDesc`, `projectBy`, `projectCtg`) VALUES
(1, 'P001', 'Project001', '133.13', 'Test Project01', 'Sakuna Yashara', 'Science');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`userID` int(11) NOT NULL,
  `userCode` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `userPwd` varchar(10) DEFAULT NULL,
  `userEmail` varchar(30) DEFAULT NULL,
  `userRole` varchar(10) DEFAULT NULL,
  `userFname` varchar(20) DEFAULT NULL,
  `userLname` varchar(20) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  `userBod` datetime DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userCode`, `username`, `userPwd`, `userEmail`, `userRole`, `userFname`, `userLname`, `userAddress`, `userBod`, `joinDate`) VALUES
(3, 'User002', 'username02', 'userpwd02', 'user02@mail.com', 'Seller', 'Pramod02', 'Madhushan02', 'No134, Galgamuwa', '1997-10-06 00:00:00', '0000-00-00 00:00:00'),
(7, 'US001', 'Username001', 'pwd001', 'us001@gmail.com', 'Researcher', 'Pramod', 'Madhushan', 'No 133, Galgamuwa', '1997-10-05 00:00:00', '2025-04-21 14:58:39');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order`
--
ALTER TABLE `order`
 ADD PRIMARY KEY (`orderID`), ADD UNIQUE KEY `orderCode` (`orderCode`,`customerID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
 ADD PRIMARY KEY (`paymentID`), ADD UNIQUE KEY `app_Code` (`app_Code`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
 ADD PRIMARY KEY (`projectID`), ADD UNIQUE KEY `projectCode` (`projectCode`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`userID`), ADD UNIQUE KEY `userCode_UNIQUE` (`userCode`), ADD UNIQUE KEY `username_UNIQUE` (`username`), ADD KEY `joinDate` (`joinDate`), ADD KEY `joinDate_2` (`joinDate`), ADD KEY `joinDate_3` (`joinDate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
MODIFY `projectID` int(15) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

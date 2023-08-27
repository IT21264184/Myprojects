-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2022 at 08:35 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abc(pvt)limited`
--

-- --------------------------------------------------------

--
-- Table structure for table `asset`
--

CREATE TABLE `asset` (
  `a_id` char(10) NOT NULL,
  `a_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asset`
--

INSERT INTO `asset` (`a_id`, `a_name`) VALUES
('A1', 'desk'),
('A2', 'chair'),
('A3', 'book'),
('A4', 'printer'),
('A5', 'PC');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `att_id` char(10) NOT NULL,
  `att_date` date DEFAULT NULL,
  `att_time` time DEFAULT NULL,
  `Emp_id` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`att_id`, `att_date`, `att_time`, `Emp_id`) VALUES
('Att11', '2021-02-16', '07:15:00', 'IE0001'),
('Att12', '2021-02-16', '08:20:00', 'IE0002'),
('Att13', '2021-02-16', '08:25:00', 'IE0003'),
('Att14', '2021-02-16', '07:18:00', 'IE0004'),
('Att15', '2021-02-16', '08:30:00', 'IE0005');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `d_number` int(11) NOT NULL,
  `dname` varchar(100) DEFAULT NULL,
  `d_location` varchar(200) DEFAULT NULL,
  `Manager_id` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`d_number`, `dname`, `d_location`, `Manager_id`) VALUES
(1, 'Human Resource Department', 'Battaramulla', 'IE0002'),
(2, 'Marketing Department', 'Kolonnawa', 'IE0001'),
(3, 'Finance Department', 'Peliyagoda', 'IE0003'),
(4, 'Sales Department', 'Kelaniya', 'IE0005'),
(5, 'Operations Department', 'Wattala', 'IE0004');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Emp_id` char(10) NOT NULL,
  `NIC` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `emp_address` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `d_number` int(11) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `since` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Emp_id`, `NIC`, `gender`, `fname`, `lname`, `salary`, `emp_address`, `email`, `phone`, `d_number`, `designation`, `since`) VALUES
('IE0001', '725004823V', 'male', 'sunil', 'gunarathne', '60000.00', '77 2nd Cross Street, 11, colombo', 'sunilgunarathne@gmail.com', 759343234, 2, 'manager', '2019-03-24'),
('IE0002', '725056353V', 'female', 'kusum', 'rathnayake', '40000.00', '93 Jawatte Road, 05', 'kusum@gmail.com', 774343734, 1, ' assistant - manager', '2018-10-23'),
('IE0003', '722526223V', 'male', 'kalum', 'bandara', '60000.00', '77 2nd Cross Street, 11, colombo', 'kalum@gmail.com', 759343234, 3, 'manager', '2019-03-24'),
('IE0004', '725094363V', 'male', 'ranga', 'herath', '40000.00', '93 Jawatte Road, 05', 'ranga@gmail.com', 774343734, 5, ' assistant - manager', '2018-10-23'),
('IE0005', '725094363V', 'male', 'shehan', 'samarathunga', '40000.00', '93 Jawatte Road, 05', 'shehan@gmail.com', 774343734, 4, ' assistant - manager', '2018-10-23');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `f_id` char(10) NOT NULL,
  `f_text` varchar(500) DEFAULT NULL,
  `Emp_id` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`f_id`, `f_text`, `Emp_id`) VALUES
('f1', 'nice', 'IE0001'),
('f2', 'need improvement', 'IE0003'),
('f3', 'good', 'IE0005'),
('f4', 'terrible', 'IE0004'),
('f5', 'average', 'IE0002');

-- --------------------------------------------------------

--
-- Table structure for table `identification`
--

CREATE TABLE `identification` (
  `username` varchar(50) NOT NULL,
  `passwrd` varchar(50) DEFAULT NULL,
  `Emp_id` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `identification`
--

INSERT INTO `identification` (`username`, `passwrd`, `Emp_id`) VALUES
('kalum3', '!Lov3MyPiano', 'IE0003'),
('kusum2', 'd3ltagamm@', 'IE0002'),
('ranga4', 'jelly22fi$h', 'IE0004'),
('shehan5', 'a11Black$', 'IE0005'),
('sunil1', 'SterlingGmail20.15', 'IE0001');

-- --------------------------------------------------------

--
-- Table structure for table `memorandum`
--

CREATE TABLE `memorandum` (
  `email` varchar(20) NOT NULL,
  `msg` varchar(100) NOT NULL,
  `emp_name` varchar(20) DEFAULT NULL,
  `Emp_id` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `memorandum`
--

INSERT INTO `memorandum` (`email`, `msg`, `emp_name`, `Emp_id`) VALUES
('kalum@gmail.com', 'The business did not play phone tag at all', 'kalum', 'IE0003'),
('kusum@gmail.com', 'Customer service makes or breaks a brand.', 'kusum', 'IE0002'),
('kusum@gmail.com', 'Running a non-profit that relies on donations?', 'kusum', 'IE0002'),
('ranga@gmail.com', 'Update to this week s assignment', 'ranga', 'IE0004'),
('shehan@gmail.com', 'Customers shouldn’t be left on hold just to schedule an appointment.', 'shehan', 'IE0005');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `a_id` char(10) NOT NULL,
  `Emp_id` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`a_id`, `Emp_id`) VALUES
('A1', 'IE0001'),
('A2', 'IE0002'),
('A3', 'IE0003'),
('A4', 'IE0004'),
('A5', 'IE0005');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asset`
--
ALTER TABLE `asset`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`att_id`),
  ADD KEY `FK_Attendance` (`Emp_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`d_number`),
  ADD KEY `FK_Department` (`Manager_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Emp_id`),
  ADD KEY `FK_Employee` (`d_number`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`f_id`),
  ADD KEY `FK_Feedback` (`Emp_id`);

--
-- Indexes for table `identification`
--
ALTER TABLE `identification`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FK_Identification` (`Emp_id`);

--
-- Indexes for table `memorandum`
--
ALTER TABLE `memorandum`
  ADD PRIMARY KEY (`email`,`msg`),
  ADD KEY `FK_Memorandum` (`Emp_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`a_id`,`Emp_id`),
  ADD KEY `FK2_Request` (`Emp_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `FK_Attendance` FOREIGN KEY (`Emp_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `FK_Department` FOREIGN KEY (`Manager_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK_Employee` FOREIGN KEY (`d_number`) REFERENCES `department` (`d_number`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `FK_Feedback` FOREIGN KEY (`Emp_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `identification`
--
ALTER TABLE `identification`
  ADD CONSTRAINT `FK_Identification` FOREIGN KEY (`Emp_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `memorandum`
--
ALTER TABLE `memorandum`
  ADD CONSTRAINT `FK_Memorandum` FOREIGN KEY (`Emp_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `FK1_Request` FOREIGN KEY (`a_id`) REFERENCES `asset` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK2_Request` FOREIGN KEY (`Emp_id`) REFERENCES `employee` (`Emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

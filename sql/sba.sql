-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2014 at 03:23 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sba`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `acc_id` int(5) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `uadd` longtext NOT NULL,
  `type` varchar(7) NOT NULL,
  `balance` int(20) NOT NULL,
  `overdraft` int(20) NOT NULL,
  PRIMARY KEY (`acc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`acc_id`, `uname`, `uadd`, `type`, `balance`, `overdraft`) VALUES
(1, 'satej Sawant', 'abc,\r\nasjihd\r\nsdfhsd\r\ndshbujvhb.\r\nMumbai', 'saving', 4500, 0),
(2, 'vijay yadav', 'avdsbh dshfj,\r\ndshbhudsbf,\r\nGhatkopar(w).\r\nMumbai 86', 'current', 14200, 0),
(3, 'suraj yadav', 'ahgsdygsa shyg,\r\nksgfuysbvby ijbk u iuf ,\r\njhfyugasvfyg,\r\njhgygd.\r\nulhasnagar', 'saving', 16000, 0),
(4, 'keshav pawaskar', 'ahgsdygsa shyg,\r\nksgfuysbvby ijbk u iuf ,\r\njhfyugasvfyg,\r\njhgygd.\r\nulhasnagar', 'current', 22000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fd`
--

CREATE TABLE IF NOT EXISTS `fd` (
  `tid` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `period` int(11) NOT NULL,
  `interest` int(11) NOT NULL,
  `amt` int(11) NOT NULL,
  `amt_after` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fd`
--

INSERT INTO `fd` (`tid`, `uid`, `rate`, `period`, `interest`, `amt`, `amt_after`) VALUES
('2014-04-08 13:06:46', 1, 2, 12, 367, 2000, 2367);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `uid` int(11) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`uid`, `password`) VALUES
(1, 'satej'),
(2, 'vijay'),
(3, 'suraj'),
(4, 'keshav');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `tid` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `pre_bal` int(11) NOT NULL,
  `post_bal` int(11) NOT NULL,
  `did` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`tid`, `uid`, `type`, `pre_bal`, `post_bal`, `did`) VALUES
('2014-04-08 12:55:37', 1, 'withdraw', 0, 0, 0),
('2014-04-08 13:06:46', 1, 'FD', 6500, 4500, 0),
('2014-04-08 13:11:55', 3, 'Withd', 20000, 18000, 0),
('2014-04-08 13:13:31', 3, 'Trans', 18000, 16000, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

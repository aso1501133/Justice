-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017 年 7 朁E06 日 07:24
-- サーバのバージョン： 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `california`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `obento`
--

CREATE TABLE `obento` (
  `bento_id` varchar(7) NOT NULL,
  `bento_name` varchar(12) NOT NULL,
  `user_id` varchar(7) NOT NULL,
  `image` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `obento`
--

INSERT INTO `obento` (`bento_id`, `bento_name`, `user_id`, `image`) VALUES
('bento1', 'アンパンマン弁当', '1501111', 'anpanman'),
('bento2', 'みつばち弁当', '1502222', 'bee'),
('bento3', 'ベイマックス弁当', '1503333', 'beimax'),
('bento4', 'ゆるキャラ弁当', '1504444', 'hunassi'),
('bento5', 'リラックマ弁当', '1505555', 'rirakuma'),
('bento6', 'スヌーピー弁当', '1506666', 'sunupi');

-- --------------------------------------------------------

--
-- テーブルの構造 `user`
--

CREATE TABLE `user` (
  `user_id` varchar(7) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(12) NOT NULL,
  `vote` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user`
--

INSERT INTO `user` (`user_id`, `password`, `name`, `vote`) VALUES
('1501111', '1111', 'てすと一号', '0'),
('1502222', '2222', 'てすと二号', '0'),
('1503333', '3333', 'てすと3号', '0'),
('1504444', '4444', 'てすと4号', '0'),
('1505555', '5555', 'てすと5号', '0'),
('1506666', '6666', 'てすと6号', '0');

-- --------------------------------------------------------

--
-- テーブルの構造 `votes`
--

CREATE TABLE `votes` (
  `bento_id` varchar(7) NOT NULL,
  `votes` varchar(3) DEFAULT '0',
  `comment` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `votes`
--

INSERT INTO `votes` (`bento_id`, `votes`, `comment`) VALUES
('bento1', '0', NULL),
('bento2', '0', NULL),
('bento3', '0', NULL),
('bento4', '0', NULL),
('bento5', '0', NULL),
('bento6', '0', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `obento`
--
ALTER TABLE `obento`
  ADD PRIMARY KEY (`bento_id`);

--
-- Indexes for table `votes`
--
ALTER TABLE `votes`
  ADD PRIMARY KEY (`bento_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

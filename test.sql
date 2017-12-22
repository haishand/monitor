-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.21-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5185
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.alarm 结构
CREATE TABLE IF NOT EXISTS `alarm` (
  `value` int(11) DEFAULT NULL,
  `param1` float DEFAULT NULL,
  `param2` float DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  `alarmStatus` int(11) DEFAULT NULL,
  KEY `FK_alarm_device` (`value`),
  CONSTRAINT `FK_alarm_device` FOREIGN KEY (`value`) REFERENCES `device` (`value`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.device 结构
CREATE TABLE IF NOT EXISTS `device` (
  `value` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) DEFAULT NULL,
  `nodeId` int(11) DEFAULT NULL,
  `multiFlag` bit(1) DEFAULT NULL,
  `deviceName` varchar(50) DEFAULT NULL,
  `deviceType` int(11) DEFAULT NULL,
  `param1Name` varchar(50) DEFAULT NULL,
  `param2Name` varchar(50) DEFAULT NULL,
  `saveInterval` int(11) DEFAULT NULL,
  `lowAlarmLimit1` float DEFAULT NULL,
  `hiAlarmLimit1` float DEFAULT NULL,
  `lowAlarmLimit2` float DEFAULT NULL,
  `hiAlarmLimit2` float DEFAULT NULL,
  `onlineStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.deviceinfo 结构
CREATE TABLE IF NOT EXISTS `deviceinfo` (
  `device_id` int(11) NOT NULL,
  `node_id` int(11) NOT NULL,
  `status` varchar(50) CHARACTER SET latin1 NOT NULL,
  `hum` float NOT NULL,
  `tem` float NOT NULL,
  `record_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `coord_type` tinyint(4) DEFAULT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.device_data 结构
CREATE TABLE IF NOT EXISTS `device_data` (
  `value` int(11) NOT NULL AUTO_INCREMENT,
  `param1` float DEFAULT NULL,
  `param2` float DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`value`),
  CONSTRAINT `FK_devicedata_device` FOREIGN KEY (`value`) REFERENCES `device` (`value`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.device_info 结构
CREATE TABLE IF NOT EXISTS `device_info` (
  `device_id` int(11) NOT NULL,
  `status` varchar(50) CHARACTER SET latin1 NOT NULL,
  `hum` float NOT NULL,
  `tem` float NOT NULL,
  `record_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `coord_type` tinyint(4) DEFAULT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

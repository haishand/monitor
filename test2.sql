-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.28-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- 导出  表 test.alarm_data 结构
CREATE TABLE IF NOT EXISTS `alarm_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `value` float DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_alarm_data_device` (`code`),
  CONSTRAINT `FK_alarm_data_device` FOREIGN KEY (`code`) REFERENCES `device` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- 正在导出表  test.alarm_data 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `alarm_data` DISABLE KEYS */;
INSERT INTO `alarm_data` (`id`, `code`, `type`, `value`, `recordTime`, `status`) VALUES
	(10, 2, '湿度高于上界', 32.8, '2017-12-21 17:12:13', 0),
	(16, 2, '湿度高于上界', 65.2, '2017-12-22 10:02:54', 0),
	(17, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0),
	(18, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0),
	(19, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0),
	(20, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0),
	(21, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0),
	(22, 2, '湿度高于上界', 30.4, '2017-12-22 10:05:49', 0);
/*!40000 ALTER TABLE `alarm_data` ENABLE KEYS */;

-- 导出  表 test.device 结构
CREATE TABLE IF NOT EXISTS `device` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.device 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` (`code`, `deviceId`, `nodeId`, `multiFlag`, `deviceName`, `deviceType`, `param1Name`, `param2Name`, `saveInterval`, `lowAlarmLimit1`, `hiAlarmLimit1`, `lowAlarmLimit2`, `hiAlarmLimit2`, `onlineStatus`) VALUES
	(2, 30002835, 0, b'0', 'TH1', 10, '温度', '湿度', NULL, 15, 25, 15, 30, 1);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;

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

-- 正在导出表  test.deviceinfo 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `deviceinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `deviceinfo` ENABLE KEYS */;

-- 导出  表 test.device_data 结构
CREATE TABLE IF NOT EXISTS `device_data` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `param1` float DEFAULT NULL,
  `param2` float DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`code`),
  CONSTRAINT `FK_devicedata_device` FOREIGN KEY (`code`) REFERENCES `device` (`code`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.device_data 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `device_data` DISABLE KEYS */;
INSERT INTO `device_data` (`code`, `param1`, `param2`, `recordTime`) VALUES
	(2, 21.4, 30.4, '2017-12-22 10:05:49');
/*!40000 ALTER TABLE `device_data` ENABLE KEYS */;

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

-- 正在导出表  test.device_info 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `device_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

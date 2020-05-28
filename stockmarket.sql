
CREATE DATABASE `stockmarket` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for S_USER
-- ----------------------------
CREATE TABLE `S_USER` (
  `ID` 			int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` 	VARCHAR(32),
  `PASSWORD`	VARCHAR(32),  
  `USER_TYPE` 	CHAR(1),
  `EMAIL` 		VARCHAR(128),
  `MOBILE_NUM` 	VARCHAR(16),
  `CONFIRMED` 		CHAR(1),  
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for S_SECTOR
-- ----------------------------
CREATE TABLE `s_sector` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SECTOR_ID` int DEFAULT NULL,
  `SECTOR_NAME` varchar(32) DEFAULT NULL,
  `BRIEF` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `COMPANY_CODE_UNIQUE` (`SECTOR_ID` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
-- Table structure for S_STOCK_EXCHANGE
-- ----------------------------
CREATE TABLE `s_stock_exchange` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EXCHANGE_ID` int DEFAULT NULL,
  `EXCHANGE_NAME` varchar(32) DEFAULT NULL,
  `BRIEF` varchar(256) DEFAULT NULL,
  `CONTACT_ADDR` varchar(256) DEFAULT NULL,
  `REMARKS` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EXCHANGE_ID` (`EXCHANGE_ID`),
  UNIQUE KEY `EXCHANGE_NAME` (`EXCHANGE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- Table structure for S_COMPANY
-- ----------------------------
CREATE TABLE `s_company` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(128) NOT NULL,
  `COMPANY_CODE` int NOT NULL,
  `EXCHANGE_ID` int NOT NULL,
  `TURN_OVER` varchar(256) DEFAULT NULL,
  `CEO` varchar(64) NOT NULL,
  `BOARD_OF_DIRECTORS` varchar(256) DEFAULT NULL,
  `SECTOR_ID` int NOT NULL,
  `BRIEF` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `COMPANY_CODE_UNIQUE` (`COMPANY_CODE` ASC),
  KEY `fk_ S_COMPANY_S_SECTOR_idx` (`SECTOR_ID`),
  KEY `fk_ S_COMPANY_S_STOCK_EXCHANGE_idx` (`EXCHANGE_ID`),
  KEY `fk_ S_COMPANY_S_STOCK_PRICE_idx` (`COMPANY_CODE`),
  CONSTRAINT `fk_ S_COMPANY_S_SECTOR` FOREIGN KEY (`SECTOR_ID`) REFERENCES `s_sector` (`SECTOR_ID`),
  CONSTRAINT `fk_ S_COMPANY_S_STOCK_EXCHANGE` FOREIGN KEY (`EXCHANGE_ID`) REFERENCES `s_stock_exchange` (`EXCHANGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- Table structure for S_STOCK_PRICE
-- ----------------------------
CREATE TABLE `s_stock_price` (
  `COMPANY_CODE` int NOT NULL,
  `CURRENT_PRICE` decimal(5,2) NOT NULL,
  `OPEN_PRICE` decimal(5,2) NOT NULL,
  `HIGH_PRICE` decimal(5,2) NOT NULL,
  `LOW_PRICE` decimal(5,2) NOT NULL,
  `PRICE_DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-- ----------------------------
-- Table structure for S_STOCK_PRICE
-- ----------------------------
CREATE TABLE `s_ipo_planed` (
  `ID` int NOT NULL,
  `COMPANY_NAME` varchar(128) NOT NULL,
  `EXCHANGE_ID` int DEFAULT NULL,
  `PRE_PRICE` decimal(5,2) DEFAULT NULL,
  `TOTAL_NUM` int DEFAULT NULL,
  `OPEN_DATE` date DEFAULT NULL,
  `EXPRESSION` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ S_IPO_PLANED_S_STOCK_EXCHANG_idx` (`EXCHANGE_ID`),
  CONSTRAINT `fk_ S_IPO_PLANED_S_STOCK_EXCHANG` FOREIGN KEY (`EXCHANGE_ID`) REFERENCES `s_stock_exchange` (`EXCHANGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

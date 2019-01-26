/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : demo2

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-31 09:59:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_address
-- ----------------------------
DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `ADDRESS_KEY` int(10) NOT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `ADDRESS_TYPE` varchar(255) NOT NULL,
  `POSTAL_CODE` varchar(255) NOT NULL,
  `ADDRESSLINE3` varchar(255) DEFAULT NULL,
  `ADDRESSLINE2` varchar(255) DEFAULT NULL,
  `ADDRESSLINE1` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `COUNTRY_NAME` varchar(255) NOT NULL,
  `ADDRESSLINE4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`,`ADDRESS_KEY`),
  CONSTRAINT `address_client_id_pk` FOREIGN KEY (`CLIENT_ID`) REFERENCES `customer_profile` (`CLIENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_email
-- ----------------------------
DROP TABLE IF EXISTS `customer_email`;
CREATE TABLE `customer_email` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `EMAIL_ADDRESS` varchar(255) NOT NULL,
  `PREFERRED_EMAIL_FLAG` varchar(255) NOT NULL,
  `EMAIL_KEY` int(2) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`,`EMAIL_KEY`),
  CONSTRAINT `email_client_id_pk` FOREIGN KEY (`CLIENT_ID`) REFERENCES `customer_profile` (`CLIENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_name
-- ----------------------------
DROP TABLE IF EXISTS `customer_name`;
CREATE TABLE `customer_name` (
  `CUSTOMER_NAME_ID` int(20) NOT NULL AUTO_INCREMENT,
  `CLIENT_ID` varchar(255) NOT NULL,
  `NAME_TYPE` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `FULL_NAME` varchar(255) DEFAULT NULL,
  `MIDDLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_NAME_ID`),
  KEY `name_client_id_pk` (`CLIENT_ID`),
  CONSTRAINT `name_client_id_pk` FOREIGN KEY (`CLIENT_ID`) REFERENCES `customer_profile` (`CLIENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_phone
-- ----------------------------
DROP TABLE IF EXISTS `customer_phone`;
CREATE TABLE `customer_phone` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `PHONE_TYPE` varchar(255) NOT NULL,
  `AREA_CODE` varchar(255) DEFAULT NULL,
  `EXTENSION` varchar(255) DEFAULT NULL,
  `PHONE_KEY` int(20) NOT NULL,
  `PHONE_NUMBER` varchar(255) NOT NULL,
  `PHONE_COUNTRY_CODE` varchar(255) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`,`PHONE_KEY`),
  CONSTRAINT `phone_client_id_pk` FOREIGN KEY (`CLIENT_ID`) REFERENCES `customer_profile` (`CLIENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_profile
-- ----------------------------
DROP TABLE IF EXISTS `customer_profile`;
CREATE TABLE `customer_profile` (
  `CUSTOMER_PROFILE_ID` int(20) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_TYPE` varchar(255) DEFAULT NULL,
  `CUSTOMER_SEGMENT` varchar(255) NOT NULL,
  `PARTNER_CUSTOMER_SEGMENT` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `PREFIX` varchar(255) DEFAULT NULL,
  `SUFFIX` varchar(255) DEFAULT NULL,
  `CLIENT_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`CUSTOMER_PROFILE_ID`),
  UNIQUE KEY `profile_client_id_unique` (`CLIENT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

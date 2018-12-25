/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : ordersystemby(yyandlzh)

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 22/12/2018 18:06:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `BusinessID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `BusinessName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PhoneNumber` int(20) UNSIGNED NULL DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ShippingAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`BusinessID`) USING BTREE,
  INDEX `BusinessID`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_2`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_3`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_4`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_5`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_6`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_7`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_8`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_9`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_10`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_11`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_12`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_13`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_14`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_15`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_16`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_17`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_18`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_19`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_20`(`BusinessID`) USING BTREE,
  INDEX `BusinessID_21`(`BusinessID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, 'ff14', 'ff14', '123456', NULL, NULL, 'Internet');
INSERT INTO `business` VALUES (2, 'home of sand', 'sand', '123456', NULL, NULL, 'land');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `CustomerID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PhoneNumber` int(11) NULL DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CustomerID`) USING BTREE,
  INDEX `UserName`(`UserName`) USING BTREE,
  INDEX `CustomerID`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_2`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_3`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_4`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_5`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_6`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_7`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_8`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_9`(`CustomerID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94698 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (7, 'xhy', '123456', 'fishs', 1234, '', '');
INSERT INTO `customer` VALUES (8, 'q', '123456', 'QQ', 123, NULL, NULL);
INSERT INTO `customer` VALUES (94697, 'lzh', '123456', 'loo', 666, '666', 'FF14 fan');

-- ----------------------------
-- Table structure for deliveryaddress
-- ----------------------------
DROP TABLE IF EXISTS `deliveryaddress`;
CREATE TABLE `deliveryaddress`  (
  `DeliveryAddressID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CustomerID` int(10) UNSIGNED NOT NULL,
  `Consignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PhoneNumber` int(11) NOT NULL,
  `Detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`DeliveryAddressID`) USING BTREE,
  INDEX `Consignee`(`Consignee`) USING BTREE,
  INDEX `Consignee_2`(`Consignee`) USING BTREE,
  INDEX `PhoneNumber`(`PhoneNumber`) USING BTREE,
  INDEX `CustomerID`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_2`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_3`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_4`(`CustomerID`) USING BTREE,
  INDEX `DeliveryAddressID`(`DeliveryAddressID`) USING BTREE,
  INDEX `DeliveryAddressID_2`(`DeliveryAddressID`) USING BTREE,
  INDEX `DeliveryAddressID_3`(`DeliveryAddressID`) USING BTREE,
  INDEX `DeliveryAddressID_4`(`DeliveryAddressID`) USING BTREE,
  CONSTRAINT `deliveryaddress_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`customerid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliveryaddress
-- ----------------------------
INSERT INTO `deliveryaddress` VALUES (1, 7, 'liang', 110, 'word');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `ProductID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ProductNumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StandardCost` double(10, 2) NOT NULL,
  `Detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Weight` double(10, 2) NULL DEFAULT NULL,
  `BusinessID` int(10) UNSIGNED NOT NULL,
  `PictureName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ProductID`) USING BTREE,
  INDEX `ProductID`(`ProductID`) USING BTREE,
  INDEX `ProductID_2`(`ProductID`) USING BTREE,
  INDEX `ProductID_3`(`ProductID`) USING BTREE,
  INDEX `BusinessID`(`BusinessID`) USING BTREE,
  INDEX `ProductID_4`(`ProductID`) USING BTREE,
  INDEX `ProductID_5`(`ProductID`) USING BTREE,
  INDEX `ProductID_6`(`ProductID`) USING BTREE,
  INDEX `ProductID_7`(`ProductID`) USING BTREE,
  INDEX `ProductID_8`(`ProductID`) USING BTREE,
  INDEX `ProductID_9`(`ProductID`) USING BTREE,
  INDEX `ProductID_10`(`ProductID`) USING BTREE,
  INDEX `ProductID_11`(`ProductID`) USING BTREE,
  INDEX `ProductID_12`(`ProductID`) USING BTREE,
  INDEX `ProductID_13`(`ProductID`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`BusinessID`) REFERENCES `business` (`businessid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 82825 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (19954, '22323', 'colo', 11.00, '*Detail\n', 0.00, 1, 'Business-1-19954-jpg');
INSERT INTO `product` VALUES (36744, '23333', 'white', 111.00, '*Detail\n', 0.00, 1, 'Business-1-36744-jpg');

-- ----------------------------
-- Table structure for salesorder
-- ----------------------------
DROP TABLE IF EXISTS `salesorder`;
CREATE TABLE `salesorder`  (
  `SalesOrderID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `BusinessID` int(10) UNSIGNED NOT NULL,
  `ProductID` int(10) UNSIGNED NOT NULL,
  `CustomerID` int(10) UNSIGNED NOT NULL,
  `DeliveryAddressID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `SalesOrderNumber` int(10) UNSIGNED NOT NULL,
  `Quantity` int(10) UNSIGNED NOT NULL,
  `Status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OrderDate` datetime(0) NOT NULL,
  `Comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SubTotal` int(10) NOT NULL,
  PRIMARY KEY (`SalesOrderID`) USING BTREE,
  INDEX `ProductID`(`ProductID`) USING BTREE,
  INDEX `CustomerID`(`CustomerID`) USING BTREE,
  INDEX `ProductID_2`(`ProductID`) USING BTREE,
  INDEX `ProductID_3`(`ProductID`) USING BTREE,
  INDEX `CustomerID_2`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_3`(`CustomerID`) USING BTREE,
  INDEX `CustomerID_4`(`CustomerID`) USING BTREE,
  INDEX `BusinessID`(`BusinessID`) USING BTREE,
  INDEX `DeliveryAddressID`(`DeliveryAddressID`) USING BTREE,
  CONSTRAINT `salesorder_ibfk_2` FOREIGN KEY (`BusinessID`) REFERENCES `business` (`businessid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `salesorder_ibfk_3` FOREIGN KEY (`ProductID`) REFERENCES `product` (`productid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `salesorder_ibfk_4` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`customerid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `salesorder_ibfk_5` FOREIGN KEY (`DeliveryAddressID`) REFERENCES `deliveryaddress` (`deliveryaddressid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

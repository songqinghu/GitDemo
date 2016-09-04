/*
Navicat MySQL Data Transfer

Source Server         : game
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-09-04 16:24:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gwebinfo
-- ----------------------------
DROP TABLE IF EXISTS `gwebinfo`;
CREATE TABLE `gwebinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取动态图web站点标识id',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gwebinfo
-- ----------------------------
INSERT INTO `gwebinfo` VALUES ('1', 'http://www.kx1d.com');
INSERT INTO `gwebinfo` VALUES ('2', 'http://www.qqszc.com');
INSERT INTO `gwebinfo` VALUES ('3', 'http://www.youqu.net');

-- ----------------------------
-- Table structure for gwebspiderinfo
-- ----------------------------
DROP TABLE IF EXISTS `gwebspiderinfo`;
CREATE TABLE `gwebspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gweb_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(50) DEFAULT NULL COMMENT '抓取的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gwebspiderinfo
-- ----------------------------
INSERT INTO `gwebspiderinfo` VALUES ('1', '1', 'http://www.kx1d.com/xieegif/');
INSERT INTO `gwebspiderinfo` VALUES ('2', '1', 'http://www.kx1d.com/meinvdongtaitu/');
INSERT INTO `gwebspiderinfo` VALUES ('3', '2', 'http://www.qqszc.com/dongtaitupian/');
INSERT INTO `gwebspiderinfo` VALUES ('4', '2', 'http://www.qqszc.com/meinvdongtaitu/');
INSERT INTO `gwebspiderinfo` VALUES ('5', '2', 'http://www.qqszc.com/luguandongtaitu/');
INSERT INTO `gwebspiderinfo` VALUES ('6', '2', 'http://www.qqszc.com/papapadongtaitu/');
INSERT INTO `gwebspiderinfo` VALUES ('7', '3', 'http://www.youqu.net/xieedongtaitu/');

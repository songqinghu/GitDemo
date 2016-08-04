/*
Navicat MySQL Data Transfer

Source Server         : game
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-08-04 23:46:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for imagetype
-- ----------------------------
DROP TABLE IF EXISTS `imagetype`;
CREATE TABLE `imagetype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类型Id',
  `typename` varchar(50) DEFAULT NULL COMMENT '图片列表名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imagetype
-- ----------------------------
INSERT INTO `imagetype` VALUES ('1', '性感美女');
INSERT INTO `imagetype` VALUES ('2', '比基尼');
INSERT INTO `imagetype` VALUES ('3', '美女诱惑');
INSERT INTO `imagetype` VALUES ('4', '性感车模');
INSERT INTO `imagetype` VALUES ('5', '美女自拍');
INSERT INTO `imagetype` VALUES ('6', '清纯美女');
INSERT INTO `imagetype` VALUES ('7', '明星图片');
INSERT INTO `imagetype` VALUES ('8', '推荐图片');

-- ----------------------------
-- Table structure for webinfo
-- ----------------------------
DROP TABLE IF EXISTS `webinfo`;
CREATE TABLE `webinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取web站点标识id',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webinfo
-- ----------------------------
INSERT INTO `webinfo` VALUES ('1', 'http://www.2cto.com');

-- ----------------------------
-- Table structure for webspiderinfo
-- ----------------------------
DROP TABLE IF EXISTS `webspiderinfo`;
CREATE TABLE `webspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `web_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(50) DEFAULT NULL COMMENT '抓取的url',
  `pictype` bigint(3) DEFAULT NULL COMMENT '图片类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webspiderinfo
-- ----------------------------
INSERT INTO `webspiderinfo` VALUES ('1', '1', 'http://www.2cto.com/meinv/sexmv/', '1');
INSERT INTO `webspiderinfo` VALUES ('2', '1', 'http://www.2cto.com/meinv/rhmeinv/', '2');
INSERT INTO `webspiderinfo` VALUES ('3', '1', 'http://www.2cto.com/meinv/gaoqing/', '3');
INSERT INTO `webspiderinfo` VALUES ('4', '1', 'http://www.2cto.com/meinv/meitui/', '4');
INSERT INTO `webspiderinfo` VALUES ('5', '1', 'http://www.2cto.com/meinv/mote/', '5');
INSERT INTO `webspiderinfo` VALUES ('6', '1', 'http://www.2cto.com/meinv/xiaoqingxin/', '6');
INSERT INTO `webspiderinfo` VALUES ('7', '1', 'http://www.2cto.com/meinv/mingxing/', '7');
INSERT INTO `webspiderinfo` VALUES ('8', '1', 'http://www.2cto.com/meinv/top/', '8');

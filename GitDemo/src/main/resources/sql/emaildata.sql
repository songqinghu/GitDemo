/*
Navicat MySQL Data Transfer

Source Server         : game
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-09-13 22:12:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emailwebinfo
-- ----------------------------
DROP TABLE IF EXISTS `emailwebinfo`;
CREATE TABLE `emailwebinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取网站编号',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emailwebinfo
-- ----------------------------
INSERT INTO `emailwebinfo` VALUES ('1', 'http://tieba.baidu.com');

-- ----------------------------
-- Table structure for emailwebspiderinfo
-- ----------------------------
DROP TABLE IF EXISTS `emailwebspiderinfo`;
CREATE TABLE `emailwebspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `emailweb_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(150) DEFAULT NULL COMMENT '抓取的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emailwebspiderinfo
-- ----------------------------
INSERT INTO `emailwebspiderinfo` VALUES ('1', '1', 'http://tieba.baidu.com/f/search/res?ie=utf-8&kw=&qw=%26quot%3B%40qq.com%20%E6%A5%BC%E4%B8%BB%26quot%3B&rn=30&un=&sm=1');
INSERT INTO `emailwebspiderinfo` VALUES ('2', '1', 'http://tieba.baidu.com/f/search/res?isnew=1&kw=&qw=%26quot%3B%40qq.com%20%C2%A5%D6%F7%26quot%3B&un=&rn=30&pn=0&sd=&ed=&sm=0');

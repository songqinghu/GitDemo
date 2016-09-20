/*
Navicat MySQL Data Transfer

Source Server         : zyy
Source Server Version : 50173
Source Host           : 103.229.28.197:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-08-28 12:54:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appversion
-- ----------------------------
DROP TABLE IF EXISTS `appversion`;
CREATE TABLE `appversion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `version` bigint(20) NOT NULL COMMENT '版本号',
  `bak` varchar(50) DEFAULT '' COMMENT '备注',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
-- Table structure for mainpic
-- ----------------------------
DROP TABLE IF EXISTS `mainpic`;
CREATE TABLE `mainpic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '详情图片,主表id',
  `pre_id` bigint(20) DEFAULT NULL COMMENT '副表id',
  `pictype` bigint(3) DEFAULT NULL COMMENT '图片类型,依赖图片类型表',
  `name` varchar(50) DEFAULT NULL COMMENT '详情页展示名称',
  `url` varchar(100) DEFAULT NULL COMMENT '详情页图片地址',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '图片标示位,默认可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`pre_id`,`pictype`,`url`,`cratedate`,`flag`)
) ENGINE=InnoDB AUTO_INCREMENT=441615 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prepic
-- ----------------------------
DROP TABLE IF EXISTS `prepic`;
CREATE TABLE `prepic` (
  `pre_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '这是副表主键',
  `web_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `pictype` bigint(3) DEFAULT NULL COMMENT '图片类型,依赖图片类型表',
  `name` varchar(100) DEFAULT NULL COMMENT '显示图片的名称',
  `url` varchar(100) DEFAULT NULL COMMENT '下轮抓取的基础URL',
  `murl` varchar(200) DEFAULT NULL COMMENT '小图片的URL,用于列表展示',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '抓取时的创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  `count` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pre_id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`pre_id`,`web_id`,`pictype`,`url`,`cratedate`,`flag`),
  KEY `index_name` (`count`)
) ENGINE=InnoDB AUTO_INCREMENT=19244 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pretimecount
-- ----------------------------
DROP TABLE IF EXISTS `pretimecount`;
CREATE TABLE `pretimecount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '统计表id',
  `pre_id` bigint(20) NOT NULL COMMENT '从表id',
  `lookcount` bigint(20) DEFAULT '1' COMMENT '观看次数',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  PRIMARY KEY (`id`),
  KEY `pre_id` (`pre_id`,`lookcount`,`updatedate`,`flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2070 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for webinfo
-- ----------------------------
DROP TABLE IF EXISTS `webinfo`;
CREATE TABLE `webinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取web站点标识id',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookwebinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookwebinfo`;
CREATE TABLE `bookwebinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取网站编号',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookwebinfo
-- ----------------------------
INSERT INTO `bookwebinfo` VALUES ('1', 'http://m.biquge.com');

-- ----------------------------
-- Table structure for bookwebspiderinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookwebspiderinfo`;
CREATE TABLE `bookwebspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookweb_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(150) DEFAULT NULL COMMENT '抓取的url',
   `booktype` bigint(2) DEFAULT NULL COMMENT '图书类型id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookwebspiderinfo
-- ----------------------------
INSERT INTO `bookwebspiderinfo` VALUES ('1', '1', 'http://m.biquge.com/21_21470/');


-- ----------------------------
-- Table structure for imagetype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类型Id',
  `typename` varchar(50) DEFAULT NULL COMMENT '小说类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `booktype` VALUES ('1', '玄幻奇幻');
INSERT INTO `booktype` VALUES ('2', '武侠仙侠');
INSERT INTO `booktype` VALUES ('3', '都市言情');
INSERT INTO `booktype` VALUES ('4', '青春校园');
INSERT INTO `booktype` VALUES ('5', '穿越架空');
INSERT INTO `booktype` VALUES ('6', '惊悚悬疑');
INSERT INTO `booktype` VALUES ('7', '历史军事');
INSERT INTO `booktype` VALUES ('8', '游戏竞技');
INSERT INTO `booktype` VALUES ('9', '耽美同人');


-- ----------------------------
-- 图书内容页
-- ----------------------------
DROP TABLE IF EXISTS `bookcontent`;
CREATE TABLE `bookcontent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '章节内容,主键id',
  `intro_id` bigint(20) NOT NULL COMMENT '图书id,关联图书表',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id关联章节表',
  `content` MEDIUMBLOB DEFAULT NULL COMMENT '详情页展示名称',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `flag` int(11) DEFAULT '0' COMMENT '标示位,默认可用',
  PRIMARY KEY (`id`),
  KEY `pre_id` (`intro_id`,`chapter_id`,`updatedate`,`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 图书章节目录
-- ----------------------------
DROP TABLE IF EXISTS `bookchapter`;
CREATE TABLE `bookchapter` (
  `chapter_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `intro_id` bigint(20) NOT NULL COMMENT '图书介绍id--对应相应的书籍',
  `name` varchar(100) DEFAULT NULL COMMENT '章节名称',
  `url` varchar(100) DEFAULT NULL COMMENT '章节内容的url,对应要抓取的章节内容',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  `count` bigint(20) NOT NULL DEFAULT '0'  COMMENT '该章节点击次数,统计展示使用',
  `number` bigint(20) NOT NULL DEFAULT '0'  COMMENT '该章节再此本书中的位置,递增,用于排序',
  `isspider` bigint(20) NOT NULL DEFAULT '0'  COMMENT '是否被抓取了,0未抓取,1抓取',
  PRIMARY KEY (`chapter_id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`intro_id`,`name`,`url`,`updatedate`,`flag`,isspider),
  KEY `index_name` (`count`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 图书简介页展示
-- ----------------------------
DROP TABLE IF EXISTS `bookintro`;
CREATE TABLE `bookintro` (
  `intro_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键,这本书唯一标识',
  `bweb_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `name` varchar(100) DEFAULT NULL COMMENT '图书名称',
  `author` varchar(100) DEFAULT NULL COMMENT '作者',
  `booktype` varchar(100) DEFAULT NULL COMMENT '图书类型',
  `isend` bigint(2) DEFAULT '0' COMMENT '是否结束,0,未结束,1结束',
  `newchapter` varchar(100) DEFAULT NULL COMMENT '最新章节名称',
  `url` varchar(100) DEFAULT NULL COMMENT  '下轮抓取图书章节列表的URL',
  `old_pic_url`  varchar(100) DEFAULT NULL COMMENT '图书图片原始地址',
  `show_pic_url`  varchar(100) DEFAULT NULL COMMENT '图书图片展示地址',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '抓取时的创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  `isspider` int(11) DEFAULT '0' COMMENT '是否爬取过章节目录,默认未爬取',
  PRIMARY KEY (`intro_id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (name,`bweb_id`,`url`,`updatedate`,`flag`,isspider)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for maingif
-- ----------------------------
DROP TABLE IF EXISTS `mainemail`;
CREATE TABLE `mainemail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邮箱,主表id',
  `emailweb_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `pre_id` bigint(20) DEFAULT NULL COMMENT '副表id',
  `email` varchar(100) DEFAULT NULL COMMENT '正真的email地址',
   clickcount int(11) DEFAULT '0' COMMENT '该用户点击邮件观看详情的次数',
   detailcount int(11) DEFAULT '0' COMMENT '该用户点点击链接进入网站的次数',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标示位,默认可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_region_name` (`email`),
  KEY `pre_id` (`pre_id`,`emailweb_id`,`email`,`cratedate`,`flag`,clickcount,detailcount)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pregif
-- ----------------------------
DROP TABLE IF EXISTS `preemail`;
CREATE TABLE `preemail` (
  `pre_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '这是副表主键',
  `emailweb_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `url` varchar(200) DEFAULT NULL COMMENT '下轮抓取的基础URL',
  `count` int(11)  DEFAULT '0' COMMENT '抓取的次数,最大抓取五次',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '抓取时的创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  PRIMARY KEY (`pre_id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`pre_id`,`emailweb_id`,`url`,`cratedate`,`flag`,count)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gwebinfo
-- ----------------------------
DROP TABLE IF EXISTS `mailwebinfo`;
CREATE TABLE `emailwebinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '抓取网站编号',
  `location` varchar(50) DEFAULT NULL COMMENT '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for emailwebspiderinfo
-- ----------------------------
DROP TABLE IF EXISTS `emailwebspiderinfo`;
CREATE TABLE `emailwebspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `emailweb_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(150) DEFAULT NULL COMMENT '抓取的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
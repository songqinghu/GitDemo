/*


Date: 2016-07-26 22:27:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ctoprepic
-- ----------------------------
DROP TABLE IF EXISTS `prepic`;
CREATE TABLE `prepic` (
  `pre_id` bigint(20) NOT NULL AUTO_INCREMENT comment '这是副表主键',
  `web_id` bigint(20) NOT NULL  comment '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `pictype` bigint(3) DEFAULT NULL comment '图片类型,依赖图片类型表',
  `name` varchar(50) DEFAULT NULL comment '显示图片的名称',
  `url` varchar(50) DEFAULT NULL   comment '下轮抓取的基础URL',
  `murl` varchar(50) DEFAULT NULL   comment '小图片的URL,用于列表展示',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '抓取时的创建时间',
  `flag` int(11) DEFAULT '0'  comment '标识位,是否可用',
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for ctomainpic
-- ----------------------------
DROP TABLE IF EXISTS `mainpic`;
CREATE TABLE `mainpic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT comment '详情图片,主表id',
  `pre_id` bigint(20) DEFAULT NULL  comment '副表id',
  `pictype` bigint(3) DEFAULT NULL comment '图片类型,依赖图片类型表',  
  `name` varchar(50) DEFAULT NULL  comment '详情页展示名称',
  `url` varchar(100) DEFAULT NULL  comment '详情页图片地址',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '创建时间',
  `flag` int(11) DEFAULT '0'  comment '图片标示位,默认可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for ctomainpic
-- ----------------------------
DROP TABLE IF EXISTS `imagetype`;

CREATE TABLE `imagetype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT comment '类型Id',
  `typename` varchar(50) DEFAULT NULL comment '图片列表名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for ctomainpic
-- ----------------------------
DROP TABLE IF EXISTS `webinfo`;

CREATE TABLE `webinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT comment '抓取web站点标识id',
  `location` varchar(50) DEFAULT NULL comment '抓取站点的url主地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `webspiderinfo`;

CREATE TABLE `webspiderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `web_id` varchar(50) DEFAULT NULL COMMENT '站点id',
  `url` varchar(50) DEFAULT NULL COMMENT '抓取的url',
  `pictype` bigint(3) DEFAULT NULL COMMENT '图片类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


















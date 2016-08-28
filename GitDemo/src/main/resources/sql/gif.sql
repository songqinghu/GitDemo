-- ----------------------------
-- Table structure for maingif
-- ----------------------------
DROP TABLE IF EXISTS `maingif`;
CREATE TABLE `maingif` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '详情图片,主表id',
  `gweb_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `pre_id` bigint(20) DEFAULT NULL COMMENT '副表id',
  `name` varchar(50) DEFAULT NULL COMMENT '详情页展示名称',
  `url` varchar(100) DEFAULT NULL COMMENT '详情页动态图地址',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '图片标示位,默认可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`pre_id`,`gweb_id`,`url`,`cratedate`,`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pregif
-- ----------------------------
DROP TABLE IF EXISTS `pregif`;
CREATE TABLE `pregif` (
  `pre_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '这是副表主键',
  `gweb_id` bigint(20) NOT NULL COMMENT '抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息',
  `name` varchar(100) DEFAULT NULL COMMENT '显示动态图的名称',
  `url` varchar(100) DEFAULT NULL COMMENT '下轮抓取的基础URL',
  `murl` varchar(200) DEFAULT NULL COMMENT '预处理页的URL,暂时不用',
  `cratedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '抓取时的创建时间',
  `flag` int(11) DEFAULT '0' COMMENT '标识位,是否可用',
  PRIMARY KEY (`pre_id`),
  UNIQUE KEY `index_region_name` (`url`),
  KEY `pre_id` (`pre_id`,`gweb_id`,`url`,`cratedate`,`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
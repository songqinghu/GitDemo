-- ----------------------------
-- 激活码存储页
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '激活码id,主键id',
  `code` varchar(100) DEFAULT NULL COMMENT '激活码内容',
  `codetype` bigint(20) NOT NULL COMMENT '激活码类型',
  `uuid` varchar(100) DEFAULT NULL COMMENT '后期绑定提取码',
  `userId` bigint(20) DEFAULT NULL COMMENT '后期绑定被消费的人',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `flag` int(11) DEFAULT '0' COMMENT '标示位 是否删除,默认可用',
  PRIMARY KEY (`id`),
  KEY `pre_id` (`code`,`codetype`,`uuid`,`userId`,`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
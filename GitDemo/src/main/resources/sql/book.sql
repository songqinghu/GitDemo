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
  `emailweb_id` varchar(50) DEFAULT NULL COMMENT '站点id',
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


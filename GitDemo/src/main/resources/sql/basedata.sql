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

/*
Navicat MySQL Data Transfer

Source Server         : zyy
Source Server Version : 50173
Source Host           : 103.229.28.197:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-08-28 12:56:49
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Records of webinfo
-- ----------------------------
INSERT INTO `webinfo` VALUES ('1', 'http://www.2cto.com');
INSERT INTO `webinfo` VALUES ('2', 'http://www.mm131.com');
INSERT INTO `webinfo` VALUES ('3', 'http://www.souutu.com');
INSERT INTO `webinfo` VALUES ('4', 'http://www.mzitu.com');
INSERT INTO `webinfo` VALUES ('5', 'http://kan.9ku.com');
INSERT INTO `webinfo` VALUES ('6', 'http://www.59pic.com');
INSERT INTO `webinfo` VALUES ('7', 'http://www.uumnt.com');

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
INSERT INTO `webspiderinfo` VALUES ('9', '2', 'http://www.mm131.com/xinggan/', '1');
INSERT INTO `webspiderinfo` VALUES ('10', '2', 'http://www.mm131.com/qingchun/', '6');
INSERT INTO `webspiderinfo` VALUES ('11', '2', 'http://www.mm131.com/xiaohua/', '6');
INSERT INTO `webspiderinfo` VALUES ('12', '2', 'http://www.mm131.com/chemo/', '4');
INSERT INTO `webspiderinfo` VALUES ('13', '2', 'http://www.mm131.com/qipao/', '8');
INSERT INTO `webspiderinfo` VALUES ('14', '2', 'http://www.mm131.com/mingxing/', '7');
INSERT INTO `webspiderinfo` VALUES ('15', '3', 'http://www.souutu.com/mnmm/xgmm/', '1');
INSERT INTO `webspiderinfo` VALUES ('16', '3', 'http://www.souutu.com/mnmm/qc/', '6');
INSERT INTO `webspiderinfo` VALUES ('17', '3', 'http://www.souutu.com/mnmm/mote/', '4');
INSERT INTO `webspiderinfo` VALUES ('18', '3', 'http://www.souutu.com/mnmm/Mtsw/', '3');
INSERT INTO `webspiderinfo` VALUES ('19', '3', 'http://www.souutu.com/mnmm/fzl/', '8');
INSERT INTO `webspiderinfo` VALUES ('20', '3', 'http://www.souutu.com/mnmm/baobei/', '3');
INSERT INTO `webspiderinfo` VALUES ('21', '3', 'http://www.souutu.com/mnmm/cm/', '4');
INSERT INTO `webspiderinfo` VALUES ('22', '3', 'http://www.souutu.com/mnmm/hgmn/', '8');
INSERT INTO `webspiderinfo` VALUES ('23', '3', 'http://www.souutu.com/mnmm/rbmn/', '8');
INSERT INTO `webspiderinfo` VALUES ('24', '3', 'http://www.souutu.com/mnmm/mnmx/', '7');
INSERT INTO `webspiderinfo` VALUES ('25', '4', 'http://www.mzitu.com/xinggan', '4');
INSERT INTO `webspiderinfo` VALUES ('26', '4', 'http://www.mzitu.com/japan', '8');
INSERT INTO `webspiderinfo` VALUES ('27', '4', 'http://www.mzitu.com/taiwan', '8');
INSERT INTO `webspiderinfo` VALUES ('28', '4', 'http://www.mzitu.com/mm', '6');
INSERT INTO `webspiderinfo` VALUES ('29', '5', 'http://kan.9ku.com/mingxing/', '8');
INSERT INTO `webspiderinfo` VALUES ('30', '5', 'http://kan.9ku.com/ichemo/', '4');
INSERT INTO `webspiderinfo` VALUES ('31', '5', 'http://kan.9ku.com/qingchun/', '6');
INSERT INTO `webspiderinfo` VALUES ('32', '5', 'http://kan.9ku.com/xinggan/', '3');
INSERT INTO `webspiderinfo` VALUES ('33', '5', 'http://kan.9ku.com/siwam/', '3');
INSERT INTO `webspiderinfo` VALUES ('34', '5', 'http://kan.9ku.com/gaoqing/', '8');
INSERT INTO `webspiderinfo` VALUES ('35', '5', 'http://kan.9ku.com/ribenm/', '8');
INSERT INTO `webspiderinfo` VALUES ('36', '6', 'http://www.59pic.com/xingganCol/', '1');
INSERT INTO `webspiderinfo` VALUES ('37', '6', 'http://www.59pic.com/swmnCol/', '3');
INSERT INTO `webspiderinfo` VALUES ('38', '6', 'http://www.59pic.com/youwuCol/', '3');
INSERT INTO `webspiderinfo` VALUES ('39', '6', 'http://www.59pic.com/zfmnCol/', '2');
INSERT INTO `webspiderinfo` VALUES ('40', '6', 'http://www.59pic.com/gqmnCol/', '8');
INSERT INTO `webspiderinfo` VALUES ('41', '6', 'http://www.59pic.com/qingchunCol/', '6');
INSERT INTO `webspiderinfo` VALUES ('42', '6', 'http://www.59pic.com/mmzCol/', '6');
INSERT INTO `webspiderinfo` VALUES ('43', '6', 'http://www.59pic.com/xqxmnCol/', '6');
INSERT INTO `webspiderinfo` VALUES ('44', '6', 'http://www.59pic.com/chemoCol/', '4');
INSERT INTO `webspiderinfo` VALUES ('45', '6', 'http://www.59pic.com/fzlmnCol/', '8');
INSERT INTO `webspiderinfo` VALUES ('46', '6', 'http://www.59pic.com/mingxingCol/', '7');
INSERT INTO `webspiderinfo` VALUES ('47', '7', 'http://www.uumnt.com/xinggan/', '1');
INSERT INTO `webspiderinfo` VALUES ('48', '7', 'http://www.uumnt.com/rihan/', '8');
INSERT INTO `webspiderinfo` VALUES ('49', '7', 'http://www.uumnt.com/siwa/', '3');
INSERT INTO `webspiderinfo` VALUES ('50', '7', 'http://www.uumnt.com/zipai/', '5');
INSERT INTO `webspiderinfo` VALUES ('51', '7', 'http://www.uumnt.com/qingchun/', '6');
INSERT INTO `webspiderinfo` VALUES ('52', '7', 'http://www.uumnt.com/chemo/', '4');

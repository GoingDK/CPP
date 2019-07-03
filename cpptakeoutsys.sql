/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : cpptakeoutsys

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-19 18:53:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `shopid` int(11) NOT NULL,
  PRIMARY KEY (`collectid`),
  KEY `userid` (`userid`),
  KEY `shopid` (`shopid`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`shopid`) REFERENCES `shop` (`shopid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1');
INSERT INTO `collection` VALUES ('2', '2', '2');
INSERT INTO `collection` VALUES ('5', '7', '1');
INSERT INTO `collection` VALUES ('7', '2', '1');
INSERT INTO `collection` VALUES ('9', '8', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ordernumber` int(10) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `商家回复评论` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordernumber`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`ordernumber`) REFERENCES `oorder` (`ordernumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'lalala', 'lalalalalala');
INSERT INTO `comment` VALUES ('2', '啊啊啊', 'asasasassa');
INSERT INTO `comment` VALUES ('3', '哎哎哎啊啊啊', null);
INSERT INTO `comment` VALUES ('4', '啊啊啊', '嗡嗡嗡嗡嗡嗡');
INSERT INTO `comment` VALUES ('7', '哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇', null);
INSERT INTO `comment` VALUES ('11', '9999999999999', '顶顶顶顶顶');
INSERT INTO `comment` VALUES ('13', '你好呀~~~！', null);
INSERT INTO `comment` VALUES ('15', '哦', null);

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `foodid` int(10) NOT NULL AUTO_INCREMENT,
  `foodtype` varchar(255) NOT NULL,
  `foodname` varchar(255) NOT NULL,
  `foodprice` double(10,2) NOT NULL,
  `优惠` double(10,3) NOT NULL,
  `上架状态` varchar(255) NOT NULL,
  `shopid` int(11) NOT NULL,
  PRIMARY KEY (`foodid`),
  KEY `shopid` (`shopid`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`shopid`) REFERENCES `shop` (`shopid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '吃', '秘制烤鸡', '15.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('2', '喝', '可乐', '5.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('3', '吃', '劲辣烤鸡', '15.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('4', '吃', '烤鸭全腿', '10.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('5', '喝', '雪碧', '5.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('6', '吃', '盐焗鸡腿', '20.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('7', '喝', '乌龙奶茶', '8.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('8', '喝', '茉香奶茶', '10.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('9', '吃', '盐焗鸡脚', '25.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('10', '吃', '奥尔良鸡腿', '6.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('11', '吃', '墨鱼丸', '3.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('12', '吃', '奥尔良鸡翅', '6.00', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('13', '喝', '王老吉', '4.50', '1.000', '已上架', '1');
INSERT INTO `food` VALUES ('14', '喝', '卡司奶茶', '8.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('15', '喝', '奥利奥珍珠奶盖', '15.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('16', '喝', '布丁奶茶', '10.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('17', '吃', '盐焗鸡翅', '24.00', '1.000', '已上架', '2');
INSERT INTO `food` VALUES ('18', '吃', '肉蛋肠', '8.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('19', '吃', '纯肉肠', '7.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('20', '吃', '双蛋肠', '7.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('21', '吃', '蒸面', '8.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('22', '喝', '百威', '9.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('23', '喝', '哈尔滨', '7.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('24', '喝', '加多宝', '5.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('25', '喝', '可乐', '8.00', '1.000', '已上架', '3');
INSERT INTO `food` VALUES ('26', '喝', '加多宝', '4.50', '1.000', '未上架', '1');

-- ----------------------------
-- Table structure for oorder
-- ----------------------------
DROP TABLE IF EXISTS `oorder`;
CREATE TABLE `oorder` (
  `ordernumber` int(10) NOT NULL AUTO_INCREMENT,
  `foodid` int(10) NOT NULL,
  `foodprice` double(10,2) NOT NULL,
  `userid` int(11) NOT NULL,
  `订单完成状态` varchar(255) NOT NULL,
  `订单接单状态` varchar(255) NOT NULL,
  `是否催单` varchar(255) NOT NULL,
  `商家回复催单` varchar(255) DEFAULT NULL,
  `下单时间` datetime DEFAULT NULL,
  `完成时间` datetime DEFAULT NULL,
  PRIMARY KEY (`ordernumber`),
  KEY `foodid` (`foodid`),
  KEY `userid` (`userid`),
  CONSTRAINT `oorder_ibfk_2` FOREIGN KEY (`foodid`) REFERENCES `food` (`foodid`),
  CONSTRAINT `oorder_ibfk_4` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oorder
-- ----------------------------
INSERT INTO `oorder` VALUES ('1', '1', '15.00', '1', '未完成', '已接单', '是', 'xwxwxwxww', '2018-06-03 19:41:36', null);
INSERT INTO `oorder` VALUES ('2', '2', '5.00', '1', '已完成', '已接单', '否', null, '2018-06-03 20:41:42', '2018-06-03 21:54:25');
INSERT INTO `oorder` VALUES ('3', '6', '20.00', '2', '已完成', '已接单', '是', '快到了', '2018-06-03 21:41:53', '2018-06-06 17:54:36');
INSERT INTO `oorder` VALUES ('4', '6', '20.00', '2', '已完成', '已接单', '否', null, '2018-06-04 18:42:05', '2018-06-04 21:55:01');
INSERT INTO `oorder` VALUES ('5', '5', '5.00', '3', '已完成', '已接单', '否', null, '2018-06-04 19:34:54', '2018-06-05 00:44:53');
INSERT INTO `oorder` VALUES ('6', '6', '20.00', '4', '未完成', '未接单', '否', null, '2018-06-04 19:41:17', null);
INSERT INTO `oorder` VALUES ('7', '7', '8.00', '2', '已完成', '已接单', '是', null, '2018-06-04 20:24:40', '2018-06-06 20:55:06');
INSERT INTO `oorder` VALUES ('8', '6', '20.00', '1', '未完成', '未接单', '否', null, '2018-06-05 17:37:27', null);
INSERT INTO `oorder` VALUES ('11', '3', '15.00', '2', '已完成', '已接单', '否', null, '2018-06-05 22:43:36', '2018-06-05 23:05:39');
INSERT INTO `oorder` VALUES ('12', '3', '15.00', '2', '未完成', '未接单', '否', '', '2018-06-06 00:56:59', null);
INSERT INTO `oorder` VALUES ('13', '7', '8.00', '2', '已完成', '已接单', '是', '啦啦啦啦啦啦', '2018-06-06 01:46:48', '2018-06-16 22:52:59');
INSERT INTO `oorder` VALUES ('15', '2', '5.00', '2', '已完成', '已接单', '否', null, '2018-06-06 21:00:15', '2018-06-08 11:43:13');
INSERT INTO `oorder` VALUES ('17', '9', '25.00', '4', '未完成', '未接单', '否', null, '2018-06-08 09:34:02', null);
INSERT INTO `oorder` VALUES ('18', '6', '20.00', '2', '未完成', '未接单', '否', null, '2018-06-08 20:16:43', null);
INSERT INTO `oorder` VALUES ('20', '18', '8.00', '8', '未完成', '未接单', '否', null, '2018-06-16 22:47:13', null);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopid` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` varchar(255) NOT NULL,
  `shopaddress` varchar(255) NOT NULL,
  `shopphone` double(11,0) NOT NULL,
  `shoppwd` varchar(255) CHARACTER SET latin1 NOT NULL,
  `商店状态` varchar(255) NOT NULL,
  PRIMARY KEY (`shopid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '一记烤鸡', 'lalalala', '13131313131', '654321', '开店');
INSERT INTO `shop` VALUES ('2', 'DAKASI', 'LLLLLL', '12121212121', '987654', '开店');
INSERT INTO `shop` VALUES ('3', '大众烧烤', 'sssssss', '14141414141', '123456', '开店');
INSERT INTO `shop` VALUES ('4', '义合堂', '啦啦啦', '12323232323', '000000', '休息');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `userphone` double(11,0) NOT NULL,
  `userpwd` varchar(255) CHARACTER SET latin1 NOT NULL,
  `userpaypwd` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `useraddress` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', '13131313131', '654321', '6654321', 'lalala');
INSERT INTO `user` VALUES ('2', 'DK', '12121212121', '987654', '000000', '凄凄切切去');
INSERT INTO `user` VALUES ('3', 'user3', '15975610000', 'qwe123', null, 'iaiaia');
INSERT INTO `user` VALUES ('4', 'user4', '15975610001', 'asdasd', '999999', 'lllll');
INSERT INTO `user` VALUES ('5', '1', '11111111111', '1', '1', '1');
INSERT INTO `user` VALUES ('7', 'Going', '15975610002', '123456', '123456', '地球');
INSERT INTO `user` VALUES ('8', '嘿嘿嘿', '45645645645', '212121', '321321', 'kikikikikikiki');

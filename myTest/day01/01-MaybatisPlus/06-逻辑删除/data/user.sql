/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 27/03/2021 12:30:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `version` int(255) DEFAULT NULL,
  `deleted` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', '2021-03-26 19:34:28', '2021-03-23 19:35:02', 0, 0);
INSERT INTO `user` VALUES (2, 'Jack', 120, 'test2@baomidou.com', '2021-03-26 19:34:32', '2021-03-09 19:34:41', 0, 0);
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', '2021-03-26 19:34:35', '2021-03-02 19:34:50', 0, 0);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', '2021-03-24 19:34:38', '2021-03-02 19:34:53', 0, 0);
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', '2021-03-11 19:34:59', '2021-03-30 19:34:56', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;

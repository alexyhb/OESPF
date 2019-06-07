/*
 Navicat Premium Data Transfer

 Source Server         : OESPF
 Source Server Type    : MariaDB
 Source Server Version : 100222
 Source Host           : localhost:3306
 Source Schema         : oespf

 Target Server Type    : MariaDB
 Target Server Version : 100222
 File Encoding         : 65001

 Date: 07/06/2019 10:29:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for esp_clockin
-- ----------------------------
DROP TABLE IF EXISTS `esp_clockin`;
CREATE TABLE `esp_clockin`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) UNSIGNED NOT NULL,
  `courses_id` int(32) NOT NULL,
  `total_number` int(8) NOT NULL,
  `corrent_clockin_number` int(8) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_courses
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses`;
CREATE TABLE `esp_courses`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `courses_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'url thumb',
  `exam_type` tinyint(2) UNSIGNED NOT NULL,
  `courses_length` time(0) NOT NULL,
  `courses_number` int(32) UNSIGNED NOT NULL,
  `money` decimal(32, 2) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `teach_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_courses
-- ----------------------------
INSERT INTO `esp_courses` VALUES (1, 'aaa', 'aaa', '#', 1, '20:03:18', 10, 250.00, '2019-06-03 20:03:33', 'lfxu');
INSERT INTO `esp_courses` VALUES (2, 'bbb', 'bbb', '#', 1, '20:03:47', 10, 250.00, '2019-06-03 20:03:55', 'lfxu');
INSERT INTO `esp_courses` VALUES (3, 'ccc', 'ccc', '#', 1, '20:04:07', 10, 250.00, '2019-06-03 20:04:17', 'lfxu');

-- ----------------------------
-- Table structure for esp_courses_point
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses_point`;
CREATE TABLE `esp_courses_point`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courses_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `creat_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime(0) DEFAULT NULL,
  `courses_point` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_courses_point
-- ----------------------------
INSERT INTO `esp_courses_point` VALUES (1, 1, 1, '2019-05-05 15:29:09', NULL, 1);

-- ----------------------------
-- Table structure for esp_courses_url
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses_url`;
CREATE TABLE `esp_courses_url`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `courses_id` int(10) UNSIGNED NOT NULL,
  `total_number` int(10) UNSIGNED NOT NULL,
  `current_number` int(10) UNSIGNED DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lecture_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_courses_url
-- ----------------------------
INSERT INTO `esp_courses_url` VALUES (1, 1, 10, 1, '#', 'aaa1');
INSERT INTO `esp_courses_url` VALUES (2, 1, 10, 2, '#', 'aaa2');
INSERT INTO `esp_courses_url` VALUES (3, 1, 10, 3, '#', 'aaa3');
INSERT INTO `esp_courses_url` VALUES (4, 1, 10, 4, '#', 'aaa4');
INSERT INTO `esp_courses_url` VALUES (5, 1, 10, 5, '#', 'aaa5');
INSERT INTO `esp_courses_url` VALUES (6, 1, 10, 6, '#', 'aaa6');
INSERT INTO `esp_courses_url` VALUES (7, 1, 10, 7, '#', 'aaa7');
INSERT INTO `esp_courses_url` VALUES (8, 1, 10, 8, '#', 'aaa8');
INSERT INTO `esp_courses_url` VALUES (9, 1, 10, 9, '#', 'aaa9');
INSERT INTO `esp_courses_url` VALUES (10, 1, 10, 10, '#', 'aaa10');

-- ----------------------------
-- Table structure for esp_homework
-- ----------------------------
DROP TABLE IF EXISTS `esp_homework`;
CREATE TABLE `esp_homework`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) UNSIGNED NOT NULL,
  `courses_id` int(32) UNSIGNED NOT NULL,
  `current_number` int(32) UNSIGNED NOT NULL,
  `homework_id` int(32) UNSIGNED NOT NULL,
  `start_time` datetime(0) NOT NULL,
  `end_time` datetime(0) NOT NULL,
  `score` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_payment
-- ----------------------------
DROP TABLE IF EXISTS `esp_payment`;
CREATE TABLE `esp_payment`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) UNSIGNED NOT NULL,
  `courses_id` int(32) UNSIGNED NOT NULL,
  `price` decimal(32, 2) UNSIGNED NOT NULL COMMENT '标价',
  `status` tinyint(2) UNSIGNED NOT NULL COMMENT '1 待支付\r\n2 已支付\r\n3 支付超时\r\n4 取消订单',
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_point_exchange
-- ----------------------------
DROP TABLE IF EXISTS `esp_point_exchange`;
CREATE TABLE `esp_point_exchange`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `point` int(32) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '1 pass\r\n2 check\r\n3 refuse\r\n',
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `esp_questionnaire`;
CREATE TABLE `esp_questionnaire`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `questionnaire_type` tinyint(2) NOT NULL,
  `ideal_score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT current_timestamp(),
  `courses_id` int(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_recharge
-- ----------------------------
DROP TABLE IF EXISTS `esp_recharge`;
CREATE TABLE `esp_recharge`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_number` int(8) UNSIGNED NOT NULL,
  `user_id` int(32) UNSIGNED NOT NULL,
  `to_up_balance` decimal(32, 2) UNSIGNED NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `status` tinyint(2) UNSIGNED NOT NULL COMMENT '1 通过\r\n2 等待中\r\n3 拒绝\r\n4 取消\r\n',
  `up_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_recharge
-- ----------------------------
INSERT INTO `esp_recharge` VALUES (1, 1, 1, 1.00, '2019-05-16 21:32:59', 1, NULL);

-- ----------------------------
-- Table structure for esp_reward_point
-- ----------------------------
DROP TABLE IF EXISTS `esp_reward_point`;
CREATE TABLE `esp_reward_point`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `reward_point` int(32) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_reward_point
-- ----------------------------
INSERT INTO `esp_reward_point` VALUES (1, 1, 15, '2019-05-03 11:45:22');

-- ----------------------------
-- Table structure for esp_running_account
-- ----------------------------
DROP TABLE IF EXISTS `esp_running_account`;
CREATE TABLE `esp_running_account`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` tinyint(2) UNSIGNED NOT NULL COMMENT '1 雅思\r\n2 托福\r\n3 GRE\r\n4 GMAT\r\n5 CET',
  `total_amount` decimal(32, 2) UNSIGNED NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `remark` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esp_running_courses
-- ----------------------------
DROP TABLE IF EXISTS `esp_running_courses`;
CREATE TABLE `esp_running_courses`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cources_id` int(32) NOT NULL,
  `total_number` int(32) NOT NULL,
  `current_number` int(32) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_running_courses
-- ----------------------------
INSERT INTO `esp_running_courses` VALUES (1, '1', 1, 1, 0, '2019-06-06 15:33:53', NULL);
INSERT INTO `esp_running_courses` VALUES (2, '1', 1, 10, 0, '2019-06-06 15:37:40', NULL);

-- ----------------------------
-- Table structure for esp_user
-- ----------------------------
DROP TABLE IF EXISTS `esp_user`;
CREATE TABLE `esp_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_role` tinyint(2) UNSIGNED NOT NULL COMMENT '1 管理员\r\n2 老师\r\n3 学生',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `balance` decimal(64, 2) UNSIGNED NOT NULL,
  `reward_point` int(32) UNSIGNED ZEROFILL NOT NULL,
  `regesit_time` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `login_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of esp_user
-- ----------------------------
INSERT INTO `esp_user` VALUES (1, 3, 'alex', '123456', 0.00, 00000000000000000000000000000000, '2019-04-08 15:19:26', NULL);
INSERT INTO `esp_user` VALUES (2, 3, 'alexia', '123', 0.00, 00000000000000000000000000000000, '2019-04-24 18:35:23', NULL);
INSERT INTO `esp_user` VALUES (3, 3, 'aaa', '123456', 0.00, 00000000000000000000000000000000, '2019-04-24 19:34:41', NULL);
INSERT INTO `esp_user` VALUES (4, 3, 'alexiaaa', '123456', 0.00, 00000000000000000000000000000000, '2019-06-05 13:50:33', NULL);
INSERT INTO `esp_user` VALUES (5, 3, 'bbb', '123456', 0.00, 00000000000000000000000000000000, '2019-06-05 17:21:52', NULL);

SET FOREIGN_KEY_CHECKS = 1;

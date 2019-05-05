/*
Navicat MariaDB Data Transfer

Source Server         : mariadb
Source Server Version : 100313
Source Host           : localhost:3307
Source Database       : oespf

Target Server Type    : MariaDB
Target Server Version : 100313
File Encoding         : 65001

Date: 2019-05-05 10:13:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for esp_clockin
-- ----------------------------
DROP TABLE IF EXISTS `esp_clockin`;
CREATE TABLE `esp_clockin` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `courses_id` int(32) NOT NULL,
  `total_number` int(8) NOT NULL,
  `corrent_clockin_number` int(8) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_clockin
-- ----------------------------

-- ----------------------------
-- Table structure for esp_courses
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses`;
CREATE TABLE `esp_courses` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `courses_name` varchar(255) NOT NULL,
  `exam_type` tinyint(2) unsigned NOT NULL,
  `courses_length` time NOT NULL,
  `courses_number` int(32) unsigned NOT NULL,
  `money` decimal(32,2) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_courses
-- ----------------------------

-- ----------------------------
-- Table structure for esp_courses_point
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses_point`;
CREATE TABLE `esp_courses_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courses_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `creat_time` datetime NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime DEFAULT NULL,
  `courses_point` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_courses_point
-- ----------------------------

-- ----------------------------
-- Table structure for esp_courses_url
-- ----------------------------
DROP TABLE IF EXISTS `esp_courses_url`;
CREATE TABLE `esp_courses_url` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courses_id` int(10) unsigned NOT NULL,
  `total_number` int(10) unsigned NOT NULL,
  `current_number` int(10) unsigned DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_courses_url
-- ----------------------------

-- ----------------------------
-- Table structure for esp_homework
-- ----------------------------
DROP TABLE IF EXISTS `esp_homework`;
CREATE TABLE `esp_homework` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `courses_id` int(32) unsigned NOT NULL,
  `current_number` int(32) unsigned NOT NULL,
  `homework_id` int(32) unsigned NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `score` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_homework
-- ----------------------------

-- ----------------------------
-- Table structure for esp_payment
-- ----------------------------
DROP TABLE IF EXISTS `esp_payment`;
CREATE TABLE `esp_payment` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `courses_id` int(32) unsigned NOT NULL,
  `courses_price` decimal(32,2) unsigned NOT NULL COMMENT '标价',
  `courses_real_price` decimal(32,2) unsigned NOT NULL COMMENT '实付',
  `status` tinyint(2) unsigned NOT NULL COMMENT '1 待支付\r\n2 已支付\r\n3 支付超时\r\n4 取消订单',
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_payment
-- ----------------------------

-- ----------------------------
-- Table structure for esp_point_exchange
-- ----------------------------
DROP TABLE IF EXISTS `esp_point_exchange`;
CREATE TABLE `esp_point_exchange` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `point` int(32) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '1 pass\r\n2 check\r\n3 refuse\r\n',
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_point_exchange
-- ----------------------------

-- ----------------------------
-- Table structure for esp_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `esp_questionnaire`;
CREATE TABLE `esp_questionnaire` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `questionnaire_type` tinyint(2) NOT NULL,
  `ideal_score` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `courses_id` int(32) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_questionnaire
-- ----------------------------

-- ----------------------------
-- Table structure for esp_recharge
-- ----------------------------
DROP TABLE IF EXISTS `esp_recharge`;
CREATE TABLE `esp_recharge` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `order_number` int(8) unsigned NOT NULL,
  `user_id` int(32) unsigned NOT NULL,
  `to_up_balance` decimal(32,2) unsigned NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `status` tinyint(2) unsigned NOT NULL COMMENT '1 通过\r\n2 等待中\r\n3 拒绝',
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_recharge
-- ----------------------------

-- ----------------------------
-- Table structure for esp_reward_point
-- ----------------------------
DROP TABLE IF EXISTS `esp_reward_point`;
CREATE TABLE `esp_reward_point` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NOT NULL,
  `reward_point` int(32) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_reward_point
-- ----------------------------
INSERT INTO `esp_reward_point` VALUES ('1', '1', '13', '2019-05-03 11:45:22');

-- ----------------------------
-- Table structure for esp_running_account
-- ----------------------------
DROP TABLE IF EXISTS `esp_running_account`;
CREATE TABLE `esp_running_account` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `type` tinyint(2) unsigned NOT NULL COMMENT '1 雅思\r\n2 托福\r\n3 GRE\r\n4 GMAT\r\n5 CET',
  `total_amount` decimal(32,2) unsigned NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `remark` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_running_account
-- ----------------------------

-- ----------------------------
-- Table structure for esp_running_courses
-- ----------------------------
DROP TABLE IF EXISTS `esp_running_courses`;
CREATE TABLE `esp_running_courses` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `cources_id` int(32) NOT NULL,
  `total_number` int(32) NOT NULL,
  `current_number` int(32) NOT NULL,
  `average_length` time NOT NULL,
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_running_courses
-- ----------------------------

-- ----------------------------
-- Table structure for esp_user
-- ----------------------------
DROP TABLE IF EXISTS `esp_user`;
CREATE TABLE `esp_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_role` tinyint(2) unsigned NOT NULL COMMENT '1 管理员\r\n2 老师\r\n3 学生',
  `user_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `balance` decimal(64,2) unsigned NOT NULL,
  `reward_point` int(32) unsigned zerofill NOT NULL,
  `regesit_time` datetime NOT NULL DEFAULT current_timestamp(),
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of esp_user
-- ----------------------------
INSERT INTO `esp_user` VALUES ('1', '3', 'alex', '123456', '0.00', '00000000000000000000000000000000', '2019-04-08 15:19:26', null);
INSERT INTO `esp_user` VALUES ('2', '3', 'alexia', '123', '0.00', '00000000000000000000000000000000', '2019-04-24 18:35:23', null);
INSERT INTO `esp_user` VALUES ('3', '3', 'aaa', '123456', '0.00', '00000000000000000000000000000000', '2019-04-24 19:34:41', null);

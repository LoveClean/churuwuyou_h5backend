/*
 Navicat Premium Data Transfer

 Source Server         : 华为云rds-312
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 122.112.159.26:3306
 Source Schema         : churuwuyou

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 24/05/2019 16:23:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常， 8超级管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '黄鹏飞', 'A4C5127AF9B4273E9274A1D80A7C7336', '18867726399', '黄鹏飞', '发哥', '2019-03-15 11:52:02', '测试员黄鹏飞', '2019-04-19 20:41:08', 8);
INSERT INTO `admin` VALUES (11, '黄鹏飞2号', 'A4C5127AF9B4273E9274A1D80A7C7336', '17316900639', '黄鹏飞', '测试员黄鹏飞', '2019-04-19 20:07:46', NULL, '2019-05-23 16:26:06', 8);
INSERT INTO `admin` VALUES (12, 'gyq', 'E99A18C428CB38D5F260853678922E03', '15888881111', '顾雨晴', '黄鹏飞2号', '2019-04-19 21:08:22', '黄鹏飞2号', '2019-04-26 18:52:57', 1);
INSERT INTO `admin` VALUES (13, 'swf', 'E1102BD2450FA9B2EDADD069FE03B4FF', '18205812926', '史文峰', '黄鹏飞', '2019-04-23 09:33:13', '黄鹏飞', '2019-05-21 17:27:09', 8);
INSERT INTO `admin` VALUES (14, 'xs', 'BCC896C9BC3F07863482D1CC142DA57A', '18058790687', '薛松', '黄鹏飞2号', '2019-04-26 18:53:56', NULL, '2019-04-26 18:53:56', 1);
INSERT INTO `admin` VALUES (16, 'hpf', 'A4C5127AF9B4273E9274A1D80A7C7336', '15558006396', '黄鹏飞', '黄鹏飞', '2019-05-06 10:11:20', '黄鹏飞', '2019-05-22 17:42:46', 1);
INSERT INTO `admin` VALUES (30, 'zsw', '30BE9FE327E9CD3F53A95CAB3124DCCD', '18811221079', '张舒雯', '黄鹏飞', '2019-05-13 17:13:07', NULL, '2019-05-23 16:23:59', 0);
INSERT INTO `admin` VALUES (32, 'zhangsan', '123456', '13753655403', '张三', NULL, '2019-05-22 10:35:53', NULL, '2019-05-23 16:22:18', 1);

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主id',
  `visitor_id` int(11) NULL DEFAULT NULL COMMENT '访客id',
  `car_num` int(16) NOT NULL COMMENT '车牌号码',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主id',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常，已申请，等待受理  2受理，处理中  3已处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投诉表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES (1, 5, 'string', 'string', 'string', '2019-05-16 14:39:32', NULL, '2019-05-20 15:06:14', 1);
INSERT INTO `complain` VALUES (2, 3, '头发', '那你', '史文峰', '2019-05-24 15:08:01', NULL, '2019-05-24 15:08:01', 1);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '类型 1资讯  2公告',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资讯表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (1, 2, '测试1212', '爱迪生', '13', '2019-05-23 10:36:17', '13', '2019-05-23 14:54:42', 1);
INSERT INTO `information` VALUES (2, 2, '测试1212', '三大幅', '13', '2019-05-23 10:39:08', '13', '2019-05-23 14:54:43', 1);
INSERT INTO `information` VALUES (3, 2, '测试1212', '阿萨达', '13', '2019-05-23 10:40:25', '13', '2019-05-23 16:07:26', 1);

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '性别 1男 2女',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `building_num` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号',
  `house_num` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `wechat_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of owner
-- ----------------------------
INSERT INTO `owner` VALUES (1, '1', 1, NULL, '1', NULL, NULL, NULL, '1', NULL, '2019-05-15 15:24:48', NULL, '2019-05-24 10:50:59', -1);
INSERT INTO `owner` VALUES (3, '史文峰', 1, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/201905171397294dbe.png', '13333333333', NULL, '3', '501', 'oov171DXgVKigtK2rHdNpCJeDfgU', '13', '2019-05-17 13:48:24', NULL, '2019-05-24 15:05:29', 1);
INSERT INTO `owner` VALUES (4, '姜洋', 0, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/201905171397294dbe.png', '18335645849', NULL, '3', '502', NULL, '13', '2019-05-17 13:52:56', '13', '2019-05-23 16:07:07', 1);
INSERT INTO `owner` VALUES (5, '黄鹏飞', 1, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/20190522145a04b1ac.png', '15558006395', NULL, '3', '501', NULL, '13', '2019-05-17 13:53:48', '13', '2019-05-22 16:15:56', 1);
INSERT INTO `owner` VALUES (7, '史文峰', 0, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/201905171397294dbe.png', '13753655403', 'E10ADC3949BA59ABBE56E057F20F883E', '3', '501', 'oov171AxTWMI2ZhMW7o6uxNKpvFc', '13', '2019-05-23 15:01:02', '13', '2019-05-24 10:43:00', 1);
INSERT INTO `owner` VALUES (8, '史文峰', 1, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/201905171397294dbe.png', '13333333334', 'E10ADC3949BA59ABBE56E057F20F883E', '3', '501', NULL, '13', '2019-05-24 11:15:58', NULL, '2019-05-24 11:15:58', 1);

-- ----------------------------
-- Table structure for parking_fee
-- ----------------------------
DROP TABLE IF EXISTS `parking_fee`;
CREATE TABLE `parking_fee`  (
  `visitor_apply_id` int(11) NOT NULL COMMENT '访客预约记录id',
  `money` int(1) NULL DEFAULT 0 COMMENT '缴费总金额',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间（车辆进入园区时间）',
  `last_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后缴费时间',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态，0未缴费，1已缴费，2，已出门',
  PRIMARY KEY (`visitor_apply_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parking_fee
-- ----------------------------
INSERT INTO `parking_fee` VALUES (1, 800, '2019-05-22 09:45:53', '2019-05-22 11:05:35', 1);
INSERT INTO `parking_fee` VALUES (2, 30, '2019-05-23 15:54:15', '2019-05-23 17:00:00', 2);

-- ----------------------------
-- Table structure for pay_record
-- ----------------------------
DROP TABLE IF EXISTS `pay_record`;
CREATE TABLE `pay_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parking_fee_id` int(11) NULL DEFAULT NULL COMMENT '停车费表id',
  `money` decimal(5, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '缴费记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_record
-- ----------------------------
INSERT INTO `pay_record` VALUES (1, 2, 15.00, '1', '2019-05-23 16:00:00');
INSERT INTO `pay_record` VALUES (2, 2, 15.00, '1', '2019-05-23 17:00:00');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主id',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常，已申请，等待受理  2受理，处理中  3已处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报修表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (1, 3, '方法', '刚刚', '史文峰', '2019-05-24 15:07:45', '13', '2019-05-24 16:01:04', 1);

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别，1男，2女',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `wechat_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类别',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态，-1已删除，0禁用，1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访客表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES (1, '高手啊', 1, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/2019052313a3264b72.jpg', 'string', NULL, '1', NULL, NULL, '2019-05-15 13:58:29', '13', '2019-05-24 11:00:44', -1);
INSERT INTO `visitor` VALUES (13, '%鬼混', 2, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/2019052313a3264b72.jpg', '15558006396', NULL, 'oov171AxTWMI2ZhMW7o6uxNKpvFc', NULL, NULL, '2019-05-23 13:34:06', '13', '2019-05-23 16:10:33', 1);
INSERT INTO `visitor` VALUES (14, '围棋少年', 1, 'http://obs-312.obs.cn-east-2.myhuaweicloud.com/2019052314652aab02.png', '17789431367', NULL, 'oov171DXgVKigtK2rHdNpCJeDfgU', NULL, NULL, '2019-05-23 14:12:20', '13', '2019-05-24 10:59:02', 1);

-- ----------------------------
-- Table structure for visitor_apply
-- ----------------------------
DROP TABLE IF EXISTS `visitor_apply`;
CREATE TABLE `visitor_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `visitor_id` int(11) NULL DEFAULT NULL COMMENT '访客id',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主id',
  `start_time` timestamp(0) NOT NULL COMMENT '预约开始时间',
  `expiration_time` timestamp(0) NOT NULL COMMENT '预约到期时间',
  `car_num` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号码',
  `in_time` timestamp(0) NULL DEFAULT NULL COMMENT '进入园区时间',
  `out_time` timestamp(0) NULL DEFAULT NULL COMMENT '离开园区时间',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态，-1不通过，0未进入，1已进入，2已离开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访客预约记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor_apply
-- ----------------------------
INSERT INTO `visitor_apply` VALUES (1, 1, 1, '2019-05-17 13:28:52', '2019-05-17 13:28:54', NULL, NULL, NULL, 1);
INSERT INTO `visitor_apply` VALUES (2, 1, 3, '2019-05-23 14:12:42', '2019-05-25 14:12:42', '晋E41448', '2019-05-23 15:52:44', '2019-05-23 17:52:55', 2);
INSERT INTO `visitor_apply` VALUES (3, 13, 3, '2019-05-23 14:12:42', '2019-05-23 14:12:42', '浙A12345', NULL, NULL, 0);
INSERT INTO `visitor_apply` VALUES (4, 13, 1, '2019-05-23 14:48:58', '2019-05-23 14:49:06', '', '2019-05-23 16:49:21', '2019-05-24 16:49:32', 2);
INSERT INTO `visitor_apply` VALUES (5, 14, 3, '2019-05-23 14:49:08', '2019-08-23 14:49:19', NULL, '2019-05-23 16:49:36', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;

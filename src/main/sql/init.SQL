
-- ----------------------------
-- Table structure for resource_info
-- ----------------------------
CREATE TABLE `resource_info`  (
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '主键id',
  `RESOURCE_CODE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源编码',
  `RESOURCE_TYPE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源类型',
  `RESOURCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `RESOURCE_PARENT` bigint(20) NULL DEFAULT NULL COMMENT '父级资源id',
  `RESOURCE_STATUS` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '状态(0-无效;1-有效)',
  `RESOURCE_CREATER` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `RESOURCE_CREATE_DATE` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `RESOURCE_ICON` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  `RESOURCE_PATH` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源路径',
  `RESOURCE_UPDATER` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `RESOURCE_UPDATE_DATE` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `RESOURCE_ORDER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源排序',
  PRIMARY KEY (`RESOURCE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES (1, 'SYS_MANAGER', '0', '系统管理', NULL, '1', 1, '2019-03-16 13:50:21', NULL, '/sys/sysManagers', NULL, NULL, '1');
INSERT INTO `resource_info` VALUES (2, 'SYS_MGR_USER', '0', '用户管理', 1, '1', 1, '2019-03-16 13:51:21', NULL, '/user/userManagers', NULL, NULL, '1');
INSERT INTO `resource_info` VALUES (3, 'SYS_MGR_ROLE', '0', '角色管理', 1, '1', 1, '2019-03-16 13:52:05', NULL, '/role/roleManagers', NULL, NULL, '2');
INSERT INTO `resource_info` VALUES (4, 'SYS_MGR_RESOURCE', '0', '资源管理', 1, '1', 1, '2019-03-16 13:52:42', NULL, '/resource/resManagers', NULL, NULL, '3');
INSERT INTO `resource_info` VALUES (5, 'SYS_MGR_CODE', '0', '字典管理', 1, '1', 1, '2019-03-16 13:53:16', NULL, '/code/codeManagers', NULL, NULL, '4');
INSERT INTO `resource_info` VALUES (6, 'SYS_MGR_DEPT', '0', '部门管理', 1, '1', 1, '2019-03-16 13:54:49', NULL, '/dept/deptManagers', NULL, NULL, '5');
INSERT INTO `resource_info` VALUES (7, 'SYS_MGR_SYS', '0', '系统相关', 1, '1', 1, '2019-03-16 13:55:57', NULL, '/sysuse', NULL, NULL, '6');
INSERT INTO `resource_info` VALUES (8, 'SYS_MSYS_ONLINE', '0', '在线管理', 7, '1', 1, '2019-03-16 13:57:05', NULL, '/sysuse/online', NULL, NULL, '1');
INSERT INTO `resource_info` VALUES (9, 'SYS_MSYS_LOGS', '0', '日志管理', 7, '1', 1, '2019-03-16 13:57:53', NULL, '/sysuse/logs', NULL, NULL, '2');
INSERT INTO `resource_info` VALUES (10, 'SYS_MSYS_ANA', '0', '系统统计', 7, '1', 1, '2019-03-16 13:59:11', NULL, '/sysuse/statistical', NULL, NULL, '3');
INSERT INTO `resource_info` VALUES (11, 'SYS_MAIN_INDEX', '0', '首页', NULL, '1', 1, '2020-04-30 22:08:04', NULL, '/mian/index', NULL, NULL, '0');
INSERT INTO `resource_info` VALUES (12, 'MY_FILE', '0', '我的信息', NULL, '1', 1, '2020-04-30 22:38:27', NULL, '/myinfo', NULL, NULL, '2');
INSERT INTO `resource_info` VALUES (13, 'MY_FILE_INFO', '0', '个人资料', 12, '1', 1, '2020-04-30 22:39:19', NULL, '/myinfo/infodetails', NULL, NULL, '1');

-- ----------------------------
-- Table structure for resource_role_relate
-- ----------------------------
CREATE TABLE `resource_role_relate`  (
  `ROLE_RS_ID` bigint(20) NOT NULL COMMENT '主键id',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色id',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`ROLE_RS_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_role_relate
-- ----------------------------
INSERT INTO `resource_role_relate` VALUES (1, 1, 1);
INSERT INTO `resource_role_relate` VALUES (2, 1, 2);
INSERT INTO `resource_role_relate` VALUES (3, 1, 3);
INSERT INTO `resource_role_relate` VALUES (4, 1, 4);
INSERT INTO `resource_role_relate` VALUES (5, 1, 5);
INSERT INTO `resource_role_relate` VALUES (6, 1, 6);
INSERT INTO `resource_role_relate` VALUES (7, 1, 7);
INSERT INTO `resource_role_relate` VALUES (8, 1, 8);
INSERT INTO `resource_role_relate` VALUES (9, 1, 9);
INSERT INTO `resource_role_relate` VALUES (10, 1, 10);
INSERT INTO `resource_role_relate` VALUES (11, 1, 11);
INSERT INTO `resource_role_relate` VALUES (12, 1, 12);
INSERT INTO `resource_role_relate` VALUES (13, 1, 13);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
CREATE TABLE `role_info`  (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '主键ID',
  `ROLE_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色code',
  `ROLE_STATUS` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '角色状态（0-有效1-无效）',
  `ROLE_CREATER` bigint(20) NULL DEFAULT NULL COMMENT '角色创建者',
  `ROLE_CREATE_DATE` timestamp(0) NULL DEFAULT NULL COMMENT '角色创建时间',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `ROLE_REMARK` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色备注',
  `ROLE_UPDATER` bigint(20) NULL DEFAULT NULL COMMENT '角色更新者',
  `ROLE_UPDATE_DATE` datetime(0) NULL DEFAULT NULL COMMENT '角色更新时间',
  `ROLE_PARENT_ID` bigint(20) NULL DEFAULT NULL COMMENT '角色父级ID',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'ADMIN', '0', 1, '2018-11-17 11:34:21', '系统管理员', NULL, NULL, NULL, NULL);
INSERT INTO `role_info` VALUES (2, 'SUPPER_ADMIN', '0', 1, '2019-03-16 16:19:52', '超级管理员', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_basic_info
-- ----------------------------
CREATE TABLE `user_basic_info`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '主键ID',
  `USER_UNIQUE_SIGN` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一识别用户标识',
  `USER_PASSWORD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `USER_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户真实名字',
  `USER_SEX` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '性别（0-男；1-女）',
  `USER_BIRTHDAY` timestamp(0) NULL DEFAULT NULL COMMENT '出生年月',
  `USER_EDUCATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
  `USER_CONTACT` bigint(100) NULL DEFAULT NULL COMMENT '联系电话',
  `USER_STATUS` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否有效（0-有效；1-无效）',
  `USER_CREATER` bigint(20) NULL DEFAULT NULL COMMENT '用户创建者',
  `USER_CREATE_DATE` timestamp(0) NULL DEFAULT NULL COMMENT '用户创建时间',
  `USER_UPDATER` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `USER_UPDATE_DATE` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`USER_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_2`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_3`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_4`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_5`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_6`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_7`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_8`(`USER_ID`) USING BTREE,
  INDEX `USER_ID_9`(`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_basic_info
-- ----------------------------
INSERT INTO `user_basic_info` VALUES (1, 'admin', '1', '管理员', '0', '2018-07-14 22:35:17', '0', 123456789, '0', 1, '2018-11-17 11:35:47', NULL, NULL);
INSERT INTO `user_basic_info` VALUES (2, 'lgli', '1', '罗罗', '0', '2018-11-17 11:35:35', '0', 123456789, '0', 1, '2018-11-17 11:35:49', NULL, NULL);

-- ----------------------------
-- Table structure for user_role_relate
-- ----------------------------
CREATE TABLE `user_role_relate`  (
  `ROLE_USER_ID` bigint(20) NOT NULL COMMENT '主键ID',
  `USER_BASIC_ID` bigint(20) NOT NULL COMMENT '用户表主键ID',
  `ROLE_INFO_ID` bigint(20) NOT NULL COMMENT '角色表主键ID',
  PRIMARY KEY (`ROLE_USER_ID`) USING BTREE,
  INDEX `role_user`(`USER_BASIC_ID`) USING BTREE,
  CONSTRAINT `role_user` FOREIGN KEY (`USER_BASIC_ID`) REFERENCES `user_basic_info` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relate
-- ----------------------------
INSERT INTO `user_role_relate` VALUES (1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;

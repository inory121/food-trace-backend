/*
 Navicat Premium Data Transfer

 Source Server         : inory
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : food_trace

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 14/12/2021 19:43:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for butcher
-- ----------------------------
DROP TABLE IF EXISTS `butcher`;
CREATE TABLE `butcher`  (
  `PigID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪只编号',
  `HealthStatu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '健康状况',
  `QuaranDate` datetime NOT NULL COMMENT '检疫日期',
  `PorkBatches` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪肉批次',
  `SlaDate` datetime NOT NULL COMMENT '屠宰日期',
  `AcidTime` datetime NOT NULL COMMENT '排酸时间',
  `AmbientTeHu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '环境温湿度',
  `PackID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '包装编号',
  `PackMaterial` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '包装材料',
  `PackTime` datetime NOT NULL COMMENT '包装时间',
  `MeatPart` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪肉部位',
  `OperatorID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作员编号',
  `Hash` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据摘要',
  `state` int NULL DEFAULT NULL COMMENT '审核状态 0 审核中 1 审核通过',
  PRIMARY KEY (`PigID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of butcher
-- ----------------------------
INSERT INTO `butcher` VALUES ('5805562810', '健康', '2020-08-05 16:00:00', '24', '2021-09-06 11:29:08', '2021-09-06 18:02:02', '25°C 60%', '3253465747', '塑料皮', '2021-09-10 07:02:01', '里脊肉', '9070617065', 'da5403694f085a15cfce2a11b282371897498eedbf8cb5d8bc62416c4466534d', 1);

-- ----------------------------
-- Table structure for check
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check`  (
  `checkID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '审核编号',
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪肉id或物流id或销售id',
  `info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '修改后的信息',
  `state` int NOT NULL COMMENT '0 审核中 1 审核通过',
  PRIMARY KEY (`checkID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of check
-- ----------------------------
INSERT INTO `check` VALUES ('1e103b9e06c27fa9aab12fb58e9b2f92', '5805562810', '{\"vaccineTime\":1623859200000,\"cultTime\":1599736717000,\"farmId\":\"581\",\"vaccineType\":\"弱毒苗\",\"farmOwner\":\"张三\",\"farmPosit\":\"安徽省淮南市\",\"ehygiene\":\"严格消毒\",\"pigId\":\"5805562810\",\"pigType\":\"金华猪\",\"pigGender\":\"雌\",\"feedType\":\"添加剂预混料\",\"operatorId\":\"8732564590\"}', 1);
INSERT INTO `check` VALUES ('1fe4e4a02dec970c80e46344d5a4572d', '5805562810', '{\"vaccineTime\":1623859200000,\"cultTime\":1599736717000,\"farmId\":\"580\",\"vaccineType\":\"弱毒苗\",\"farmOwner\":\"张三\",\"farmPosit\":\"安徽省淮南市\",\"ehygiene\":\"严格消毒\",\"pigId\":\"5805562810\",\"pigType\":\"金华猪\",\"pigGender\":\"雌\",\"feedType\":\"添加剂预混料\",\"operatorId\":\"8732564590\"}', 1);
INSERT INTO `check` VALUES ('29685a0653214f64c662c8ae87ccc67f', '5805562810', '{\"vaccineTime\":1623859200000,\"cultTime\":1599736717000,\"farmId\":\"5800\",\"vaccineType\":\"弱毒苗\",\"farmOwner\":\"张三\",\"farmPosit\":\"安徽省淮南市\",\"ehygiene\":\"严格消毒\",\"pigId\":\"5805562810\",\"pigType\":\"金华猪\",\"pigGender\":\"雌\",\"feedType\":\"添加剂预混料\",\"operatorId\":\"8732564590\"}', 1);
INSERT INTO `check` VALUES ('7bdc35e57f91ef3d7a1ce57742dadfab', '7514162444', '{\"enterPosit\":\"湖北省武汉市\",\"storageTime\":1631274333000,\"shelfTime\":1631360773000,\"storageTeHu\":\"25°C 60%\",\"salesSite\":\"武汉市\",\"salesInfoId\":\"7514162444\",\"enterName\":\"武汉家乐福有限公司\",\"operatorId\":\"6476335359\"}', 1);
INSERT INTO `check` VALUES ('7d51d69e8fff23494967a758a09258cc', '5805562810', '{\"vaccineTime\":1623859200000,\"cultTime\":1599736717000,\"farmId\":\"580\",\"vaccineType\":\"弱毒苗\",\"farmOwner\":\"张三\",\"farmPosit\":\"安徽省淮南市\",\"ehygiene\":\"严格消毒\",\"pigId\":\"5805562810\",\"pigType\":\"金华猪\",\"pigGender\":\"雌\",\"feedType\":\"添加剂预混料\",\"operatorId\":\"8732564590\"}', 1);
INSERT INTO `check` VALUES ('85415e3c6bf9a5356ae601a6a1277453', '4271359911', '{\"enterOwner\":\"李四\",\"transTime\":1631101247000,\"enterPosit\":\"江西省南昌市\",\"transportId\":\"4271359911\",\"carriageTeHu\":\"-10°C\",\"licenNumber\":\"豫C634968\",\"transDestin\":\"湖南省长沙市\",\"transOrigin\":\"江苏省宿迁市\",\"driverName\":\"王五\",\"enterName\":\"申通物流\",\"operatorId\":\"6352132309\"}', 1);
INSERT INTO `check` VALUES ('a9fd33e9cac77b7ddc6165bdf9644d00', '5805562810', '{\"porkBatches\":\"24\",\"healthStatu\":\"健康\",\"quaranDate\":1596643200000,\"packMaterial\":\"塑料皮\",\"packId\":\"3253465747\",\"pigId\":\"5805562810\",\"slaDate\":1630927748000,\"ambientTeHu\":\"25°C 60%\",\"acidTime\":1630951322000,\"meatPart\":\"里脊肉\",\"packTime\":1631257321000,\"operatorId\":\"9070617065\"}', 1);

-- ----------------------------
-- Table structure for farm
-- ----------------------------
DROP TABLE IF EXISTS `farm`;
CREATE TABLE `farm`  (
  `PigID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪只编号',
  `FarmId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '养殖场编号',
  `FarmPosit` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '养殖场地址',
  `FarmOwner` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '养殖场负责人',
  `Ehygiene` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '环境卫生状况',
  `PigType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪只种类',
  `PigGender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '猪只性别',
  `CultTime` datetime NOT NULL COMMENT '入栏时间',
  `FeedType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '喂食饲料种类',
  `VaccineType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '疫苗接种种类',
  `VaccineTime` datetime NOT NULL COMMENT '疫苗接种时间',
  `OperatorID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作员编号',
  `Hash` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据摘要',
  `state` int NULL DEFAULT NULL COMMENT '审核状态 0 审核中 1 审核通过',
  PRIMARY KEY (`PigID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of farm
-- ----------------------------
INSERT INTO `farm` VALUES ('5805562810', '580', '安徽省淮南市', '张三', '严格消毒', '金华猪', '雌', '2020-09-10 11:18:37', '添加剂预混料', '弱毒苗', '2021-06-16 16:00:00', '8732564590', '4e4fac2b47d65ca38c5c5767c9cb0474fd5b7ddad7768120aeb24f903f11809b', 1);

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `SalesInfoID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '销售信息编号',
  `EnterName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业名称',
  `EnterPosit` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业地址',
  `StorageTime` datetime NOT NULL COMMENT '入库时间',
  `StorageTeHu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '库内温湿度',
  `SalesSite` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '销售地点',
  `ShelfTime` datetime NOT NULL COMMENT '上架时间',
  `OperatorID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作员编号',
  `Hash` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据摘要',
  `state` int NULL DEFAULT NULL COMMENT '审核状态 0 审核中 1 审核通过',
  PRIMARY KEY (`SalesInfoID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('7514162444', '武汉家乐福有限公司', '湖北省武汉市', '2021-09-10 11:45:33', '25°C 60%', '武汉市', '2021-09-11 11:46:13', '6476335359', 'eef5a1df4cc4eff4be44878a6769fa7f6ee1267931cdb22e03e265932e5cbe61', 1);

-- ----------------------------
-- Table structure for transport
-- ----------------------------
DROP TABLE IF EXISTS `transport`;
CREATE TABLE `transport`  (
  `TransportID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物流订单编号',
  `EnterName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业名称',
  `EnterPosit` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业地址',
  `EnterOwner` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '企业负责人',
  `LicenNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '运输车牌号',
  `TransTime` datetime NOT NULL COMMENT '运输时间',
  `TransOrigin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '运输起始地',
  `TransDestin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '运输目的地',
  `CarriageTeHu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车厢温湿度',
  `DriverName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '司机姓名',
  `OperatorID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作员编号',
  `Hash` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据摘要',
  `state` int NULL DEFAULT NULL COMMENT '审核状态 0 审核中 1 审核通过',
  PRIMARY KEY (`TransportID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transport
-- ----------------------------
INSERT INTO `transport` VALUES ('4271359911', '申通物流', '江西省南昌市', '李四', '豫C634968', '2021-09-08 11:40:47', '江苏省宿迁市', '湖南省长沙市', '-10°C', '王五', '6352132309', 'c3740d88a6a0023cee4713cdc7431d6c76b08aff0ad7ba6433f377d6e49302b6', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL COMMENT '用户id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'guest' COMMENT '用户角色',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg' COMMENT '用户头像',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1446439777007153154, 'admin', 'fb001dfcffd1c899f3297871406242f097aecf1a5342ccf3ebcd116146188e4b', 'admin', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536710684385281, 'butcher', '326ac81d4467e2ed5ce6246d46df4418085c53f7d5a4234c4b0432b34652ab3b', 'butcher', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536875931574274, 'consumer', '2dd5fcfaf24484e6860ad6a1e54b840a8eff4b33babf7841c79480bb69b35925', 'consumer', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536679097081857, 'farmer', '23f2c15ce19cc1aba3d206914675b98a0a1767a3336ef028635f4899ca9badba', 'farmer', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536781211607042, 'seller', '7b3a98caf36633c7d4f7dd55d41edd76f2908df857b800cc8d9915f0eddf0ea0', 'seller', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536820235411457, 'supervision', '44bc7de8e701338b9b7be962b0e8d5b2761dfb6adb7c617edbd052d4d78e30e1', 'supervision', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440537069347708930, 'test', '36f028580bb02cc8272a9a020f4200e346e276ae664e45ee80745574e2f5ab80', 'test', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');
INSERT INTO `user` VALUES (1440536741785149442, 'transporter', 'ca35c339ab7ac2c1c4f57f670ecbd032e95567a7c2c327cab5a3cfd642a3305c', 'transporter', 'http://inory.oss-cn-shanghai.aliyuncs.com/2021/07/11/IMG_2279(20210428-025841)%20(1).jpg');

SET FOREIGN_KEY_CHECKS = 1;

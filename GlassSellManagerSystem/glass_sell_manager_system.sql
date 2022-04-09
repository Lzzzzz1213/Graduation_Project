/*
Navicat MySQL Data Transfer

Source Server         : like
Source Server Version : 50728
Source Host           : localhost:3308
Source Database       : glass_sell_manager_system

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-09-14 08:38:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_customer
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer`;
CREATE TABLE `sys_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_schoolName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_qqNumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_phoneNumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_parentMomPhoneNumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_parentDadPhoneNumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_height` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_weight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_physicalTherapyAdvice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_remarks` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_history` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_PDRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_PDLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_glassesDegree` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_createOrderDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_getOrderDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_glassesType` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_framesType` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_userId` int(11) DEFAULT NULL,
  `customer_userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_vip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_lastDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_visionRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_visionLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_customer
-- ----------------------------
INSERT INTO `sys_customer` VALUES ('16', '测试姓名', '男', '2003-06-20', '重庆工程职业技术学院', '四川省成都市(区/县)青白江区小区信息', null, '13789999975', 'sc.it.like@qq.com', null, null, '160', '50', null, null, '无', '15', '15', null, '2021-06-04', null, null, null, '24', '李茂', null, '2021-06-04', '2021-06-04', '4.5', '4.6');
INSERT INTO `sys_customer` VALUES ('12', '测试4', '男', '2014-05-07', '重庆工程职业技术学院', '北京省市辖区(区/县)东城区小区4', null, '13844444444', '13608097960@163.com', null, null, '120', '34', null, null, null, null, null, null, null, null, null, null, '23', '老李', null, '2021-06-02', null, null, null);
INSERT INTO `sys_customer` VALUES ('13', '测速5', '男', '2012-06-05', '李冰小学', '北京省市辖区(区/县)东城区小区5', null, '13855555555', 'sc.it.like@qq.com', null, null, '130', '37', null, null, '2021-05-29', '15', '15', '左眼参数:312312,右眼参数23213', '2021-06-03', null, '10001:', '101100', '23', '老李', null, '2021-06-02', '2021-06-03', '4.5', '4.6');
INSERT INTO `sys_customer` VALUES ('14', '测速6', '女', '2014-06-11', '李冰小学', '北京省市辖区(区/县)东城区小区6', null, '13866666666', 'cvjt107465@163.com', null, null, '130', '30', null, null, null, null, null, null, null, null, null, null, '23', '老李', null, '2021-06-02', null, null, null);
INSERT INTO `sys_customer` VALUES ('15', '测试7', '女', '1999-06-02', '重庆工程职业技术学院', '云南省昆明市(区/县)呈贡县小区7', null, '13877777777', 'cvjt107465@163.com', null, null, '188', '70', null, null, null, null, null, null, null, null, null, null, '23', '老李', null, '2021-06-02', null, null, null);
INSERT INTO `sys_customer` VALUES ('9', '测试1', '男', '2002-06-15', '重庆工程职业技术学院', '四川省成都市(区/县)都江堰市小区1', null, '13811111111', 'sc.it.like@qq.com', '13899228377', '13899228379', '165', '55', '按摩训练', '无', '无', '15', '15', '左眼参数:近视150度，闪光25度,右眼参数近视150度，闪光25度', '2021-06-02', '2021-06-02', '10003', '10002', '1', '李可', 'vip', '2021-06-02', '2021-06-02', '4.5', '4.6');
INSERT INTO `sys_customer` VALUES ('10', '测试2', '女', '1995-08-11', '成都外国语实验中学', '四川省成都市(区/县)青白江区小区2', null, '13822222222', 'sc.it.like@qq.com', null, null, '160', '45', null, null, '无', '15', '15', '左眼参数:,右眼参数', '2021-06-03', '2021-06-02', '10110', '10003', '1', '李可', 'vip', '2021-06-02', '2021-06-03', '4.5', '4.6');
INSERT INTO `sys_customer` VALUES ('11', '测试3', '男', '2018-06-09', '李冰小学', '四川省成都市(区/县)彭州市小区3', null, '13833333333', '13608097960@163.com', null, null, '80', '25', null, null, '2021-05-29', '15', '15', '左眼参数:123213,右眼参数12312', '2021-06-02', null, '10001', '10004', '23', '老李', null, '2021-06-02', '2021-06-02', '4.5', '4.6');

-- ----------------------------
-- Table structure for sys_email
-- ----------------------------
DROP TABLE IF EXISTS `sys_email`;
CREATE TABLE `sys_email` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_customerID` int(11) DEFAULT NULL,
  `email_customerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email_userId` int(11) DEFAULT NULL,
  `email_userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_email
-- ----------------------------
INSERT INTO `sys_email` VALUES ('1', '5', '李梨梨', '1', '李可', 'tipCustomerGetOrder', '2021-06-01 12:45:46');
INSERT INTO `sys_email` VALUES ('3', '8', '王小明', '1', '李可', 'tipCustomerReview', '2021-06-01 12:58:36');
INSERT INTO `sys_email` VALUES ('4', '10', '测试2', '1', '李可', 'tipCustomerGetOrder', '2021-06-02 05:38:30');
INSERT INTO `sys_email` VALUES ('5', '9', '测试1', '1', '李可', 'tipCustomerReview', '2021-06-03 09:25:27');
INSERT INTO `sys_email` VALUES ('6', '11', '测试3', '23', '老李', 'tipCustomerGetOrder', '2021-06-03 10:00:01');
INSERT INTO `sys_email` VALUES ('7', '13', '测速5', '23', '老李', 'tipCustomerGetOrder', '2021-06-03 10:03:45');

-- ----------------------------
-- Table structure for sys_emailsend
-- ----------------------------
DROP TABLE IF EXISTS `sys_emailsend`;
CREATE TABLE `sys_emailsend` (
  `emailSend_id` int(11) NOT NULL AUTO_INCREMENT,
  `emailSend_to` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emailSend_from` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emailSend_subject` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emailSend_text` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emailSend_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`emailSend_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_emailsend
-- ----------------------------
INSERT INTO `sys_emailsend` VALUES ('2', 'sc.it.like@qq.com', '李可', '测试1111', '测试111111', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('3', 'sc.it.like@qq.com', '李可', '12312321', '321312321', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('4', 'sc.it.like@qq.com', '李可', '12312321', '321312321', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('5', 'sc.it.like@qq.com', '李可', '12321312', '421312', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('6', 'sc.it.like@qq.com', '李可', '2131', '231321321', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('7', 'sc.it.like@qq.com', '李可', '213213', '21312321', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('8', 'sc.it.like@qq.com', '李可', '12312', '3123213', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('9', 'sc.it.like@qq.com', '李可', '2131231', '2321', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('10', 'sc.it.like@qq.com', '李可', '1231', '3123213213', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('11', 'sc.it.like@qq.com', '李可', 'wqeqwd', 'asdsadas', '2021-06-02');
INSERT INTO `sys_emailsend` VALUES ('12', 'sc.it.like@qq.com', '李可', '测试内容', '测试内容测试内容测试内容测试内容测试内容', '2021-06-03');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_amount` float(255,0) DEFAULT NULL,
  `order_payAmount` float(255,0) DEFAULT NULL,
  `order_oderState` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_paymentState` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_logisticsState` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_paymentWay` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_logisticsName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_userId` int(11) DEFAULT NULL,
  `order_userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_customerId` int(11) DEFAULT NULL,
  `order_customerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_registerInfoId` int(11) DEFAULT NULL,
  `order_productDescribe` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_customerDegreeInfo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_successDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES ('12', '30377', '2312', '已发货等待签收', '已支付', '已发货', '现金', '申通快递:11111', '2021-06-03', '22', '李可', '13', '测速5', '13', '产品名称：套餐1价格：29999.0内容：东西1东西1东西1东西1东西1东西1东西1东西1 产品名称：镜架4价格：178.0货号：101100 产品名称：镜架1,价格：200.0,货号：10001', '162272900912', '左眼参数:312312,右眼参数23213', null);
INSERT INTO `sys_order` VALUES ('10', '30398', '2213', '已发货等待签收', '已支付', '已发货', '现金', '申通快递:23142312321', '2021-06-02', '1', '李可', '11', '测试3', '11', '产品名称：套餐1价格：29999.0内容：东西1东西1东西1东西1东西1东西1东西1东西1 产品名称：镜片2价格：199.0货号：10004 产品名称：镜架1,价格：200.0,货号：10001', '162270843710', '左眼参数:123213,右眼参数12312', null);
INSERT INTO `sys_order` VALUES ('11', '30576', '2312', '已编辑', '未支付', '未发货', '现金', '暂无物流信息', '2021-06-03', '22', '李可', '10', '测试2', '12', '产品名称：套餐1价格：29999.0内容：东西1东西1东西1东西1东西1东西1东西1东西1 产品名称：镜片1价格：399.0货号：10003 产品名称：镜架4,价格：178.0,货号：101100', '162272780011', '左眼参数:,右眼参数', null);
INSERT INTO `sys_order` VALUES ('8', '30548', '30000', '订单已完成', '已支付', '已发货', '支付宝', '顺丰快递:23142312321', '2021-06-02', '1', '李可', '9', '测试1', '9', '产品名称：套餐1价格：29999.0内容：东西1东西1东西1东西1东西1东西1东西1东西1 产品名称：镜架2价格：150.0货号：10002 产品名称：镜片1,价格：399.0,货号：10003', '16226265288', '左眼参数:近视150度，闪光25度,右眼参数近视150度，闪光25度', '2021-06-02');
INSERT INTO `sys_order` VALUES ('9', '399', '400', '订单已完成', '已支付', '已发货', '微信', '圆通快递:23142312321', '2021-06-02', '1', '李可', '10', '测试2', '10', ' 产品名称：镜架1价格：200.0货号：10001 产品名称：镜片2,价格：199.0,货号：10004', '16226266899', '左眼参数:近视150度，闪光25度,右眼参数近视150度，闪光25度', '2021-06-02');
INSERT INTO `sys_order` VALUES ('13', null, null, '未编辑', null, null, null, null, '2021-06-04', '24', '李茂', '16', '测试姓名', '14', null, null, null, null);

-- ----------------------------
-- Table structure for sys_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_price` float(255,2) DEFAULT NULL,
  `product_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO `sys_product` VALUES ('1', '镜架1', '2021-05-27', '200.00', '10001');
INSERT INTO `sys_product` VALUES ('2', '镜架2', '2021-05-27', '150.00', '10002');
INSERT INTO `sys_product` VALUES ('3', '镜片1', '2021-05-27', '399.00', '10003');
INSERT INTO `sys_product` VALUES ('4', '镜片2', '2021-05-27', '199.00', '10004');
INSERT INTO `sys_product` VALUES ('5', '镜架4', '2021-06-01', '178.00', '101100');

-- ----------------------------
-- Table structure for sys_productpackage
-- ----------------------------
DROP TABLE IF EXISTS `sys_productpackage`;
CREATE TABLE `sys_productpackage` (
  `productPackage_id` int(11) NOT NULL AUTO_INCREMENT,
  `productPackage_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPackage_price` float(255,2) DEFAULT NULL,
  `productPackage_describe` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPackage_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPackage_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`productPackage_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_productpackage
-- ----------------------------
INSERT INTO `sys_productpackage` VALUES ('1', '套餐1', '29999.00', '东西1东西1东西1东西1东西1东西1东西1东西1', '100001', '2021-05-28');
INSERT INTO `sys_productpackage` VALUES ('2', '套餐2', '39999.00', '东西2', '100002', '2021-05-28');
INSERT INTO `sys_productpackage` VALUES ('3', '套餐3', '19999.00', '东西3', '100003', '2021-05-28');
INSERT INTO `sys_productpackage` VALUES ('4', '套餐4', '5000.00', '东西4', '100004', '2021-05-22');
INSERT INTO `sys_productpackage` VALUES ('6', '套餐7', '1999.00', '内容7', '199882', '2021-06-02');

-- ----------------------------
-- Table structure for sys_registerinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_registerinfo`;
CREATE TABLE `sys_registerinfo` (
  `registerInfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `registerInfo_customerId` int(11) DEFAULT NULL,
  `registerInfo_customerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_userId` int(11) DEFAULT NULL,
  `registerInfo_userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_visionRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_visionLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_history` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_support` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinMiroirDeBouleRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinMiroirDeColonneRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinAxeRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinCorrectionRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinMiroirDeBouleLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinMiroirDeColonneLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinAxeLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_loinCorrectionLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheMiroirDeBouleRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheMiroirDeColonneRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheAxeRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheCorrectionRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheMiroirDeBouleLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheMiroirDeColonneLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheAxeLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_procheCorrectionLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_PDRight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_PDLeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerInfo_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`registerInfo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_registerinfo
-- ----------------------------
INSERT INTO `sys_registerinfo` VALUES ('14', '16', '测试姓名', '24', '李茂', '4.5', '4.6', '无', null, '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '', '', '', '', '', '', '', '', '15', '15', '2021-06-04');
INSERT INTO `sys_registerinfo` VALUES ('13', '13', '测速5', '22', '李可', '4.5', '4.6', '2021-05-29', '101100', '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '', '', '', '', '', '', '', '', '15', '15', '2021-06-03');
INSERT INTO `sys_registerinfo` VALUES ('12', '10', '测试2', '22', '李可', '4.5', '4.6', '无', '10003', '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '', '', '', '', '', '', '', '', '15', '15', '2021-06-03');
INSERT INTO `sys_registerinfo` VALUES ('9', '9', '测试1', '1', '李可', '4.5', '4.6', '无', '10002', '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '', '', '', '', '', '', '', '', '15', '15', '2021-06-02');
INSERT INTO `sys_registerinfo` VALUES ('10', '10', '测试2', '1', '李可', '4.5', '4.6', '2021-05-29', '10001', '', '', '', '', '', '', '', '', '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '15', '15', '2021-06-02');
INSERT INTO `sys_registerinfo` VALUES ('11', '11', '测试3', '1', '李可', '4.5', '4.6', '2021-05-29', '10004', '-1.00', '-2.00', '175', '5.0', '-2.00', '-2.00', '175', '5.0', '', '', '', '', '', '', '', '', '15', '15', '2021-06-02');

-- ----------------------------
-- Table structure for sys_review
-- ----------------------------
DROP TABLE IF EXISTS `sys_review`;
CREATE TABLE `sys_review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_customerId` int(11) DEFAULT NULL,
  `review_customerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_userId` int(11) DEFAULT NULL,
  `review_userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_createDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_UCVARight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_UCVALeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_CVARight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_CVALeft` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_Right` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_Left` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_positionOfEye` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_ACA` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `review_suggest` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_review
-- ----------------------------
INSERT INTO `sys_review` VALUES ('1', '0', null, '0', null, '2021-05-31', '4.5', '4.5', '5.0', '5.0', '近视度数150度，25度闪光', '近视度数150度，25度闪光', '15', '13', '护眼方案1');
INSERT INTO `sys_review` VALUES ('7', '9', '9', '22', '李可', '2021-06-03', '4.5', '4.5', '5.0', '5.0', '近视度数150度，25度闪光', '近视度数150度，25度闪光', '15', '13', '建议2');
INSERT INTO `sys_review` VALUES ('6', '9', '9', '1', '李可', '2021-06-02', '4.5', '4.5', '5.0', '5.0', '近视度数150度，25度闪光', '近视度数150度，25度闪光', '15', '13', '方案1');

-- ----------------------------
-- Table structure for sys_school
-- ----------------------------
DROP TABLE IF EXISTS `sys_school`;
CREATE TABLE `sys_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_school
-- ----------------------------
INSERT INTO `sys_school` VALUES ('1', '都江堰青城山高级中学');
INSERT INTO `sys_school` VALUES ('2', '都江堰中学');
INSERT INTO `sys_school` VALUES ('3', '柳街中学');
INSERT INTO `sys_school` VALUES ('4', '李冰中学');
INSERT INTO `sys_school` VALUES ('5', '李冰小学');
INSERT INTO `sys_school` VALUES ('6', '塔子坝中学');
INSERT INTO `sys_school` VALUES ('7', '成都外国语实验中学');
INSERT INTO `sys_school` VALUES ('10', '重庆工程职业技术学院');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phonenumber` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '李可', '1999-12-13', '四川省成都市都江堰市', 'admin', '21232F297A57A5A743894A0E4A801FC3', '管理员', '498684205@qq.com', 'user:admin', '男', '13608097960');
INSERT INTO `sys_user` VALUES ('2', '陈薪丞', '1999-12-13', '重庆市万州区', 'admin1', '21232F297A57A5A743894A0E4A801FC3', '主管', '11111@qq.com', 'user:boss', '男', '15736203019');
INSERT INTO `sys_user` VALUES ('3', '方梅', '2000-03-01', '重庆市忠县', 'user', '21232F297A57A5A743894A0E4A801FC3', '员工', '22222@qq.com', 'user:staff', '女', '13800000000');
INSERT INTO `sys_user` VALUES ('11', '测试7', '2021-05-18', '四川省成都市7', '100007', '21232F297A57A5A743894A0E4A801FC3', '员工', '7@qq.com', 'user:staff', '男', '19900000021');
INSERT INTO `sys_user` VALUES ('12', '测试8', '2021-05-18', '四川省成都市8', '100008', '21232F297A57A5A743894A0E4A801FC3', '员工', '8@qq.com', 'user:staff', '男', '19900000051');
INSERT INTO `sys_user` VALUES ('13', '测试9', '2021-05-18', '四川省成都市9', '100009', 'C5BE78354A949D3A542B22C2D5248EBB', '员工', '9@qq.com', 'user:staff', '男', '19900000055');
INSERT INTO `sys_user` VALUES ('14', '测试10', '2021-05-18', '四川省成都市10', '1000010', '21232F297A57A5A743894A0E4A801FC3', '员工', '10@qq.com', 'user:staff', '女', '19900000102');
INSERT INTO `sys_user` VALUES ('19', '测试15', '2021-05-18', '四川省成都市15', '1000015', '21232F297A57A5A743894A0E4A801FC3', '老板', '15@qq.com', 'user:boss', '男', '19900000169');
INSERT INTO `sys_user` VALUES ('22', '李可', '2021-05-18', '四川省成都市都江堰市', 'admin12334', '21232F297A57A5A743894A0E4A801FC3', '员工', '498684205@qq.com', 'user:staff', '男', '13608097970');
INSERT INTO `sys_user` VALUES ('23', '老李', '2021-05-22', '四川省成都市(区/县)都江堰市兰卡威三期7栋一单元', '13808009989', '53B28C42E302EE6896EA563AD60ACBF8', '员工', '498@qq.com', 'user:staff', '男', '13808009989');
INSERT INTO `sys_user` VALUES ('24', '李茂', '1992-02-06', '贵州省贵阳市(区/县)花溪区不知名地址', '13899999999', '6E1C7994709251E29A07D3D1895CEF9F', '员工', '40988@qq.com', 'user:staff', '女', '13899999999');

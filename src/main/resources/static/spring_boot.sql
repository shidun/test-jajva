/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : spring_boot

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-08-12 09:51:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL DEFAULT '',
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单Id',
  `product_id` varchar(32) DEFAULT NULL COMMENT '商品Id',
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `product_quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1111111', '12331', '11111', '5555', '111.00', '11', '订单详情123', null, null);
INSERT INTO `order_detail` VALUES ('11121', '1234561', '1444', '商品5555', '51.00', '132', '订2123', null, null);
INSERT INTO `order_detail` VALUES ('12345', '22221', '12345', '7.31商品', '11.00', '11', 'http://xxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1553589127771345004', '1553589127716472313', '123', '商品3', '21.00', '2', null, null, null);
INSERT INTO `order_detail` VALUES ('1553589172893200181', '1553589172843393848', '123', '商品3', '21.00', '2', null, null, null);
INSERT INTO `order_detail` VALUES ('1553589356871878818', '1553589356822736146', '1234567', '商品名字', '11.00', '5', null, null, null);
INSERT INTO `order_detail` VALUES ('1553602424915710518', '1553602424901276697', '1234567', '商品名字', '11.00', '3', null, null, null);
INSERT INTO `order_detail` VALUES ('1553602482028736829', '1553602481997384788', '1234567', '商品名字', '11.00', '3', null, null, null);
INSERT INTO `order_detail` VALUES ('1553602516671670286', '1553602516644240968', '1234567', '商品名字', '11.00', '3', null, null, null);
INSERT INTO `order_detail` VALUES ('1553602720752408787', '1553602720714644415', '1234567', '商品名字', '11.00', '3', null, null, null);
INSERT INTO `order_detail` VALUES ('1553847385350601458', '1553847385338647699', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847387692716862', '1553847387690547000', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847388342170297', '1553847388340382487', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847388981482235', '1553847388980783039', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847389366224200', '1553847389364780221', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847402197611554', '1553847402195611178', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847402526810166', '1553847402525934315', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847402971360324', '1553847402969981398', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847403565693484', '1553847403564473755', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847403927602289', '1553847403925160138', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847404290852021', '1553847404288470249', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847404648758186', '1553847404646366815', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847405018702629', '1553847405016208224', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847405392193890', '1553847405390489173', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847405711364814', '1553847405710669143', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847406087506131', '1553847406085655800', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847406368942321', '1553847406366978793', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847406709575750', '1553847406708915007', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847407094626314', '1553847407093793511', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1553847407427300853', '1553847407425245123', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554172257583238779', '1554172257479539142', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554172311912766568', '1554172311909578480', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554173085281381970', '1554173085271592896', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554173134473308072', '1554173134469935987', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554173149553810350', '1554173149550775985', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554173373397801371', '1554173373386223206', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554173443206403721', '1554173443196864092', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554255478326690040', '1554255478322121261', '1234567', '商品名字', '11.00', '4', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554948751869225144', '1554948751022777424', '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554948870415545188', '1554948870403912528', '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554948870453368138', '1554948870403912528', '1234567', '商品名字', '11.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554977372713732042', '1554977371851119245', '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1554977372831479657', '1554977371851119245', '1234567', '商品名字', '11.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1564653927684828048', '1564653927457671192', '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654023520254772', '1564654023461353197', '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654066426785374', '1564654066313433967', '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654153029908641', '1564654152879726065', '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654369716254598', null, '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654625532467257', null, '1111232', '手抓饼', '12.00', '1', 'http://xxxxxxx', null, null);
INSERT INTO `order_detail` VALUES ('1564654711616998613', null, '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1564654794102641503', null, '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1564654893550831418', '1564654893379576795', '1554089994111308244', '新增123', '22.00', '2', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1564737225280354827', '1564737225230472563', '1234567', '商品名字', '11.00', '3', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('1564737340096710186', '1564737340094995353', '1234567', '商品名字', '11.00', '3', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', null, null);
INSERT INTO `order_detail` VALUES ('213213123', '123213213', '123213213', 'asdasdasd', '123123.00', '111', '123213', null, null);

-- ----------------------------
-- Table structure for `order_master`
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL DEFAULT '',
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_adress` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL DEFAULT '' COMMENT '买家微信Id',
  `order_amout` decimal(10,2) DEFAULT '0.00' COMMENT '订单金额',
  `order_status` tinyint(4) DEFAULT '0' COMMENT '订单状态',
  `pay_status` tinyint(4) DEFAULT '0' COMMENT '支付状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1553589127716472313', '石盾s', '1234564314', '杭州大厦', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '42.00', '2', '0', '2019-08-09 14:51:34', null);
INSERT INTO `order_master` VALUES ('1553589172843393848', '石盾s', '1234564314', '杭州大厦', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '42.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553589356822736146', '石盾s', '1234564314', '杭州大厦', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '55.00', '1', '1', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553602424901276697', '张三', '123213213', '浙江温州皮革厂', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '33.00', '2', '0', '2019-08-09 14:47:47', null);
INSERT INTO `order_master` VALUES ('1553602481997384788', '张三', '123213213', '浙江温州皮革厂', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '33.00', '1', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553602516644240968', '张三', '123213213', '浙江温州皮革厂', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '33.00', '2', '0', '2019-08-09 14:45:47', null);
INSERT INTO `order_master` VALUES ('1553602720714644415', '张三', '123213213', '浙江温州皮革厂', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '33.00', '2', '0', '2019-04-02 09:57:51', '2019-03-20 20:35:07');
INSERT INTO `order_master` VALUES ('1553847385338647699', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847387690547000', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-08-09 15:14:15', null);
INSERT INTO `order_master` VALUES ('1553847388340382487', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '1', '0', '2019-08-09 15:18:59', null);
INSERT INTO `order_master` VALUES ('1553847388980783039', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847389364780221', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847402195611178', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847402525934315', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-08-09 15:12:47', null);
INSERT INTO `order_master` VALUES ('1553847402969981398', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847403564473755', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847403925160138', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847404288470249', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847404646366815', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-08-09 16:38:41', null);
INSERT INTO `order_master` VALUES ('1553847405016208224', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847405390489173', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847405710669143', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847406085655800', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847406366978793', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '1', '0', '2019-04-02 10:02:46', null);
INSERT INTO `order_master` VALUES ('1553847406708915007', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847407093793511', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1553847407425245123', '测试123', '123123123', '奥术大师大所多', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '2', '0', '2019-04-02 09:57:51', null);
INSERT INTO `order_master` VALUES ('1554172257479539142', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-04-09 10:31:25', null);
INSERT INTO `order_master` VALUES ('1554172311909578480', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554173085271592896', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554173134469935987', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554173149550775985', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554173373386223206', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554173443196864092', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554255478322121261', '测试123', '123123123', '奥术大123', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554948751022777424', '石盾', '123123213', '测试地址', '222222', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554948870403912528', '石盾', '123123213', '测试地址', '222222', '66.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1554977371851119245', '石盾', '123123213', '测试地址', '222222', '66.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1564653927457671192', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '2', '0', '2019-08-02 18:04:50', null);
INSERT INTO `order_master` VALUES ('1564654023461353197', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '0', '0', '2019-08-09 11:51:55', null);
INSERT INTO `order_master` VALUES ('1564654066313433967', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '0', '0', '2019-08-09 11:51:53', null);
INSERT INTO `order_master` VALUES ('1564654152879726065', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '0', '0', '2019-08-09 11:51:53', null);
INSERT INTO `order_master` VALUES ('1564654369560541858', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '0', '0', '2019-08-09 11:51:52', null);
INSERT INTO `order_master` VALUES ('1564654625462729666', 'shidun', '12345123213', '杭州金华', '1232134', '12.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1564654711414131945', 'shidun', '12345123213', '杭州金华', '1232134', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1564654794031935129', 'shidun', '12345123213', '杭州金华', '1232134', '44.00', '0', '0', '2019-08-09 11:51:25', null);
INSERT INTO `order_master` VALUES ('1564654893379576795', 'shidun', '12345123213', '杭州金华', '1232134', '44.00', '0', '1', '2019-08-02 11:41:42', null);
INSERT INTO `order_master` VALUES ('1564737225230472563', '张三', '123213213', '浙江温州皮革厂', 'oQm5O5eQc0ZdIBONLym0WA1aDeV8', '33.00', '0', '0', '2019-08-07 17:33:19', null);
INSERT INTO `order_master` VALUES ('1564737340094995353', '张三', '123213213', '浙江温州皮革厂', 'oQm5O5eQc0ZdIBONLym0WA1aDeV8', '33.00', '0', '0', '2019-08-07 17:16:54', null);
INSERT INTO `order_master` VALUES ('22221', 'shidun', '12345611', '杭州市', 'oybUM6J4tdDskJihTCMO4TfB8ss4', '12.00', '0', '0', '2019-08-09 11:51:22', null);

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL COMMENT '类目名称',
  `category_type` int(11) DEFAULT NULL COMMENT '类目编号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='类目表';

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '测sss22', '8', '2019-07-31 15:34:04', '2019-04-08 20:11:02');
INSERT INTO `product_category` VALUES ('6', '测试名字2', '1', '2021-11-01 00:00:00', '2019-04-01 11:37:29');
INSERT INTO `product_category` VALUES ('7', '测试名字3', '5', '2021-11-01 00:00:00', '2019-04-01 11:37:30');
INSERT INTO `product_category` VALUES ('8', '测试名字4', '6', '2002-11-11 00:00:00', '2019-04-01 11:37:30');
INSERT INTO `product_category` VALUES ('9', '测试名字5', '1', '2002-11-11 00:00:00', '2019-04-08 20:15:29');
INSERT INTO `product_category` VALUES ('10', '测试名字62', '11', '2019-08-10 11:06:01', '2019-04-08 20:15:30');
INSERT INTO `product_category` VALUES ('17', '测试名字7', '111', '2019-04-18 14:12:26', '2019-04-08 20:15:32');
INSERT INTO `product_category` VALUES ('18', '石盾的商品', '4', '2019-04-19 14:12:29', '2019-04-03 09:57:15');
INSERT INTO `product_category` VALUES ('19', '石盾啊', '1111', '2019-05-23 09:47:13', '2019-04-08 20:15:33');
INSERT INTO `product_category` VALUES ('20', '石盾的商品', '222', '2019-04-18 09:47:11', '2019-04-08 20:15:35');
INSERT INTO `product_category` VALUES ('27', '男生最爱22', '42', '2019-07-30 14:53:03', null);
INSERT INTO `product_category` VALUES ('28', '女生最爱', '31', null, null);
INSERT INTO `product_category` VALUES ('29', '女生最爱2', '5', '2019-07-30 14:54:53', null);
INSERT INTO `product_category` VALUES ('30', '男生22', '12', '2019-07-31 09:53:14', null);
INSERT INTO `product_category` VALUES ('31', '测试', '1', null, null);

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
  `product_price` decimal(10,2) NOT NULL COMMENT '商品单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '商品描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(4) DEFAULT '0' COMMENT '状态 0正常 1下架',
  `category_type` int(11) DEFAULT NULL COMMENT '类目编号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1111232', '手抓饼', '12.00', '962', '这是一个很好吃的手抓饼哦!', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', '1', '9', '2019-08-10 10:35:49', '2019-08-10 10:22:10');
INSERT INTO `product_info` VALUES ('123', '商品3', '55.00', '101', '测试3', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1752243568,253651337&fm=27&gp=0.jpg', '1', '4', '2019-08-09 17:28:12', '2019-04-08 20:11:52');
INSERT INTO `product_info` VALUES ('1232', '商品3', '11.00', '101', '测试3', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=105293018,2500805440&fm=27&gp=0.jpg', '1', '1', '2019-08-09 17:28:09', '2019-04-08 20:11:52');
INSERT INTO `product_info` VALUES ('123432', '商品名字2', '21.00', '101', '测试描述2', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1451330793,2242997567&fm=27&gp=0.jpg', '1', '4', '2019-08-09 17:24:19', '2019-04-08 20:11:52');
INSERT INTO `product_info` VALUES ('1234567', '商品名字', '11.00', '18', 'asdas', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', '0', '6', '2019-08-09 16:38:41', '2019-04-08 20:11:52');
INSERT INTO `product_info` VALUES ('1554089994111308244', '新增123', '22.00', '108', '这种子', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', '0', '8', '2019-08-02 10:50:16', '2019-04-08 20:11:52');
INSERT INTO `product_info` VALUES ('1565404863372550529', '手抓饼', '1.00', '22', '这是一个很好吃123213', 'http://img.redocn.com/sheji/20141219/zhongguofengdaodeliyizhanbanzhijing_3744115.jpg', '1', '9', '2019-08-10 10:43:29', null);
INSERT INTO `product_info` VALUES ('222', '测试123', '123.00', '111', '123213', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1979198230,3799788659&fm=27&gp=0.jpg', '0', '5', '2019-08-09 17:22:30', '2019-04-08 20:11:52');

-- ----------------------------
-- Table structure for `seller_info`
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `seller_id` varchar(255) NOT NULL DEFAULT '',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seller_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1554103358291695429', 'admin', 'admin', 'oybUM6J4tdDskJihTCMO4TfB8ss4', null, '2019-04-02 09:58:19');
INSERT INTO `seller_info` VALUES ('1565419023674827204', 'ssss', '12345', 'sdasda21', null, null);

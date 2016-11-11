/*
SQLyog v10.2 
MySQL - 5.1.73-community : Database - feiw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`feiw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `feiw`;

/*Table structure for table `t_fragment` */

DROP TABLE IF EXISTS `t_fragment`;

CREATE TABLE `t_fragment` (
  `blockid` varchar(32) NOT NULL COMMENT '实例ID',
  `fragmentname` varchar(36) DEFAULT NULL COMMENT '单页名称',
  `description` varchar(50) DEFAULT NULL COMMENT '单页描述',
  `path` varchar(50) DEFAULT NULL COMMENT '视图路径',
  `createtime` datetime DEFAULT NULL COMMENT '单页创建时间',
  PRIMARY KEY (`blockid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_fragment` */

insert  into `t_fragment`(`blockid`,`fragmentname`,`description`,`path`,`createtime`) values ('10','about','关于我们',NULL,'2016-03-18 13:05:52'),('12','new','新手入门',NULL,'2016-05-03 11:06:21'),('13','operation-flow','操作流程',NULL,'2016-05-14 23:06:57'),('2','main-top-banner','首页顶部banner',NULL,'2016-02-18 09:52:03'),('3','main-top-addtofavorite','首页添加收藏',NULL,'2015-03-19 00:12:28'),('4','main-bottom-copyright','首页底部版权',NULL,'2016-02-17 16:12:36'),('5','main-navigation','首页导航',NULL,'2016-02-18 11:41:01'),('6','main-center-banner','首页中间图片',NULL,'2016-02-19 14:29:52'),('7','main-contact-us','首页联系我们论坛客服',NULL,'2016-02-22 10:15:47'),('8','main-ids','广告位',NULL,'2016-02-23 16:19:32'),('9','back-to-top','返回顶部',NULL,'2016-03-08 22:49:56');

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `item_id` varchar(50) NOT NULL COMMENT '任务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '任务发布人',
  `item_count` int(11) DEFAULT NULL COMMENT '任务个数',
  `item_source` varchar(12) DEFAULT NULL COMMENT '任务来源',
  `item_all_cost` decimal(10,0) DEFAULT NULL COMMENT '总任务消耗金额',
  `item_one_cost` decimal(10,0) DEFAULT NULL COMMENT '单个任务消耗金额',
  `item_state` char(1) DEFAULT NULL COMMENT '0：已保存但未发布。1：已发布。2：已完成，3：已结算，4：违规冻结',
  `comments_after` varchar(5) DEFAULT NULL COMMENT '几天后评价',
  `comments_stars` varchar(5) DEFAULT NULL COMMENT '几星评价',
  `comments_content` varchar(200) DEFAULT NULL COMMENT '评价内容',
  `other_needs` text COMMENT '其他要求',
  `item_time` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`item_id`,`user_id`,`item_count`,`item_source`,`item_all_cost`,`item_one_cost`,`item_state`,`comments_after`,`comments_stars`,`comments_content`,`other_needs`,`item_time`) values ('1','zhangsan',21,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('10','zhangsan',30,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('11','zhangsan',31,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('12','zhangsan',32,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('14','zhangsan',33,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('15','zhangsan',34,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('16','zhangsan',35,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('17','zhangsan',36,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('18','zhangsan',37,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('19','zhangsan',38,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('2','zhangsan',22,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('20','zhangsan',40,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('3','zhangsan',23,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('4','zhangsan',24,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('5','zhangsan',25,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('6','zhangsan',26,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('7','zhangsan',27,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('8','zhangsan',28,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14'),('9','zhangsan',29,'淘宝','200','198','0','5','5','请五星好评','没有其他需求	','2016-02-23 20:08:14');

/*Table structure for table `t_news` */

DROP TABLE IF EXISTS `t_news`;

CREATE TABLE `t_news` (
  `newsid` varchar(36) NOT NULL COMMENT '新闻ID',
  `blockid` varchar(36) NOT NULL COMMENT '栏目ID',
  `title` varchar(50) DEFAULT NULL COMMENT '新闻标题',
  `shorttitle` varchar(50) DEFAULT NULL COMMENT '新闻短标题',
  `keywords` varchar(50) DEFAULT NULL COMMENT '关键字',
  `author` varchar(36) DEFAULT NULL COMMENT '作者',
  `editor` varchar(36) DEFAULT NULL COMMENT '编辑',
  `source` varchar(50) DEFAULT NULL COMMENT '内容来源',
  `content` text COMMENT '新闻内容',
  `count` int(10) DEFAULT NULL COMMENT '访问量',
  `commentcount` int(10) DEFAULT NULL COMMENT '评论量',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastedittime` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `audit` char(1) DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`newsid`,`blockid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_news` */

insert  into `t_news`(`newsid`,`blockid`,`title`,`shorttitle`,`keywords`,`author`,`editor`,`source`,`content`,`count`,`commentcount`,`createtime`,`lastedittime`,`audit`) values ('1','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','3','ADMIN','3','3',NULL,3,3,'2015-01-18 22:04:14','2016-02-22 14:56:11',''),('10','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','x','ADMIN','x','x','<p>xxxxx</p>',0,0,'2015-01-20 22:14:56','2015-01-20 22:14:56',NULL),('11','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','为什么葡萄酒大部分是750ml？','ADMIN','王菲','网易','<p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">凤凰体育讯北京时间3月9日晚，2015赛季中超联赛迎来首轮最后一场比赛的较量，坐镇天河体育场，广州恒大2-1逆转升班马石家庄永昌。上半时，委内瑞拉国脚隆东打进永昌在中超历史上的首球，半场结束前，埃尔克森助攻高拉特扳平比分，后者近3场轰入5球。下半时，恒大错失多次机会，终场哨响前，于汉超完成绝杀。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">恒大方面，卡纳瓦罗迎来中超首秀，曾诚因伤没有进入大名单，李帅顶替了他的位置。锋线郜林、埃尔克森和高拉特三箭齐发。石家庄永昌方面，新援毛剑卿首发登场，外援隆东发挥引人关注。赛前永昌队开出500万赢球奖、200万平球奖。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">双方一上来都不保守，第2分钟，邹正为恒大制造角球，黄博文角球旋到门前，王国明第一下打得不远，右路的荣昊再传中，王国明将球没收。第3分钟，乔罗角球发到门前，穆伦加禁区内头球攻门，李帅勉强将球挡了一下再将球摁在身下。第7分钟，邹正边路传中直接出了底线。第15分钟，乔罗边线球手榴弹掷得很远，穆伦加停球转身打门没有打上力量。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">第17分钟，郑智得球交给埃尔克森，后者回做，高拉特得球凌空怒射，王国明将球扑出底线。<strong style=\"font-style: normal; font-weight: bold;\">第19分钟，永昌率先进球，穆伦加前场接应高球顺势交给隆东，委内瑞拉国脚停好球大力远射，球直窜球门左侧，李帅鞭长莫及，恒大主场0-1落后！</strong>随后，乔罗背后绊倒埃尔克森吃到黄牌。第25分钟，隆东在禁区内摔倒，主裁判没有鸣哨。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">第31分钟，左路邹正得球传中，黄博文头球攻门被王国明托出底线。第43分钟，高拉特直塞被挡出，黄博文禁区内直面门将，但是大力劲射高出。<strong style=\"font-style: normal; font-weight: bold;\">上半场补时第2分钟，黄博文中路分球，埃尔克森外脚背传中，高拉特得球后形成单刀，面对门将劲射得分，1-1。</strong>高拉特打进自己中超处子球，同时也是近3场比赛的第5个进球。半场结束，双方战成1-1。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">第49分钟，毛剑卿对雷内犯规吃到黄牌。第52分钟，恒大快发任意球，郜林得球杀入禁区，但射门踢嗤被王国明用脚挡出。第55分钟，荣昊传中，高拉特反越位成功近距离头球高出。第61分钟，邹正左路送出传中到禁区，郑智头球攻门高出。恒大逐渐掌控比赛局面，永昌只能依靠外援的个人能力形成反击。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">第69分钟，乔罗开出角球，隆东头球攻门顶偏。第70分钟，黄博文右脚打门打在许博身上，随后禁区内混战，恒大未能形成真正威胁。随后替换黄博文登场的廖力生也完成一脚射门，但偏出不少。第73分钟，高拉特左路带球切入直传，雷内反插上形成单刀，但王国明出击很快将球封堵。第80分钟，高拉特中路的直传，埃尔克森转身左脚打门被王国明挡出，随后高拉特射门高出。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">第83分钟，永昌获得任意球，许博大力射门偏出。第87分钟，恒大进攻至对方禁区，郜林调整过多错失良机。<strong style=\"font-style: normal; font-weight: bold;\">补时阶段第4分钟，高拉特边路过人后送出妙传，于汉超门前头球破门，广州恒大终场前完成绝杀。</strong>最终全场比赛结束，广州恒大主场2-1击败石家庄永昌，取得开门红。</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">双方出场如下：</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">广州恒大（4-3-3）：22-李帅；3-梅方、28-金英权、25-邹正、33-荣昊（88’27-郑龙）；10-郑智、8-雷内（82’20-于汉超）、16-黄博文（71’2-廖力生）；29-郜林、9-埃尔克森、11-高拉特</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">石家庄永昌：12-王国明；4-李超、18-许博、5-白鹤、13-冯绍顺；14-赵荣亨、23-胡伟、8-乔罗（90’20-姜继弘）、7-毛剑卿（57’11-黄世博）；19-穆伦加（90’16-德芬迪）、9-隆东</p><p style=\"font: 14px/24px simsun, arial, helvetica, clean, sans-serif; margin: 0px 0px 25px; padding: 0px; text-align: left; color: rgb(43, 43, 43); text-transform: none; text-indent: 28px; letter-spacing: normal; word-spacing: 0px; white-space: normal; font-size-adjust: none; font-stretch: normal; background-color: rgb(255, 255, 255); -webkit-text-stroke-width: 0px;\">（周凯）</p><p><br/></p>',0,0,'2015-01-20 22:15:14','2016-02-22 15:01:08',NULL),('12','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','为什么葡萄酒大部分是750ml','ADMIN','v','为什么葡萄酒大部分是750ml',NULL,0,0,'2015-01-20 22:17:11','2016-02-22 15:01:01',NULL),('13','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','n','ADMIN','n','n','<p>n</p>',0,0,'2015-01-20 22:18:27','2015-01-20 22:18:27',NULL),('14','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','test-','ADMIN','d-','f-','<p><span style=\"font-family: &#39;Microsoft YaHei&#39;, Verdana, sans-serif, 宋体; font-size: 14px; line-height: 22px; background-color: rgb(255, 255, 255);\">Freemarker 中截取字符串 必须先用if判断其长度？</span></p>',1,0,'2015-01-20 22:39:04','2016-02-22 14:55:58',NULL),('15','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','','ADMIN','','oscchina',NULL,0,0,'2016-02-19 14:14:35','2016-02-22 14:49:26',NULL),('17','3','新手必看','新手必看','','ADMIN','管理员','本站','<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; text-align: center; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(255, 0, 0); font-size: 10px;\"><strong>我刚来刷宝平台，新手，应怎么样开始呢？</strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\"><span style=\"font-size: 16px;\">　　欢迎您来到刷宝平台,刷宝是一个免费互刷平台,也许你有一些疑虑和不明白,不知道怎么操作,没有关系,<span style=\"font-size: 10px; color: rgb(255, 0, 0);\">只要您花点时间认真看完这篇文章,相信您一定能够学会,如果你认为我们平台是骗子,那请</span></span><span style=\"font-size: 16px; line-height: 1.6;\"><span style=\"font-size: 10px; color: rgb(255, 0, 0);\">你现在就关闭此网页,因为此文章不值得你去学习!</span>如果还不明白,可以请教我们的客服,现在就让我们来看一下平台是如何操作的。</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; text-align: center; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;<br/><span style=\"color: rgb(255, 0, 0); font-size: 18px;\"><strong>==========刷宝平台是什么？==========</strong></span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">　　<span style=\"font-size: 16px;\">刷宝平台是一个类似支付宝的第三方担保平台,担保发布方和接手方的刷钻过程安全等价进行!刷宝平台一直致力打造全国最先进、最安全、最快速的淘宝刷信誉模式；刷宝会员来自全国各地一万<span style=\"font-size: 10px; line-height: 1.6;\">多名不同地区,不同IP,不同ID,跟您真实交易的买家来自全国各地一样真实.刷宝提倡人人为我,我为人人的免费的互刷模式,即是你帮别人刷一次,别人帮你刷一次,一切都是纯人工操作,和真实的交易几乎没有什么差别,这样的人工刷钻让淘宝无从查起,堪称当前最安全的刷钻方法。</span></span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; text-align: center; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;<br/><strong><span style=\"font-size: 10px; color: rgb(255, 0, 0);\">=======刷钻危险吗？会不会被封店=======</span></strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">　　刷宝平台——2014全国首家第三代信誉平台是长期研究淘宝系统而专门打造的平台互刷系统，只要按刷宝平台的流程去做，就不会出现被封店的情况。为什么说在刷宝刷钻是安全的？淘宝是怎么<span style=\"font-size: 10px; line-height: 1.6;\">查刷信誉的呢？主要是两个办法：一个是人工查,一个是靠第二代稽查电脑系统24小时全程监控所有的淘宝交易.哪一种是主要呢？当然是后者啦.你想想看看.淘宝每年的交易额是6300亿,每天有几千万个店铺,每天至少是几十亿的交易量,每天几千万桩至过亿桩交易,这么多的交易,这么大的金额,靠人工查,淘宝不破产才怪!所以淘宝主要是靠第二代稽查系统在监控着淘宝每天几千万桩交易的.而靠电脑查就有漏洞,因为电脑毕竟只是一套软件系统而已。</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;<br/>　　但是靠电脑系统查就有漏洞，你只要了解淘宝系统监控规律，你就可以安全的刷了。<span style=\"font-size: 10px; color: rgb(255, 0, 0);\">你想想如果淘宝电脑系统没有监控到你的交易异常，淘宝怎么会去查你吗？</span>淘宝每天上千万桩交易，上千万个<span style=\"font-size: 10px; line-height: 1.6;\">店铺，每一桩交易都查，查的过来么？再说，平台都是纯手工操作，和淘宝真实交易有什么区别呢？几乎没有！而且这些交易是和淘宝每天的真实交易混在一起的，真假难辨的！</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">　　所以只要你了解淘宝系统监控规律，你就可以安全的刷了，你想想如果淘宝电脑系统没有监控到你的交易异常，淘宝怎么会去查你吗？不查你就是安全的？<span style=\"font-size: 10px; color: rgb(255, 0, 0);\">如果你说不了解淘宝的规律啊，没关系<span style=\"font-size: 10px; line-height: 1.6;\">，刷宝已经帮你总结好了，你只需要多看这两个帖子就能基本了解了！</span></span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; text-align: center; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;<br/><span style=\"font-size: 10px; color: rgb(255, 0, 0);\"><strong>=======既然刷钻安全，那么怎么刷？=======</strong></span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">　　只要你熟悉淘宝买卖的基本步骤，只要你肯多花几十分钟的时间来了解一下刷宝平台刷信誉的流程，那你就很快就会在刷宝刷信誉了，<span style=\"font-size: 10px; color: rgb(255, 0, 0);\">但是如果你是淘宝菜鸟，就请你先去熟悉淘宝规则来刷信誉<span style=\"font-size: 10px; line-height: 1.6;\">，才不会给你或给别人带来危害！</span></span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">　　刷宝刷信誉是以任务的形式来刷，你发布一个任务就能让你的店铺得到一个好评，你发布251个任务，就能使你的店铺到达1钻；你发布501个任务，就到2钻；你发布1001个任务，就到3钻；你发<span style=\"font-size: 10px; line-height: 1.6;\">布2001个任务，就到4钻；你发布5001个任务，就到5钻，依次类推！</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\"><span style=\"font-size: 16px;\">　　在别人替你刷好评之前，比如说你要刷10元的商品。那平台就会扣下你10元作为担保金。对方接手后，就拿他自己的10元去淘宝真实拍下你的商品，然后给你好评。这样10元就回到你的支付宝，</span><span style=\"font-size: 16px; line-height: 1.6;\">而你的10元担保金则转移到他的平台存款中。这样的互刷是免费的。互刷只有资金有周转流动，实质毫无损失，而双方的信誉不断增加！明白么？资金有流转，实质无损失。</span></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal; color: rgb(51, 51, 51); font-family: &#39;Microsoft YaHei&#39;, Tahoma; font-size: 12px; line-height: 18px; background-color: rgb(255, 255, 255);\"><span style=\"font-size: 10px;\">&nbsp;<br/><span style=\"font-size: 16px;\"><strong>弄明白平台是怎么刷钻后，接下来你有三种选择：</strong></span><br/><span style=\"font-size: 16px;\">第一种◆我是卖家，需要花钱雇佣别人帮你刷信誉---这种简单方便，但必须花钱；<br/>第二种◆我是买家，帮人刷信誉赚任务佣金(发布点)---这种是自由网络赚钱职业；<br/>第三种◆我两者都是，先帮人刷信誉赚佣金，再用佣金发布任务--这种就是免费互刷；</span></span></p><p><br/></p>',0,0,'2016-02-19 14:26:26','2016-03-18 13:15:34',NULL),('18','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','','ADMIN','','','<p>元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。</p>',0,0,'2016-02-23 13:33:34','2016-02-23 13:33:34',NULL),('19','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','','ADMIN','','','<p>元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。</p>',0,0,'2016-02-23 13:33:42','2016-02-23 13:33:42',NULL),('20','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','','ADMIN','1','','<p>元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。</p>',0,0,'2016-02-23 13:33:48','2016-02-23 13:33:48',NULL),('21','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','','ADMIN','','','<p>元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。</p>',0,0,'2016-02-23 13:33:54','2016-02-23 13:33:54',NULL),('23','2','Java中的异常处理机制的简单原理和应用Java中的异常处理机制的简单原理和应用JavaJava中的','Java中的异常处理机制的简单原理和应用Java中的异常处理机制的简单原理和应用Java中的异常处理','','ADMIN','','','<p><span style=\"font-family: Verdana;font-size: 13px\">&nbsp; &nbsp; 1<span style=\"font-family:宋体\">、</span><span style=\"font-family:Verdana\">Java</span><span style=\"font-family:宋体\">中的异常处理机制的简单原理和应用。</span></span><span style=\"font-family: Verdana;font-size: 13px\"><br/></span><span style=\"font-family: Verdana;font-size: 13px\">当<span style=\"font-family:Verdana\">JAVA</span><span style=\"font-family:宋体\">程序违反了</span><span style=\"font-family:Verdana\">JAVA</span><span style=\"font-family:宋体\">的语义规则时，</span><span style=\"font-family:Verdana\">JAVA</span><span style=\"font-family:宋体\">虚拟机就会将发生的错误表示为一个异常。违反语义规则包括</span><span style=\"font-family:Verdana\">2</span><span style=\"font-family:宋体\">种情况。一种是</span><span style=\"font-family:Verdana\">JAVA</span><span style=\"font-family:宋体\">类库内置的语义检查。例如数组下标越界</span><span style=\"font-family:Verdana\">,</span><span style=\"font-family:宋体\">会引发</span><span style=\"font-family:Verdana\">IndexOutOfBoundsException;</span><span style=\"font-family:宋体\">访问</span><span style=\"font-family:Verdana\">null</span><span style=\"font-family:宋体\">的对象时会引发</span><span style=\"font-family:Verdana\">NullPointerException</span><span style=\"font-family:宋体\">。另一种情况就是</span><span style=\"font-family:Verdana\">JAVA</span><span style=\"font-family:宋体\">允许程序员扩展这种语义检查，程序员可以创建自己的异常，并自由选择在何时用</span><span style=\"font-family:Verdana\">throw</span><span style=\"font-family:宋体\">关键字引发异常。所有的异常都是</span><span style=\"font-family:Verdana\">java.lang.Thowable</span><span style=\"font-family:宋体\">的子类。</span></span></p><p><span style=\"font-size: 13px;\"><font face=\"宋体\"><br/></font></span><span style=\"font-family: Verdana;font-size: 13px\">&nbsp; &nbsp;2<span style=\"font-family:宋体\">、垃圾回收的优点和原理。并考虑</span><span style=\"font-family:Verdana\">2</span><span style=\"font-family:宋体\">种回收机制。</span></span><span style=\"font-family: Verdana;font-size: 13px\"><br/></span><span style=\"font-family: Verdana;font-size: 13px\">Java<span style=\"font-family:宋体\">语言中一个显著的特点就是引入了垃圾回收机制，使</span><span style=\"font-family:Verdana\">c++</span><span style=\"font-family:宋体\">程序员最头疼的内存管理的问题迎刃而解，它使得</span><span style=\"font-family:Verdana\">Java</span><span style=\"font-family:宋体\">程序员在编写程序的时候不再需要考虑内存管理。由于有个垃圾回收机制，</span><span style=\"font-family:Verdana\">Java</span><span style=\"font-family:宋体\">中的对象不再有“作用域”的概念，只有对象的引用才有“作用域”。</span></span></p><p><span style=\"font-family: Verdana;font-size: 13px\"><span style=\"font-family:宋体\">&nbsp; 垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清楚和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。回收机制有分代复制垃圾回收和标记垃圾回收，增量垃圾回收。</span></span><span style=\"font-family: Verdana;font-size: 13px\"><br/></span></p><p><br/></p>',0,0,'2016-02-23 13:35:05','2016-02-23 15:22:06',NULL),('29','4','关于我们','','关于我们','ADMIN','管理员','本站','<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">根据第三方市场研究公司艾瑞咨询的数据，京东（JD.com）是中国最大的自营式电商企业，2015年第一季度在中国自营式B2C电商市场的占有率为56.3%。2014年，京东市场交易额达到2602亿元，净收入达到1150亿元。2015年第二季度，京东市场交易额达到1145亿元，同比增长82%；净收入达到459亿元，同比增长61%。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">目前，京东集团旗下设有京东商城、京东金融、拍拍、京东智能、京东到家及海外事业部。2014年5月，京东在美国纳斯达克证券交易所正式挂牌上市，是中国第一个成功赴美上市的大型综合型电商平台，并跻身全球前十大互联网公司排行榜。2015年7月，京东因其高成长性入选纳斯达克100指数和纳斯达克100平均加权指数，成为纳斯达克100指数中仅有的2家中国互联网公司之一。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">京东致力于为消费者提供愉悦的在线购物体验。通过内容丰富、人性化的网站（www.jd.com）和移动客户端，京东以富有竞争力的价格，提供具有丰富品类及卓越品质的商品和服务，以快速可靠的方式送达消费者，并且提供灵活多样的支付方式。另外，京东还为第三方卖家提供在线销售平台和物流等一系列增值服务。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">京东提供丰富优质的商品，品类包括：计算机、手机及其它数码产品、家电、汽车配件、服装与鞋类、奢侈品（如：手提包、手表与珠宝）、家居与家庭用品、化妆品与其它个人护理用品、食品与营养品、书籍、电子图书、音乐、电影与其它媒体产品、母婴用品与玩具、体育与健身器材以及虚拟商品（如：国内机票、酒店预订等）。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">京东拥有中国电商行业最大的仓储设施。截至2015年6月30日，京东在全国拥有7大物流中心，在全国44座城市运营166个大型仓库，拥有4142个配送站和自提点，覆盖全国2043个区县。京东专业的配送队伍能够为消费者提供一系列专业服务，如：211限时达、次日达、夜间配和三小时极速达，GIS包裹实时追踪、售后100分、快速退换货以及家电上门安装等服务，保障用户享受到卓越、全面的物流配送和完整的“端对端”购物体验。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">京东是一家技术驱动的公司，从成立伊始就投入巨资开发完善可靠、能够不断升级、以电商应用服务为核心的自有技术平台。我们将继续增强公司的技术平台实力，以便更好地提升内部运营效率，同时为合作伙伴提供卓越服务。</p><h3 style=\"margin: 20px 0px 5px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">配送服务说明：</h3><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">211限时达：当日上午11：00前提交的现货订单（部分城市为上午10点前），以订单出库完成拣货时间点开始计算，当日送达；夜里11：00前提交的现货订单（以订单出库后完成拣货时间点开始计算），次日15：00前送达。截至2015年7月31日，“211限时达”已覆盖全国135个区县。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">次日达：在一定时间点之前提交的现货订单（以订单出库后完成拣货的时间点开始计算），将于次日送达。截至2015年7月31日，“次日达”已覆盖全国951个区县。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">极速达：京东为消费者提供的一项个性化付费增值服务。消费者通过“在线支付”方式全额成功付款或“货到付款”方式成功提交订单，并勾选“极速达”服务后，京东会在服务时间内，3小时将商品送至消费者所留地址。目前，“极速达”业务在北京、上海、广州、成都、武汉、沈阳六个城市提供服务。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">夜间配：京东为消费者提供更快速、更便利的一项增值服务。消费者下单时在日历中选择“19:00-22:00”时段，属“夜间配”服务范围内的商品，京东会尽可能安排配送员在消费者选定当日晚间19:00-22:00送货上门。目前，“夜间配”业务在北京、上海、广州、成都、武汉、沈阳六个城市提供服务。</p><h3 style=\"margin: 20px 0px 5px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">媒体垂询:</h3><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-family: Arial, Verdana, 宋体; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">media-contact@jd.com</p><p><br/></p>',0,0,'2016-03-18 12:58:14','2016-03-18 12:58:14',NULL),('4','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','2','ADMIN','2','2','2',2,2,'2015-01-18 22:07:48','2015-01-18 22:07:48','2'),('6','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','2','ADMIN','2','2','2',2,2,'2015-01-18 22:08:26','2015-01-18 22:08:26','2'),('7','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','test','ADMIN','d','f','<p style=\"text-align: center;\">cfffffffffffff<span style=\"font-size: 20px;\">ffzcdcevee</span></p>',0,0,'2015-01-20 00:20:52','2015-01-20 00:20:52',NULL),('8','1','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','1','ADMIN','1','1',NULL,1,1,'2015-01-20 00:32:22','2016-02-22 14:56:27',NULL),('9','2','新手入门必看','元宵灯会年年有，城市里的灯会或许不会大不同，却又都充满节日的喜悦。','x','ADMIN','x','x','<p>xxxxx</p>',0,0,'2015-01-20 22:10:22','2015-01-20 22:10:22',NULL);

/*Table structure for table `t_news_property` */

DROP TABLE IF EXISTS `t_news_property`;

CREATE TABLE `t_news_property` (
  `blockid` varchar(36) NOT NULL COMMENT '栏目ID',
  `title` varchar(36) DEFAULT NULL COMMENT '栏目标题',
  `blockpage` int(10) DEFAULT '5' COMMENT '首页显示条数',
  `listpage` int(10) DEFAULT '15' COMMENT '列表显示条数',
  `iscomments` char(1) DEFAULT '0' COMMENT '是否允许评论',
  `description` varchar(50) DEFAULT NULL COMMENT '栏目描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `parentid` varchar(36) DEFAULT '1' COMMENT '父类栏目ID',
  `hasnext` char(1) DEFAULT '0' COMMENT '是否有子栏目',
  `priority` int(11) DEFAULT '0' COMMENT '优先级排序字段',
  `display` char(1) DEFAULT '1' COMMENT '是否显示该栏目（0：不显示；1：显示）',
  PRIMARY KEY (`blockid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_news_property` */

insert  into `t_news_property`(`blockid`,`title`,`blockpage`,`listpage`,`iscomments`,`description`,`createtime`,`parentid`,`hasnext`,`priority`,`display`) values ('1','本站资讯',5,15,'0','首页的本站资讯','2016-04-10 00:34:04','0','0',0,'1'),('2','相关文档',5,15,'0','相关文档','2016-02-23 15:16:16','0','0',0,'1');

/*Table structure for table `t_user_pay` */

DROP TABLE IF EXISTS `t_user_pay`;

CREATE TABLE `t_user_pay` (
  `pay_id` int(11) NOT NULL COMMENT '主键，序列生成',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT NULL COMMENT '登录名',
  `user_jine` double DEFAULT '0' COMMENT '总金额（可取现）',
  `user_dongjie` double DEFAULT '0' COMMENT '冻结的金额',
  `zhifubao` varchar(50) DEFAULT NULL COMMENT '支付宝账号',
  `zhifubao_name` varchar(50) DEFAULT NULL COMMENT '支付宝姓名',
  `yinhangka` varchar(50) DEFAULT NULL COMMENT '银行卡号',
  `yinhangka_name` varchar(50) DEFAULT NULL COMMENT '银行卡姓名',
  `weigui_cishu` int(11) DEFAULT NULL COMMENT '操作违规次数',
  `anquanma` varchar(6) DEFAULT NULL COMMENT '安全码，提款时用',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_pay` */

insert  into `t_user_pay`(`pay_id`,`user_id`,`user_name`,`user_jine`,`user_dongjie`,`zhifubao`,`zhifubao_name`,`yinhangka`,`yinhangka_name`,`weigui_cishu`,`anquanma`) values (1,'1','admin',40.5,5,'hojunf@163.com','lizhongrui','222222','lizhongrui',0,'000000'),(2,'5','test',0,0,NULL,NULL,NULL,NULL,0,'000000');

/*Table structure for table `t_user_pay_log` */

DROP TABLE IF EXISTS `t_user_pay_log`;

CREATE TABLE `t_user_pay_log` (
  `user_pay_log_id` varchar(36) NOT NULL COMMENT '主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `money` double DEFAULT NULL COMMENT '充值金额',
  `type` int(2) DEFAULT NULL COMMENT '1、支付宝；2、银行卡；3、微信',
  `pay_zhanghao` varchar(50) DEFAULT NULL COMMENT '充值账号',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `state` int(2) DEFAULT NULL COMMENT '状态：0、审核中；1、审核通过；2、审核不通过',
  `reason` varchar(200) DEFAULT NULL COMMENT '审核不通过原因',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`user_pay_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_pay_log` */

/*Table structure for table `z_action` */

DROP TABLE IF EXISTS `z_action`;

CREATE TABLE `z_action` (
  `actionid` varchar(36) NOT NULL COMMENT '动作ID',
  `actionname` varchar(36) DEFAULT NULL COMMENT '动作名称',
  `actionurl` varchar(100) DEFAULT NULL COMMENT '动作路径',
  `viewfile` varchar(100) DEFAULT NULL COMMENT '视图',
  `contentfile` varchar(100) DEFAULT NULL COMMENT '模板',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`actionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_action` */

insert  into `z_action`(`actionid`,`actionname`,`actionurl`,`viewfile`,`contentfile`,`description`,`createtime`) values ('12','xxx','fragment/fragmentBlock/1','classes/com/fragment/view/v/JianRuShouShoucang.ftl','','',NULL),('13','','login/login','','zhiyoudaohanghebanquan.ftl','',NULL),('14','','login/managelogin','','','',NULL),('15','','news/details','','main.ftl','',NULL),('16','','news/list','','main.ftl','',NULL),('17','','fragment/fragmentBlock/2','templates/views/fragment/main-top-banner.ftl','','',NULL),('18','','fragment/fragmentBlock/3','templates/views/fragment/main-top-addtofavorite.ftl','','',NULL),('19','','fragment/fragmentBlock/4','templates/views/fragment/main-bottom-copyright.ftl','','','2016-02-17 16:12:53'),('20','','fragment/fragmentBlock/5','templates/views/fragment/main-navigation.ftl','','','2016-02-18 11:42:15'),('21','','news/block/2','','main.ftl','',NULL),('22','','fragment/fragmentBlock/7','templates/views/fragment/main-contact-us.ftl','','','2016-02-22 10:16:38'),('23','','fragment/fragmentBlock/8','templates/views/fragment/main-ids.ftl','','','2016-02-23 16:34:25'),('24','','item/itemBlock','','main.ftl','',NULL),('25','','fragment/fragmentBlock/9','templates/views/fragment/back-to-top.ftl','','','2016-03-08 22:54:06'),('26','','news/block/3','','main.ftl','',NULL),('27','','fragment/fragmentBlock/11','templates/views/fragment/left-nav.ftl','','','2016-04-10 00:46:56'),('28','','fragment/fragmentBlock/12','','main.ftl','','2016-05-03 11:19:48'),('29','','fragment/fragmentBlock/10','','main.ftl','','2016-05-03 11:21:19'),('30','','register/register','','main.ftl','',NULL),('31','','login/doLogin','','zhiyoudaohanghebanquan.ftl','',NULL),('32','','member/memberInfo','','main.ftl','',NULL),('33','','fragment/fragmentBlock/13','templates/views/fragment/operation-flow.ftl','','','2016-05-14 23:35:37'),('34','','pay/zhifubao','','main.ftl','',NULL),('35','','member/modifyPass','','main.ftl','','2016-05-17 00:18:42'),('36','','member/modifyPassSumit','','main.ftl','','2016-05-17 10:35:23'),('37','','payLog/auditSubmit','','','',NULL),('38','','pay/zhifubaoSubmit','','main.ftl','',NULL),('39','','register/doRegister','','main.ftl','','2016-05-17 13:29:22'),('40','','pay/withdraw','','main.ftl','','2016-05-17 15:57:48'),('41','','pay/withdrawSubmit','','main.ftl','','2016-05-18 15:21:16'),('7','','login/doManagelogin','','','',NULL),('8','','news/block','','portal.ftl','',NULL);

/*Table structure for table `z_chanel` */

DROP TABLE IF EXISTS `z_chanel`;

CREATE TABLE `z_chanel` (
  `chanelid` varchar(36) NOT NULL COMMENT '频道ID',
  `chanelname` varchar(50) DEFAULT NULL COMMENT '频道名称',
  `description` varchar(100) DEFAULT NULL COMMENT '频道描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`chanelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_chanel` */

insert  into `z_chanel`(`chanelid`,`chanelname`,`description`,`createtime`) values ('1','main.ftl','网站首页','2015-01-07 00:59:16'),('10','about.ftl','关于我们','2016-05-11 15:34:05'),('11','unionpay.ftl','银联支付','2016-05-15 13:03:47'),('12','weixin.ftl','微信支付','2016-05-15 15:07:37'),('13','zhifubao.ftl','支付宝付款','2016-05-15 15:08:43'),('2','404.ftl','错误页面',NULL),('7','new.ftl','新手必看','2016-05-11 15:25:54'),('8','related.ftl','相关文档','2016-05-11 15:28:19'),('9','news.ftl','本站资讯','2016-05-11 15:32:13');

/*Table structure for table `z_component` */

DROP TABLE IF EXISTS `z_component`;

CREATE TABLE `z_component` (
  `COMPONENTID` varchar(36) NOT NULL COMMENT '组件ID',
  `COMPONENTTYPE` varchar(12) NOT NULL COMMENT '组件实例类型',
  `COMPONENTNAME` varchar(36) DEFAULT NULL COMMENT '组件名称',
  `ISSINGLETON` char(1) DEFAULT NULL COMMENT '是否是单实例（0：多实例1：单实例）',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '组件描述',
  `CONFPATH` varchar(50) DEFAULT NULL COMMENT '组件配置文件路径',
  `MAINTAINACTION` varbinary(50) DEFAULT NULL COMMENT '实例维护地址',
  `PRIORITY` int(11) DEFAULT '0' COMMENT '优先级排序字段',
  PRIMARY KEY (`COMPONENTID`,`COMPONENTTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_component` */

insert  into `z_component`(`COMPONENTID`,`COMPONENTTYPE`,`COMPONENTNAME`,`ISSINGLETON`,`DESCRIPTION`,`CONFPATH`,`MAINTAINACTION`,`PRIORITY`) values ('1','news','新闻','0','','com/news/conf/component-news.xml',NULL,NULL),('2','fragment','页面片段','0','','com/fragment/conf/component-fragment.xml','fragment/fragmentAdd.htm',NULL),('4','login','用户登录','1','','com/login/conf/component-login.xml',NULL,NULL),('5','item','任务','1','任务','com/item/conf/component-item.xml',NULL,NULL),('6','register','注册','1','','com/login/conf/component-register.xml',NULL,NULL),('7','member','会员','1','','com/item/conf/component-member.xml',NULL,NULL),('8','pay','支付','1','用户支付','com/item/conf/component-pay.xml',NULL,NULL),('9','item','充值','1','','com/item/conf/component-payLog.xml',NULL,NULL);

/*Table structure for table `z_depart` */

DROP TABLE IF EXISTS `z_depart`;

CREATE TABLE `z_depart` (
  `depart_id` varchar(36) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL COMMENT '上级部门',
  `name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `number` varchar(36) DEFAULT NULL COMMENT '部门编号',
  `has_next` char(1) DEFAULT NULL COMMENT '是否有子节点',
  `priority` int(11) DEFAULT NULL COMMENT '优先级排序字段',
  `is_show` char(1) DEFAULT NULL COMMENT '前台是否显示',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_depart` */

insert  into `z_depart`(`depart_id`,`parent_id`,`name`,`number`,`has_next`,`priority`,`is_show`,`create_time`) values ('1','','中国','00','1',0,'1','2015-05-21 06:01:03'),('10','3','临沂','0539','0',2,'1','2015-12-31 10:42:42'),('3','1','山东','0531','1',0,'1','2015-05-25 11:39:55'),('4','1','北京','010','0',0,'1','2015-06-03 16:10:09'),('6','1','上海','0101','0',0,'1','2015-07-24 16:51:46'),('8','3','济南','0531','0',10,'1','2015-10-12 21:58:13');

/*Table structure for table `z_dictionary` */

DROP TABLE IF EXISTS `z_dictionary`;

CREATE TABLE `z_dictionary` (
  `DIC_ID` varchar(36) NOT NULL COMMENT '字典id',
  `DIC_NAME` varchar(50) DEFAULT NULL COMMENT '字典名称',
  `DIC_KEY` varchar(10) DEFAULT NULL COMMENT '键',
  `DIC_VALUE` varchar(50) DEFAULT NULL COMMENT '值',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`DIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_dictionary` */

insert  into `z_dictionary`(`DIC_ID`,`DIC_NAME`,`DIC_KEY`,`DIC_VALUE`,`DESCRIPTION`) values ('10','yes_or_no','0','否','否'),('11','duty_type','0','总经理','职务'),('12','duty_type','1','普通员工','职务'),('13','is_able','0','无效','有效'),('14','is_able','1','有效','有效'),('15','duty_type','2','部门经理','部门经理'),('16','security_question','0','你最喜欢的人的姓名？','安全问题'),('17','security_question','1','你最喜欢的电影的名字？','安全问题'),('18','view_type','0','news','新闻'),('19','view_type','1','fragment','页面片段'),('2','user_state','1','有效','用户有效'),('20','view_type','2','navigation','导航'),('3','user_state','0','无效','用户无效'),('7','template_default','1','是','模板是否是默认模板'),('8','template_default','0','否','模板是否是默认模板'),('9','yes_or_no','1','是','是');

/*Table structure for table `z_menu` */

DROP TABLE IF EXISTS `z_menu`;

CREATE TABLE `z_menu` (
  `MENUID` int(10) NOT NULL COMMENT '主键',
  `MENUNAME` varchar(36) DEFAULT NULL COMMENT '菜单名',
  `MENUURL` varchar(100) DEFAULT NULL COMMENT '链接地址',
  `PARENTID` varchar(10) DEFAULT NULL COMMENT '上一级菜单id',
  `HASNEXT` char(1) DEFAULT NULL COMMENT '是否有下级（0：否；1：是）',
  `PRIORITY` int(11) DEFAULT NULL COMMENT '优先级排序字段',
  `DISPLAY` char(1) DEFAULT NULL COMMENT '是否显示该菜单（0：不显示；1：显示）',
  PRIMARY KEY (`MENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_menu` */

insert  into `z_menu`(`MENUID`,`MENUNAME`,`MENUURL`,`PARENTID`,`HASNEXT`,`PRIORITY`,`DISPLAY`) values (1,'权限管理','permission-manage-menu','0','1',0,'1'),(2,'用户管理','user/userIndex.htm','1','2',1,'1'),(3,'菜单权限','menuPermission/menuPermissionTreeIndex.htm','1','2',4,'1'),(4,'角色管理','role/roleIndex.htm','1','2',5,'1'),(5,'网站信息','site-info-menu','0','1',4,'1'),(7,'新闻维护','news/newsMgrMain.htm','5','2',2,'1'),(8,'字典定义','dictionary/dictionaryIndex.htm','18','0',4,'1'),(9,'网站管理','site-manage-menu','0','1',1,'1'),(10,'模板管理','template/templateIndex.htm','9','2',0,'1'),(11,'组件实例','component-instance-menu','9','1',6,'1'),(12,'页面片段','fragment/fragmentIndex.htm','11','2',2,'1'),(13,'视图管理','view/viewIndex.htm','9','2',3,'1'),(14,'频道管理','chanel/chanelIndex.htm','9','2',1,'1'),(15,'组件管理','component/componentIndex.htm','9','0',3,'1'),(16,'新闻实例','newsproperty/newspropertyIndex.htm','11','2',5,'1'),(17,'动作配置','action/actionIndex.htm','9','2',3,'1'),(18,'参数维护','site-params','0','1',2,'1'),(19,'缓存清理','manage/cacheIndex.htm','18','0',1,'1'),(20,'组织机构','depart/departMgrTreeIndex.htm','1','2',0,'1'),(21,'菜单管理','menu/menuTreeIndex.htm','1','0',2,'1'),(24,'任务发布','item/itemIndex.htm','5','0',0,'1'),(25,'功能权限','permission/permissionIndex.htm','1','0',0,'1'),(26,'支付信息','pay/payIndex.htm','5','0',0,'1'),(27,'支付操作','payLog/payLogIndex.htm','5','0',0,'1');

/*Table structure for table `z_menu_permission` */

DROP TABLE IF EXISTS `z_menu_permission`;

CREATE TABLE `z_menu_permission` (
  `PERMISSION_ID` varchar(36) NOT NULL COMMENT '权限id',
  `PERMISSION_NAME` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `PARENT_ID` varchar(36) DEFAULT NULL COMMENT '父节点ID',
  `RESOURCE` varchar(100) DEFAULT NULL COMMENT '资源(动作URI)',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  `HAS_NEXT` char(1) DEFAULT '0' COMMENT '是否有子节点',
  `PRIORITY` int(11) DEFAULT '0' COMMENT '优先级排序字段',
  PRIMARY KEY (`PERMISSION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `z_menu_permission` */

insert  into `z_menu_permission`(`PERMISSION_ID`,`PERMISSION_NAME`,`PARENT_ID`,`RESOURCE`,`DESCRIPTION`,`HAS_NEXT`,`PRIORITY`) values ('1','权限管理','0','permission-manage-menu','权限管理菜单','1',5),('13','网站管理','0','site-manage-menu','网站管理菜单','1',4),('14','模板管理','13','template/templateIndex.htm','模板管理菜单','0',0),('16','角色维护','1','role/roleIndex.htm','角色维护菜单','0',2),('17','频道管理','13','chanel/chanelIndex.htm','频道管理菜单','0',0),('18','视图管理','13','view/viewIndex.htm','视图管理菜单','0',0),('19','动作配置','13','action/actionIndex.htm','动作配置菜单','0',0),('2','用户管理','1','user/userIndex.htm','用户管理菜单','0',1),('20','组件管理','13','component/componentIndex.htm','组件管理菜单','0',0),('21','组件实例','13','component-instance-menu','组件实例','1',0),('22','页面片段','21','fragment/fragmentIndex.htm','页面片段菜单','0',0),('23','新闻实例','21','newsproperty/newspropertyIndex.htm','新闻实例菜单','0',0),('25','网站信息','0','site-info-menu','网站信息菜单','1',0),('26','新闻维护','25','news/newsMgrMain.htm','新闻维护菜单','0',0),('3','权限管理','1','permission/permissionMenuIndex.htm','权限管理菜单','0',3),('36','参数维护','0','site-params','参数维护菜单','1',1),('37','缓存清理','36','manage/cacheIndex.htm','缓存清理菜单','0',0),('38','字典定义','37','dictionary/dictionaryIndex.htm','字典定义菜单','0',0),('39','组织机构','1','depart/departMgrTreeIndex.htm','组织机构','0',0),('40','菜单权限','1','menu/menuTreeIndex.htm','菜单权限','0',2);

/*Table structure for table `z_permission` */

DROP TABLE IF EXISTS `z_permission`;

CREATE TABLE `z_permission` (
  `PERMISSION_ID` varchar(36) NOT NULL COMMENT '权限id',
  `PERMISSION_NAME` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `PARENT_ID` varchar(36) DEFAULT NULL COMMENT '父节点ID',
  `RESOURCE` varchar(100) DEFAULT NULL COMMENT '资源(动作URI)',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  `HAS_NEXT` char(1) DEFAULT '0' COMMENT '是否有子节点',
  `PRIORITY` int(11) DEFAULT '0' COMMENT '优先级排序字段',
  PRIMARY KEY (`PERMISSION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `z_permission` */

insert  into `z_permission`(`PERMISSION_ID`,`PERMISSION_NAME`,`PARENT_ID`,`RESOURCE`,`DESCRIPTION`,`HAS_NEXT`,`PRIORITY`) values ('24','后台管理首页','0','manage/mainFrame.htm','后台管理首页','0',0),('28','内容管理树','0','manage/menuList.htm','内容管理树','0',0),('29','设置','0','manage/setup.htm','设置','0',0),('41','会员中心-基本信息','0','member/memberInfo.htm','','0',0),('42','充值-支付宝付款','0','pay/zhifubao.htm','支付宝充值','0',0),('43','密码修改','0','member/modifyPass.htm','','0',0),('44','密码修改提交','0','member/modifyPassSubmit.htm','','0',0),('45','充值-支付宝付款提交','0','pay/zhifubaoSubmit.htm','','0',0),('46','取款','0','pay/withdraw.htm','','0',0),('47','取款提交','0','pay/withdrawSubmit.htm','','0',0);

/*Table structure for table `z_role` */

DROP TABLE IF EXISTS `z_role`;

CREATE TABLE `z_role` (
  `ROLE_ID` varchar(36) NOT NULL COMMENT '角色id',
  `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `PRIORITY` int(11) DEFAULT '0' COMMENT '优先级排序字段',
  `ISSUPER` char(1) DEFAULT '0' COMMENT '是否是超级管理员',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_role` */

insert  into `z_role`(`ROLE_ID`,`ROLE_NAME`,`DESCRIPTION`,`PRIORITY`,`ISSUPER`) values ('0','超级管理员','超级管理员',0,'1'),('1','登陆用户','登陆用户',0,'0'),('5','后台管理员','后台管理员',0,'0'),('nologin','未登录用户','未登录用户可访问到的链接',0,'0');

/*Table structure for table `z_role_permission` */

DROP TABLE IF EXISTS `z_role_permission`;

CREATE TABLE `z_role_permission` (
  `ROLE_PERMISSION_ID` int(10) NOT NULL,
  `ROLE_ID` varchar(36) DEFAULT NULL,
  `PERMISSION_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROLE_PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_role_permission` */

insert  into `z_role_permission`(`ROLE_PERMISSION_ID`,`ROLE_ID`,`PERMISSION_ID`) values (40,'5','24'),(41,'1','29'),(42,'5','1'),(43,'5','3'),(44,'5','16'),(45,'5','40'),(46,'5','2'),(47,'5','39'),(48,'5','14'),(49,'5','17'),(50,'5','18'),(51,'5','19'),(52,'5','20'),(56,'5','36'),(57,'5','37'),(58,'5','38'),(60,'5','13'),(63,'1','25'),(64,'1','26'),(70,'1','41'),(71,'1','42'),(72,'1','43'),(73,'1','45'),(74,'1','44'),(75,'1','46'),(76,'1','47');

/*Table structure for table `z_sequence` */

DROP TABLE IF EXISTS `z_sequence`;

CREATE TABLE `z_sequence` (
  `TABLENAME` varchar(36) NOT NULL COMMENT '最大化表名',
  `NEXTVALUE` varchar(36) DEFAULT NULL COMMENT '当前索引值',
  PRIMARY KEY (`TABLENAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_sequence` */

insert  into `z_sequence`(`TABLENAME`,`NEXTVALUE`) values ('t_fragment','13'),('t_news','29'),('t_news_property','4'),('t_user_pay','3'),('z_action','41'),('z_chanel','13'),('z_component','9'),('z_depart','10'),('z_dictionary','20'),('z_menu','27'),('z_permission','47'),('z_role','5'),('z_role_permission','76'),('z_template','22'),('z_user','24'),('z_user_role','49'),('z_view','29');

/*Table structure for table `z_template` */

DROP TABLE IF EXISTS `z_template`;

CREATE TABLE `z_template` (
  `templateid` varchar(36) NOT NULL COMMENT '模板标识',
  `templatename` varchar(36) DEFAULT NULL COMMENT '模板名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `isdefault` char(1) DEFAULT '0' COMMENT '是否是默认模板',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`templateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_template` */

insert  into `z_template`(`templateid`,`templatename`,`description`,`isdefault`,`createtime`) values ('21','item-content.ftl','任务模板','0','2016-03-18 22:14:12'),('22','zhiyoudaohanghebanquan.ftl','只有导航和版权的模板','0','2016-05-11 14:28:58'),('3','main.ftl','首页模板','0','2016-01-17 23:06:20'),('5','portal.ftl','portal','1','2015-03-18 14:40:20');

/*Table structure for table `z_user` */

DROP TABLE IF EXISTS `z_user`;

CREATE TABLE `z_user` (
  `USER_ID` varchar(36) NOT NULL COMMENT '主键',
  `USER_NAME` varchar(36) NOT NULL COMMENT '用户名--登陆名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  `DEPART_ID` varchar(36) DEFAULT NULL COMMENT '部门',
  `USER_ALIAS` varchar(20) DEFAULT NULL COMMENT '别名',
  `DUTY_ID` varchar(36) DEFAULT NULL COMMENT '职务',
  `EMAIL` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `QUESTION` varchar(50) DEFAULT NULL COMMENT '安全问题',
  `ANSWER` varchar(36) DEFAULT NULL COMMENT '安全问题答案',
  `QQ_NUMBER` varchar(15) DEFAULT NULL COMMENT 'qq号',
  `PHONE` varchar(15) DEFAULT NULL COMMENT '手机号',
  `PRIORITY` int(11) DEFAULT '0' COMMENT '排序',
  `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `LOGIN_ERROR_TIMES` int(11) DEFAULT '0' COMMENT '错误登录次数（5次将锁定账号）',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `LAST_LOGIN_IP` varchar(36) DEFAULT NULL COMMENT '最后登录IP地址',
  `LOGIN_TIMES` int(11) DEFAULT '0' COMMENT '登录系统次数',
  `STATUS` char(1) NOT NULL DEFAULT '1' COMMENT '状态 1-有效 0-失效',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_user` */

insert  into `z_user`(`USER_ID`,`USER_NAME`,`PASSWORD`,`DEPART_ID`,`USER_ALIAS`,`DUTY_ID`,`EMAIL`,`QUESTION`,`ANSWER`,`QQ_NUMBER`,`PHONE`,`PRIORITY`,`REG_TIME`,`LOGIN_ERROR_TIMES`,`LAST_LOGIN_TIME`,`LAST_LOGIN_IP`,`LOGIN_TIMES`,`STATUS`) values ('1','admin','admin','1','系统管理员','0','71@qq.com','0','2','22278009771',NULL,0,'2015-03-18 08:22:03',0,'2016-05-18 20:12:54','0:0:0:0:0:0:0:1',274,'1'),('5','test','test','1','test','1','test@test.com','test','test','test','',0,'2015-04-28 00:08:26',0,'2016-05-18 16:19:11','0:0:0:0:0:0:0:1',9,'1');

/*Table structure for table `z_user_role` */

DROP TABLE IF EXISTS `z_user_role`;

CREATE TABLE `z_user_role` (
  `USER_ROLE_ID` varchar(36) NOT NULL COMMENT '主键',
  `USER_ID` varchar(36) DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` varchar(36) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`USER_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_user_role` */

insert  into `z_user_role`(`USER_ROLE_ID`,`USER_ID`,`ROLE_ID`) values ('1','1','0'),('2','3','0'),('28','2','1'),('34','28','0'),('35','28','1'),('36','28','4'),('37','28','5'),('38','28','nologin'),('39','26','1'),('44','5','1'),('47','29','5'),('49','20','1');

/*Table structure for table `z_view` */

DROP TABLE IF EXISTS `z_view`;

CREATE TABLE `z_view` (
  `viewid` varchar(36) NOT NULL COMMENT '视图ID',
  `viewtype` varchar(10) DEFAULT NULL COMMENT '视图类型',
  `viewname` varchar(36) DEFAULT NULL COMMENT '视图名称',
  `viewpath` varchar(200) DEFAULT NULL COMMENT '视图路径',
  `description` varchar(50) DEFAULT NULL COMMENT '视图描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`viewid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `z_view` */

insert  into `z_view`(`viewid`,`viewtype`,`viewname`,`viewpath`,`description`,`createtime`) values ('1','news','news-scroll-upc','templates/views/news/news-scroll-upc.ftl','新闻滚动视图','2016-02-17 16:07:23'),('18','fragment','main-bottom-copyright','templates/views/fragment/main-bottom-copyright.ftl','首页底部版权','2016-02-17 16:06:47'),('19','fragment','main-top-addtofavorite','templates/views/fragment/main-top-addtofavorite.ftl','首页顶部添加收藏','2016-02-17 16:04:31'),('20','news','1','templates/views/news/1.ftl','1','2016-02-17 15:53:03'),('21','fragment','main-top-banner','templates/views/fragment/main-top-banner.ftl','首页顶部banner','2016-02-19 14:27:26'),('22','fragment','main-navigation','templates/views/fragment/main-navigation.ftl','首页导航','2016-02-18 11:41:39'),('23','fragment','main-center-banner','templates/views/fragment/main-center-banner.ftl','首页中间图片','2016-02-19 14:28:55'),('24','fragment','main-contact-us','templates/views/fragment/main-contact-us.ftl','首页联系我们','2016-02-22 10:16:09'),('25','fragment','main-ids','templates/views/fragment/main-ids.ftl','广告位','2016-02-23 16:32:07'),('26','fragment','back-to-top','templates/views/fragment/back-to-top.ftl','返回顶部','2016-03-08 22:50:33'),('27','fragment','left-nav','templates/views/fragment/left-nav.ftl','左侧导航','2016-04-10 00:46:36'),('28','fragment','operation-flow','templates/views/fragment/operation-flow.ftl','操作流程','2016-05-14 23:34:02'),('29','news','news-scroll-right-to-left','templates/views/news/news-scroll-right-to-left.ftl','','2016-05-15 00:37:52');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

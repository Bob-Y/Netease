/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.15 : Database - trading
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`trading` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `trading`;

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `cartItem_id` int(10) NOT NULL AUTO_INCREMENT,
  `cartItem_product_id` int(11) DEFAULT NULL,
  `cartItem_quantity` int(10) DEFAULT NULL,
  `cart_id` int(10) not null,
  PRIMARY KEY (`cartItem_id`),
  KEY `cartItem_product` (`cartItem_product_id`),
  KEY `cartItem_cart` (`cart_id`),
  CONSTRAINT `cartItem_product` FOREIGN KEY (`cartItem_product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cartItem_cart` FOREIGN KEY (`cart_id`) REFERENCES `shoppingcart` (`shoppingCart_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cartitem` */

/*Table structure for table `ordertable` */

DROP TABLE IF EXISTS `ordertable`;

CREATE TABLE `ordertable` (
  `order_id` int(20) NOT NULL AUTO_INCREMENT,
  `order_time` datetime DEFAULT NULL,
  `order_product` int(11) DEFAULT NULL,
  `order_quantity` int(11) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `order_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user` (`order_user_id`),
  KEY `order_product` (`order_product`),
  CONSTRAINT `order_product` FOREIGN KEY (`order_product`) REFERENCES `product` (`product_id`),
  CONSTRAINT `order_user` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ordertable` */

insert  into `ordertable`(`order_id`,`order_time`,`order_product`,`order_quantity`,`order_price`,`order_user_id`) values (1,'2019-03-23 13:10:10',2,15,13.5,1),(2,'2019-03-23 13:08:37',2,15,12.5,1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_title` varchar(80) DEFAULT NULL,
  `product_abstract` varchar(140) DEFAULT NULL,
  `product_detail` varchar(1000) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  `product_imgAddr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_user_id` int(10) DEFAULT NULL COMMENT 'seller',
  `product_imgType` int(11) DEFAULT NULL COMMENT 'product image address type',
  PRIMARY KEY (`product_id`),
  KEY `product_user` (`product_user_id`),
  CONSTRAINT `product_user` FOREIGN KEY (`product_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`product_id`,`product_title`,`product_abstract`,`product_detail`,`product_price`,`product_status`,`product_imgAddr`,`product_user_id`,`product_imgType`) values (1,'bing title updated','bingo abstract updated','bing detail',0,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',2,NULL),(2,'bing title','bingo abstract','bing detail',12.5,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',1,NULL),(3,'bing title updated','updated by service','bing detail',0,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',2,NULL),(4,'bing title','bingo abstract','bing detail',12.5,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',1,NULL),(5,'bing title','bingo abstract','bing detail',12.5,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',1,1),(6,'bing title','create by service','bing detail',12.5,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',1,1),(7,'bing title','create by service','bing detail',12.5,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553984482027&di=a5571c05d8b12c3e66c91204108764b2&imgtype=0&src=http%3A%2F%2Fcdn6.haitou.cc%2Fcompany%2Flogo%2F64%2F10764_449b.png%3Fv%3D1473690362',1,1),(8,'first web content','web content product','test test',2.5,NULL,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553975982238&di=c8e77f0957ed67704e375eb60be94501&imgtype=0&src=http%3A%2F%2Ffpv.tv%2Fwp-content%2Fuploads%2F2015%2F08%2Ffall-sunset-in-the-midwest-new-g.jpg',NULL,NULL),(9,'second web content','web content product','new image',100,NULL,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553975982238&di=85aa8683066efedac0b32785931a81fe&imgtype=0&src=http%3A%2F%2Fimglf0.ph.126.net%2FDN9hd8Fpnfm7vC7zIKh7vA%3D%3D%2F1825083749092483929.jpg',NULL,NULL);

/*Table structure for table `shoppingcart` */

DROP TABLE IF EXISTS `shoppingcart`;

CREATE TABLE `shoppingcart` (
  `shoppingCart_id` int(10) NOT NULL AUTO_INCREMENT,
  `shoppingCart_user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`shoppingCart_id`),
  KEY `shoppingCart_user` (`shoppingCart_user_id`),
  CONSTRAINT `shoppingCart_user` FOREIGN KEY (`shoppingCart_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shoppingcart` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_type` int(2) DEFAULT NULL COMMENT '1:customer,2:seller',
  `user_password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_type`,`user_password`) values (1,'seller',2,'relles'),(2,'buyer',1,'reyub');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

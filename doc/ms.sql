/*
SQLyog Ultimate v11.52 (64 bit)
MySQL - 5.6.12-log : Database - mservice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `order` */

CREATE TABLE `order` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') COLLATE utf8_bin NOT NULL,
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `order` */

/*Table structure for table `order_product` */

CREATE TABLE `order_product` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','CANCEL','COMMIT') NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_amt` int(11) DEFAULT NULL,
  `state` enum('NEW','CANCEL','REFOUND','CHANGE') DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_product` */

/*Table structure for table `product` */

CREATE TABLE `product` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`agg_id`,`event_type`,`id`,`name`,`stock`,`create_time`) values (NULL,'',1,'Product01',1,'2016-12-26 15:21:30'),(NULL,'',153882838,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',260710176,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',512288181,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',739985212,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',821122956,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',930331790,'Product01',10,'2016-12-26 15:21:30'),(NULL,'',935984900,'Product01',10,'2016-12-26 15:21:30');

/*Table structure for table `resource` */

CREATE TABLE `resource` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') COLLATE utf8_bin NOT NULL,
  `id` bigint(20) DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `resource` */

/*Table structure for table `role` */

CREATE TABLE `role` (
  `agg_id` bigint(20) NOT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `role_resource` */

CREATE TABLE `role_resource` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  `create` tinyint(1) DEFAULT NULL,
  `update` tinyint(1) DEFAULT NULL,
  `read` tinyint(1) DEFAULT NULL,
  `delete` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_resource` */

/*Table structure for table `user` */

CREATE TABLE `user` (
  `agg_id` bigint(20) DEFAULT NULL,
  `event_type` enum('TRY','COMMIT','CANCEL') COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`agg_id`,`event_type`,`id`,`name`,`password`,`age`,`role_id`,`create_time`) values (NULL,'TRY',1,'yancy01',NULL,18,NULL,'2016-12-26 15:34:27');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

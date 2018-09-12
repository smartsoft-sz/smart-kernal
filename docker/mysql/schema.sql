-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: 139.196.96.7    Database: base
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `QRTZ_BLOB_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_BLOB_TRIGGERS`
--

LOCK TABLES `QRTZ_BLOB_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CALENDARS`
--

DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CALENDARS`
--

LOCK TABLES `QRTZ_CALENDARS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CRON_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CRON_TRIGGERS`
--

LOCK TABLES `QRTZ_CRON_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` DISABLE KEYS */;
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('SchedulerFactory','testJob','testJob','0 */1 * * * ?','Asia/Shanghai');
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_FIRED_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_FIRED_TRIGGERS`
--

LOCK TABLES `QRTZ_FIRED_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_JOB_DETAILS`
--

DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `QRTZ_LOCKS`
--

DROP TABLE IF EXISTS `QRTZ_LOCKS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

LOCK TABLES `QRTZ_PAUSED_TRIGGER_GRPS` WRITE;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SCHEDULER_STATE`
--

DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `QRTZ_SIMPLE_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPLE_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPLE_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SIMPROP_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPROP_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPROP_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_code`
--

DROP TABLE IF EXISTS `tbl_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `seq_num` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `code_group_code` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_code_code_group_code` (`code_group_code`),
  CONSTRAINT `fk_code_code_group_code` FOREIGN KEY (`code_group_code`) REFERENCES `tbl_code_group` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=340 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_code_group`
--

DROP TABLE IF EXISTS `tbl_code_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_code_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_email_config`
--

DROP TABLE IF EXISTS `tbl_email_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_email_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host` varchar(50) NOT NULL DEFAULT '',
  `port` varchar(200) DEFAULT NULL,
  `protocol` varchar(255) DEFAULT NULL,
  `parameter` varchar(255) DEFAULT '',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `encoding` varchar(255) DEFAULT NULL,
  `email_from` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_email_config`
--

LOCK TABLES `tbl_email_config` WRITE;
/*!40000 ALTER TABLE `tbl_email_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_email_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_email_template`
--

DROP TABLE IF EXISTS `tbl_email_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_email_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_id` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  `content` longtext,
  `parameter` varchar(255) DEFAULT '',
  `template_subject` varchar(255) DEFAULT NULL,
  `template_from` varchar(255) DEFAULT NULL,
  `template_from_name` varchar(255) DEFAULT NULL,
  `template_to` varchar(255) DEFAULT NULL,
  `template_cc` varchar(255) DEFAULT NULL,
  `template_bcc` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_email_template`
--

LOCK TABLES `tbl_email_template` WRITE;
/*!40000 ALTER TABLE `tbl_email_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_email_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_job`
--

DROP TABLE IF EXISTS `tbl_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT 'job名称',
  `code` varchar(255) DEFAULT NULL COMMENT 'job名称代码（方法名）',
  `description` varchar(500) DEFAULT NULL COMMENT 'job描述',
  `interval_value` bigint(20) NOT NULL COMMENT 'job执行间隔值',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `bean_name` varchar(255) DEFAULT NULL COMMENT '该job所对应的Service',
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_job`
--

LOCK TABLES `tbl_job` WRITE;
/*!40000 ALTER TABLE `tbl_job` DISABLE KEYS */;
INSERT INTO `tbl_job` VALUES (41,'testJob','testJob',NULL,3,'m','TestJobService',254,'2018-07-07 12:04:30',254,'2018-07-07 14:13:29',2);
/*!40000 ALTER TABLE `tbl_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_job_rerun_result`
--

DROP TABLE IF EXISTS `tbl_job_rerun_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_job_rerun_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_id` bigint(20) NOT NULL,
  `start_time` datetime DEFAULT NULL COMMENT 'job的开始时间',
  `end_time` datetime DEFAULT NULL COMMENT 'job的结束时间',
  `run_time` datetime DEFAULT NULL COMMENT '记录目前跑完的那条记录的结束时间',
  `status` varchar(50) NOT NULL COMMENT '两种状态INPROGRESS, COMPLETED',
  `job_item_status` varchar(50) DEFAULT NULL COMMENT '两种状态SUCCESS，ERROR',
  `job_error` text COMMENT '每个Item的Exception记录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_job_rerun_result`
--

LOCK TABLES `tbl_job_rerun_result` WRITE;
/*!40000 ALTER TABLE `tbl_job_rerun_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_job_rerun_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_job_run_result`
--

DROP TABLE IF EXISTS `tbl_job_run_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_job_run_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_id` bigint(20) NOT NULL,
  `start_time` datetime NOT NULL COMMENT 'job的开始时间',
  `end_time` datetime DEFAULT NULL COMMENT 'job的结束时间',
  `run_time` double(20,3) DEFAULT NULL COMMENT '本次job运行的总时间(单位：s)',
  `status` varchar(50) NOT NULL COMMENT '三种状态INPROGRESS, SUCCESS, FAILED',
  `job_error` varchar(1000) DEFAULT NULL COMMENT 'Exception记录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=134663 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_key_seq`
--

DROP TABLE IF EXISTS `tbl_key_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_key_seq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(100) NOT NULL COMMENT 'éœ€è¦ç»´æŠ¤çš„keyåç§°',
  `cur_key` bigint(20) DEFAULT NULL COMMENT 'å½“å‰ç¼–å·',
  `created_date` datetime DEFAULT NULL COMMENT 'è®°å½•åˆ›å»ºæ—¶é—´',
  `last_modified_date` datetime DEFAULT NULL COMMENT 'æ•°æ®ç¼–å·æ›´æ–°æ—¶é—´',
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_parameter`
--

DROP TABLE IF EXISTS `tbl_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `value_type` varchar(10) DEFAULT NULL COMMENT 'string: 0, int: 1; float: 2, double:3,byte:4 ',
  `description` varchar(255) DEFAULT NULL,
  `func_code` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `tbl_permission`
--

DROP TABLE IF EXISTS `tbl_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(300) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `tbl_resource`
--

DROP TABLE IF EXISTS `tbl_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `request_method` varchar(10) DEFAULT NULL,
  `check_type` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_resource_permission`
--

DROP TABLE IF EXISTS `tbl_resource_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_resource_permission` (
  `resource_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `permission_type` varchar(30) DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`resource_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'ROLE_ADMIN','超级管理员','系统超级管理员');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_permission`
--

DROP TABLE IF EXISTS `tbl_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_schedule_job`
--

DROP TABLE IF EXISTS `tbl_schedule_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) DEFAULT NULL,
  `job_group` varchar(255) DEFAULT NULL,
  `cron_expression` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `bean_class` varchar(255) DEFAULT NULL,
  `is_concurrent` bit(1) DEFAULT NULL,
  `spring_id` varchar(50) DEFAULT NULL,
  `method_name` varchar(50) DEFAULT NULL,
  `manual_fire_time` datetime DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_schedule_job`
--

LOCK TABLES `tbl_schedule_job` WRITE;
/*!40000 ALTER TABLE `tbl_schedule_job` DISABLE KEYS */;
INSERT INTO `tbl_schedule_job` VALUES (5,'testJob','testJob','0 */1 * * * ?',NULL,'testJob','com.smart.job.TestJob','','testJob','testJob',NULL,254,'2018-07-09 21:50:14',254,'2018-07-09 21:50:14',1);
/*!40000 ALTER TABLE `tbl_schedule_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sms_config`
--

DROP TABLE IF EXISTS `tbl_sms_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sms_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_key_id` varchar(255) DEFAULT NULL,
  `access_key_secret` varchar(500) DEFAULT NULL,
  `sign_name` varchar(255) DEFAULT NULL,
  `send_type` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sms_config`
--

LOCK TABLES `tbl_sms_config` WRITE;
/*!40000 ALTER TABLE `tbl_sms_config` DISABLE KEYS */;
INSERT INTO `tbl_sms_config` VALUES (2,'erw','erwer','erwer','werwer','erwer','2018-06-01 14:21:42',1,'2018-06-01 14:21:47',1,1);
/*!40000 ALTER TABLE `tbl_sms_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sms_verify`
--

DROP TABLE IF EXISTS `tbl_sms_verify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sms_verify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `mobile` varchar(30) NOT NULL,
  `verify_code` varchar(30) NOT NULL,
  `verify_time` datetime DEFAULT NULL,
  `expiry_time` datetime NOT NULL,
  `verify_count` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sms_verify`
--

LOCK TABLES `tbl_sms_verify` WRITE;
/*!40000 ALTER TABLE `tbl_sms_verify` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_sms_verify` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(50) DEFAULT NULL,
  `login_name` varchar(50) NOT NULL COMMENT '默认为员工的工号',
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(500) DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'backend' COMMENT '0: 平台用户，1:公司用户',
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login_name`),
  UNIQUE KEY `idx_user_login` (`login_name`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'18896597805','admin','ç®¡ç†å‘˜','1797788139@qq.com','http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJISVpn5qI0JfdDLeJVCEbTpu5iae7LAOEobkKQd7HpVGS4IKLpEDvlLWCVlGleIPU5QmOZ7HHziaZQ/132','A','$2a$10$sYA5E8h/xADoC9La48hyhuvcDjK/BiDOeTWTD53e4iR8NT.CnIleq','0',1,'2018-06-01 15:26:14',1,'2018-08-02 16:05:28',1);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_role`
--

LOCK TABLES `tbl_user_role` WRITE;
/*!40000 ALTER TABLE `tbl_user_role` DISABLE KEYS */;
INSERT INTO `tbl_user_role` VALUES (1,1);
/*!40000 ALTER TABLE `tbl_user_role` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2018-08-09 18:42:30



--
-- Table structure for table `tbl_menu`
--

DROP TABLE IF EXISTS `tbl_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(60) NOT NULL,
  `router_name` varchar(60) NOT NULL,
  `link_url` varchar(200),
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu`
--

LOCK TABLES `tbl_menu` WRITE;
/*!40000 ALTER TABLE `tbl_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_menu` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_user_role`
--


DROP TABLE IF EXISTS `tbl_menu_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu_role` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK_tbl_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `tbl_menu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_tbl_role_id` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



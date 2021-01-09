-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据表
use seckill;
-- 创建表
CREATE TABLE seckill(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL COMMENT '开始时间',
  `end_time`  timestamp NOT NULL COMMENT '结束时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_stop_time(end_time),
  key idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT = '秒杀库存表'

CREATE TABLE seckill_record(
  `seckill_id` int(11) NOT NULL COMMENT '商品库存id',
  `seckill_phone` int(15) NOT NULL COMMENT '用户手机号',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态 -1无效 0成功 1已付款',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id,seckill_phone),
  key idx_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀记录表'
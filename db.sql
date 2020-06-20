drop database if exists springboot_demo; -- 数据库名不能用中划线-
create database springboot_demo;
use springboot_demo;

CREATE TABLE hotel_room
(
	room_id INT NOT NULL AUTO_INCREMENT,
	hotel_id INT  NOT NULL,
	room_state INT NOT NULL,
	room_price INT NOT NULL,
	PRIMARY KEY(room_id)
);

drop table if exists hotel_trade;

/*==============================================================*/
/* Table: hotel_trade                                           */
/*==============================================================*/
create table hotel_trade
(
   out_trade_no         int not null auto_increment,
   trade_no             varchar(64),
   hotel_id             int not null,
   trade_amount         decimal(10,2)  not null,
   trade_comment        varchar(500),
   trade_user_id        int not null,
   trade_create_time    timestamp,
   trade_title          varchar(255) not null,
   trade_state          int not null,
   primary key (out_trade_no)
);

alter table hotel_trade comment '酒店订单数据';
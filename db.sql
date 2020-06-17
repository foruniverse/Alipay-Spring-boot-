drop database if exists springboot_demo; -- 数据库名不能用中划线-
create database springboot_demo;
use springboot_demo;


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


create table hotel_room
(
    room_id int not null auto_increment,
    hotel_id int not null,
    room_state int not null,
    room_price int
)
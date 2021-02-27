CREATE TABLE IF NOT EXISTS user(
 id varchar(20) not null comment '用户id',
 name varchar(20) not null comment '用户姓名',
 password varchar(20) not null comment '登录密码',
 create_time timestamp(3) not null default current_timestamp(3) comment '注册时间',
 update_time timestamp(3) comment '更新时间',
 is_deleted  tinyint not null default 0 comment '注销标志',
   PRIMARY KEY ( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS goods(
 id varchar(20) not null comment '商品id',
 name varchar(50) not null comment '商品名字',
 price decimal(20,2) comment '商品价格',
 detail varchar(200) comment '商品详情',
 num int not null comment '库存',
 create_time timestamp(3) not null default current_timestamp(3) comment '上架时间',
 update_time timestamp(3) comment '更新时间',
 is_deleted  tinyint not null default 0 comment '下架标志',
   PRIMARY KEY ( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS orders(
 id varchar(20) not null comment '订单id',
 user_id varchar(20) not null comment '关联用户id',
 status varchar(4) not null comment '订单状态',
 create_time timestamp(3) not null default current_timestamp(3) comment '创建时间',
 update_time timestamp(3) comment '更新时间',
 is_deleted  tinyint not null default 0 comment '删除标志',
   PRIMARY KEY ( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS order_goods(
 order_id varchar(20) not null comment '订单id',
 goods_id varchar(20) not null comment '商品id',
 goods_num int not null comment '商品数量',
 create_time timestamp(3) not null default current_timestamp(3) comment '添加时间',
 update_time timestamp(3) comment '更新时间',
 is_deleted  tinyint not null default 0 comment '删除标志',
   PRIMARY KEY ( order_id, goods_id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
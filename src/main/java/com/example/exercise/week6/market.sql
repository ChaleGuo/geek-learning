create geek2 if not exists;

use geek2;

CREATE TABLE user (
                      id bigint NOT NULL AUTO_INCREMENT,
                      login_name VARCHAR(20) NOT NULL COMMENT '登录名',
                      password VARCHAR(64) NOT NULL COMMENT '加密的密码',
                      real_name VARCHAR(20) DEFAULT NULL COMMENT '真实姓名',
                      id_card_no VARCHAR(20) DEFAULT NULL COMMENT '身份证号',
                      email VARCHAR(20) DEFAULT NULL COMMENT '邮箱',
                      phone VARCHAR(32) NOT NULL COMMENT '电话',
                      age INT DEFAULT NULL COMMENT '年龄',
                      sex tinyint NOT NULL DEFAULT 0 COMMENT '性别，0未知，1女，2男',
                      status tinyint NOT NULL DEFAULT 0 COMMENT '用户状态 0正常，1注销，2删除',
                      insert_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
                      update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                      PRIMARY KEY (ID),
                      KEY login (login_name, password)
) ENGINE = InnoDB COMMENT '用户表';

CREATE TABLE my_order (
                          id bigint NOT NULL AUTO_INCREMENT,
                          user_id bigint NOT NULL COMMENT '用户id',
                          product_id bigint NOT NULL COMMENT '商品id',
                          num int NOT NULL COMMENT '商品数量',
                          address_id bigint NOT NULL COMMENT '收货地址id',
                          amount INT NOT NULL COMMENT '总金额(分)',
                          pay_type tinyint NOT NULL COMMENT '付款方式，0支付宝，1微信，3银行卡，4其他',
                          express_company VARCHAR(32) DEFAULT NULL COMMENT '快递公司',
                          tracking_number VARCHAR(128) DEFAULT NULL COMMENT '快递单号',
                          status tinyint NOT NULL DEFAULT 0 COMMENT '订单状态 0未付款，1已付款，2待发货，3待收货，4待评价 5正常完成，6申请退货，7，退货中，8退货完成 ',
                          insert_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
                          update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          PRIMARY KEY (ID),
                          KEY user_pid (user_id, product_id)
) ENGINE = InnoDB COMMENT '订单表';

CREATE TABLE product (
                         id bigint NOT NULL AUTO_INCREMENT,
                         business_id bigint NOT NULL COMMENT '商家id', -- 商家表
                         name VARCHAR(64) NOT NULL COMMENT '商品名称',
                         brand VARCHAR(32) NOT NULL COMMENT '品牌',
                         info VARCHAR(512) DEFAULT NULL COMMENT '商品描述',
                         img VARCHAR(512) DEFAULT NULL COMMENT '商品图片',
                         price INT NOT NULL COMMENT '单价(分)',
                         stock INT NOT NULL DEFAULT 0 COMMENT '库存',
                         status tinyint NOT NULL DEFAULT 0 COMMENT '商品状态，0上架，1下架',
                         del_flag tinyint NOT NULL DEFAULT 0 COMMENT '删除标志 0正常，1已删除',
                         insert_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
                         update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT '商品表';

CREATE TABLE address (
                         id bigint NOT NULL AUTO_INCREMENT,
                         user_id bigint NOT NULL COMMENT '用户id',
                         province VARCHAR(16) NOT NULL COMMENT '省份',
                         city VARCHAR(512) NOT NULL COMMENT '城市',
                         street VARCHAR(512) NOT NULL COMMENT '街道',
                         address VARCHAR(512) NOT NULL COMMENT '详细地址',
                         recipient VARCHAR(32) NOT NULL COMMENT '收件人姓名',
                         phone VARCHAR(32) NOT NULL COMMENT '收件人电话',
                         del_flag tinyint NOT NULL DEFAULT 0 COMMENT '删除标志 0正常，1已删除',
                         insert_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
                         update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT '收货地址表';
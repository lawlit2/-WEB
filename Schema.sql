create table 外卖管理平台数据库.address
(
    id      int auto_increment comment 'ID'
        primary key,
    address varchar(255) null comment '收货地址',
    user    varchar(255) null comment '收货人',
    phone   varchar(255) null comment '联系电话',
    user_id int          null comment '用户ID'
)
    comment '收货地址表' collate = utf8mb4_unicode_ci
                         row_format = DYNAMIC;

create table 外卖管理平台数据库.admin
(
    id       int auto_increment comment 'ID'
        primary key,
    username varchar(255) null comment '用户名',
    password varchar(255) null comment '密码',
    name     varchar(255) null comment '姓名',
    avatar   varchar(255) null comment '头像',
    role     varchar(255) null comment '角色标识',
    phone    varchar(255) null comment '电话',
    email    varchar(255) null comment '邮箱'
)
    comment '管理员' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.banner
(
    id          int auto_increment comment 'ID'
        primary key,
    img         varchar(255) null comment '图片',
    business_id int          null comment '商家ID'
)
    comment '广告表' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.business
(
    id                 int auto_increment comment '序号'
        primary key,
    username           varchar(255)                  null comment '账号',
    password           varchar(255)                  null comment '密码',
    name               varchar(255)                  null comment '名称',
    avatar             varchar(255)                  null comment 'logo',
    role               varchar(255)                  null comment '角色',
    phone              varchar(255)                  null comment '电话',
    info               varchar(255)                  null comment '简介',
    address            varchar(255)                  null comment '地址',
    license            varchar(255)                  null comment '营业执照',
    status             varchar(255) default '待审核' null comment '审核状态',
    time_range         varchar(255)                  null comment '营业时间',
    type               varchar(255)                  null comment '类型',
    weeklyDeliveryTime varchar(255)                  null,
    deliveryTimeWindow varchar(255)                  null
)
    comment '商家表' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.cart
(
    id          int auto_increment comment 'ID'
        primary key,
    goods_id    int null comment '商品ID',
    num         int null comment '数量',
    user_id     int null comment '用户ID',
    business_id int null comment '商家ID'
)
    comment '购物车' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.category
(
    id          int auto_increment
        primary key,
    name        varchar(255) null comment '名称',
    business_id int          null comment '商家ID'
)
    comment '商品分类' collate = utf8mb4_unicode_ci
                       row_format = DYNAMIC;

create table 外卖管理平台数据库.collect
(
    id          int auto_increment comment 'ID'
        primary key,
    business_id int          null comment '商家ID',
    user_id     int          null comment '用户ID',
    time        varchar(255) null comment '收藏时间'
)
    comment '用户收藏' collate = utf8mb4_unicode_ci
                       row_format = DYNAMIC;

create table 外卖管理平台数据库.comment
(
    id          int auto_increment comment 'ID'
        primary key,
    content     varchar(255)              null comment '评论',
    star        double(10, 1) default 0.0 null comment '评分',
    user_id     int                       null comment '用户ID',
    business_id int                       null comment '商家ID',
    order_id    int                       null comment '订单ID',
    time        varchar(255)              null comment '时间',
    goods_id    int                       null comment '商品ID',
    constraint user_id
        unique (user_id, order_id)
)
    comment '评价表' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.goods
(
    id            int auto_increment comment 'ID'
        primary key,
    name          varchar(255)                 null comment '名称',
    price         decimal(10, 2)               null comment '价格',
    img           varchar(255)                 null comment '图片',
    descr         varchar(255)                 null comment '描述',
    origin        varchar(255)                 null comment '原材料',
    taste         varchar(255)                 null comment '口味',
    specs         varchar(255)                 null comment '规格',
    date          varchar(255)                 null comment '上架日期',
    status        varchar(255)  default '上架' null comment '上架状态',
    discount      double(11, 1) default 1.0    null comment '折扣',
    business_id   int                          null comment '商家ID',
    category_id   int                          null comment '分类ID',
    dailySetMeal  tinyint(1)    default 0      null,
    Dollar        decimal(10, 2)               null,
    SpecialOffers tinyint(1)                   null
)
    comment '商品信息' collate = utf8mb4_unicode_ci
                       row_format = DYNAMIC;

create table 外卖管理平台数据库.notice
(
    id      int auto_increment comment 'ID'
        primary key,
    title   varchar(255) null comment '标题',
    content varchar(255) null comment '内容',
    time    varchar(255) null comment '创建时间',
    user    varchar(255) null comment '创建人'
)
    comment '公告信息表' collate = utf8mb4_unicode_ci
                         row_format = DYNAMIC;

create table 外卖管理平台数据库.orders
(
    id                    int auto_increment comment 'ID'
        primary key,
    order_no              varchar(255)   null comment '订单编号',
    time                  varchar(255)   null comment '下单时间',
    pay_type              varchar(255)   null comment '支付类型',
    pay_time              varchar(255)   null comment '支付时间',
    status                varchar(255)   null comment '订单状态',
    business_id           int            null comment '接单商家ID',
    user                  varchar(255)   null comment '收货人',
    phone                 varchar(255)   null comment '收货人电话',
    address               varchar(255)   null comment '送货地址',
    user_id               int            null comment '下单人ID',
    amount                decimal(10, 2) null comment '订单总价',
    discount              decimal(10, 2) null comment '优惠金额',
    actual                decimal(10, 2) null comment '实付款',
    comment               varchar(255)   null comment '备注',
    cover                 varchar(255)   null comment '缩略图',
    name                  varchar(255)   null comment '名称',
    FollowUpProductTime   varchar(255)   null,
    deliveryDate          varchar(255)   null,
    merchantPhone         varchar(255)   null,
    deliveryPhone         varchar(255)   null,
    estimatedDeliveryTime varchar(255)   null
)
    comment '订单表' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;

create table 外卖管理平台数据库.orders_item
(
    id         int auto_increment comment 'ID'
        primary key,
    order_id   int            null comment '订单ID',
    goods_name varchar(255)   null comment '商品名称',
    goods_img  varchar(255)   null comment '商品图片',
    price      decimal(10, 2) null comment '商品价格',
    num        int            null comment '购买数量',
    goods_id   int            null comment '商品ID'
)
    comment '订单详情表' collate = utf8mb4_unicode_ci
                         row_format = DYNAMIC;

create table 外卖管理平台数据库.user
(
    id       int auto_increment comment 'ID'
        primary key,
    username varchar(255) null comment '账号',
    password varchar(255) null comment '密码',
    name     varchar(255) null comment '姓名',
    avatar   varchar(255) null comment '头像',
    role     varchar(255) null comment '角色',
    sex      varchar(255) null comment '性别',
    phone    varchar(255) null comment '电话',
    integral int          null
)
    comment '用户表' collate = utf8mb4_unicode_ci
                     row_format = DYNAMIC;


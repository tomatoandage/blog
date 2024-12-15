CREATE TABLE `t_tag` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签id',
                         `name` varchar(60) NOT NULL DEFAULT '' COMMENT '标签名称',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                         `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位：0：未删除 1：已删除',
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE KEY `uk_name` (`name`) USING BTREE,
                         KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章标签表';

insert into t_tag(id,name) values (1,'编程开发');
insert into t_tag(id,name) values (2,'个人生活');

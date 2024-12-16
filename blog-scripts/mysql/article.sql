CREATE TABLE `t_article` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
                             `title` varchar(120) NOT NULL DEFAULT '' COMMENT '文章标题',
                             `cover` varchar(120) NOT NULL DEFAULT '' COMMENT '文章封面',
                             `summary` varchar(160) DEFAULT '' COMMENT '文章摘要',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                             `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志位：0：未删除 1：已删除',
                             `read_num` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '被阅读次数',
                             PRIMARY KEY (`id`) USING BTREE,
                             KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章表';

CREATE TABLE `t_article_content` (
                                     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章内容id',
                                     `article_id` bigint(20) NOT NULL COMMENT '文章id',
                                     `content` text COMMENT '教程正文',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     KEY `idx_article_id` (`article_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章内容表';


CREATE TABLE `t_article_category_rel` (
                                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                          `article_id` bigint(20) unsigned NOT NULL COMMENT '文章id',
                                          `category_id` bigint(20) unsigned NOT NULL COMMENT '分类id',
                                          PRIMARY KEY (`id`) USING BTREE,
                                          UNIQUE KEY `uni_article_id` (`article_id`) USING BTREE,
                                          KEY `idx_category_id` (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章所属分类关联表';

CREATE TABLE `t_article_tag_rel` (
                                     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                     `article_id` bigint(20) unsigned NOT NULL COMMENT '文章id',
                                     `tag_id` bigint(20) unsigned NOT NULL COMMENT '标签id',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     KEY `idx_article_id` (`article_id`) USING BTREE,
                                     KEY `idx_tag_id` (`tag_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章对应标签关联表';


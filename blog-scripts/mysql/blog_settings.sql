CREATE TABLE `t_blog_settings` (
                                   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                   `logo` varchar(120) NOT NULL DEFAULT '' COMMENT '博客Logo',
                                   `name` varchar(60) NOT NULL DEFAULT '' COMMENT '博客名称',
                                   `author` varchar(20) NOT NULL DEFAULT '' COMMENT '作者名',
                                   `introduction` varchar(120) NOT NULL DEFAULT '' COMMENT '介绍语',
                                   `avatar` varchar(120) NOT NULL DEFAULT '' COMMENT '作者头像',
                                   `github_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'GitHub 主页访问地址',
                                   `csdn_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'CSDN 主页访问地址',
                                   `gitee_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'Gitee 主页访问地址',
                                   `zhihu_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT '知乎主页访问地址',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='博客设置表';

# 初始化博客设置信息记录
insert into t_blog_settings values (1, 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', '犬小哈的博客', '犬小哈', '平安喜乐', 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', '', '', '', '')


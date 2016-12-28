
----------系统用户-------2016-7-28---------------------
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_un` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `user` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `username` char(20) NOT NULL,
 PRIMARY KEY (`id`, `username`)
);
create database my_test default character set utf8mb4;



CREATE TABLE `user` (
    `id` varchar(64) NOT NULL,
    `password` varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
INSERT INTO `my_test`.`user` (`id`, `password`, `username`) VALUES ('1', '123456', 'wjp');


create table `user_log` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` varchar(32),
    primary key (`id`)
) engine = innodb auto_increment=1 default charset = utf8mb4 collate = utf8mb4_general_ci;


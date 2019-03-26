-- create database perk4me;

use perk4me;

-- must be first due to foreign key 
drop table if exists user_roles;

drop table if exists role;
drop table if exists user;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `daystreak` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `interests` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `ontimedays` int(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tier` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `totaldays` int(11) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
);

-- create table role (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id));

-- create table user (id bigint not null auto_increment, age integer, password varchar(255), salary bigint, username varchar(255), primary key (id));

-- create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id));

alter table user_roles add constraint fk__user_roles__role foreign key (role_id) references role (id);
alter table user_roles add constraint fk__user_roles__user foreign key (user_id) references user (id);


INSERT INTO user
(id, username, password, age)
VALUES
(1, 'user1', '$2a$04$Ye7/lJoJin6.m9sOJZ9ujeTgHEVM4VXgI2Ingpsnf9gXyXEXf/IlW', 33);

INSERT INTO user
(id, address,bio,city,daystreak,first_name,interests,job,last_name,ontimedays,password,picture,points,state,tier,token,totaldays,username,zip)
VALUES 
( 2 , '1 Abbey Road', 'One of the Beatles.', 'New York', 16, 'John', 'Guitar, Singing', 'Employee', 'Lennon', 39, '$2a$04$Ye7/lJoJin6.m9sOJZ9ujeTgHEVM4VXgI2Ingpsnf9gXyXEXf/IlW', 'assets/img/profiles/lennon.jpg', 8700, 'New York', 'Gold', 'fake-jwt-token', 57, 'lennon', 55116);

insert into user
    (id, address,bio,city,daystreak,first_name,interests,job,last_name,ontimedays,password,picture,points,state,tier,token,totaldays,username,zip)
values(3 , '2 Abbey Road', 'One of the Beatles.', 'Boston', 21, 'Paul', 'Guitar, Singing', 'Employee', 'McCartney', 57, '$2a$04$Ye7/lJoJin6.m9sOJZ9ujeTgHEVM4VXgI2Ingpsnf9gXyXEXf/IlW', 'assets/img/profiles/mccartney.jpg', 8700, 'Massachusetts', 'Platinum', 'fake-jwt-token', 63, 'mccartney', 55116);

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2);

-- Cart Load
INSERT INTO cart (id) VALUES (1);
INSERT INTO cart (id) VALUES (2);
INSERT INTO cart (id) VALUES (3);
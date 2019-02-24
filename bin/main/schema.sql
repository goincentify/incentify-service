CREATE TABLE IF NOT EXISTS `user` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `username` char(20) NOT NULL,
 PRIMARY KEY (`id`, `username`)
);

INSERT INTO incentify_data.user
(id, address,bio,city,daystreak, first_name, interests, job, last_name, ontimedays, password, picture, points,s tate, tier, token, totaldays, username, zip)
VALUES ( 1 , '1 Abbey Road', 'One of the Beatles.', 'New York', 16, 'John', 'Guitar, Singing', 'Employee', 'Lennon', 39, 'password', 'assets/img/profiles/lennon.jpg', 8700, 'New York', 'Gold', 'fake-jwt-token', 57, 'lennon', 55116);

INSERT INTO incentify_data.user
(id, address, bio, city, daystreak, first_name, interests, job, last_name, ontimedays, password, picture, points, state, tier, token, totaldays, username, zip)
VALUES (2 , '2 Abbey Road', 'One of the Beatles.', 'Boston', 21, 'Paul', 'Guitar, Singing', 'Employee', 'McCartney', 57, 'password', 'assets/img/profiles/mccartney.jpg', 8700, 'Massachusetts', 'Platinum', 'fake-jwt-token', 63, 'mccartney', 55116);
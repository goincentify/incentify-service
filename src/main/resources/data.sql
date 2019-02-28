INSERT INTO user
(id, address,bio,city,daystreak,first_name,interests,job,last_name,ontimedays,password,picture,points,state,tier,token,totaldays,username,zip)
VALUES 
( 1 , '1 Abbey Road', 'One of the Beatles.', 'New York', 16, 'John', 'Guitar, Singing', 'Employee', 'Lennon', 39, 'password', 'assets/img/profiles/lennon.jpg', 8700, 'New York', 'Gold', 'fake-jwt-token', 57, 'lennon', 55116);

insert into user
    (id, address,bio,city,daystreak,first_name,interests,job,last_name,ontimedays,password,picture,points,state,tier,token,totaldays,username,zip)
values(2 , '2 Abbey Road', 'One of the Beatles.', 'Boston', 21, 'Paul', 'Guitar, Singing', 'Employee', 'McCartney', 57, 'password', 'assets/img/profiles/mccartney.jpg', 8700, 'Massachusetts', 'Platinum', 'fake-jwt-token', 63, 'mccartney', 55116);

insert into rewardcodes (code, value) values ("NICEJOB1", 500);
insert into rewardcodes (code, value) values ("GREATWORK1", 1000);
insert into rewardcodes (code, value) values ("TOPSALES1", 2000);
use mysql;

select host, user from user;

create user smart identified by '123456';

grant all on smart.* to smart@'%' identified by '123456' with grant option;

flush privileges;

-- privileges.sql
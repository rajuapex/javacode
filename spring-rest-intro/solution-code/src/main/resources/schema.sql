drop table flights if exists;
create table flights (id integer PRIMARY KEY AUTO_INCREMENT, airline_code varchar(2), airline_name varchar(50), code_share boolean not null, destination varchar(50), destination_code varchar(3), flight_number varchar(6), terminal varchar(1), time time);

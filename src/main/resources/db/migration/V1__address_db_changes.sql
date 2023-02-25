create table cities
(
    id   integer generated by default as identity,
    name varchar(30),
    primary key (id));
insert into cities(name)
values ('Москва'),
       ('Сочи');

create table streets
(
    id      integer generated by default as identity,
    name    varchar(30),
    city_id integer,
    foreign key (city_id) references cities(id),
    primary key (id));
insert into streets(name, city_id)
values ('Ленина',1),
       ('Южная',1),
       ('Красная',2);

create table houses
(
    id        integer generated by default as identity,
    number    integer,
    street_id integer,
    foreign key (street_id ) references streets(id),
    primary key (id));
insert into houses(number, street_id)
values (55,1),
       (22,2),
       (44,3);

create table apartments
(
    id       integer generated by default as identity,
    area     integer,
    house_id integer,
    foreign key (house_id) references  houses(id),
    primary key (id));
insert into apartments(area, house_id)
values (55,1),
       (44,2),
       (66,3);

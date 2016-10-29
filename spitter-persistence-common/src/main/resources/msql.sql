/*mysql*/
/*drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
  username varchar(25) not null,
  password varchar(25) not null,
  fullname varchar(100) not null,
  email varchar(50) not null,
  update_by_email boolean not null
);
create table spittle (
  id int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
  spitter_id int(11) not null,
  spittleText varchar(2000) not null,
  postedTime date not null,
  foreign key (spitter_id) references spitter(id) on delete cascade on update cascade
);*/
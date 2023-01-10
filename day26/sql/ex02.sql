create table t02(
	num1 tinyint,
	num2 int,
	num3 bigint
);

insert into t02 values (1,1,1);
insert into t02 value (127,127,127);
insert into t02 value (127,128,128);

select * from t02;

create table t03(
	num1 int,
	num2 double,
	num3 double(5,3)
);

insert into t03 values(1,1,1);
insert into t03 values(3.14,3.14,3.14);
insert into t03 values(4,4.12345,4.12345);
insert into t03 values(5, 12.34567, 12.34567);
insert into t03 values(6, 123.4567, 123.4567);
select * from t03;

create table t04(
	num int,
	nalja1 date,
	nalja2 datetime,
	nalja3 timestamp,
	nalja4 time
);


insert into t04 values(1,now(),now(),now(),now());
insert into t04(num, nalja1) values(2,'2022-12-31');
insert into t04(num, nalja2) values(2,'2022-12-31');
insert into t04(num, nalja3) values(4,'2022-12-31');
insert into t04(num, nalja4) values(5,'12:00:00');
insert into t04(num, nalja1) values(6,'22-12-31');
insert into t04(num, nalja1) values(7,'221231');
select * from t04;


create table t05(
	name1 char(3),
	name2 varchar(3),
	name3 text
);

insert into t05 values('aaa','aaa','aaa');
insert into t05 values('b','b','b');

select * from t05;

create table t11(
	num int,
	name varchar(3)
);

desc t12;
alter table t11 add sub varchar(3);
alter table t12 drop sub;
alter table t11 modify column name varchar(5);
alter table t11 rename column name to sub;

insert into t11 values (1111,'aaa');
select * from t11;


drop table t11;
alter table t11 rename t12;
select * from t12;
delete from t12;
insert into t12 values (1111,'aa');
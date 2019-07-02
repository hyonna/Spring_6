create table files(

	fnum number(8) constraint files_fnum_pk primary key,
	num number(8) not null,
	fname varchar2(2000),
	oname varchar2(2000)

);


commit

select * from notice


create table notice(
	num number(8),
	title varchar2(400),
	writer varchar2(400),
	contents clob,
	reg_date date,
	hit number(8),
	constraint notice_num_pk primary key (num)
);

create sequence notice_seq
start with 1
increment by 1
nomaxvalue
nocache
nocycle;


create sequence memberfile_seq
start with 1
increment by 1
nomaxvalue
nocache
nocycle;


create table member(

	id varchar2(400),
	pw varchar2(400) not null,
	name varchar2(400) not null,
	email varchar2(400) not null,
	grade number(8) default 3,
	constraint member_id_pk primary key(id)
	

);

drop table member;

delete member where id='id';

create table memberFile(

	num number(8),
	id varchar2(400),
	fname varchar2(2000),
	oname varchar2(2000),
	constraint memberFile_num_pk primary key(num),
	constraint memberFile_id_fk foreign key(id) references member(id) on delete cascade
);

select * from member
select * from memberFile;
select * from memberFile where id='id';


commit


create table notice(
num number(8),
title varchar2(400),
writer varchar2(400),
contents clob,
reg_date date,
hit number(8),
constraint notice_num_pk primary key (num)
);

create sequence notice_seq
start with 1
nomaxvalue
nocache
nocycle;

insert into notice values (notice_seq.nextval, 'happy', 'admin', null, sysdate, 0)
select count(num) from notice;
select * from notice;

create table qna(
num number(8),
title varchar2(400),
writer varchar2(400),
contents clob,
reg_date date,
hit number(8),
ref number(8),
step number(8),
depth number(8),
constraint qna_num_pk primary key (num)
);

insert into qna values(qna_seq.nextval, 'title', 'writer', null, sysdate, 0, qna_seq.currval, 0, 0)

commit



select * from
(select rownum R, N.* from
(select * from notice order by num desc) N)
where R between 1 and 10;
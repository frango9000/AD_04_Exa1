alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table vendas cascade constraints;
drop table prezos cascade constraints;
drop table stock cascade constraints;

create table stock(
codp varchar2(3),
nomp varchar2(15),
cants integer,
primary key(codp)
);
create table prezos(
codp varchar2(3),
prezo integer,
de integer,
primary key(codp),
foreign key (codp) references stock(codp)
);
create table vendas(
nv integer,
codp varchar2(3),
cantv integer,
des varchar2(1),
primary key(nv),
foreign key (codp) references stock(codp)
);
insert into stock values('p1','leite',500);
insert into stock values('p2','aceite',400);
insert into stock values('p3','farinha',1000);
insert into stock values('p4','arroz',2000);
insert into stock values('p5','sal',500);
insert into stock values('p6','pan',200);

insert into prezos values('p1',10,1);
insert into prezos values('p2',20,2);
insert into prezos values('p3',30,3);
insert into prezos values('p4',40,5);
insert into prezos values('p5',20,5);
insert into prezos values('p6',40,10);

insert into vendas  values(1,'p3',2,'s');
insert into vendas  values(2,'p1',3,'n');
insert into vendas  values(3,'p2',2,'s');
insert into vendas  values(4,'p1',4,'n');
insert into vendas  values(5,'p5',2,'s');
commit;
 select * from vendas;
 select * from stock;
 select * from prezos;



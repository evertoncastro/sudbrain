create table usuarios(
	id serial not null,
	nome varchar(50) not null,
	login varchar(15) not null,
	senha varchar(15) not null,
	primary key(id)
);

alter table usuarios add column pontos int;
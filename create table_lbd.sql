# drop database aluguelMaquina;
create database aluguelMaquina;
use aluguelMaquina;

#2 - Crie as tabelas no banco de dados relacional e insira registros em todas as tabelas (1,5)

#tabelas (entidades)
create table usuario(
	codigo int primary key auto_increment,
    nome varchar(100) not null,
    documento varchar(50) not null,
    senha varchar(50) not null,
    email varchar(100) not null unique,
    telefone varchar(100)
);

create table maquina(
	codigo int primary key auto_increment,
    nomeMaquina varchar(100) not null,
    descricao varchar(100) not null,
    especificacaoTecnica varchar(100) not null,
    img varchar(100) not null,
    txAluguelHora decimal(10,2),
    categoria varchar (100)
);

create table aluguel(
	codigo int primary key auto_increment,
    codigoUsuario int,
    codigoMaquina int,
    codigoEquipe int,
    dataHoraInicio timestamp default now(),
    dataHoraDevolucao timestamp,
    pagamento varchar(100),
    status varchar(100)
);

create table avaliacao(
	codigo int primary key auto_increment,
    codigoUsuario int,
    codigoMaquina int,
    avaliacao int,
    comentario varchar(100),
	dataAvaliacao timestamp default now()
);

create table equipe(
	codigo int primary key auto_increment,
    nome varchar(100) not null,
    telefone varchar(20),
	email varchar(100) not null
);

#relacionamento

alter table aluguel add foreign key (codigoUsuario) references usuario(codigo);
alter table  aluguel add foreign key (codigoMaquina) references maquina(codigo);
alter table  aluguel add foreign key (codigoEquipe) references equipe(codigo);

alter table  avaliacao add foreign key (codigoUsuario) references usuario(codigo);
alter table  avaliacao add foreign key (codigoMaquina) references maquina(codigo);

#inserir dados

INSERT INTO 
	usuario(
		codigo,
		nome,
		documento,
		senha,
        email,
        telefone
    )
VALUES
	(1,'Lucy','44444444444','lucy444','lucy@norton.net','40028922'),
    (2,'adriana','55555555555','adri555','adriana@norton.net','89224002'),
    (3,'roberta silva','7777777777','silvarob','roberta_silva@norton.net','88884444');
    
INSERT INTO 
	maquina(
		codigo,
		nomeMaquina,
		descricao,
		especificacaoTecnica,
		img,
		txAluguelHora,
		categoria
    )
VALUES
	(1,'martelo','10 kg, preto','nao sei','martelo.jpg',5,'equipamentos de construção'),
    (2,'makita','20 kg, vermelha','nao sei','makita.jpg',25,'ferramenta eletrica'),
    (3,'tesoura','2 kg, verde','nao sei','tesoura.jpg',4.50,'ferramenta de jardinagem'),
	(4,'balança','30 kg, prata','tbm n sei','balanca.jpg',2.50,'equipamento de médico');
    
INSERT INTO 
	equipe(
		codigo,
		nome,
		telefone,
		email
    )
VALUES
	(1,'david','985557777','david@suporte.com'),
    (2,'morgana','982221111','morgana@suporte.com');
    
INSERT INTO 
	aluguel(
		codigo,
		codigoUsuario,
		codigoMaquina,
		codigoEquipe,
		dataHoraDevolucao,
		pagamento,
		status
    )
VALUES
	(1,1,1,1,null,'credito','em uso'),
    (2,2,2,null,date_add(now(), INTERVAL 5 day),'dinheiro','concluido'),
    (3,2,3,null,null,'débito','em uso');
    
    update aluguel set datahoraInicio = '2023-10-01 12:00:00' where codigo = 1;
    
INSERT INTO 
	avaliacao(
		codigo,
		codigoUsuario,
		codigoMaquina,
		avaliacao,
		comentario
    )
VALUES
	(1,2,2,5,'equipamento muito bom');
    
#verificacao de resgistro
select * from usuario;
select * from maquina;
select * from aluguel;
select * from avaliacao;
select * from equipe;

# 3 - Crie um Índice para cada tabela criada (0,5)

create index idx_nomeUsuario on usuario(nome);
create index idx_nomeMaquina on maquina(nomeMaquina);
create index idx_statusAluguel on aluguel(status);
create index idx_avaliacao on avaliacao(avaliacao);
create index idx_nomeEquipe on equipe(nome);

# 4 - Utilizando o operador BETWEEN faça uma consulta que utilize o campo de data (0,5)

select
	*
from
	aluguel
where
	datahoraInicio between '2023-11-01' and '2023-11-30';
    
# 5 - Utilizando o operador LIKE e uma tabela que contenha nomes liste todos os registros que tenham o sobrenome SILVA (0,5)

select
	*
from 
	usuario
where
	nome like '%silva%';
    
# 6 - Crie uma view com os dados das CONSULTAS que utilizem UNION (1,0)

create view vw_pessoas as
select
	codigo
    ,nome
    ,telefone
    ,email
    ,'usuario' as tabela
from
	usuario
union
select
	codigo
    ,nome
    ,telefone
    ,email
    ,'equipe de suporte' as tabela
from
	equipe;

select * from vw_pessoas


    



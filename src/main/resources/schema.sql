create table solicitacao_acesso (
    solicitacao_acesso_id int primary key auto_increment,
    nome varchar(80) not null,
    email varchar(80) not null,
    cep varchar(9) not null,
    cidade varchar(40) not null,
    estado varchar(40) not null,
    bairro varchar(40) not null,
    logradouro varchar(80) not null,
    numero varchar(10) not null,
    ddd int,
    numero_telefone int,
    tipo_estabelecimento varchar(20) not null check (tipo_estabelecimento in ('hospital', 'hemocentro')),
    cnes varchar(7),
    tipo_hospital varchar(20) check (tipo_hospital in ('publico', 'privado', 'filantropico')),
    diretor_responsavel varchar(80),
    ativo boolean
);

drop table if exists estabelecimento;
create table estabelecimento (
	estabelecimento_id int primary key auto_increment,
    nome varchar(80) not null,
    email varchar(80) not null,
    cep varchar(9) not null,
    cidade varchar(40) not null,
    estado varchar(40) not null,
    bairro varchar(40) not null,
    logradouro varchar(80) not null,
    numero varchar(10) not null, 
    ativo boolean
);

drop table if exists telefone;
create table telefone (
	telefone_id int primary key auto_increment,
	estabelecimento_id int,
    ddd int not null,
    numero int not null,
    whatsapp boolean, 
    descricao varchar(80),
	FOREIGN KEY (estabelecimento_id) REFERENCES estabelecimento(estabelecimento_id) on update cascade
);

drop table if exists hemocentro;
create table hemocentro (
	hemocentro_id int primary key auto_increment,
	estabelecimento_id int,
	FOREIGN KEY (estabelecimento_id) REFERENCES estabelecimento(estabelecimento_id) on update cascade
);

drop table if exists hospital;
create table hospital (
	hospital_id int primary key auto_increment, 
	estabelecimento_id int not null,
    cnes varchar(7) unique not null, 
    tipo varchar(20) check (tipo in ('publico', 'privado', 'filantropico')) not null,
    diretor_responsavel varchar(80) not null,
	FOREIGN KEY (estabelecimento_id) REFERENCES estabelecimento(estabelecimento_id) on update cascade
);  

drop table if exists perfil;
create table perfil (
	perfil_id int primary key auto_increment,
    nome varchar(80) not null
); 

drop table if exists permissao;
create table permissao (
	permissao_id int primary key auto_increment,
	perfil_id int not null,
    controller varchar(80) not null,
    endpoint varchar(80) not null,
    criacao boolean, 
    visualizacao boolean, 
    atualizacao boolean,
    FOREIGN KEY (perfil_id) REFERENCES perfil(perfil_id) on update cascade
); 

drop table if exists usuario;
create table usuario (
	usuario_id int primary key auto_increment,
    cpf varchar(14) not null,
    nome varchar(80) not null,
    email varchar(80) not null,
    senha varchar(250) not null,
    ddd int,
    telefone int,
    whatsapp boolean,
	cep varchar(9) not null,
    cidade varchar(40) not null,
    estado varchar(40) not null,
    bairro varchar(40) not null,
    logradouro varchar(80) not null,
    numero varchar(10) not null,
    estabelecimento_id int not null,
	perfil_id int not null,
	FOREIGN KEY (estabelecimento_id) REFERENCES estabelecimento(estabelecimento_id) on update cascade,
    FOREIGN KEY (perfil_id) REFERENCES perfil(perfil_id) on update cascade
); 

drop table if exists contrato;
create table contrato (
	contrato_id int primary key auto_increment, 
	hospital_id int not null,
    hemocentro_id int not null,
    dt_inicio datetime not null, 
    dt_fim datetime not null,
    usuario_requerimento int,
    usuario_requerido int,
    qtd_sangue_mensal int not null,
	FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id) on update cascade,
	FOREIGN KEY (hemocentro_id) REFERENCES hemocentro(hemocentro_id) on update cascade,
	FOREIGN KEY (usuario_requerimento) REFERENCES usuario(usuario_id) on update cascade,
	FOREIGN KEY (usuario_requerido) REFERENCES usuario(usuario_id) on update cascade
);  

drop table if exists requisicao;
create table requisicao (
	requisicao_id int primary key auto_increment, 
	hospital_id int not null,
    hemocentro_id int not null,
    usuario_requerimento int,
    usuario_requerido int,
    situacao varchar(30),
	FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id) on update cascade,
	FOREIGN KEY (hemocentro_id) REFERENCES hemocentro(hemocentro_id) on update cascade,
	FOREIGN KEY (usuario_requerimento) REFERENCES usuario(usuario_id) on update cascade,
	FOREIGN KEY (usuario_requerido) REFERENCES usuario(usuario_id) on update cascade
);  

drop table if exists bolsa_requisicao;
create table bolsa_requisicao (
	bolsa_requisicao_id int primary key auto_increment, 
	requisicao_id int,
    hemocomponente varchar(80) not null,
    abo varchar(2) check (abo in ('A', 'B', 'AB', 'O')) not null,
    rh varchar(1) check (rh in ('+', '-')) not null,
    qtd_requirida int not null,
	FOREIGN KEY (requisicao_id) REFERENCES requisicao(requisicao_id) on update cascade
);  

drop table if exists entrega;
create table entrega (
	entrega_id int primary key auto_increment, 
	requisicao_id int not null,
    usuario_aprovador int not null,
    usuario_recebedor int not null,
    emergencia boolean,
	FOREIGN KEY (requisicao_id) REFERENCES requisicao(requisicao_id) on update cascade,
    FOREIGN KEY (usuario_aprovador) REFERENCES usuario(usuario_id) on update cascade,
	FOREIGN KEY (usuario_recebedor) REFERENCES usuario(usuario_id) on update cascade
);  

drop table if exists utilizacao;
create table utilizacao (
	utilizacao_id int primary key auto_increment, 
	nome_paciente varchar(80) not null,
    cpf varchar(14) not null,
    motivo varchar(500) not null,
    dt_utilizacao datetime not null, 
    cod_profisional_retirante varchar(50) not null
);  

drop table if exists descarte;
create table descarte (
	descarte_id int primary key auto_increment, 
	nome_profissional varchar(80) not null,
    cod_profissional varchar(80) not null,
    motivo varchar(500),
    dt_descarte datetime
);  

drop table if exists bolsa_entrega;
create table bolsa_entrega (
	bolsa_entrega_id int primary key auto_increment, 
	entrega_id int not null,
    hemocomponente varchar(80) not null,
    abo varchar(2) check (abo in ('A', 'B', 'AB', 'O')) not null,
    rh varchar(1) check (rh in ('+', '-')) not null,
    qtd_utilizada int ,
    utilizacao_id int,
    qtd_descartada int,
    descarte_id int,
	FOREIGN KEY (entrega_id) REFERENCES entrega(entrega_id) on update cascade,
	FOREIGN KEY (utilizacao_id) REFERENCES utilizacao(utilizacao_id) on update cascade,
	FOREIGN KEY (descarte_id) REFERENCES descarte(descarte_id) on update cascade
); 
 
drop table if exists historico;
create table historico (
	historico_id int primary key auto_increment,
    nome_tabela varchar(100) not null, 
    registro_id int,
    acao varchar(10) check (acao in ('CREATE', 'UPDATE', 'DELETE')) not null,
    usuario_id int,
    dt_historico datetime,
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id) on update cascade
);

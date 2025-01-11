
-- Inserindo dados na tabela solicitacao_acesso
insert into solicitacao_acesso (nome, email, cep, cidade, estado, bairro, logradouro, numero, ddd, numero_telefone, tipo_estabelecimento, cnes, tipo_hospital, diretor_responsavel, ativo) 
values 
('Hospital', 'hospital@teste.com', '12345-678', 'Araraquara', 'Sao Paulo', 'Teste', 'Rua Teste', '123', 11, 123456789, 'HOSPITAL', '1234567', 'PRIVADO', 'Dr. Teste da Silva', true),
('Hemocentro Araraquara', 'hemocentro@araraquara.com', '98765-432', 'Araraquara', 'Sao Paulo', 'Teste', 'Rua Teste', '456', 21, 987654321, 'HEMOCENTRO', null, null, null, true);

-- Inserindo dados na tabela estabelecimento
insert into estabelecimento (nome, email, cep, cidade, estado, bairro, logradouro, numero, ativo) 
values 
('Hospital', 'hospital@teste.com', '12345-678', 'Araraquara', 'Sao Paulo', 'Teste', 'Rua Teste', '123', true),
('Hemocentro Araraquara', 'hemocentro@araraquara.com',  '98765-432', 'Araraquara', 'Sao Paulo', 'Teste', 'Rua Teste', '456', true);

-- Inserindo dados na tabela perfil
insert into perfil (nome) 
values 
('Administrador'),
('Operador');

-- Inserindo dados na tabela permissao
insert into permissao (perfil_id, controller, criacao, visualizacao, atualizacao, deletar) 
values 
(1, 'USUARIO', true, true, true, true),
(1, 'USUARIO', true, true, true, true),
(1, 'BOLSA_REQUISICAO', true, true, true, true),
(1, 'BOLSA_ENTREGA', true, true, true, true),
(1, 'CONTRATO', true, true, true, true),
(1, 'BOLSA_DESCARTE', true, true, true, true),
(1, 'ESTABELECIMENTO', true, true, true, true),
(1, 'HEMOCENTRO', true, true, true, true),
(1, 'HISTORICO', true, true, true, true),
(1, 'HOSPITAL', true, true, true, true),
(1, 'PERFIL', true, true, true, true),
(1, 'SOLICITACAO_ACESSO', true, true, true, true),
(1, 'BOLSA_UTILIZACAO', true, true, true, true),
(2, 'USUARIO', false, true, false, false);

-- Inserindo dados na tabela usuario
insert into usuario (cpf, nome, email, senha, cep, cidade, estado, bairro, logradouro, numero, estabelecimento_id, perfil_id) 
values 
('12345678901', 'João Silva', 'joao@exemplo.com', 'senha123', '12345-678', 'Cidade A', 'Sao Paulo', 'Bairro A', 'Rua A', '123', 1, 1),
('98765432100', 'Maria Oliveira', 'maria@exemplo.com', 'senha456', '98765-432', 'Cidade B', 'Sao Paulo', 'Bairro B', 'Rua B', '456', 2, 2),
('12345678900', 'João da Silva', 'admin@gmail.com', '$2a$10$2d5QfJJABSqD4is41yUulu5bJ2Vo3tUa6kUGoiVigcZPRz6KJuC.m', '12345-678', 'São Paulo', 'São Paulo', 'Centro', 'Rua da Administração', '1000', 1, 1);

-- Inserindo dados na tabela telefone
INSERT INTO telefone (estabelecimento_id, usuario_id, ddd, numero, whatsapp, descricao)
VALUES (1, NULL, 11, 123456789, TRUE, 'Telefone principal');

INSERT INTO telefone (estabelecimento_id, usuario_id, ddd, numero, whatsapp, descricao)
VALUES (NULL, 1, 21, 987654321, FALSE, 'Telefone de contato');

-- Inserindo dados na tabela hemocentro
insert into hemocentro (estabelecimento_id) 
values 
(2);

-- Inserindo dados na tabela hospital
insert into hospital (estabelecimento_id, cnes, tipo, diretor_responsavel) 
values 
(1, '1234567', 'PRIVADO', 'Dr. Teste da Silva');

-- Inserindo dados na tabela contrato
insert into contrato (hospital_id, hemocentro_id, dt_inicio, dt_fim, usuario_requerimento, usuario_requerido, qtd_sangue_mensal) 
values 
(1, 1, '2024-01-01', '2024-12-31', 1, 2, 100);

-- Inserindo dados na tabela requisicao
insert into requisicao (hospital_id, hemocentro_id, usuario_requerimento, usuario_requerido, situacao) 
values 
(1, 1, 1, 2, 'PENDENTE'),
(1, 1, 2, 1, 'APROVADA');

-- Inserindo dados na tabela bolsa_requisicao
insert into bolsa_requisicao (requisicao_id, hemocomponente, abo, rh, qtd_requirida) 
values 
(1, 'PLASMA', 'A', '+', 10),
(2, 'SANGUE', 'O', '-', 20);

-- Inserindo dados na tabela entrega
insert into entrega (requisicao_id, usuario_aprovador, usuario_recebedor, emergencia) 
values 
(1, 1, 2, true),
(2, 2, 1, false);

-- Inserindo dados na tabela utilizacao
insert into utilizacao (nome_paciente, cpf, motivo, dt_utilizacao, cod_profisional_retirante) 
values 
('Paciente A', '12345678901', 'Tratamento de câncer', '2024-10-01', '12345'),
('Paciente B', '98765432100', 'Transfusão de sangue', '2024-09-15', '67890');

-- Inserindo dados na tabela descarte
insert into descarte (nome_profissional, cod_profissional, motivo, dt_descarte) 
values 
('Profissional A', '12345', 'Descarte por vencimento', '2024-10-10'),
('Profissional B', '67890', 'Descarte por contaminação', '2024-09-20');

-- Inserindo dados na tabela bolsa_entrega
insert into bolsa_entrega (entrega_id, hemocomponente, abo, rh, qtd_utilizada, utilizacao_id, qtd_descarte, descarte_id) 
values 
(1, 'PLASMA', 'A', '+', 5, 1, null,  null),
(2, 'SANGUE', 'O', '-', null, null, 1, 2);

-- Inserindo dados na tabela historico
insert into historico (nome_tabela, registro_id, acao, usuario_id, dt_historico) 
values 
('solicitacao_acesso', 1, 'CREATE', 1, '2024-01-01 10:00:00'),
('hospital', 2, 'UPDATE', 2, '2024-02-15 14:00:00');

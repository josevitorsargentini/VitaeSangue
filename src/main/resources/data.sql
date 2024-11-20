
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

-- Inserindo dados na tabela telefone
insert into telefone (estabelecimento_id, ddd, numero, whatsapp, descricao) 
values 
(1, 11, 123456789, true, 'Telefone principal'),
(2, 21, 987654321, false, 'Telefone secundário');

-- Inserindo dados na tabela hemocentro
insert into hemocentro (estabelecimento_id) 
values 
(2);

-- Inserindo dados na tabela hospital
insert into hospital (estabelecimento_id, cnes, tipo, diretor_responsavel) 
values 
(1, '1234567', 'PRIVADO', 'Dr. Teste da Silva');

-- Inserindo dados na tabela perfil
insert into perfil (nome) 
values 
('Administrador'),
('Operador');

-- Inserindo dados na tabela permissao
insert into permissao (perfil_id, controller, endpoint, criacao, visualizacao, atualizacao) 
values 
(1, 'usuario', '/usuario', true, true, true),
(2, 'usuario', '/usuario', false, true, false);

-- Inserindo dados na tabela usuario
insert into usuario (cpf, nome, email, senha, ddd, telefone, whatsapp, cep, cidade, estado, bairro, logradouro, numero, estabelecimento_id, perfil_id) 
values 
('12345678901', 'João Silva', 'joao@exemplo.com', 'senha123', 11, 123456789, true, '12345-678', 'Cidade A', 'Sao Paulo', 'Bairro A', 'Rua A', '123', 1, 1),
('98765432100', 'Maria Oliveira', 'maria@exemplo.com', 'senha456', 21, 987654321, false, '98765-432', 'Cidade B', 'Sao Paulo', 'Bairro B', 'Rua B', '456', 2, 2);

-- Inserindo dados na tabela contrato
insert into contrato (hospital_id, hemocentro_id, dt_inicio, dt_fim, usuario_requerimento, usuario_requerido, qtd_sangue_mensal) 
values 
(1, 1, '2024-01-01', '2024-12-31', 1, 2, 100);

-- Inserindo dados na tabela requisicao
insert into requisicao (hospital_id, hemocentro_id, usuario_requerimento, usuario_requerido, situacao) 
values 
(1, 1, 1, 2, 'pendente'),
(1, 1, 2, 1, 'aprovada');

-- Inserindo dados na tabela bolsa_requisicao
insert into bolsa_requisicao (requisicao_id, hemocomponente, abo, rh, qtd_requirida) 
values 
(1, 'Plasma', 'A', '+', 10),
(2, 'Sangue', 'O', '-', 20);

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
insert into bolsa_entrega (entrega_id, hemocomponente, abo, rh, qtd_utilizada, utilizacao_id, qtd_descartada, descarte_id) 
values 
(1, 'Plasma', 'A', '+', 5, 1, null,  null),
(2, 'Sangue', 'O', '-', null, null, 1, 2);

-- Inserindo dados na tabela historico
insert into historico (nome_tabela, registro_id, acao, usuario_id, dt_historico) 
values 
('solicitacao_acesso', 1, 'CREATE', 1, '2024-01-01 10:00:00'),
('hospital', 2, 'UPDATE', 2, '2024-02-15 14:00:00');

ALTER TABLE conserto ADD ativo TINYINT;
--Atualizar do banco já inseridos anteriormente para ativos
UPDATE conserto SET ativo = 1;
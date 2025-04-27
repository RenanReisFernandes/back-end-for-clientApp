CREATE TABLE Cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    telefone BIGINT,
    endereco VARCHAR(255),
    cpf VARCHAR(20),
    data_cadastro DATETIME
);
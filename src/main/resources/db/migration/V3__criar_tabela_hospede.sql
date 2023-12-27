CREATE TABLE Hospede (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_registro DATE NOT NULL,
    lista_de_reserva TEXT
);

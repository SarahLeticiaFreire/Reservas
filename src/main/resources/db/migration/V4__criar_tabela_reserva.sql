CREATE TABLE Reserva (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    acomodacao_id BIGINT,
    hospede_id BIGINT,
    FOREIGN KEY (acomodacao_id) REFERENCES Acomodacao(id),
    FOREIGN KEY (hospede_id) REFERENCES Hospede(id)
);

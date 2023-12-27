CREATE TABLE acomodacao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    localizacao VARCHAR(255),
    numeroRegistro VARCHAR(255),
    quartosDisponiveis INT,
    anfitriao_id BIGINT,
    FOREIGN KEY (anfitriao_id) REFERENCES anfitriao(id)
);

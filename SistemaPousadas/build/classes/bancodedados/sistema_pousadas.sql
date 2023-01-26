CREATE SCHEMA IF NOT EXISTS Sistema_pousadas;
USE Sistema_pousadas ;

CREATE TABLE IF NOT EXISTS Clientes (
  cpf VARCHAR(11) NOT NULL,
  nome TEXT NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  data_nascimento  DATE NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  numero VARCHAR(5) NOT NULL,
  cidade VARCHAR(200) NOT NULL,
  estado VARCHAR(200) NOT NULL,
  PRIMARY KEY (cpf));

CREATE TABLE IF NOT EXISTS Quartos (
  idQuarto INT NOT NULL AUTO_INCREMENT,
  numero INT NOT NULL,
  descricao TEXT NOT NULL,
  valor DOUBLE NOT NULL,
  numCamas INT NULL,
  PRIMARY KEY (idQuarto));

CREATE TABLE IF NOT EXISTS Reservas (
  idReserva INT NOT NULL AUTO_INCREMENT,
  qtd_pessoas INT NOT NULL,
  valor DOUBLE NOT NULL,
  forma_pag VARCHAR(45) NOT NULL,
  dataEntrada DATE NOT NULL,
  dataSaida DATE NOT NULL,
  fk_cpf VARCHAR(11) NOT NULL,
  comCafe TINYINT NULL,
  fk_idQuarto INT NOT NULL,
  PRIMARY KEY (idReserva),
  FOREIGN KEY (fk_cpf)
  REFERENCES Clientes (cpf),
  FOREIGN KEY (fk_idQuarto)
  REFERENCES Quartos (idQuarto));

CREATE TABLE IF NOT EXISTS Cancelamento (
  idCancelamento INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  justificativa TEXT NOT NULL,
  fk_idReserva INT NOT NULL,
  PRIMARY KEY (idCancelamento),
  FOREIGN KEY (fk_idReserva)
  REFERENCES Reservas (idReserva));

CREATE TABLE IF NOT EXISTS Imagens (
  idImagens INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  descricao TEXT NOT NULL,
  fk_idQuarto INT NOT NULL,
  imagem BLOB NULL,
  PRIMARY KEY (idImagens),
  FOREIGN KEY (fk_idQuarto)
  REFERENCES Quartos (idQuarto));

CREATE TABLE IF NOT EXISTS hospedes (
  fk_idReserva INT NOT NULL,
  fk_cpf VARCHAR(11) NOT NULL,
  FOREIGN KEY (fk_idReserva)
  REFERENCES Reservas (idReserva)
  FOREIGN KEY (fk_cpf)
  REFERENCES Clientes (cpf));
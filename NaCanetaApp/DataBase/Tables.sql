DROP TABLE IF EXISTS  `cotacaosystem`.`Produto`;
CREATE TABLE `cotacaosystem`.`Produto`(
	`Id`  INT NOT NULL AUTO_INCREMENT,
    `Descricao` VARCHAR(200) NOT NULL,
    `Marca` VARCHAR(100) NULL,
    `Preco` FLOAT NOT NULL,
    PRIMARY KEY (`Id`)
);


DROP TABLE IF EXISTS  `cotacaosystem`.`Loja`;
CREATE TABLE `cotacaosystem`.`Loja`(
	`Id`  INT NOT NULL AUTO_INCREMENT,
    `Nome` VARCHAR(200) NOT NULL,
    `Endereco` VARCHAR(100) NULL,
    `Telefone` VARCHAR(100) NULL,
    PRIMARY KEY (`Id`)
);


DROP TABLE IF EXISTS  `cotacaosystem`.`Loja_Produto`;
CREATE TABLE `cotacaosystem`.`Loja_Produto`(
	`Id`  INT NOT NULL AUTO_INCREMENT,
    `IdProduto` INT NOT NULL,
    `IdLoja` INT NOT NULL,
    PRIMARY KEY (`Id`),
    FOREIGN KEY (`IdProduto`) REFERENCES `Produto`(`Id`),
    FOREIGN KEY (`IdLoja`) REFERENCES `Loja`(`Id`)
);


DROP TABLE IF EXISTS `cotacaosystem`.`Item`;
CREATE TABLE `cotacaosystem`.`Item` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(200) NOT NULL,
  `Quantidade` INT NULL DEFAULT 0,
  PRIMARY KEY (`Id`)
);


DROP TABLE IF EXISTS `cotacaosystem`.`ListaMaterial`;
CREATE TABLE `cotacaosystem`.`ListaMaterial` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Serie` VARCHAR(200) NOT NULL,
  `Ano` Int NOT NULL,
  PRIMARY KEY (`Id`)
);


DROP TABLE IF EXISTS  `cotacaosystem`.`ListaMaterial_Item`;
CREATE TABLE `cotacaosystem`.`ListaMaterial_Item`(
	`Id`  INT NOT NULL AUTO_INCREMENT,
    `IdListaMaterial` INT NOT NULL,
    `IdItem` INT NOT NULL,
    PRIMARY KEY (`Id`),
    FOREIGN KEY (`IdListaMaterial`) REFERENCES `ListaMaterial`(`Id`),
    FOREIGN KEY (`IdItem`) REFERENCES `Item`(`Id`)
);


DROP TABLE IF EXISTS `cotacaosystem`.`Escola`;
CREATE TABLE `cotacaosystem`.`Escola` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(200) NULL,
  `Endereco` VARCHAR(200) NULL,
  `Telefone` VARCHAR(50) NULL,
  PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS  `cotacaosystem`.`Escola_ListaMaterial`;
CREATE TABLE `cotacaosystem`.`Escola_ListaMaterial`(
	`Id`  INT NOT NULL AUTO_INCREMENT,
    `IdEscola` INT NOT NULL,
    `IdListaMaterial` INT NOT NULL,
    PRIMARY KEY (`Id`),
    FOREIGN KEY (`IdEscola`) REFERENCES `Escola`(`Id`),
    FOREIGN KEY (`IdListaMaterial`) REFERENCES `ListaMaterial`(`Id`)
);



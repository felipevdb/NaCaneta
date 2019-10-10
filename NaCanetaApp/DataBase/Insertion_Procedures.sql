use cotacaosystem;

DROP PROCEDURE IF EXISTS Inserir_Item;
DELIMITER $$
CREATE PROCEDURE Inserir_Item (IN Descricao VARCHAR(200), Quantidade INT)
BEGIN
    INSERT INTO `cotacaosystem`.`Item`(Descricao, Quantidade) VALUES (Descricao, Quantidade);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_Produto;
DELIMITER $$
CREATE PROCEDURE Inserir_Produto (IN Descricao VARCHAR(200), Marca VARCHAR(100), Preco FLOAT)
BEGIN
    INSERT INTO `cotacaosystem`.`Produto`(Descricao, Marca, Preco) VALUES (Descricao, Marca, Preco);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_ListaMaterial;
DELIMITER $$
CREATE PROCEDURE Inserir_ListaMaterial (IN Serie VARCHAR(200), Ano Int)
BEGIN
    INSERT INTO `cotacaosystem`.`ListaMaterial`(Serie , Ano) VALUES (Serie , Ano);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_Escola;
DELIMITER $$
CREATE PROCEDURE Inserir_Escola (IN Nome VARCHAR(200), Endereco VARCHAR(200), Telefone VARCHAR(50))
BEGIN
    INSERT INTO `cotacaosystem`.`Escola`(Nome , Endereco, Telefone) VALUES (Nome , Endereco, Telefone);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_Loja_Produto;
DELIMITER $$
CREATE PROCEDURE Inserir_Loja_Produto (IN IdProduto INT, IdLoja INT)
BEGIN
    INSERT INTO `cotacaosystem`.`Loja_Produto`(IdProduto , IdLoja) VALUES (IdProduto , IdLoja);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_ListaMaterial_Item;
DELIMITER $$
CREATE PROCEDURE Inserir_ListaMaterial_Item (IN IdListaMaterial INT, IdItem INT)
BEGIN
    INSERT INTO `cotacaosystem`.`ListaMaterial_Item`(IdListaMaterial , IdItem) VALUES (IdListaMaterial , IdItem);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Inserir_Escola_ListaMaterial;
DELIMITER $$
CREATE PROCEDURE Inserir_Escola_ListaMaterial (IN IdEscola INT, IdListaMaterial INT)
BEGIN
    INSERT INTO `cotacaosystem`.`Escola_ListaMaterial`(IdEscola , IdListaMaterial) VALUES (IdEscola , IdListaMaterial);
END $$
DELIMITER ;

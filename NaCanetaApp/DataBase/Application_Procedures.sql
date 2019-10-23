DROP PROCEDURE IF EXISTS Adicionar_ListaMaterial;
DELIMITER $$
CREATE PROCEDURE Adicionar_ListaMaterial (IN IdEscola INT, Serie VARCHAR(200), Ano Int)
BEGIN
    CALL Inserir_ListaMaterial(Serie, Ano);
    SET @IdListaMaterial := (SELECT max(Id) from ListaMaterial);
    CALL Inserir_Escola_ListaMaterial(IdEscola, @IdListaMaterial);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Adicionar_Escola;
DELIMITER $$
CREATE PROCEDURE Adicionar_Escola (IN Nome VARCHAR(200), Endereco VARCHAR(200), Telefone VARCHAR(50))
BEGIN
    CALL Inserir_Escola (Nome, Endereco, Telefone);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Adicionar_Loja;
DELIMITER $$
CREATE PROCEDURE Adicionar_Loja (IN Nome VARCHAR(200), Endereco  VARCHAR(100), Telefone VARCHAR(100))
BEGIN
    CALL Inserir_Loja (Nome, Endereco, Telefone);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Adicionar_Cotacao;
DELIMITER $$
CREATE PROCEDURE Adicionar_Cotacao (IN valor FLOAT, IdListaMaterial  int, IdLoja INT)
BEGIN
    CALL Inserir_Cotacao (valor, IdListaMaterial, IdLoja);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Mostrar_Cotacao_ALL;
DELIMITER $$
CREATE PROCEDURE Mostrar_Cotacao_ALL()
BEGIN
    SELECT C.Id as id_Cotacao
    , E.Nome as nome_Escola
    , C.valor as valor_Cotacao
    , LM.Id as id_ListaMaterial
    , LM.Serie as serie_ListaMaterial
    , LM.Ano as ano_ListaMaterial
    , L.Nome as nome_Loja
    FROM Cotacao C
    INNER JOIN ListaMaterial LM ON LM.Id = C.IdListaMaterial
    INNER JOIN Loja L ON L.Id = C.IdLoja
    INNER JOIN Escola_ListaMaterial E_LM ON E_LM.IdListaMaterial = LM.Id
    INNER JOIN Escola E ON E.Id = E_LM.IdEscola;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Mostrar_Cotacao_BY_ID;
DELIMITER $$
CREATE PROCEDURE Mostrar_Cotacao_BY_ID(IN Id_Cotacao INT)
BEGIN
    SELECT C.Id as id_Cotacao
    , E.Nome as nome_Escola
    , C.valor as valor_Cotacao
    , LM.Id as id_ListaMaterial
    , LM.Serie as serie_ListaMaterial
    , LM.Ano as ano_ListaMaterial
    , L.Nome as nome_Loja
    FROM Cotacao C
    INNER JOIN ListaMaterial LM ON LM.Id = C.IdListaMaterial
    INNER JOIN Loja L ON L.Id = C.IdLoja
    INNER JOIN Escola_ListaMaterial E_LM ON E_LM.IdListaMaterial = LM.Id
    INNER JOIN Escola E ON E.Id = E_LM.IdEscola
    WHERE C.Id = Id_Cotacao;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Mostrar_ListaMaterial_ALL;
DELIMITER $$
CREATE PROCEDURE Mostrar_ListaMaterial_ALL()
BEGIN
    SELECT 
	LM.Id AS id_ListaMaterial
    , LM.Ano AS ano_ListaMaterial
    , LM.Serie AS serie_ListaMaterial
    FROM ListaMaterial LM
    INNER JOIN Escola_ListaMaterial E_LM ON E_LM.IdListaMaterial = LM.Id
    INNER JOIN Escola E ON E.Id = E_LM.IdEscola;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS Mostrar_ListaMaterial_POR_Escola;
DELIMITER $$
CREATE PROCEDURE Mostrar_ListaMaterial_POR_Escola(IN id_Escola INT)
BEGIN
    SELECT 
	LM.Id AS id_ListaMaterial
    , LM.Ano AS ano_ListaMaterial
    , LM.Serie AS serie_ListaMaterial
    FROM ListaMaterial LM
    INNER JOIN Escola_ListaMaterial E_LM ON E_LM.IdListaMaterial = LM.Id
    INNER JOIN Escola E ON E.Id = E_LM.IdEscola AND E.Id = id_Escola;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Mostrar_Escola;
DELIMITER $$
CREATE PROCEDURE Mostrar_Escola()
BEGIN
    SELECT Id as id_Escola, Nome as nome_Escola, Endereco as endereco_Escola, Telefone as telefone_Escola FROM Escola;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS Mostrar_Loja;
DELIMITER $$
CREATE PROCEDURE Mostrar_Loja()
BEGIN
    select Id as id_Loja, Nome as nome_Loja, Endereco as endereco_Loja,Telefone as telefone_Loja  from Loja;
END $$
DELIMITER ;


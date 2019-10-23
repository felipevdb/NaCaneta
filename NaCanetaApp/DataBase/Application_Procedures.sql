DROP PROCEDURE IF EXISTS Adicionar_ListaMaterial;
DELIMITER $$
CREATE PROCEDURE Adicionar_ListaMaterial (IN IdEscola INT, Serie VARCHAR(200), Ano Int)
BEGIN
    CALL Inserir_ListaMaterial(Serie, Ano);
    SET @IdListaMaterial := (SELECT max(Id) from ListaMaterial);
    CALL Inserir_Escola_ListaMaterial(IdEscola, @IdListaMaterial);
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




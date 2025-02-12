package br.com.alura.clientelo.arquivo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
class ExtratorDeCsvTest {

    @Test
    void extraiPedidos() throws Exception {
        // Arrange
        var csvData = """
                CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATA,CLIENTE
                INFORMÁTICA,Notebook Samsung,3523.00,1,01/01/2022,ANA
                MÓVEIS,Sofá 3 lugares,2500.00,1,05/01/2022,ANA
                """;
        var inputStream = new ByteArrayInputStream(csvData.getBytes());
        var extrator = new ExtratorDeCsv();

        // Act
        var pedidos = extrator.extraiPedidos(inputStream);

        // Assert
        assertEquals(2, pedidos.size());
    }
}
package br.com.alura.clientelo.arquivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ProcessadorDeArquivoIT {
    @Test
    void processaArquivo() throws Exception {
        // Arrange
        var processador = new ProcessadorDeArquivo();
        var extrator = new ExtratorDeCsv();

        // Act
        var pedidos = processador.processaArquivo("pedidos-teste.csv", extrator);

        // Assert
        assertEquals(3, pedidos.size());
        assertEquals("Notebook Positivo", pedidos.get(0).getProduto());
    }
}
package br.com.alura.clientelo.arquivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
class ProcessadorDeArquivoTest {
    @Mock
    ExtratorDePedidos extrator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processaArquivo() throws Exception {
        // Arrange
        var processador = new ProcessadorDeArquivo();
        PedidoArquivo pedidoArquivo = new PedidoArquivo();
        pedidoArquivo.setCategoria("categoria");
        pedidoArquivo.setProduto("seguro");
        pedidoArquivo.setPreco(new BigDecimal("10.0"));
        pedidoArquivo.setQuantidade(1);
        pedidoArquivo.setData(null);
        pedidoArquivo.setCliente("cliente");

        given(extrator.extraiPedidos(any())).willReturn(List.of(pedidoArquivo));

        // Act
        var pedidos = processador.processaArquivo("pedidos.csv", extrator);

        // Assert
        assertEquals(1, pedidos.size());
        assertEquals("seguro", pedidos.get(0).getProduto());
    }
}
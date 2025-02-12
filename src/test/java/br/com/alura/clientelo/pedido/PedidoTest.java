package br.com.alura.clientelo.pedido;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
class PedidoTest {

    @Test
    void verificaPedidoRS10EhMaisBaratoQuePedidoRS200() {
        // Arrange
        var pedidoRS10 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("10.0") , 1, null);
        var pedidoRS200 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("20.0"), 10, null);

        // Act
        var resultado = pedidoRS10.isMaisBaratoQue(pedidoRS200);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void verificaPedidoRS30NaoEhMaisBaratoQuePedidoRS20() {
        // Arrange
        var pedidoRS30 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("10.0") , 3, null);
        var pedidoRS20 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("20.0"), 1, null);

        // Act
        var resultado = pedidoRS30.isMaisBaratoQue(pedidoRS20);

        // Assert
        assertFalse(resultado);
    }
}
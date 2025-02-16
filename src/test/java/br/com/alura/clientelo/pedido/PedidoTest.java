package br.com.alura.clientelo.pedido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PedidoTest {

    Pedido pedidoRS10;

    Pedido pedidoRS15;

    @BeforeEach
    void setup() {
        // Arrange
        pedidoRS10 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("10.0"), 1, null);

        pedidoRS15 = new Pedido("categoria", "produto",
                "cliente", new BigDecimal("5.0"), 3, null);
    }

    @Test
    @DisplayName("Deve retornar true pois o pedido de R$10 é mais barato que o pedido de R$15")
    void pedidoRS10isMaisBaratoQuePedidoRS15() {
        // Act
        var resultado = pedidoRS10.isMaisBaratoQue(pedidoRS15);

        // Assert
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false pois o pedido de R$15 não é mais barato que o pedido de R$10")
    void pedidoRS15NaoIsMaisBaratoQuePedidoRS10() {
        // Act
        var resultado = pedidoRS15.isMaisBaratoQue(pedidoRS10);

        // Assert
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar false pois o pedido de R$15 não é mais barato que o pedido de R$15")
    void pedidoRS15NaoIsMaisBaratoQuePedidoRS15() {
        // Act
        var resultado = pedidoRS15.isMaisBaratoQue(pedidoRS15);

        // Assert
        assertFalse(resultado);
    }
}
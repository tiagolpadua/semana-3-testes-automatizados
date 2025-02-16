package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class RelatorioSinteticoTest {

    @Test
    void geraRelatorio() {
        // Arrange
        var pedidos = List.of(
                new Pedido("INFORMÁTICA", "produto",
                        "cliente", new BigDecimal("10.0"), 1, null),
                new Pedido("ALIMENTOS", "produto",
                        "cliente", new BigDecimal("5.0"), 3, null),
                new Pedido("INFORMÁTICA", "produto",
                        "cliente", new BigDecimal("8.0"), 2, null)
        );

        // Act
        var relatorio = RelatorioSintetico.geraRelatorio(pedidos);

        // Assert
        assertEquals(3, relatorio.getQuantidadeDePedidos());
        assertEquals(6, relatorio.getTotalDeProdutosVendidos());
        assertEquals(new BigDecimal("41.00"), relatorio.getMontanteDeVendas());
        assertEquals(pedidos.get(0), relatorio.getPedidoMaisBarato());
        assertEquals(pedidos.get(2), relatorio.getPedidoMaisCaro());
        assertEquals(2, relatorio.getTotalDeCategorias());
    }
}
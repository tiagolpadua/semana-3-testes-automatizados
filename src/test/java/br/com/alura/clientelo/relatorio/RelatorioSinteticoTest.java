package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioSinteticoTest {

    @Test
    void geraRelatorio() {
        // Arrange
        var pedidos = new ArrayList<Pedido>();

        pedidos.add(new Pedido("categoria", "produto",
                "cliente", new BigDecimal("5.0"), 1, null));
        pedidos.add(new Pedido("categoria", "produto",
                "cliente", new BigDecimal("10.0"), 2, null));
        pedidos.add(new Pedido("categoria", "produto",
                "cliente", new BigDecimal("3.0"), 5, null));

        // Act
        var relatorio = RelatorioSintetico.geraRelatorio(pedidos);

        // Assert
        assertEquals(3, relatorio.getQuantidadeDePedidos());
        assertEquals(8, relatorio.getTotalDeProdutosVendidos());
        assertEquals(new BigDecimal("40.00"), relatorio.getMontanteDeVendas());
    }
}
package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RelatorioServiceTest {

    private RelatorioService relatorioService;

    @BeforeEach
    void setUp() {
        relatorioService = new RelatorioService();
    }

    @Test
    void geraRelatorioCom3Pedidos() {

        // Creating 3 example orders
        Pedido pedido1 = new Pedido("Cat1", "Prod1", "Maria", new BigDecimal("100.00"), 2, LocalDate.now());
        Pedido pedido2 = new Pedido("Cat2", "Prod2", "Paulo",new BigDecimal("200.00"), 3, LocalDate.now());
        Pedido pedido3 = new Pedido("Cat1", "Prod3", "Pedro",new BigDecimal("150.00"), 1, LocalDate.now());

        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2, pedido3);

        RelatorioSintetico relatorio = relatorioService.geraRelatorio(pedidos);

        assertThat(relatorio.quantidadeDePedidos()).isEqualTo(3);
        assertThat(relatorio.totalDeProdutosVendidos()).isEqualTo(6);
        assertThat(relatorio.montanteDeVendas()).isEqualByComparingTo(new BigDecimal("950.00"));
        assertThat(relatorio.pedidoMaisBarato()).isEqualTo(pedido3);
        assertThat(relatorio.pedidoMaisCaro()).isEqualTo(pedido2);
        assertThat(relatorio.totalDeCategorias()).isEqualTo(2);
    }

    @Test
    void geraRelatorioCom1Pedido() {
        Pedido pedido1 = new Pedido("Cat1", "Prod1", "Maria", new BigDecimal("100.00"), 2, LocalDate.now());

        List<Pedido> pedidos = Arrays.asList(pedido1);

        RelatorioSintetico relatorio = relatorioService.geraRelatorio(pedidos);

        assertThat(relatorio.quantidadeDePedidos()).isEqualTo(1);
        assertThat(relatorio.totalDeProdutosVendidos()).isEqualTo(2);
        assertThat(relatorio.montanteDeVendas()).isEqualByComparingTo(new BigDecimal("200.00"));
        assertThat(relatorio.pedidoMaisBarato()).isEqualTo(pedido1);
        assertThat(relatorio.pedidoMaisCaro()).isEqualTo(pedido1);
        assertThat(relatorio.totalDeCategorias()).isEqualTo(1);
    }
}

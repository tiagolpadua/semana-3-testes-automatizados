package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class RelatorioService {
    public RelatorioSintetico geraRelatorio(List<Pedido> pedidos) {
        int totalDeProdutosVendidos = 0;
        BigDecimal montanteDeVendas = BigDecimal.ZERO;

        Pedido pedidoMaisBarato = null;
        Pedido pedidoMaisCaro = null;

        Set<String> categoriasProcessadas = new HashSet<>();

        for (Pedido pedidoAtual : pedidos) {
            if (pedidoMaisBarato == null || pedidoAtual.isMaisBaratoQue(pedidoMaisBarato)) {
                pedidoMaisBarato = pedidoAtual;
            }

            if (pedidoMaisCaro == null || pedidoAtual.isMaisCaroQue(pedidoMaisCaro)) {
                pedidoMaisCaro = pedidoAtual;
            }

            montanteDeVendas = montanteDeVendas.add(pedidoAtual.getValorTotal());
            totalDeProdutosVendidos += pedidoAtual.getQuantidade();

            categoriasProcessadas.add(pedidoAtual.getCategoria());
        }

        return new RelatorioSintetico(
                pedidos.size(),
                totalDeProdutosVendidos,
                montanteDeVendas,
                pedidoMaisBarato,
                pedidoMaisCaro,
                categoriasProcessadas.size()
        );
    }

    public void exibir(RelatorioSintetico relatorioSintetico) {
        log.info("##### RELATÓRIO SINTÉTICO -> VALORES TOTAIS #####");
        System.out.println();

        log.info("TOTAL DE PEDIDOS REALIZADOS: {}", relatorioSintetico.quantidadeDePedidos());
        log.info("TOTAL DE PRODUTOS VENDIDOS: {}", relatorioSintetico.totalDeProdutosVendidos());
        log.info("TOTAL DE CATEGORIAS: {}", relatorioSintetico.totalDeCategorias());
        System.out.println();

        log.info("MONTANTE DE VENDAS: {}", FormatUtils.formataParaReal(relatorioSintetico.montanteDeVendas()));
        System.out.println();

        log.info("PEDIDO MAIS BARATO: {} ({})", FormatUtils.formataParaReal(relatorioSintetico.pedidoMaisBarato().getValorTotal()), relatorioSintetico.pedidoMaisBarato().getProduto());
        log.info("PEDIDO MAIS CARO: {} ({})\n", FormatUtils.formataParaReal(relatorioSintetico.pedidoMaisCaro().getValorTotal()), relatorioSintetico.pedidoMaisCaro().getProduto());
        System.out.println();

        log.info("### FIM DO RELATÓRIO ###");
    }
}

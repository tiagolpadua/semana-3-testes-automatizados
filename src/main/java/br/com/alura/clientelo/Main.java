package br.com.alura.clientelo;

import br.com.alura.clientelo.arquivo.*;
import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final Map<Integer, ExtratorDePedidos> EXTRATORES = Map.of(
        1, new ExtratorDeCsv(),
        2, new ExtratorDeJson(),
        3, new ExtratorDeXml()
    );

    private static final Map<Integer, String> NOMES = Map.of(
        1, "pedidos.csv",
        2, "pedidos.json",
        3, "pedidos.xml"
    );

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o tipo de arquivo que deseja processar (1. CSV, 2. JSON ou 3. XML): ");

            int opcaoDoArquivo = scanner.nextInt();
            if (opcaoDoArquivo < 1 || opcaoDoArquivo > 3) {
                logger.error("Opção inválida. O programa será encerrado.");
                return;
            }

            ProcessadorDeArquivo processadorDeArquivo = new ProcessadorDeArquivo();
            List<Pedido> pedidos = processadorDeArquivo.processaArquivo(NOMES.get(opcaoDoArquivo), EXTRATORES.get(opcaoDoArquivo));

            RelatorioSintetico relatorioSintetico = RelatorioSintetico.geraRelatorio(pedidos);
            relatorioSintetico.exibir();
        }
    }
}

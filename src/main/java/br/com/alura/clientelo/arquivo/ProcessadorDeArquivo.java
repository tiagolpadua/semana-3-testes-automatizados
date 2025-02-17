package br.com.alura.clientelo.arquivo;

import java.util.List;

import br.com.alura.clientelo.pedido.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessadorDeArquivo {
    private StreamFetcher streamFetcher;

    public List<Pedido> processaArquivo(String nomeDoArquivo, ExtratorDePedidos extrator) throws Exception {
        try (var stream = streamFetcher.fetchStream(nomeDoArquivo)) {

            return extrator.extraiPedidos(stream)
                    .stream()
                    .map(PedidoArquivo::toPedido)
                    .toList();
        }
    }
}

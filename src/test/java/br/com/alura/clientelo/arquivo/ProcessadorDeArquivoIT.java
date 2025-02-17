package br.com.alura.clientelo.arquivo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.clientelo.pedido.Pedido;

class ProcessadorDeArquivoIT {
    private ProcessadorDeArquivo processadorDeArquivo;

    @BeforeEach
    void setUp() {
        processadorDeArquivo = new ProcessadorDeArquivo();
        processadorDeArquivo.setStreamFetcher(new StreamFetcher());
    }

    @Test
    void testProcessaArquivoComSucesso() throws Exception {
        String nomeDoArquivo = "pedidos.csv";
        var extratorDePedidos = new ExtratorDeCsv();

        List<Pedido> pedidos = processadorDeArquivo.processaArquivo(nomeDoArquivo, extratorDePedidos);

        assertEquals(14, pedidos.size());
        assertEquals("Notebook Positivo", pedidos.get(0).getProduto());
    }

    @Test
    void testProcessaArquivoComArquivoNaoEncontrado() {
        String nomeDoArquivo = "arquivo_inexistente.csv";

        var extratorDePedidos = new ExtratorDeCsv();

        processadorDeArquivo.setStreamFetcher(new StreamFetcher());

        Exception exception = assertThrows(Exception.class, () -> {
            processadorDeArquivo.processaArquivo(nomeDoArquivo, extratorDePedidos);
        });

        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
}


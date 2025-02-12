package br.com.alura.clientelo.arquivo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.clientelo.pedido.Pedido;

class ProcessadorDeArquivoIntegrationTestIT {

    private ProcessadorDeArquivo processadorDeArquivo;
    private ExtratorDePedidos extratorDePedidos;

    @BeforeEach
    void setUp() {
        processadorDeArquivo = new ProcessadorDeArquivo();
    }

    @Test
    void testProcessaArquivoComSucesso() throws Exception {
        String nomeDoArquivo = "pedidos.csv";
        extratorDePedidos = new ExtratorDeCsv();

        List<Pedido> pedidos = processadorDeArquivo.processaArquivo(nomeDoArquivo, extratorDePedidos);

        assertEquals(14, pedidos.size());
        assertEquals("Notebook Positivo", pedidos.get(0).getProduto());
    }

    @Test
    void testProcessaArquivoComArquivoNaoEncontrado() {
        String nomeDoArquivo = "arquivo_inexistente.csv";

        extratorDePedidos = new ExtratorDeCsv();

        Exception exception = assertThrows(Exception.class, () -> {
            processadorDeArquivo.processaArquivo(nomeDoArquivo, extratorDePedidos);
        });

        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
}


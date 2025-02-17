package br.com.alura.clientelo.arquivo;

import br.com.alura.clientelo.pedido.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class ProcessadorDeArquivoTest {

    @InjectMocks
    private ProcessadorDeArquivo processador;

    @Mock
    private StreamFetcher streamFetcher;

    @Mock
    private ExtratorDePedidos extrator;

    @Mock
    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveriaProcessarArquivoComSucesso() throws Exception {
        // Arrange
        String nomeDoArquivo = "pedidos.csv";
        Pedido pedido = new Pedido();
        given(streamFetcher.fetchStream(nomeDoArquivo)).willReturn(inputStream);
        given(extrator.extraiPedidos(inputStream)).willReturn(List.of(new PedidoArquivo()));

        // Act
        List<Pedido> resultado = processador.processaArquivo(nomeDoArquivo, extrator);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(pedido, resultado.get(0));
    }
}
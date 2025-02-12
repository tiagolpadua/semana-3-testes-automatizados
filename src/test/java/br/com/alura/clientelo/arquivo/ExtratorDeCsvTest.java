package br.com.alura.clientelo.arquivo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class ExtratorDeCsvTest {
    @Test
    void testExtraiPedidosComSucesso() throws Exception {
        // Arrange
        String csvData = """
                CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATA,CLIENTE
                INFORMÁTICA,Notebook Samsung,3523.00,1,01/01/2022,ANA
                MÓVEIS,Sofá 3 lugares,2500.00,1,05/01/2022,ANA
                """;
        InputStream inputStream = new ByteArrayInputStream(csvData.getBytes());
        ExtratorDeCsv extrator = new ExtratorDeCsv();

        // Act
        List<PedidoArquivo> pedidos = extrator.extraiPedidos(inputStream);

        System.out.println(pedidos);

        // Assert
        assertNotNull(pedidos);
        assertEquals(2, pedidos.size());

        PedidoArquivo pedido1 = pedidos.get(0);
        assertEquals("INFORMÁTICA", pedido1.getCategoria());
        assertEquals("Notebook Samsung", pedido1.getProduto());
        assertEquals(3523.00, pedido1.getPreco().doubleValue());
        assertEquals(1, pedido1.getQuantidade());
        assertEquals("2022-01-01", pedido1.getData().toString());
        assertEquals("ANA", pedido1.getCliente());

        PedidoArquivo pedido2 = pedidos.get(1);
        assertEquals("MÓVEIS", pedido2.getCategoria());
        assertEquals("Sofá 3 lugares", pedido2.getProduto());
        assertEquals(2500.00, pedido2.getPreco().doubleValue());
        assertEquals(1, pedido2.getQuantidade());
        assertEquals("2022-01-05", pedido2.getData().toString());
        assertEquals("ANA", pedido2.getCliente());
    }

    @Test
    void testExtraiPedidosComErro() {
        ExtratorDeCsv extrator = new ExtratorDeCsv();
        assertThrows(Exception.class, () -> extrator.extraiPedidos(null));
    }
}
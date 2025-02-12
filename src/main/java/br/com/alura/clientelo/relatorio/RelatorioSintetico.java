package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;

import java.math.BigDecimal;

public record RelatorioSintetico(int quantidadeDePedidos, int totalDeProdutosVendidos, BigDecimal montanteDeVendas, Pedido pedidoMaisBarato, Pedido pedidoMaisCaro, int totalDeCategorias){}


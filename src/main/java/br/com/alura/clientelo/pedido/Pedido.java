package br.com.alura.clientelo.pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public record Pedido(String categoria, String produto, String cliente, BigDecimal preco, int quantidade, LocalDate data) {
    public BigDecimal getValorTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + categoria + '\'' +
                ", produto='" + produto + '\'' +
                ", cliente='" + cliente + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }

    public boolean isMaisBaratoQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) > 0;
    }
}

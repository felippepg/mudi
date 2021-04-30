package br.com.piresfoundation.mudi.dto;

import br.com.piresfoundation.mudi.models.Oferta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOfera {

    private String pedidoId;
    @NotNull
    @Pattern(regexp = "\\d+(\\.\\d{2})?$")
    private String valorProduto;
    @NotNull
    private String dataEntrega;
    private String comentario;

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega));
        oferta.setValor(new BigDecimal(this.valorProduto));

        return oferta;
    }
}

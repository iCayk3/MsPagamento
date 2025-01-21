package br.com.alurafood.pagamentos.dto;

import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PagamentoDTO(
    Long id,
    @NotNull
    @Positive
    BigDecimal valor,
    @NotBlank
    @Size(max = 100)
    String nome,
    @NotBlank
    @Size(max = 19)
    String numero,
    @NotBlank
    @Size(max = 7)
    String expiracao,
    @NotBlank
    @Size(max = 3, min = 3)
    String codigo,
    Status status,
    @NotNull
    Long pedidoId,
    @NotNull
    Long formaDePagamentoId
) {
    public PagamentoDTO(Pagamento dados){
        this(dados.getId(), dados.getValor(), dados.getNome(), dados.getNumero(), dados.getExpiracao(),
             dados.getCodigo(), dados.getStatus(), dados.getPedidoId(), dados.getFormaDePagamentoId());
    }
}

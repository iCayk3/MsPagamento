package br.com.alurafood.pagamentos.model;

import br.com.alurafood.pagamentos.dto.PagamentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId;

    public Pagamento(PagamentoDTO dados) {
        this.id = dados.id();
        this.valor = dados.valor();
        this.nome = dados.nome();
        this.numero = dados.numero();
        this.expiracao = dados.expiracao();
        this.codigo = dados.codigo();
        this.status = dados.status();
        this.pedidoId = dados.pedidoId();
        this.formaDePagamentoId = dados.formaDePagamentoId();
    }
}

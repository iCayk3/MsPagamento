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
    @Enumerated(EnumType.STRING)
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

    public Pagamento(){}

    public void atualizarStatus(Status status){
        this.status = status;
    }
    public void atualizarId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public Status getStatus() {
        return status;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public Long getFormaDePagamentoId() {
        return formaDePagamentoId;
    }

    public void atualizarPagamento(PagamentoDTO dto) {
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.valor() != null){
            this.valor = dto.valor();
        }
        if(dto.numero() != null){
            this.numero = dto.numero();
        }
        if(dto.expiracao() != null){
            this.expiracao = dto.expiracao();
        }
        if(dto.codigo() != null){
            this.codigo = dto.codigo();
        }
        if(dto.pedidoId() != null){
            this.pedidoId = dto.pedidoId();
        }
        if(dto.formaDePagamentoId() != null){
            this.formaDePagamentoId = dto.formaDePagamentoId();
        }
    }
}

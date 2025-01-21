package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PagamentoDTO;
import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.Status;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    public Page<PagamentoDTO> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(PagamentoDTO::new);
    }

    public PagamentoDTO obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return new PagamentoDTO(pagamento);
    }

    public PagamentoDTO criarPagamento(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento(dto);
        pagamento.atualizarStatus(Status.CRIADO);
        repository.save(pagamento);

        return new PagamentoDTO(pagamento);
    }

    public PagamentoDTO atualizarPagamento(Long id, PagamentoDTO dto) {
        var pagamento = repository.findById(id);
        if(pagamento.isPresent()){
            pagamento.get().atualizarPagamento(dto);
            return new PagamentoDTO(pagamento.get());
        }
        throw new RuntimeException("Id não encontrado.");
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }
}

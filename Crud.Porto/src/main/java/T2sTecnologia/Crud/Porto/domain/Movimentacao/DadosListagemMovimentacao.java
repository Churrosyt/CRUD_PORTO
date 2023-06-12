package T2sTecnologia.Crud.Porto.domain.Movimentacao;

import T2sTecnologia.Crud.Porto.domain.Container.Container;
import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;


import java.time.LocalDateTime;

public record DadosListagemMovimentacao(
        Long id,
        Movimentacoes movimentacoes,
        LocalDateTime datahorainicio,
        LocalDateTime datahorafim,

        Container container


) {

    public DadosListagemMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getMovimentacoes(), movimentacao.getDatahorainicio(),
                movimentacao.getDatahorafim(), movimentacao.getContainer());
    }
}

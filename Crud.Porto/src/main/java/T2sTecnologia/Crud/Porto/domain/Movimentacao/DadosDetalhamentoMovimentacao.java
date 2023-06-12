package T2sTecnologia.Crud.Porto.domain.Movimentacao;

import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;


import java.time.LocalDateTime;

public record DadosDetalhamentoMovimentacao(

        Long id,
        Movimentacoes movimentacoes,
        LocalDateTime datahorainicio,
        LocalDateTime datahorafim


) {

    public DadosDetalhamentoMovimentacao (Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getMovimentacoes(),
                movimentacao.getDatahorainicio(), movimentacao.getDatahorafim());
    }
}

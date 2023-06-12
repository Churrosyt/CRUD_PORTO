package T2sTecnologia.Crud.Porto.domain.Container;

import T2sTecnologia.Crud.Porto.domain.Enums.Categoria;
import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;
import T2sTecnologia.Crud.Porto.domain.Enums.Status;
import T2sTecnologia.Crud.Porto.domain.Movimentacao.DadosDetalhamentoMovimentacao;
import T2sTecnologia.Crud.Porto.domain.Movimentacao.Movimentacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


public record DadosDetalhamentoContainer(

        Long id,
        String nome,
        String numero,
        String tipo,
        Status status,
        Categoria categoria,
        @JsonIgnoreProperties("container")
        List<Movimentacao> movimentacao


) {
    public DadosDetalhamentoContainer(Container container){
        this(container.getId(), container.getNome(), container.getNumero(),
                container.getTipo(),container.getStatus(), container.getCategoria(),
                container.getMovimentacao());
    }


}

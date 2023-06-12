package T2sTecnologia.Crud.Porto.domain.Container;

import T2sTecnologia.Crud.Porto.domain.Enums.Categoria;
import T2sTecnologia.Crud.Porto.domain.Enums.Status;
import T2sTecnologia.Crud.Porto.domain.Movimentacao.Movimentacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record DadosListagemContainer(
        Long id,
        String nome,
        String numero,
        String tipo,
        Status status,
        Categoria categoria,
        @JsonIgnoreProperties("container")
        List<Movimentacao> movimentacao


) {
    public DadosListagemContainer(Container container){
        this(container.getId(), container.getNome(), container.getNumero(),
                container.getTipo(),container.getStatus(), container.getCategoria(), container.getMovimentacao());
    }
}

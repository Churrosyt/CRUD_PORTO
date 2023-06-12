package T2sTecnologia.Crud.Porto.domain.Container;

import T2sTecnologia.Crud.Porto.domain.Enums.Categoria;

import T2sTecnologia.Crud.Porto.domain.Enums.Status;
import T2sTecnologia.Crud.Porto.domain.Movimentacao.Movimentacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DadosCadastroContainer(

        @NotNull
        String nome,

        @NotNull
        @Pattern(regexp = "[A-Z]{4}\\d{7}")
        String numero,

        @NotNull
        String tipo,

        @NotNull
        Status status,

        @NotNull
        Categoria categoria,

        @JsonIgnoreProperties("container")
        List<Movimentacao> movimentacao




) {

}

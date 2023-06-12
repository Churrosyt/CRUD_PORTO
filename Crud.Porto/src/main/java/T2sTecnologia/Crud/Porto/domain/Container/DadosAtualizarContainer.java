package T2sTecnologia.Crud.Porto.domain.Container;

import T2sTecnologia.Crud.Porto.domain.Enums.Categoria;
import T2sTecnologia.Crud.Porto.domain.Enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarContainer(
        @NotNull
        Long id,

        String nome,

        @Pattern(regexp = "[A-Z]{4}\\d{7}")

        String numero,

        String tipo,

        Status status,

        Categoria categoria

) {
}

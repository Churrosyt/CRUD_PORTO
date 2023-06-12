package T2sTecnologia.Crud.Porto.domain.Movimentacao;

import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public record DadosAtualizarMovimentacao(

        @NotNull
        Long id,

        Movimentacoes movimentacoes,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dahorainicio,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime datahorafim




) {
}

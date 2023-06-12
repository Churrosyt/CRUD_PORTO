package T2sTecnologia.Crud.Porto.domain.Movimentacao;

import T2sTecnologia.Crud.Porto.domain.Container.Container;
import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosCadastroMovimentacao(


        Movimentacoes movimentacoes,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime datahorainicio,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime datahorafim,

        Container container




) {


}

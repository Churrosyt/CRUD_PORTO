package T2sTecnologia.Crud.Porto.domain.Movimentacao;

import T2sTecnologia.Crud.Porto.domain.Container.Container;
import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "movimentacao")
@Entity(name = "Movimentacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Movimentacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
     private Movimentacoes movimentacoes;

    private LocalDateTime datahorainicio;
    private LocalDateTime datahorafim;

   
    @ManyToOne

    private Container container;

    public Movimentacao(DadosCadastroMovimentacao dados) {
        this.movimentacoes = dados.movimentacoes();
        this.datahorainicio = dados.datahorainicio();
        this.datahorafim = dados.datahorafim();
        this.container = dados.container();
    }

    public void atualizarInformacoes(DadosAtualizarMovimentacao dados) {
        if(dados.movimentacoes() != null){
            this.movimentacoes = dados.movimentacoes();
        }
        if (dados.datahorainicio() != null){
            this.datahorainicio = dados.datahorainicio();
        }

        if (dados.datahorafim() != null){
            this.datahorafim = dados.datahorafim();
        }

    }
}

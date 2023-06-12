package T2sTecnologia.Crud.Porto.domain.Container;


import T2sTecnologia.Crud.Porto.domain.Enums.Categoria;
import T2sTecnologia.Crud.Porto.domain.Enums.Movimentacoes;
import T2sTecnologia.Crud.Porto.domain.Enums.Status;
import T2sTecnologia.Crud.Porto.domain.Movimentacao.Movimentacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "container")
@Entity(name = "Container")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Container {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numero;
    private String tipo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("container")
    private List<Movimentacao> movimentacao;

    public Container(DadosCadastroContainer dados){
        this.nome = dados.nome();
        this.numero = dados.numero();
        this.tipo = dados.tipo();
        this.status = dados.status();
        this.categoria = dados.categoria();
        this.movimentacao = dados.movimentacao();

    }


    public void atualizarInformacoes(DadosAtualizarContainer dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.numero() != null){
         this.numero = dados.numero();
        }
        if(dados.tipo() != null){
            this.tipo = dados.tipo();
        }
        if(dados.status() != null){
            this.status = dados.status();
        }
        if(dados.categoria() != null){
            this.categoria = dados.categoria();
        }



    }
}

package T2sTecnologia.Crud.Porto.Controller;


import T2sTecnologia.Crud.Porto.domain.Movimentacao.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("movimentacao")
public class MovimentacaoControle {

    @Autowired
    private MovimentacaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroMovimentacao dados, UriComponentsBuilder uriBuilder){
        var movimentacao = new Movimentacao(dados);
        repository.save(movimentacao);
        var uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(movimentacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMovimentacao(movimentacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
       var movimentacao = repository.getReferenceById(id);
       return ResponseEntity.ok(new DadosDetalhamentoMovimentacao(movimentacao));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMovimentacao>> buscarTodos(@PageableDefault(size = 20)Pageable paginacao){

        var page = repository.findAll(paginacao).map(DadosListagemMovimentacao::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizarMovimentacao dados){

        var container = repository.getReferenceById(dados.id());
        container.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMovimentacao(container));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }



}

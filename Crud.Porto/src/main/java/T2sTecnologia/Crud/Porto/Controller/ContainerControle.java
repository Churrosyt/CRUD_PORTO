package T2sTecnologia.Crud.Porto.Controller;


import T2sTecnologia.Crud.Porto.domain.Container.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("container")
public class ContainerControle {

    @Autowired
    private ContainerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroContainer dados, UriComponentsBuilder uriBuilder){
        var container = new Container(dados);
        repository.save(container);
        var uri = uriBuilder.path("/container/{id}").buildAndExpand(container.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoContainer(container));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
       var container = repository.getReferenceById(id);
       return ResponseEntity.ok(new DadosDetalhamentoContainer(container));

    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Container>> getByname(@PathVariable String nome){
        return ResponseEntity.ok(repository.findByNome(nome));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemContainer>> buscarTodos(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){

        var page = repository.findAll(paginacao).map(DadosListagemContainer::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizarContainer dados){

        var container = repository.getReferenceById(dados.id());
        container.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoContainer(container));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }



}

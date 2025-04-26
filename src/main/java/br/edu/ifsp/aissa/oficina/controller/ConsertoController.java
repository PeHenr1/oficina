package br.edu.ifsp.aissa.oficina.controller;

import br.edu.ifsp.aissa.oficina.model.dto.DadosConserto;
import br.edu.ifsp.aissa.oficina.model.dto.DadosConsertoAtualizacao;
import br.edu.ifsp.aissa.oficina.model.dto.DadosConsertoDetalhado;
import br.edu.ifsp.aissa.oficina.model.dto.DadosConsertoResumo;
import br.edu.ifsp.aissa.oficina.model.entity.Conserto;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Optional;
import br.edu.ifsp.aissa.oficina.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<DadosConsertoDetalhado> cadastrar(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/cadastrar").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosConsertoDetalhado(conserto));
    }

    @PostMapping("/lote")
    public ResponseEntity<List<DadosConsertoDetalhado>> cadastrarLote(@RequestBody List<DadosConserto> dadosConsertos) {
        List<Conserto> consertos = new ArrayList<>();

        for (DadosConserto dados : dadosConsertos) {
            Conserto conserto = new Conserto(dados);
            consertos.add(conserto);
        }
        repository.saveAll(consertos);

        List<DadosConsertoDetalhado> resposta = new ArrayList<>();
        for (Conserto c : consertos) {
            resposta.add(new DadosConsertoDetalhado(c));
        }
        return ResponseEntity.ok(resposta);
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listarPaginado(Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosConsertoResumo>> listarResumo(){
        var pagina = repository.findAllByAtivoTrue().stream().map(DadosConsertoResumo::new).toList();
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosConsertoDetalhado> getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosConsertoDetalhado(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<DadosConsertoDetalhado> atualizar(@RequestBody @Valid DadosConsertoAtualizacao dados) {
        Optional<Conserto> consertoOptional = repository.findById(dados.id());

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            conserto.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosConsertoDetalhado(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            conserto.excluir();
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}


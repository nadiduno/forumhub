package com.forum.forumhub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.forumhub.topico.CadastrarDadosTopico;
import com.forum.forumhub.topico.DadosListagemTopico;
import com.forum.forumhub.topico.Topico;
import com.forum.forumhub.topico.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	 	@Autowired
	    private TopicoRepository repository;

	    @GetMapping
	    public List<DadosListagemTopico> listar() {
	        return repository.findAll().stream()
	                .map(DadosListagemTopico::new)
	                .collect(Collectors.toList());
	    }

	    @PostMapping
	    public ResponseEntity<CadastrarDadosTopico> cadastrar(@RequestBody CadastrarDadosTopico dados) {
	        Topico topico = new Topico(dados);
	        repository.save(topico);
	        return ResponseEntity.ok(dados);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody CadastrarDadosTopico dados) {
	        Optional<Topico> topicoExistente = repository.findById(id);
	        if (topicoExistente.isPresent()) {
	            Topico topico = topicoExistente.get();
	            topico.setTitulo(dados.titulo());
	            topico.setMensagem(dados.mensagem());
	            topico.setStatus(dados.status());
	            topico.setAutor(dados.autor());
	            topico.getCurso().setId(dados.idCurso()); //Atualiza o curso associado
	            repository.save(topico);
	            return ResponseEntity.ok(topico);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> excluir(@PathVariable Long id) {
	        Optional<Topico> topico = repository.findById(id);
	        if (topico.isPresent()) {
	            repository.deleteById(id);
	            return ResponseEntity.ok("Tópico excluído com sucesso.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Topico> buscarPorId(@PathVariable Long id) {
	        Optional<Topico> topico = repository.findById(id);
	        if (topico.isPresent()) {
	            return ResponseEntity.ok(topico.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}

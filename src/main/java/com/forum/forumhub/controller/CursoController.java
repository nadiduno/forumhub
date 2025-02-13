package com.forum.forumhub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
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

import com.forum.forumhub.curso.CadastrarDadosCurso;
import com.forum.forumhub.curso.Curso;
import com.forum.forumhub.curso.CursoRepository;
import com.forum.forumhub.curso.DadosListagemCurso;


import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
    private CursoRepository repository;
		
	
	 @GetMapping
	 public List<DadosListagemCurso> listar() {
	    return repository.findAll().stream()
	             .map(DadosListagemCurso::new)
	             .collect(Collectors.toList());
	    }
	
	 @GetMapping("/{id}") 
	 public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
	     Optional<Curso> curso = repository.findById(id);
	     if (curso.isPresent()) {
	         return ResponseEntity.ok(curso.get());
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	  }
	 
	 @PostMapping
	 @Transactional
	 public ResponseEntity<CadastrarDadosCurso> cadastrar(@RequestBody CadastrarDadosCurso dados) {
		 Curso curso = new Curso(dados);
	     repository.save(curso);
	     return ResponseEntity.ok(dados);
	 }
	
	 @PutMapping("/{id}")
	 @Transactional
	 public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody CadastrarDadosCurso dados) {
	     Optional<Curso> cursoExistente = repository.findById(id);
	     if (cursoExistente.isPresent()) {
	         Curso curso = cursoExistente.get();
	         curso.setNome(dados.nome());
	         curso.setCategoria(dados.categoria());
	         repository.save(curso);
	         return ResponseEntity.ok(curso); 
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	 }
	 
	 @DeleteMapping("/{id}")
	 @Transactional
	 public ResponseEntity<String> excluir(@PathVariable Long id) {
	     Optional<Curso> curso = repository.findById(id);

	     if (curso.isPresent()) {
	         repository.deleteById(id);
	         String message = String.format("Curso %d eliminado com sucesso", id);
	         //logger.info(message);
	         return ResponseEntity.ok(message); 
	     } else {
	         String errorMessage = String.format("Curso %d não encontrado", id);
	         //logger.warn(errorMessage);
	         return ResponseEntity.notFound().build(); 
	     }
	    }

	 
}

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

import com.forum.forumhub.perfil.CadastrarDadosPerfil;
import com.forum.forumhub.perfil.DadosListagemPerfil;
import com.forum.forumhub.perfil.Perfil;
import com.forum.forumhub.perfil.PerfilRepository;

@RestController
@RequestMapping("/perfis")
public class PerfilController {
	@Autowired
    private PerfilRepository repository;

    @GetMapping
    public List<DadosListagemPerfil> listar() {
        return repository.findAll().stream()
                .map(DadosListagemPerfil::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CadastrarDadosPerfil> cadastrar(@RequestBody CadastrarDadosPerfil dados) {
        Perfil perfil = new Perfil(dados);
        repository.save(perfil);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizar(@PathVariable Long id, @RequestBody CadastrarDadosPerfil dados) {
        Optional<Perfil> perfilExistente = repository.findById(id);
        if (perfilExistente.isPresent()) {
            Perfil perfil = perfilExistente.get();
            perfil.setNome(dados.nome());
            repository.save(perfil);
            return ResponseEntity.ok(perfil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        Optional<Perfil> perfil = repository.findById(id);
        if (perfil.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Perfil excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
        Optional<Perfil> perfil = repository.findById(id);
        if (perfil.isPresent()) {
            return ResponseEntity.ok(perfil.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

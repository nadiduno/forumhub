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

import com.forum.forumhub.perfil.Perfil;
import com.forum.forumhub.usuario.Usuario;
import com.forum.forumhub.usuarioPerfil.CadastrarDadosUsuarioPerfil;
import com.forum.forumhub.usuarioPerfil.DadosListagemUsuarioPerfil;
import com.forum.forumhub.usuarioPerfil.UsuarioPerfil;
import com.forum.forumhub.usuarioPerfil.UsuarioPerfilRepository;

@RestController
@RequestMapping("/usuarioPerfis")
public class UsuarioPerfilController {
	@Autowired
    private UsuarioPerfilRepository repository;

    @GetMapping
    public List<DadosListagemUsuarioPerfil> listar() {
        return repository.findAll().stream()
                .map(DadosListagemUsuarioPerfil::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CadastrarDadosUsuarioPerfil> cadastrar(@RequestBody CadastrarDadosUsuarioPerfil dados) {
        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
        Perfil perfil = new Perfil();
        perfil.setId(dados.idPerfil());
        usuarioPerfil.setPerfil(perfil);
        Usuario usuario = new Usuario();
        usuario.setId(dados.idUsuario());
        usuarioPerfil.setUsuario(usuario);
        repository.save(usuarioPerfil);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPerfil> atualizar(@PathVariable Long id, @RequestBody CadastrarDadosUsuarioPerfil dados) {
        Optional<UsuarioPerfil> usuarioPerfilExistente = repository.findById(id);
        if (usuarioPerfilExistente.isPresent()) {
            UsuarioPerfil usuarioPerfil = usuarioPerfilExistente.get();
            Perfil perfil = new Perfil();
            perfil.setId(dados.idPerfil());
            usuarioPerfil.setPerfil(perfil);
            Usuario usuario = new Usuario();
            usuario.setId(dados.idUsuario());
            usuarioPerfil.setUsuario(usuario);
            repository.save(usuarioPerfil);
            return ResponseEntity.ok(usuarioPerfil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        Optional<UsuarioPerfil> usuarioPerfil = repository.findById(id);
        if (usuarioPerfil.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Associação excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioPerfil> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioPerfil> usuarioPerfil = repository.findById(id);
        if (usuarioPerfil.isPresent()) {
            return ResponseEntity.ok(usuarioPerfil.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

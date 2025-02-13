package com.forum.forumhub.curso;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosListagemCurso(Long id, String nome, String categoria) {
	@JsonIgnore
	public DadosListagemCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
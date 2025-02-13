package com.forum.forumhub.perfil;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosListagemPerfil(Long id, String nome) {
	@JsonIgnore
	public DadosListagemPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getNome());
    }
}

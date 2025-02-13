package com.forum.forumhub.usuarioPerfil;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosListagemUsuarioPerfil(Long id, Long idPerfil, Long idUsuario) {
	@JsonIgnore
	public DadosListagemUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
        this(usuarioPerfil.getId(), usuarioPerfil.getPerfil().getId(), usuarioPerfil.getUsuario().getId());
    }
}

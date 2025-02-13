package com.forum.forumhub.resposta;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosListagemResposta(Long id, String mensagem, Date dataCriacao, boolean solucao, Long idTopico, Long idUsuario) {
	@JsonIgnore
	public DadosListagemResposta(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.isSolucao(), resposta.getTopico().getId(), resposta.getUsuario().getId());
    }
}

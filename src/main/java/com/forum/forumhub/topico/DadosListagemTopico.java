package com.forum.forumhub.topico;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record DadosListagemTopico(Long id, String titulo, String mensagem, Date dataCriacao, int status, String autor, Long idCurso) {
	@JsonIgnore
	public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso().getId());
    }
}

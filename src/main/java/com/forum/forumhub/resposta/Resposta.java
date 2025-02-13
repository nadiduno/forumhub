package com.forum.forumhub.resposta;

import java.util.Date;

import com.forum.forumhub.topico.Topico;
import com.forum.forumhub.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "resposta")
@Entity(name = "Resposta")
public class Resposta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private Date dataCriacao;
    private boolean solucao; 

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Resposta() {}
    public Resposta(CadastrarDadosResposta dados) {
        this.mensagem = dados.mensagem();
        this.dataCriacao = new Date(); 
        this.solucao = dados.solucao();
        this.topico = new Topico();
        this.topico.setId(dados.idTopico()); // Associa a resposta ao tópico pelo ID
        this.usuario = new Usuario();
        this.usuario.setId(dados.idUsuario()); // Associa a resposta ao usuário pelo ID
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isSolucao() {
        return solucao;
    }

    public void setSolucao(boolean solucao) {
        this.solucao = solucao;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

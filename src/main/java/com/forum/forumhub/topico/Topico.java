package com.forum.forumhub.topico;

import java.util.Date;
import java.util.List;

import com.forum.forumhub.curso.Curso;
import com.forum.forumhub.resposta.Resposta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "topico")
@Entity(name = "Topico")
public class Topico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private Date dataCriacao;
    private int status;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico() {}

    public Topico(CadastrarDadosTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = new Date(); 
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = new Curso();
        this.curso.setId(dados.idCurso()); 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
    	this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    


    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}

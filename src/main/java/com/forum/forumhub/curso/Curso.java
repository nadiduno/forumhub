package com.forum.forumhub.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "curso")
@Entity(name = "Curso")
public class Curso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    
    //Construtor para JPA
    public Curso() {}

    
    //Construtor para o record
    public Curso(CadastrarDadosCurso dados) {
    	this.nome = dados.nome();
        this.categoria = dados.categoria();
	}
	
    //Getters 
    
    public Long getId() { 
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
	
    //Setters 
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

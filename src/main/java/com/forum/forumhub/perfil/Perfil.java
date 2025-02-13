package com.forum.forumhub.perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "perfil")
@Entity(name = "Perfil")
public class Perfil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

   public Perfil() {}

    public Perfil(CadastrarDadosPerfil dados) {
        this.nome = dados.nome();
    }

    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

}

package com.forum.forumhub.usuario;

import java.util.List;

import com.forum.forumhub.auth.Auth;
import com.forum.forumhub.usuarioPerfil.UsuarioPerfil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "usuario")
@Entity(name = "Usuario")
public class Usuario {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;
	    private String email;

	    @OneToMany(mappedBy = "usuario")
	    private List<UsuarioPerfil> usuarioPerfis;
	    
	    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL) 
	    private Auth auth;

	    public Usuario() {}

	    public Usuario(CadastrarDadosUsuario dados) {
	        this.nome = dados.nome();
	        this.email = dados.email();
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    
	    public List<UsuarioPerfil> getUsuarioPerfis() {
	        return usuarioPerfis;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }


	    public void setUsuarioPerfis(List<UsuarioPerfil> usuarioPerfis) {
	        this.usuarioPerfis = usuarioPerfis;
	    }
	    
	    public void setAuth(Auth auth) {
	        this.auth = auth;
	    }
}

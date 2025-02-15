package com.forum.forumhub.auth;

import com.forum.forumhub.usuario.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "auth")
public class Auth {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String login;

	    private String senha;

	    @OneToOne
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;
}

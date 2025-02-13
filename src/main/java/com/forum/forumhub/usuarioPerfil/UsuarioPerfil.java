package com.forum.forumhub.usuarioPerfil;

import com.forum.forumhub.perfil.Perfil;
import com.forum.forumhub.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "usuarioPerfil")
@Entity(name = "UsuarioPerfil")
public class UsuarioPerfil {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_perfil") 
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

   
    public UsuarioPerfil() {}

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

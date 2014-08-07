package com.rafabene.demos.deltaspike.dominio.servicos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;
import com.rafabene.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;
import com.rafabene.demos.deltaspike.infraestrutura.exceptions.UsuarioJaCadastradoException;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private RepositorioUsuarios repositorioUsuarios;
    
    @Inject
    private ApplicationMessages applicationMessages;

    public void criarLogin(Usuario usuario) throws UsuarioJaCadastradoException {
        try {
            repositorioUsuarios.save(usuario);
            repositorioUsuarios.flush();
        } catch (PersistenceException e) {
            throw new UsuarioJaCadastradoException(applicationMessages.usuarioJaCadastrado());
        }
    }
}

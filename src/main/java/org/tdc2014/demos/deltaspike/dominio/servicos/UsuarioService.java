package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;
import org.tdc2014.demos.deltaspike.infraestrutura.exceptions.UsuarioJaCadastradoException;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

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

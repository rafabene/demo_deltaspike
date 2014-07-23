package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;

public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    public void criarLogin(Usuario usuario) throws UsuarioJaCadastradoException {
        try {
            repositorioUsuarios.save(usuario);
            repositorioUsuarios.flush();
        } catch (PersistenceException e) {
            throw new UsuarioJaCadastradoException();
        }
    }
}

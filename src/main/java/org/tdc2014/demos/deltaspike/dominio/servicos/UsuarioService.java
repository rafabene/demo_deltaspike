package org.tdc2014.demos.deltaspike.dominio.servicos;

import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;

public class UsuarioService {

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    public void criarLogin(Usuario usuario) {
        repositorioUsuarios.save(usuario);
    }

}

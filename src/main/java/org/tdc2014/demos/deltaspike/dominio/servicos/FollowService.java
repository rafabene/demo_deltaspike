package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.util.List;

import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.Logged;

public class FollowService {

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    @Inject
    @Logged
    private Usuario usuarioLogado;

    public List<Usuario> obterListaUsuarios() {
        Usuario usuario = repositorioUsuarios.findBy(usuarioLogado.getId());
        List<Usuario> usuarios = repositorioUsuarios.findAll();
        // Remove os usuários que já são seguidos
        usuarios.removeAll(usuario.getSeguidos());
        // Remove o usário logado da lista
        usuarios.remove(usuario);
        return usuarios;
    }

    public void seguirUsuario(Usuario seguido) {
        Usuario usuario = repositorioUsuarios.findBy(usuarioLogado.getId());
        usuario.getSeguidos().add(seguido);
        repositorioUsuarios.save(usuario);
        repositorioUsuarios.flush();
    }

}

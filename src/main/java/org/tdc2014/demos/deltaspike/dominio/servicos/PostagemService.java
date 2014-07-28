package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Postagem;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioPostagens;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;

public class PostagemService {

    @Inject
    private RepositorioPostagens repositorioPostagens;

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    public List<Postagem> getTimeLine(Usuario usuario) {
        Usuario managedUser = repositorioUsuarios.findBy(usuario.getId());
        List<Usuario> seguidos = managedUser.getSeguidos();
        // Adiciona o proprio usuario como seguido
        seguidos.add(usuario);
        return repositorioPostagens.findBySeguidos(seguidos);
    }

    public void postarMensagem(Usuario usuario, Postagem postagem) {
        Usuario managedUser = repositorioUsuarios.findBy(usuario.getId());
        postagem.setDatetime(new Date());
        postagem.setAutor(managedUser);
        repositorioPostagens.saveAndFlush(postagem);
    }
}

package org.tdc2014.demos.deltaspike.aplicacao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.aplicacao.Pages.ListUsuarios;
import org.tdc2014.demos.deltaspike.aplicacao.Pages.PostarMensagem;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.servicos.FollowService;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

@Model
public class FollowBean {

    @Inject
    private FollowService followService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ApplicationMessages applicationMessages;

    public Class<ListUsuarios> irParaListUsuarios() {
        return ListUsuarios.class;
    }

    public List<Usuario> listaUsuarios() {
        return followService.obterListaUsuarios();
    }

    public void seguirUsuario(Usuario usuario) {
        followService.seguirUsuario(usuario);
        facesContext.addMessage(null, new FacesMessage(applicationMessages.seguindoUsuario(usuario.getUsername())));
    }

    public Class<PostarMensagem> telaPostarMensagem() {
        return PostarMensagem.class;
    }
}

package com.rafabene.demos.deltaspike.aplicacao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.rafabene.demos.deltaspike.aplicacao.Pages.ListUsuarios;
import com.rafabene.demos.deltaspike.aplicacao.Pages.PostarMensagem;
import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;
import com.rafabene.demos.deltaspike.dominio.servicos.FollowService;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

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

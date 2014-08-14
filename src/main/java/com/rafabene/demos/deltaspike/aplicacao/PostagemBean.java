package com.rafabene.demos.deltaspike.aplicacao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.rafabene.demos.deltaspike.dominio.entidades.Postagem;
import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;
import com.rafabene.demos.deltaspike.dominio.servicos.PostagemService;
import com.rafabene.demos.deltaspike.dominio.servicos.partial.PrePostagemService;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.Messages;
import com.rafabene.demos.deltaspike.infraestrutura.seguranca.Logged;

@Model
public class PostagemBean {

    @Inject
    private Postagem postagem;

    @Inject
    private PostagemService postagemService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Messages applicationMessages;

    @Inject
    @Logged
    private Usuario usuarioLogado;

    @Inject
    private PrePostagemService prePostagemService;

    public Postagem getPostagem() {
        return postagem;
    }

    public void postarMensage() {
        prePostagemService.executePrePostagem(postagem.getMensagem());
        facesContext.addMessage(null, new FacesMessage(applicationMessages.mensagemPublicada()));
        postagemService.postarMensagem(usuarioLogado, postagem);
        postagem = new Postagem();
    }

    public List<Postagem> getTimeline() {
        return postagemService.getTimeLine(usuarioLogado);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}

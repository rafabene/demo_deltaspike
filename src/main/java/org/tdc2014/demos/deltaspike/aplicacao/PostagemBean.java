package org.tdc2014.demos.deltaspike.aplicacao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Postagem;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.servicos.PostagemService;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.Logged;

@Model
public class PostagemBean {

    @Inject
    private Postagem postagem;

    @Inject
    private PostagemService postagemService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ApplicationMessages applicationMessages;

    @Inject
    @Logged
    private Usuario usuarioLogado;

    public Postagem getPostagem() {
        return postagem;
    }

    public void postarMensage() {
        facesContext.addMessage(null, new FacesMessage(applicationMessages.mensagemPublicada()));
        postagemService.postarMensagem(usuarioLogado, postagem);
        postagem = new Postagem();
    }

    public List<Postagem> getTimeline() {
        return postagemService.getTimeLine(usuarioLogado);
    }

}

package org.tdc2014.demos.deltaspike.aplicacao;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Postagem;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

@Model
public class PostagemBean {

    @Inject
    private Postagem postagem;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ApplicationMessages applicationMessages;

    public Postagem getPostagem() {
        return postagem;
    }

    public void postarMensage() {
        facesContext.addMessage(null, new FacesMessage(applicationMessages.mensagemPublicada()));
        postagem = new Postagem();
    }

}

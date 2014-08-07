package com.rafabene.demos.deltaspike.aplicacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.apache.deltaspike.core.api.scope.WindowScoped;

import com.rafabene.demos.deltaspike.aplicacao.Pages.CriarUsuario;
import com.rafabene.demos.deltaspike.aplicacao.Pages.PostarMensagem;
import com.rafabene.demos.deltaspike.aplicacao.Pages.Welcome;
import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;
import com.rafabene.demos.deltaspike.dominio.servicos.LoginService;
import com.rafabene.demos.deltaspike.dominio.servicos.UsuarioService;
import com.rafabene.demos.deltaspike.infraestrutura.exceptions.UsuarioJaCadastradoException;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.Messages;
import com.rafabene.demos.deltaspike.infraestrutura.seguranca.Logged;

@Named
@WindowScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Usuario usuario;

    @Inject
    private LoginService loginService;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;

    @Inject
    private ViewNavigationHandler viewNavigationHandler;
    
    @Inject
    private Messages applicationMessages;
  
    public Usuario getUsuario() {
        return usuario;
    }

    // type-safe outcome
    public Class<PostarMensagem> login() {
        this.usuario = loginService.login(usuario.getUsername(), usuario.getPassword());
        return PostarMensagem.class;

    }

    // type-safe outcome
    public Class<CriarUsuario> telaCriarUsuario() {
        return CriarUsuario.class;
    }

    // type-safe outcome
    public void telaHome() {
        viewNavigationHandler.navigateTo(Welcome.class);
    }

    public Class<Welcome> logoff() {
        this.usuario = new Usuario();
        return Welcome.class;
    }

    // outcome via viewNavigation Handler
    public void registrarUsuario() {
        try {
            usuarioService.criarLogin(usuario);
            facesContext.addMessage(null, new FacesMessage(applicationMessages.usuarioCriadoSucesso()));
            telaHome();
        } catch (UsuarioJaCadastradoException e) {
            catchEvent.fire(new ExceptionToCatchEvent(e));
        }
    }

    @Produces
    @RequestScoped
    @Logged
    public Usuario getUsuarioLogado() {
        return this.usuario;
    }
    
}

package org.tdc2014.demos.deltaspike.aplicacao;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.tdc2014.demos.deltaspike.aplicacao.ApplicationViewConfig.CriarUsuario;
import org.tdc2014.demos.deltaspike.aplicacao.ApplicationViewConfig.PostarMensagem;
import org.tdc2014.demos.deltaspike.aplicacao.ApplicationViewConfig.Welcome;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.servicos.LoginService;
import org.tdc2014.demos.deltaspike.dominio.servicos.UsuarioJaCadastradoException;
import org.tdc2014.demos.deltaspike.dominio.servicos.UsuarioService;
import org.tdc2014.demos.deltaspike.infrastrutura.Logado;

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

    // outcome via viewNavigation Handler
    public void registrarUsuario() {
        try {
            usuarioService.criarLogin(usuario);
            facesContext.addMessage(null, new FacesMessage("Usuário criado com sucesso!"));
            telaHome();
        } catch (UsuarioJaCadastradoException e) {
            catchEvent.fire(new ExceptionToCatchEvent(e));
        }
    }

    @Produces
    @Logado
    public Usuario getUsuarioLogado() {
        return this.usuario;
    }
}

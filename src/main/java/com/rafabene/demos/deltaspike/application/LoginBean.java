package com.rafabene.demos.deltaspike.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import com.rafabene.demos.deltaspike.application.Pages.CreateUser;
import com.rafabene.demos.deltaspike.application.Pages.Welcome;
import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.services.LoginService;
import com.rafabene.demos.deltaspike.domain.services.UsuarioService;
import com.rafabene.demos.deltaspike.infra.exceptions.UsuarioJaCadastradoException;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;
import com.rafabene.demos.deltaspike.infra.security.Logged;

@Named
@WindowScoped
public class LoginBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Inject
    private User user;

    @Inject
    private LoginService loginService;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private JsfMessage<Messages> messages;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;

    @Inject
    private ViewNavigationHandler viewNavigationHandler;

    public User getUser()
    {
        return user;
    }

    // type-safe outcome
    public Class<? extends ViewConfig> login()
    {
        User usuarioLogado = loginService.login(user.getUsername(), user.getPassword());
        // Fica na própria página
        if (usuarioLogado == null)
        {
            return Pages.Welcome.class;
        }
        this.user = usuarioLogado;
        // If user is logged in, handle the navigation do AuthenticationListener
        return null;
    }

    // type-safe outcome
    public Class<CreateUser> gotoCreateUserScreen()
    {
        return CreateUser.class;
    }

    // type-safe outcome
    public void gotoWelcomeScreen()
    {
        viewNavigationHandler.navigateTo(Welcome.class);
    }

    public Class<Welcome> logoff()
    {
        this.user = new User();
        return Welcome.class;
    }

    // outcome via viewNavigation Handler
    public void registerUser()
    {
        try
        {
            usuarioService.criarLogin(user);
            messages.addInfo().userCreatedSuccess();
            gotoWelcomeScreen();
        }
        catch (UsuarioJaCadastradoException e)
        {
            catchEvent.fire(new ExceptionToCatchEvent(e));
        }
    }

    @Produces
    @RequestScoped
    @Logged
    public User getLoggedUser()
    {
        return this.user;
    }

}

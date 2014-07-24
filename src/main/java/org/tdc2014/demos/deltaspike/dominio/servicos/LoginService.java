package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

public class LoginService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;
    
    @Inject
    private ApplicationMessages applicationMessages;

    public Usuario login(String username, char[] password) {
        try {
            Usuario usuario = repositorioUsuarios.findByUsernameAndPassword(username, password);
            return usuario;
        } catch (NoResultException e) {
            // O tratamento de exception é delegado para os @ExceptionHandlers
            catchEvent.fire(new ExceptionToCatchEvent(new Throwable(applicationMessages.acessoNegado())));
        }
        return null;
    }

}

package org.tdc2014.demos.deltaspike.dominio.servicos;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;

public class LoginService {

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;

    public Usuario login(String username, char[] password) {
        try {
            Usuario usuario = repositorioUsuarios.findByUsernameAndPassword(username, password);
            return usuario;
        } catch (NoResultException e) {
            // O tratamento de exception é delegado para os @ExceptionHandlers
            catchEvent.fire(new ExceptionToCatchEvent(new Throwable("Acesso Negado!")));
        }
        return null;
    }

}

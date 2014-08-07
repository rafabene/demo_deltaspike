package com.rafabene.demos.deltaspike.dominio.servicos;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;

import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;
import com.rafabene.demos.deltaspike.dominio.repositorios.RepositorioUsuarios;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.Messages;
import com.rafabene.demos.deltaspike.infraestrutura.seguranca.UsuarioLogadoEvent;

public class LoginService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RepositorioUsuarios repositorioUsuarios;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;
    
    @Inject
    private Event<UsuarioLogadoEvent> usuarioLogadoEvent; 
    
    @Inject
    private Messages applicationMessages;

    public Usuario login(String username, char[] password) {
        try {
            Usuario usuario = repositorioUsuarios.findByUsernameAndPassword(username, password);
            //Dispara o evento de usuário logado
            usuarioLogadoEvent.fire(new UsuarioLogadoEvent());
            return usuario;
        } catch (NoResultException e) {
            // O tratamento de exception é delegado para os @ExceptionHandlers
            catchEvent.fire(new ExceptionToCatchEvent(new Throwable(applicationMessages.acessoNegado())));
        }
        return null;
    }

}

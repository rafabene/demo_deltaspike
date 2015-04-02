package com.rafabene.demos.deltaspike.domain.services;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;

import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.repositories.UsersRepository;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;
import com.rafabene.demos.deltaspike.infra.security.UserLoggedInEvent;

public class LoginService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;
    
    @Inject
    private Event<UserLoggedInEvent> loggedUserEvent; 
    
    @Inject
    private Messages applicationMessages;

    public User login(String username, char[] password) {
        try {
            User usuario = usersRepository.findByUsernameAndPassword(username, password);
            //fire the event about logged in user
            loggedUserEvent.fire(new UserLoggedInEvent());
            return usuario;
        } catch (NoResultException e) {
            // The exception handling is delegated to the @ExceptionHandlers
            catchEvent.fire(new ExceptionToCatchEvent(new Throwable(applicationMessages.accessDenied())));
            return null;
        }
    }

}

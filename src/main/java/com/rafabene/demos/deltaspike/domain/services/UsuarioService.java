package com.rafabene.demos.deltaspike.domain.services;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.repositories.UsersRepository;
import com.rafabene.demos.deltaspike.infra.exceptions.UsuarioJaCadastradoException;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;

public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsersRepository repositorioUsuarios;
    
    @Inject
    private Messages applicationMessages;

    public void criarLogin(User usuario) throws UsuarioJaCadastradoException {
        try {
            repositorioUsuarios.save(usuario);
            repositorioUsuarios.flush();
        } catch (PersistenceException e) {
            throw new UsuarioJaCadastradoException(applicationMessages.userAlreadyRegistered());
        }
    }
}

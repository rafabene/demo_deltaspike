package com.rafabene.demos.deltaspike.domain.services;

import java.util.List;

import javax.inject.Inject;

import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.repositories.UsersRepository;
import com.rafabene.demos.deltaspike.infra.security.Logged;

public class FollowService {

    @Inject
    private UsersRepository usersRepository;

    @Inject
    @Logged
    private User loggedUser;

    public List<User> getUsersList() {
        User managedLoggedUser = usersRepository.findBy(loggedUser.getId());
        List<User> usuarios = usersRepository.findAll();
        // Remove the users that is already being followed
        usuarios.removeAll(managedLoggedUser.getFolloweds());
        // remove the user himself from the list
        usuarios.remove(managedLoggedUser);
        return usuarios;
    }

    public void followUser(User followed) {
        User usuario = usersRepository.findBy(loggedUser.getId());
        usuario.getFolloweds().add(followed);
        usersRepository.saveAndFlush(usuario);
    }

}

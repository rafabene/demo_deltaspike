package com.rafabene.demos.deltaspike.application;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.deltaspike.jsf.api.message.JsfMessage;

import com.rafabene.demos.deltaspike.application.Pages.ListUsers;
import com.rafabene.demos.deltaspike.application.Pages.PostMessage;
import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.services.FollowService;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;

@Model
public class FollowBean
{

    @Inject
    private FollowService followService;

    @Inject
    private JsfMessage<Messages> messages;

    public Class<ListUsers> gotoListUsers()
    {
        return ListUsers.class;
    }

    public List<User> listUsers()
    {
        return followService.getUsersList();
    }

    public void followUser(User usuario)
    {
        followService.followUser(usuario);
        messages.addInfo().followingUser(usuario.getUsername());
    }

    public Class<PostMessage> gotoPostMessage()
    {
        return PostMessage.class;
    }
}

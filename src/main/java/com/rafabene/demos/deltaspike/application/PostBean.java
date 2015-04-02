package com.rafabene.demos.deltaspike.application;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.deltaspike.jsf.api.message.JsfMessage;

import com.rafabene.demos.deltaspike.domain.entities.Post;
import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.services.PostService;
import com.rafabene.demos.deltaspike.domain.services.partial.PrePostService;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;
import com.rafabene.demos.deltaspike.infra.security.Logged;

@Model
public class PostBean
{

    @Inject
    private Post post;

    @Inject
    private PostService postService;

    @Inject
    private JsfMessage<Messages> messages;

    @Inject
    @Logged
    private User loggedUser;

    @Inject
    private PrePostService prePostService;

    public Post getPost()
    {
        return post;
    }

    public void postMessage()
    {
        prePostService.executePrePost(post.getMessage());
        messages.addInfo().messagePublished();
        postService.postMessage(loggedUser, post);
        post = new Post();
    }

    public List<Post> getTimeline()
    {
        return postService.getTimeLine(loggedUser);
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }
}

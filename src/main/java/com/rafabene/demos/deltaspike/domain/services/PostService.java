package com.rafabene.demos.deltaspike.domain.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.rafabene.demos.deltaspike.domain.entities.Post;
import com.rafabene.demos.deltaspike.domain.entities.User;
import com.rafabene.demos.deltaspike.domain.repositories.PostRepository;
import com.rafabene.demos.deltaspike.domain.repositories.UsersRepository;

public class PostService {

    @Inject
    private PostRepository postRepository;

    @Inject
    private UsersRepository userRepository;

    public List<Post> getTimeLine(User user) {
        User managedUser = userRepository.findBy(user.getId());
        List<User> following = managedUser.getFolloweds();
        // Add the user himself as a following 
        following.add(managedUser);
        return postRepository.findByFollowingUsers(following);
    }

    public void postMessage(User user, Post post) {
        User managedUser = userRepository.findBy(user.getId());
        post.setDatetime(new Date());
        post.setAuthor(managedUser);
        postRepository.saveAndFlush(post);
    }
}

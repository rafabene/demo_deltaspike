package com.rafabene.demos.deltaspike.domain.repositories;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.rafabene.demos.deltaspike.domain.entities.Post;
import com.rafabene.demos.deltaspike.domain.entities.User;

@Repository
public interface PostRepository extends EntityRepository<Post, Long> {
    
    
    @Query("SELECT p FROM Post AS p WHERE p.author in (?1)")
    public List<Post> findByFollowingUsers(List<User> followingUsers);

}

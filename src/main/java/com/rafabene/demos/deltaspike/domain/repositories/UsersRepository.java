package com.rafabene.demos.deltaspike.domain.repositories;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.rafabene.demos.deltaspike.domain.entities.User;

@Repository
public interface UsersRepository extends EntityRepository<User, Long>
{

    // method signature creates the query
    public User findByUsernameAndPassword(String username, char[] password);

}

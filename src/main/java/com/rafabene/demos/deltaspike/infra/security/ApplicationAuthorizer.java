package com.rafabene.demos.deltaspike.infra.security;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.interceptor.InvocationContext;

import org.apache.deltaspike.security.api.authorization.Secures;

import com.rafabene.demos.deltaspike.domain.entities.User;

@ApplicationScoped
public class ApplicationAuthorizer
{
    @Secures
    @AdminOnly
    public boolean verificaPermissao(InvocationContext invocationContext, BeanManager manager, @Logged User usuario) throws Exception
    {
        return usuario.getRole().equalsIgnoreCase("Admin");
    }
}
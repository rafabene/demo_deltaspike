package org.tdc2014.demos.deltaspike.infraestrutura.seguranca;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.interceptor.InvocationContext;

import org.apache.deltaspike.security.api.authorization.Secures;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;

@ApplicationScoped
public class ApplicationAuthorizer
{
    @Secures
    @AdminOnly
    public boolean verificaPermissao(InvocationContext invocationContext, BeanManager manager, @Logado Usuario usuario) throws Exception
    {
        return usuario.getRole().equalsIgnoreCase("Admin");
    }
}
package com.rafabene.demos.deltaspike.domain.services.partial;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.enterprise.context.Dependent;

@PrePostBinding
@Dependent
public class PrePostHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("This is a Partial-Bean implementation\n"
            + "The invoked method was " + method.getName() + " using the follogin parameter " + args[0]);
        return null;
    }

}

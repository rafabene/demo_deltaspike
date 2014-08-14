package com.rafabene.demos.deltaspike.dominio.servicos.partial;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.enterprise.context.Dependent;

@PrePostagemBinding
@Dependent
public class PrePostagemHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Esta é uma impementação de Partial Bean da classe\n"
            + "O método invocado foi " + method.getName() + "com o valor " + args[0]);
        return null;
    }

}

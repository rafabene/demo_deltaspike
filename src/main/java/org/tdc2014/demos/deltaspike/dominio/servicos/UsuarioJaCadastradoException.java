package org.tdc2014.demos.deltaspike.dominio.servicos;

public class UsuarioJaCadastradoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public UsuarioJaCadastradoException() {
        super("Já existe um usuário com este login!");
    }

}

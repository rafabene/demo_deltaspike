package com.rafabene.demos.deltaspike.dominio.repositorios;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;

@Repository
public interface RepositorioUsuarios extends EntityRepository<Usuario, Long> {

    // O próprio nome do método cria o SQL
    public Usuario findByUsernameAndPassword(String username, char[] password);
    
}

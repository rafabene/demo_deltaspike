package org.tdc2014.demos.deltaspike.dominio.repositorios;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;

@Repository
public interface RepositorioUsuarios extends EntityRepository<Usuario, Long> {

    // O próprio nome do método criar o SQL
    public Usuario findByUsernameAndPassword(String username, char[] password);
}

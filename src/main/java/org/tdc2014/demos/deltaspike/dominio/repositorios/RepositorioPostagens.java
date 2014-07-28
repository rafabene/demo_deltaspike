package org.tdc2014.demos.deltaspike.dominio.repositorios;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.tdc2014.demos.deltaspike.dominio.entidades.Postagem;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;

@Repository
public interface RepositorioPostagens extends EntityRepository<Postagem, Long> {
    
    
    @Query("SELECT p FROM Postagem AS p WHERE p.autor in (?1)")
    public List<Postagem> findBySeguidos(List<Usuario> usuariosSeguidos);

}

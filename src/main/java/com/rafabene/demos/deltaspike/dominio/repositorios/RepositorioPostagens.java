package com.rafabene.demos.deltaspike.dominio.repositorios;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.rafabene.demos.deltaspike.dominio.entidades.Postagem;
import com.rafabene.demos.deltaspike.dominio.entidades.Usuario;

@Repository
public interface RepositorioPostagens extends EntityRepository<Postagem, Long> {
    
    
    @Query("SELECT p FROM Postagem AS p WHERE p.autor in (?1)")
    public List<Postagem> findBySeguidos(List<Usuario> usuariosSeguidos);

}

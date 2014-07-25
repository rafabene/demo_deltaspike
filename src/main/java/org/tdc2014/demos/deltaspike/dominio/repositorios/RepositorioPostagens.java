package org.tdc2014.demos.deltaspike.dominio.repositorios;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.tdc2014.demos.deltaspike.dominio.entidades.Postagem;

@Repository
public interface RepositorioPostagens extends EntityRepository<Postagem, Long> {

}

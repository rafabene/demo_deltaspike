package com.rafabene.demos.deltaspike.dominio.servicos.partial;

/**
 * A implementação desta interface acontece através da Portial-bean do DeltaSpike Através da anotação {@link PrePostagemBinding}
 * 
 * @author rafaelbenevides
 *
 */
@PrePostagemBinding
public interface PrePostagemService {

    public void executePrePostagem(Object value);

}

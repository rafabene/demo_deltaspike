package com.rafabene.demos.deltaspike.domain.services.partial;

/**
 * 
 * This interface implementation happens though the DeltaSpike Partial-Bean via {@link PrePostBinding}
 * A implementação desta interface acontece através da Portial-bean do DeltaSpike Através da anotação {@link PrePostBinding}
 * 
 * @author rafaelbenevides
 *
 */
@PrePostBinding
public interface PrePostService {

    public void executePrePost(String message);

}

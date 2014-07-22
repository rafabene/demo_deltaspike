package org.tdc2014.demos.deltaspike.dominio.entidades;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public abstract T getId();

}

package org.tdc2014.demos.deltaspike.dominio.entidades;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    public abstract T getId();

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}

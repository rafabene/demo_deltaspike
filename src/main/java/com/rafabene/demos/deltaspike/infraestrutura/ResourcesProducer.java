package com.rafabene.demos.deltaspike.infraestrutura;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.quartz.Job;

public class ResourcesProducer {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    @Produces
    public Logger createLogger() {
        return Logger.getLogger("Demo TDC 2014");
    }

    @Produces
    @ApplicationScoped
    protected Scheduler<Job> produceScheduler(Scheduler<Job> scheduler)
    {
        return scheduler;
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}

package com.rafabene.demos.deltaspike.infra;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
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
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
    
    @Produces
    @RequestScoped
    public FacesContext produceFacesContext(){
        return FacesContext.getCurrentInstance();
    }

    @Produces
    @ApplicationScoped
    @SuppressWarnings({"unchecked", "rawtypes", "cdi-ambiguous-dependency"})
    public Scheduler<Job> produceScheduler(Scheduler scheduler)
    {
        return scheduler;
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}

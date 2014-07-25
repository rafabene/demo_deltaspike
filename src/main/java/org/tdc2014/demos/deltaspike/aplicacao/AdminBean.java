package org.tdc2014.demos.deltaspike.aplicacao;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.quartz.Job;
import org.tdc2014.demos.deltaspike.dominio.servicos.CdiAwareQuartzJob;
import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.AdminOnly;

@Model
public class AdminBean {

    @Inject
    private FacesContext facesContext;

    @Inject
    private ApplicationMessages applicationMessages;

    @Inject
    private Scheduler<Job> jobScheduler;

    // Demonstra um tipo de tarefa que apenas um administrador pode fazer
    @AdminOnly
    public void iniciarTarefaAdministrativa() {
        jobScheduler.registerNewJob(CdiAwareQuartzJob.class);
        facesContext.addMessage(null, new FacesMessage(applicationMessages.tarefaAdminstrativaAgendada()));
    }

}

package com.rafabene.demos.deltaspike.aplicacao;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.quartz.Job;

import com.rafabene.demos.deltaspike.dominio.servicos.CdiAwareQuartzJob;
import com.rafabene.demos.deltaspike.infraestrutura.i18n.Messages;
import com.rafabene.demos.deltaspike.infraestrutura.seguranca.AdminOnly;

@Model
public class AdminBean {

    @Inject
    private FacesContext facesContext;

    @Inject
    private Messages applicationMessages;

    @Inject
    private Scheduler<Job> jobScheduler;

    // Demonstra um tipo de tarefa que apenas um administrador pode fazer
    @AdminOnly
    public void iniciarTarefaAdministrativa() {
        jobScheduler.registerNewJob(CdiAwareQuartzJob.class);
        facesContext.addMessage(null, new FacesMessage(applicationMessages.tarefaAdminstrativaAgendada()));
    }

}

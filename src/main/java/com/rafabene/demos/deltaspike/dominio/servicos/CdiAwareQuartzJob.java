package com.rafabene.demos.deltaspike.dominio.servicos;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.deltaspike.scheduler.api.Scheduled;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.rafabene.demos.deltaspike.infraestrutura.i18n.Messages;

//Job de exemplo agendado para rodar a cada 1 minuto
@Scheduled(cronExpression = "0 0/1 * * * ?", onStartup = false)
public class CdiAwareQuartzJob implements org.quartz.Job {

    private static int execution = 0;

    // O Job permite injeção CDI
    @Inject
    private AdminService service;
    
    @Inject
    private Messages applicationMessages;
    
    @Inject
    private Logger logger;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        service.executarRotinasAdministrativas();
        //remove registro do Job depois de 3 execuções 
        execution++;
        if (execution == 3) {
            try {
                context.getScheduler().unscheduleJob(context.getTrigger().getKey());
                logger.info(applicationMessages.tarefaAdminstrativaRemovida());
            } catch (SchedulerException e) {
                throw new JobExecutionException(e);
            }
            execution = 0;
        }

    }
}
package com.rafabene.demos.deltaspike.domain.services;

import java.util.logging.Logger;

import org.apache.deltaspike.scheduler.api.Scheduled;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Scheduled(cronExpression = "0 * * * * ?")
public class CronTask implements Job
{

    static public final Logger log = Logger.getLogger(CronTask.class.getName());

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException
    {
        log.info("Cron Task execute");
        System.out.println("I'm running :)");
    }

}

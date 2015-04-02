package com.rafabene.demos.deltaspike.application;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.quartz.Job;

import com.rafabene.demos.deltaspike.domain.services.CdiAwareQuartzJob;
import com.rafabene.demos.deltaspike.infra.i18n.Messages;
import com.rafabene.demos.deltaspike.infra.security.AdminOnly;

@Model
public class AdminBean
{

    @Inject
    private JsfMessage<Messages> messages;

    @Inject
    private Scheduler<Job> jobScheduler;

    // Shows a kind of method that only an 'Admin' can execute
    @AdminOnly
    public void startAdministrativeTask()
    {
        jobScheduler.registerNewJob(CdiAwareQuartzJob.class);
        messages.addInfo().administrativeTaskScheduled();
    }

}

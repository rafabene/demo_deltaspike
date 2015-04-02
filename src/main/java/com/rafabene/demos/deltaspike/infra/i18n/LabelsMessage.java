package com.rafabene.demos.deltaspike.infra.i18n;

import javax.inject.Named;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

@Named("label")
@MessageBundle
public interface LabelsMessage {

    public String user();

    public String password();

    public String confirmPassword();

    public String registerUser();

    public String cancel();

    public String register();

    @MessageTemplate("{config}")
    public String configuration();

    public String jmsQueue();

    public String message();

    public String logoff();

    public String options();

    public String postMessage();
    
    public String administrativeTask();
    
    public String author();
    
    public String postData();
    
    public String followUsers();

    public String followUser();

    public String action();
    
    public String back();
    
    public String refresh();
    
    public String loggedAs(String username);
    
    @MessageTemplate("{jms.user}")
    public String jmsUser();
    
}

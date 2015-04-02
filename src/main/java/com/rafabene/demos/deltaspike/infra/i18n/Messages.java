package com.rafabene.demos.deltaspike.infra.i18n;

import org.apache.deltaspike.core.api.message.MessageBundle;

@MessageBundle
public interface Messages {

    public String userCreatedSuccess();

    public String accessDenied();

    public String userAlreadyRegistered();

    public String messagePublished();

    public String administrativeTaskScheduled();

    public String administrativeTaskExecuted();

    public String administrativeTaskRemoved();
    
    public String followingUser(String username);
}

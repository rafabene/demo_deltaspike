package com.rafabene.demos.deltaspike.application;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;

import com.rafabene.demos.deltaspike.infra.security.ApplicationDecisionVoter;
import com.rafabene.demos.deltaspike.infra.security.UserLoggedInEvent;

public class AuthenticationListener {
    
    @Inject
    private ViewNavigationHandler viewNavigationHandler;
    
    @Inject
    private ApplicationDecisionVoter applicationDecisionVoter;
    
    // Redirect to the denied page after the login.
    public void handleLoggedIn(@Observes UserLoggedInEvent event) {
        this.viewNavigationHandler.navigateTo(applicationDecisionVoter.getDeniedPage());
    }

}

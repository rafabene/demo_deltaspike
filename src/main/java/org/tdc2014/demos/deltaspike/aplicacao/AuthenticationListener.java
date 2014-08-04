package org.tdc2014.demos.deltaspike.aplicacao;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.ApplicationDecisionVoter;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.UsuarioLogadoEvent;

public class AuthenticationListener {
    
    @Inject
    private ViewNavigationHandler viewNavigationHandler;
    
    @Inject
    private ApplicationDecisionVoter applicationDecisionVoter;
    
    //Redireciona para a página solicitada após o login
    public void handleLoggedIn(@Observes UsuarioLogadoEvent event) {
        this.viewNavigationHandler.navigateTo(applicationDecisionVoter.getDeniedPage());
    }

}

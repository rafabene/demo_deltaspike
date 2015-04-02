package com.rafabene.demos.deltaspike.infra.security;

import java.util.HashSet;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoterContext;
import org.apache.deltaspike.security.api.authorization.SecurityViolation;

import com.rafabene.demos.deltaspike.application.Pages;
import com.rafabene.demos.deltaspike.domain.entities.User;

@WindowScoped
public class ApplicationDecisionVoter implements AccessDecisionVoter {

    private static final long serialVersionUID = 1L;

    @Inject
    @Logged
    private User loggedUser;

    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Inject
    private FacesContext facesContext;

    private Class<? extends ViewConfig> deniedPage = Pages.PostMessage.class;

    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext ctx) {
        Set<SecurityViolation> violations = new HashSet<SecurityViolation>();

        if (this.loggedUser == null || this.loggedUser.getId() == null) {
            violations.add(new UserIsNotLoggedInViolation());
            // Besides throwing an exception, it stores the denied page
            deniedPage = viewConfigResolver.getViewConfigDescriptor(facesContext.getViewRoot().getViewId()).getConfigClass();
        }
        return violations;
    }

    class UserIsNotLoggedInViolation implements SecurityViolation {

        private static final long serialVersionUID = 1L;

        @Override
        public String getReason() {
            return "User is not logged in";
        }

    }

    public Class<? extends ViewConfig> getDeniedPage() {
        try {
            return deniedPage;
        } finally {
            deniedPage = Pages.PostMessage.class;
        }
    }

}

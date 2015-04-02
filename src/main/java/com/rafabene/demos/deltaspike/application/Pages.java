package com.rafabene.demos.deltaspike.application;

import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.jsf.api.config.view.View.NavigationMode;
import org.apache.deltaspike.security.api.authorization.Secured;

import com.rafabene.demos.deltaspike.infra.security.ApplicationDecisionVoter;

// Validation happens on deploy time
@Folder(name = "/")
public class Pages {

    @View(navigation = NavigationMode.REDIRECT)
    public interface ApplicationView extends ViewConfig {
    };

    @Secured(ApplicationDecisionVoter.class)
    public interface SecuredPages extends ApplicationView {

    }

    public class Welcome extends DefaultErrorView implements ApplicationView {
    }

    public class CreateUser implements ApplicationView {
    }

    public class PostMessage implements SecuredPages {

    }

    public class ListUsers implements SecuredPages {

    }
}

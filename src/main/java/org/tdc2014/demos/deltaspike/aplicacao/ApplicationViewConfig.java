package org.tdc2014.demos.deltaspike.aplicacao;

import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.jsf.api.config.view.View.NavigationMode;
import org.apache.deltaspike.security.api.authorization.Secured;
import org.tdc2014.demos.deltaspike.infrastrutura.ApplicationDecisionVoter;

// A validação do caminho acontece em tempo de deploy
@Folder(name = "/")
public class ApplicationViewConfig {

    @View(navigation = NavigationMode.REDIRECT)
    public interface ApplicationView extends ViewConfig {
    };

    @Secured(ApplicationDecisionVoter.class)
    public interface SecuredPages extends ApplicationView {

    }

    public class Welcome extends DefaultErrorView implements ApplicationView {
    }

    public class CriarUsuario implements ApplicationView {
    }

    public class PostarMensagem implements SecuredPages, ApplicationView {

    }
}

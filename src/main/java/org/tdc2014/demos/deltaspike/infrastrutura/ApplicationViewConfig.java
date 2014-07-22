package org.tdc2014.demos.deltaspike.infrastrutura;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.jsf.api.config.view.View.NavigationMode;

// A validação do caminho acontece em tempo de deploy
@Folder(name = "/")
public class ApplicationViewConfig {

    @View(navigation = NavigationMode.REDIRECT)
    public interface ApplicationView extends ViewConfig {
    };

    public class Welcome implements ApplicationView {
    }

    public class CriarUsuario implements ApplicationView {
    };

}

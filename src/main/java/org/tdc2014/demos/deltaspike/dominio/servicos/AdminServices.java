package org.tdc2014.demos.deltaspike.dominio.servicos;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

public class AdminServices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ApplicationMessages applicationMessages;

    @Inject
    private Logger logger;

    public void executarRotinasAdministrativas() {
        logger.info(applicationMessages.tarefaAdminstrativaExecutada());
    }

}

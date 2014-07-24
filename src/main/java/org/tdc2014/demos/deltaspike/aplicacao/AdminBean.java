package org.tdc2014.demos.deltaspike.aplicacao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.tdc2014.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;
import org.tdc2014.demos.deltaspike.infraestrutura.seguranca.AdminOnly;

@Model
public class AdminBean {

    @Inject
    private FacesContext facesContext;

    @Inject
    private ApplicationMessages applicationMessages;

    // Demonstra um tipo de tarefa que apenas um administrador pode fazer
    @AdminOnly
    public void iniciarTarefaAdministrativa() {
        facesContext.addMessage(null, new FacesMessage(applicationMessages.tarefaAdminstrativaIniciada()));
    }

}

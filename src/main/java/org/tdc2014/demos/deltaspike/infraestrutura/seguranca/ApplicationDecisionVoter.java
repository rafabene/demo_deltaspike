package org.tdc2014.demos.deltaspike.infraestrutura.seguranca;

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
import org.tdc2014.demos.deltaspike.aplicacao.Pages;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;

@WindowScoped
public class ApplicationDecisionVoter implements AccessDecisionVoter {

    private static final long serialVersionUID = 1L;

    @Inject
    @Logged
    private Usuario usuarioLogado;

    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Inject
    private FacesContext facesContext;

    private Class<? extends ViewConfig> deniedPage = Pages.PostarMensagem.class;

    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext ctx) {
        Set<SecurityViolation> violations = new HashSet<SecurityViolation>();

        if (this.usuarioLogado == null || this.usuarioLogado.getId() == null) {
            violations.add(new UsuarioNaoLogadoViolation());
            // Além de lançar uma violação, armazena qual foi a página que teve o acesso negado
            deniedPage = viewConfigResolver.getViewConfigDescriptor(facesContext.getViewRoot().getViewId()).getConfigClass();
        }
        return violations;
    }

    class UsuarioNaoLogadoViolation implements SecurityViolation {

        private static final long serialVersionUID = 1L;

        @Override
        public String getReason() {
            return "Usuário não logado";
        }

    }

    public Class<? extends ViewConfig> getDeniedPage() {
        try {
            return deniedPage;
        } finally {
            deniedPage = Pages.PostarMensagem.class;
        }
    }

}

package org.tdc2014.demos.deltaspike.infraestrutura.seguranca;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.deltaspike.security.api.authorization.AccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoterContext;
import org.apache.deltaspike.security.api.authorization.SecurityViolation;
import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;

@ApplicationScoped
public class ApplicationDecisionVoter implements AccessDecisionVoter {
    

    private static final long serialVersionUID = 1L;
    
    @Inject
    @Logado
    private Usuario usuarioLogado;

    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext ctx) {
        Set<SecurityViolation> violations = new HashSet<SecurityViolation>();
        if (this.usuarioLogado == null || this.usuarioLogado.getId() == null){
            violations.add(new UsuarioNaoLogadoViolation());
        }
        return violations;
    }
    
    class UsuarioNaoLogadoViolation implements SecurityViolation{

        private static final long serialVersionUID = 1L;

        @Override
        public String getReason() {
            return "Usuário não logado";
        }
        
    }

}

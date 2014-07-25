package org.tdc2014.demos.deltaspike.infraestrutura.i18n;

import org.apache.deltaspike.core.api.message.MessageBundle;

@MessageBundle
public interface ApplicationMessages {

    public String usuarioCriadoSucesso();

    public String acessoNegado();

    public String usuarioJaCadastrado();

    public String mensagemPublicada();

    public String tarefaAdminstrativaAgendada();

    public String tarefaAdminstrativaExecutada();

    public String tarefaAdminstrativaRemovida();
    
    public String seguindoUsuario(String username);
}
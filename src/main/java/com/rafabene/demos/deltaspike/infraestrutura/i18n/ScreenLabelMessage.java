package com.rafabene.demos.deltaspike.infraestrutura.i18n;

import javax.inject.Named;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

@Named
@MessageBundle
public interface ScreenLabelMessage {

    public String usuario();

    @MessageTemplate("{password}")
    public String senha();

    public String confirmaSenha();

    public String registrarUsuario();

    public String cancelar();

    public String registrar();

    public String configuracoes();

    public String filaJMS();

    public String mensagem();

    public String logoff();

    public String opcoes();

    public String postarMensagem();
    
    public String tarefaAdministrativa();
    
    public String autor();
    
    public String dadosPostagem();
    
    public String seguirUsuarios();

    public String seguirUsuario();

    public String acao();
    
    public String voltar();
    
    public String atualizar();
    
    public String logadoComo(String username);
    
}

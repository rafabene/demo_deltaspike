package org.tdc2014.demos.deltaspike.aplicacao;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.tdc2014.demos.deltaspike.dominio.entidades.Usuario;
import org.tdc2014.demos.deltaspike.dominio.servicos.LoginService;
import org.tdc2014.demos.deltaspike.infrastrutura.ApplicationViewConfig.CriarUsuario;
import org.tdc2014.demos.deltaspike.infrastrutura.ApplicationViewConfig.Welcome;

@ManagedBean
public class LoginBean {

    @Inject
    private Usuario usuario;

    @Inject
    private LoginService loginService;

    public Usuario getUsuario() {
        return usuario;
    }

    public void login() {
        loginService.login(usuario.getUsername(), usuario.getPassword());
    }

    public Class<CriarUsuario> criarUsuario() {
        return CriarUsuario.class;
    }

    public Class<Welcome> home() {
        return Welcome.class;
    }

}

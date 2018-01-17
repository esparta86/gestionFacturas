/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.login.controller;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Esparta_86
 */
@ManagedBean (name = "menuPrincipalController")
@ViewScoped
public class MenuPrincipalController {
    
    @ManagedProperty(value = "#{accesoEnterpriseWebController}")
    private AccesoEnterpriseWebController accesoEnterpriseWebController;
    private Boolean usuarioLogeado = Boolean.FALSE;
    
    @PostConstruct
    public void init() {
         if (getAccesoEnterpriseWebController().getUsuarioLogeado().trim().compareTo("") != 0) {
             setUsuarioLogeado(Boolean.TRUE);
         }
    }
    
    public void checkAlreadyLoggedInSystem() throws IOException{
        if (getAccesoEnterpriseWebController().getUsuarioLogeado().trim().compareTo("") == 0) {
             ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
             ec.redirect(ec.getRequestContextPath()+"/Logging/accesoEnterpriseWeb.xhtml");
         }
    }

    /**
     * Creates a new instance of MenuPrincipalController
     */
    public MenuPrincipalController() {
    }

    /**
     * @return the accesoEnterpriseWebController
     */
    public AccesoEnterpriseWebController getAccesoEnterpriseWebController() {
        return accesoEnterpriseWebController;
    }

    /**
     * @param accesoEnterpriseWebController the accesoEnterpriseWebController to set
     */
    public void setAccesoEnterpriseWebController(AccesoEnterpriseWebController accesoEnterpriseWebController) {
        this.accesoEnterpriseWebController = accesoEnterpriseWebController;
    }

    /**
     * @return the usuarioLogeado
     */
    public Boolean getUsuarioLogeado() {
        return usuarioLogeado;
    }

    /**
     * @param usuarioLogeado the usuarioLogeado to set
     */
    public void setUsuarioLogeado(Boolean usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.login.controller;

import com.mario.dao.entities.Usuario;
import com.mario.sessionsbeansJDBC.UsuarioFacadeJDBC;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author rcolocho
 */
@ManagedBean(name = "accesoEnterpriseWebController")
@ViewScoped
public class AccesoEnterpriseWebController implements Serializable {

    @EJB
    private UsuarioFacadeJDBC usuarioFacadeJDBC;
    private String usuario;
    private String password;

    public AccesoEnterpriseWebController() {
    }

    @PostConstruct
    public void init() {

        usuario = "";
        password = "";
    }

    public void logearUsuario() {
        try {
            if(usuario.trim().compareTo("") == 0 || password.trim().compareTo("") == 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incompletas", "Ingrese completamente los campos: USUARIO y PASSWORD"));
            }else{
                Usuario usuarioDB = usuarioFacadeJDBC.obtenerUsuario(usuario, "MARIO");
                if(usuarioDB != null){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Credenciales correctas", "Usuario correcto"));
                }
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String msj = e.getMessage() != null ? e.getMessage() : sw.toString();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj));
        }
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

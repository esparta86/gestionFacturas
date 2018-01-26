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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rcolocho
 */
@ManagedBean(name = "accesoEnterpriseWebController")
@SessionScoped
public class AccesoEnterpriseWebController implements Serializable {

    @EJB
    private UsuarioFacadeJDBC usuarioFacadeJDBC;
    private String usuario;
    private String password;
    private String usuarioLogeado;

    public AccesoEnterpriseWebController() {
        usuario = "";
        password = "";
        usuarioLogeado = "";

    }

    @PostConstruct
    public void init() {

        usuario = "";
        password = "";
        setUsuarioLogeado("");
    }

    public void logearUsuario() {
        try {
            if (usuario.trim().compareTo("") == 0 || password.trim().compareTo("") == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incompletas", "Ingrese completamente los campos: USUARIO y PASSWORD"));
            } else {
                Usuario usuarioDB = usuarioFacadeJDBC.obtenerUsuario(usuario, password, "MARIO");
                if (usuarioDB != null) {
                    setUsuarioLogeado(usuarioDB.getUsuario());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Credenciales correctas", "Usuario correcto"));
                    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    ec.redirect(ec.getRequestContextPath() + "/Logging/MenuPrincipal.xhtml");
                } else {
                    usuario = "";
                    password = "";
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", "Ingrese un usuario/password validos"));
                }
            }
        } catch (Exception e) {
            usuario = "";
            password = "";
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String msj = e.getMessage() != null ? e.getMessage() : sw.toString();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj));
        }
    }

    public void invalidarSessionUsuario() {
        try {
            this.usuario = "";
            this.password = "";
            this.usuarioLogeado = "";
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String urlContext
                    = ((HttpServletRequest) ec.getRequest()).getRequestURI();
            ec.redirect(urlContext);
            
        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * @return the usuarioLogeado
     */
    public String getUsuarioLogeado() {
        return usuarioLogeado;
    }

    /**
     * @param usuarioLogeado the usuarioLogeado to set
     */
    public void setUsuarioLogeado(String usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
}

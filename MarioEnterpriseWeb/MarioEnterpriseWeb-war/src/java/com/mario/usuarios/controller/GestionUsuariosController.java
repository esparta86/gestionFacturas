/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.usuarios.controller;

import com.mario.dao.entities.Usuario;
import com.mario.login.controller.AccesoEnterpriseWebController;
import com.mario.sessionsbeansJDBC.UsuarioFacadeJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Esparta_86
 */
@ManagedBean(name = "gestionUsuariosController")
@ViewScoped
public class GestionUsuariosController implements Serializable{

    @EJB
    UsuarioFacadeJDBC usuarioFacadeJDBC;

    @ManagedProperty(value = "#{accesoEnterpriseWebController}")
    private AccesoEnterpriseWebController accesoEnterpriseWebController;
    private Boolean usuarioLogeado = Boolean.FALSE;

    private List<Usuario> listaUsuarios;
    private Usuario usuarioNuevo;

    @PostConstruct
    public void init() {
        try {
            if (getAccesoEnterpriseWebController().getUsuarioLogeado().trim().compareTo("") != 0) {
                setUsuarioLogeado(Boolean.TRUE);
                setListaUsuarios(usuarioFacadeJDBC.obtenerListaUsuarios("MARIO"));
                setUsuarioNuevo(new Usuario());
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String msj = e.getMessage() != null ? e.getMessage() : sw.toString();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj));
        }
    }

    public void guardarNuevoUsuario() {
        try {
            usuarioNuevo.setFum(new Date());
            usuarioNuevo.setUltimoUsuario(getAccesoEnterpriseWebController().getUsuarioLogeado().trim());
            if (validarDatos()) {
                usuarioFacadeJDBC.guardarUsuario(usuarioNuevo, "MARIO");
                setListaUsuarios(usuarioFacadeJDBC.obtenerListaUsuarios("MARIO"));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Creado",
                                "Usuario ha sido creado con exito"));

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos Incompletos",
                                "Ingrese un usuario y passoword"));
            }

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String msj = e.getMessage() != null ? e.getMessage() : sw.toString();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no agregado", msj));
        }
    }

    public Boolean validarDatos() {
        if (usuarioNuevo.getUsuario() != null && usuarioNuevo.getPassword() != null) {
            if (usuarioNuevo.getPassword().trim().compareTo("") == 0 || usuarioNuevo.getUsuario().trim().compareTo("") == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public void checkAlreadyLoggedInSystem() throws IOException {
        if (getAccesoEnterpriseWebController().getUsuarioLogeado().trim().compareTo("") == 0) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/Logging/accesoEnterpriseWeb.xhtml");
        }
    }

    public void redirecHome() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/Logging/MenuPrincipal.xhtml");
    }

    /**
     * Creates a new instance of GestionUsuariosController
     */
    public GestionUsuariosController() {
    }

    /**
     * @return the accesoEnterpriseWebController
     */
    public AccesoEnterpriseWebController getAccesoEnterpriseWebController() {
        return accesoEnterpriseWebController;
    }

    /**
     * @param accesoEnterpriseWebController the accesoEnterpriseWebController to
     * set
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

    /**
     * @return the listaUsuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @return the usuarioNuevo
     */
    public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    /**
     * @param usuarioNuevo the usuarioNuevo to set
     */
    public void setUsuarioNuevo(Usuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.dao.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Esparta_86
 */
public class Usuario implements Serializable{
    
    private String usuario;
    private String password;
    private Date fum;
    private String ultimoUsuario;
    
    public Usuario(){
        
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
     * @return the fum
     */
    public Date getFum() {
        return fum;
    }

    /**
     * @param fum the fum to set
     */
    public void setFum(Date fum) {
        this.fum = fum;
    }

    /**
     * @return the ultimoUsuario
     */
    public String getUltimoUsuario() {
        return ultimoUsuario;
    }

    /**
     * @param ultimoUsuario the ultimoUsuario to set
     */
    public void setUltimoUsuario(String ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }
    
}

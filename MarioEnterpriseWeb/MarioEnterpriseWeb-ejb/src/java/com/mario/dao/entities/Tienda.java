/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.dao.entities;

import java.io.Serializable;

/**
 *
 * @author Esparta_86
 */
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer tienda_id;
    private String descripcion;

    /**
     * @return the tienda_id
     */
    public Integer getTienda_id() {
        return tienda_id;
    }

    /**
     * @param tienda_id the tienda_id to set
     */
    public void setTienda_id(Integer tienda_id) {
        this.tienda_id = tienda_id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

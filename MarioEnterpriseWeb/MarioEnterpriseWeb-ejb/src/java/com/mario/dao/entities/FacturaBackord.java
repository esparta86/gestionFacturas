/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.dao.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;

/**
 *
 * @author Esparta_86
 */
public class FacturaBackord  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String numeroFactura;
    private Integer tiendaID;
    private Date fechaImportac;
    private Character estado;
    private BigDecimal totalFactura;
    
    @Transient
    private Boolean estadoB;
    @Transient
    private String nombreTienda;

    /**
     * @return the numeroFactura
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * @param numeroFactura the numeroFactura to set
     */
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     * @return the tiendaID
     */
    public Integer getTiendaID() {
        return tiendaID;
    }

    /**
     * @param tiendaID the tiendaID to set
     */
    public void setTiendaID(Integer tiendaID) {
        this.tiendaID = tiendaID;
    }

    /**
     * @return the fechaImportac
     */
    public Date getFechaImportac() {
        return fechaImportac;
    }

    /**
     * @param fechaImportac the fechaImportac to set
     */
    public void setFechaImportac(Date fechaImportac) {
        this.fechaImportac = fechaImportac;
    }

    /**
     * @return the estado
     */
    public Character getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Character estado) {
        this.estado = estado;
    }

    /**
     * @return the totalFactura
     */
    public BigDecimal getTotalFactura() {
        return totalFactura;
    }

    /**
     * @param totalFactura the totalFactura to set
     */
    public void setTotalFactura(BigDecimal totalFactura) {
        this.totalFactura = totalFactura;
    }

    /**
     * @return the estadoB
     */
    public Boolean getEstadoB() {
        return estadoB;
    }

    /**
     * @param estadoB the estadoB to set
     */
    public void setEstadoB(Boolean estadoB) {
        this.estadoB = estadoB;
    }

    /**
     * @return the nombreTienda
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * @param nombreTienda the nombreTienda to set
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
    
    
    
}

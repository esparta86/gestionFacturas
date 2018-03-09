/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davivienda.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Esparta_86
 */
public class cobrosMensualPorCanal {
    
    private Integer idColector;
    private Integer idCanal;
    private String cuentaAbono;
    private String cuentaCargo;
    private BigDecimal montoTotal;
    private char estado;
    
    private String idMes;
    private int transaccionesPorCanal;
    private String cobroPorCanal;
    private Date fechaUltimaActualizacion;
    private Date fechaIngreso;
    private String idCobrosTotal;

    /**
     * @return the idColector
     */
    public Integer getIdColector() {
        return idColector;
    }

    /**
     * @param idColector the idColector to set
     */
    public void setIdColector(Integer idColector) {
        this.idColector = idColector;
    }

    /**
     * @return the idCanal
     */
    public Integer getIdCanal() {
        return idCanal;
    }

    /**
     * @param idCanal the idCanal to set
     */
    public void setIdCanal(Integer idCanal) {
        this.idCanal = idCanal;
    }

    /**
     * @return the cuentaAbono
     */
    public String getCuentaAbono() {
        return cuentaAbono;
    }

    /**
     * @param cuentaAbono the cuentaAbono to set
     */
    public void setCuentaAbono(String cuentaAbono) {
        this.cuentaAbono = cuentaAbono;
    }

    /**
     * @return the cuentaCargo
     */
    public String getCuentaCargo() {
        return cuentaCargo;
    }

    /**
     * @param cuentaCargo the cuentaCargo to set
     */
    public void setCuentaCargo(String cuentaCargo) {
        this.cuentaCargo = cuentaCargo;
    }

    /**
     * @return the montoTotal
     */
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @return the idMes
     */
    public String getIdMes() {
        return idMes;
    }

    /**
     * @param idMes the idMes to set
     */
    public void setIdMes(String idMes) {
        this.idMes = idMes;
    }

    /**
     * @return the transaccionesPorCanal
     */
    public int getTransaccionesPorCanal() {
        return transaccionesPorCanal;
    }

    /**
     * @param transaccionesPorCanal the transaccionesPorCanal to set
     */
    public void setTransaccionesPorCanal(int transaccionesPorCanal) {
        this.transaccionesPorCanal = transaccionesPorCanal;
    }

    /**
     * @return the cobroPorCanal
     */
    public String getCobroPorCanal() {
        return cobroPorCanal;
    }

    /**
     * @param cobroPorCanal the cobroPorCanal to set
     */
    public void setCobroPorCanal(String cobroPorCanal) {
        this.cobroPorCanal = cobroPorCanal;
    }

    /**
     * @return the fechaUltimaActualizacion
     */
    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    /**
     * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
     */
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the idCobrosTotal
     */
    public String getIdCobrosTotal() {
        return idCobrosTotal;
    }

    /**
     * @param idCobrosTotal the idCobrosTotal to set
     */
    public void setIdCobrosTotal(String idCobrosTotal) {
        this.idCobrosTotal = idCobrosTotal;
    }
    
    
}

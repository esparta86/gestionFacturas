/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.util.clases;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author rcolocho
 */
public class Factura  implements Serializable{
    
    private String codigoFactura;
    private String descripcionFactura;
    private Integer qty;
    private String factura;
    private BigDecimal precio;
    private String archivo;
    private boolean edicion;
    
    public Factura(){
        
    }

    /**
     * @return the codigoFactura
     */
    public String getCodigoFactura() {
        return codigoFactura;
    }

    /**
     * @param codigoFactura the codigoFactura to set
     */
    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    /**
     * @return the descripcionFactura
     */
    public String getDescripcionFactura() {
        return descripcionFactura;
    }

    /**
     * @param descripcionFactura the descripcionFactura to set
     */
    public void setDescripcionFactura(String descripcionFactura) {
        this.descripcionFactura = descripcionFactura;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return the factura
     */
    public String getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(String factura) {
        this.factura = factura;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * @return the archivo
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the edicion
     */
    public boolean isEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    
}

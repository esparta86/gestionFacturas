/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.facturas.consulta.controller;

import com.mario.login.controller.AccesoEnterpriseWebController;
import com.mario.util.clases.Factura;
import com.mario.util.clases.criteriosBusquedas;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author rcolocho
 */
@ManagedBean(name = "busquedaFacturaController")

@ViewScoped
public class BusquedaFacturaController {

    @ManagedProperty(value = "#{accesoEnterpriseWebController}")
    private AccesoEnterpriseWebController accesoEnterpriseWebController;

    private boolean busquedaHistoricos;
    private Date fechaHistoricoI;
    private Date fechaHistoricoF;
    private List<criteriosBusquedas> listaCriteriosFacturas;
    private criteriosBusquedas criterioSeleccionado;
    private List<Factura> listaFacturas;
    private Boolean usuarioLogeado = Boolean.FALSE;

    public BusquedaFacturaController() {
    }

    @PostConstruct
    public void init() {
        if (getAccesoEnterpriseWebController().getUsuarioLogeado().trim().compareTo("") != 0) {
            setUsuarioLogeado(Boolean.TRUE);
            this.setBusquedaHistoricos((boolean) Boolean.FALSE);
            this.setListaCriteriosFacturas(new ArrayList<criteriosBusquedas>());
            criteriosBusquedas criterio1 = new criteriosBusquedas();
            criterio1.setIdCriterio(1);
            criterio1.setNombreCriterio("codigo");
            criteriosBusquedas criterio2 = new criteriosBusquedas();
            criterio2.setIdCriterio(2);
            criterio2.setNombreCriterio("Descripcion");

            criteriosBusquedas criterio3 = new criteriosBusquedas();
            criterio3.setIdCriterio(3);
            criterio3.setNombreCriterio("precio");

            this.getListaCriteriosFacturas().add(criterio1);
            this.getListaCriteriosFacturas().add(criterio2);
            this.getListaCriteriosFacturas().add(criterio3);
            this.criterioSeleccionado = new criteriosBusquedas();
            this.criterioSeleccionado.setIdCriterio(0);

            this.setListaFacturas(new ArrayList<Factura>());
            for (int i = 0; i < 100; i++) {
                Factura factura = new Factura();
                factura.setCodigoFactura("11-5311-00-6B");
                factura.setDescripcionFactura("STOP TERCEL " + i);
                factura.setEdicion(true);
                factura.setPrecio(new BigDecimal("100.77"));
                factura.setQty(new Integer("3"));
                factura.setArchivo("factura");
                this.getListaFacturas().add(factura);
            }

            for (int i = 0; i < 100; i++) {
                Factura factura = new Factura();
                factura.setCodigoFactura("12-1159-00-1A");
                factura.setDescripcionFactura("VIA NISSAN  " + i);
                factura.setEdicion(true);
                factura.setPrecio(new BigDecimal("40.77"));
                factura.setQty(new Integer("5"));
                factura.setArchivo("backord");
                this.getListaFacturas().add(factura);
            }
        }else{
            System.err.println("USUARIO NO LOGEADO");
        }

    }

    /**
     * @return the busquedaHistoricos
     */
    public boolean isBusquedaHistoricos() {
        return busquedaHistoricos;
    }

    /**
     * @param busquedaHistoricos the busquedaHistoricos to set
     */
    public void setBusquedaHistoricos(boolean busquedaHistoricos) {
        this.busquedaHistoricos = busquedaHistoricos;
    }

    /**
     * @return the fechaHistoricoI
     */
    public Date getFechaHistoricoI() {
        return fechaHistoricoI;
    }

    /**
     * @param fechaHistoricoI the fechaHistoricoI to set
     */
    public void setFechaHistoricoI(Date fechaHistoricoI) {
        this.fechaHistoricoI = fechaHistoricoI;
    }

    /**
     * @return the fechaHistoricoF
     */
    public Date getFechaHistoricoF() {
        return fechaHistoricoF;
    }

    /**
     * @param fechaHistoricoF the fechaHistoricoF to set
     */
    public void setFechaHistoricoF(Date fechaHistoricoF) {
        this.fechaHistoricoF = fechaHistoricoF;
    }

    /**
     * @return the listaCriteriosFacturas
     */
    public List<criteriosBusquedas> getListaCriteriosFacturas() {
        return listaCriteriosFacturas;
    }

    /**
     * @param listaCriteriosFacturas the listaCriteriosFacturas to set
     */
    public void setListaCriteriosFacturas(List<criteriosBusquedas> listaCriteriosFacturas) {
        this.listaCriteriosFacturas = listaCriteriosFacturas;
    }

    /**
     * @return the criterioSeleccionado
     */
    public criteriosBusquedas getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    /**
     * @param criterioSeleccionado the criterioSeleccionado to set
     */
    public void setCriterioSeleccionado(criteriosBusquedas criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    /**
     * @return the listaFacturas
     */
    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    /**
     * @param listaFacturas the listaFacturas to set
     */
    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
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

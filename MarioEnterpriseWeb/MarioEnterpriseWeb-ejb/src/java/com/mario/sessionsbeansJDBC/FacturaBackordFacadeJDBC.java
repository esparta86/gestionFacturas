/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeansJDBC;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.FacturaBackord;
import com.mario.dao.entities.Tienda;
import com.mario.sessionsbeans.FacturaBackordFacade;
import com.mario.sessionsbeans.TiendaFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author rcolocho
 */
@Stateless
public class FacturaBackordFacadeJDBC extends AbstractFacadeJDBC {

    public List<FacturaBackord> getAllFacturas(String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            FacturaBackordFacade facturaBackordFacade = new FacturaBackordFacade();
            return recuperarTranscient(facturaBackordFacade.getAllFacturas(conexionPosgresql), conexionPosgresql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }

    public void actualizarEstadoFactura(FacturaBackord facturaBackord, String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            FacturaBackordFacade facturaBackordFacade = new FacturaBackordFacade();
            facturaBackordFacade.edit(facturaBackord, conexionPosgresql);
            conexionPosgresql.commit();

        } catch (Exception e) {
            conexionPosgresql.rollback();
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }

    public List<FacturaBackord> recuperarTranscient(List<FacturaBackord> lista, ConexionPosgresql conexionPosgresql) throws Exception {
        int i = 0;
        TiendaFacade tiendaFacade = new TiendaFacade();
        for (FacturaBackord fact : lista) {
            Tienda tienda = tiendaFacade.getTienda(fact.getTiendaID(), conexionPosgresql);
            fact.setNombreTienda(tienda != null ? tienda.getDescripcion() : "Tienda No Encontrada");
            i++;
            if (i % 100 == 0) {
                conexionPosgresql.cerrarCursores();
            }

        }
        return lista;
    }
}

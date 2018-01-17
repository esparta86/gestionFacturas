/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeansJDBC;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.FacturaBackord;
import com.mario.sessionsbeans.FacturaBackordFacade;
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
            return facturaBackordFacade.getAllFacturas(conexionPosgresql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }
}

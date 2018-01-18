/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeans;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.FacturaBackord;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esparta_86
 */
public class FacturaBackordFacade extends AbstractFacade {

    @Override
    public void create(Object paramObject, ConexionPosgresql paramConexionPosgresql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object paramObject, ConexionPosgresql paramConexionPosgresql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Object paramObject, ConexionPosgresql paramConexionPosgresql) throws Exception {
        FacturaBackord entidad = (FacturaBackord) paramObject;
        String query = " UPDATE FACTURA_BACKORD SET ESTADO = ? "
                + " WHERE NUMERO_FACTURA = ? AND TIENDA_ID = ?";
        paramConexionPosgresql.executeUpdatePS(query, new Object[]{
            entidad.getEstado(),
            entidad.getNumeroFactura(),
            entidad.getTiendaID()
        });
        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }

    }

    @Override
    public Object find(Object paramObject, ConexionPosgresql paramConexionPosgresql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FacturaBackord> parseResultSetToClass(ResultSet paramResultSet) throws Exception {
        List<FacturaBackord> listaFacturaBackords = new ArrayList<FacturaBackord>();
        try {
            while (paramResultSet.next()) {
                FacturaBackord facturaBackord = new FacturaBackord();
                facturaBackord.setNumeroFactura(paramResultSet.getString("NUMERO_FACTURA"));
                facturaBackord.setTiendaID(paramResultSet.getInt("TIENDA_ID"));
                facturaBackord.setEstado(paramResultSet.getString("ESTADO").charAt(0));
                if (facturaBackord.getEstado().compareTo('A') == 0) {
                    facturaBackord.setEstadoB(Boolean.TRUE);
                } else {
                    facturaBackord.setEstadoB(Boolean.FALSE);
                }
                facturaBackord.setFechaImportac(paramResultSet.getDate("FECHA_IMPORTAC"));
                facturaBackord.setTotalFactura(paramResultSet.getBigDecimal("TOTAL_FACTURA"));
                listaFacturaBackords.add(facturaBackord);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaFacturaBackords;
    }

    public List<FacturaBackord> getAllFacturas(ConexionPosgresql paramConexionPosgresql) throws Exception {
        List<FacturaBackord> resultado;
        ResultSet resultSet;
        String query = "SELECT * FROM FACTURA_BACKORD";

        resultSet = paramConexionPosgresql.executeQueryPS(query, new Object[]{});

        resultado = parseResultSetToClass(resultSet);

        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }

        return resultado;

    }
}

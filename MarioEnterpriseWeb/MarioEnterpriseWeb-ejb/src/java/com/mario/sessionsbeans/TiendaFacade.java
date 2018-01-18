/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeans;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.FacturaBackord;
import com.mario.dao.entities.Tienda;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esparta_86
 */
public class TiendaFacade extends AbstractFacade {
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object find(Object paramObject, ConexionPosgresql paramConexionPosgresql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Tienda> parseResultSetToClass(ResultSet paramResultSet) throws Exception {
        List<Tienda> listaTiendas = new ArrayList<Tienda>();
        try {
            while (paramResultSet.next()) {
                Tienda tienda = new Tienda();
                tienda.setDescripcion(paramResultSet.getString("DESCRIPCION"));
                tienda.setTienda_id(paramResultSet.getInt("TIENDA_ID"));
                listaTiendas.add(tienda);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaTiendas;
    }
    
    public List<Tienda> getAllTiendas(ConexionPosgresql paramConexionPosgresql) throws Exception {
        List<Tienda> resultado;
        ResultSet resultSet;
        String query = "SELECT * FROM TIENDA";
        
        resultSet = paramConexionPosgresql.executeQueryPS(query, new Object[]{});
        
        resultado = parseResultSetToClass(resultSet);
        
        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }
        
        return resultado;
        
    }
    
    public Tienda getTienda(Integer idtienda, ConexionPosgresql paramConexionPosgresql) throws Exception {
        ResultSet resultSet;
        List<Tienda> resultado;
        String query = "SELECT * FROM TIENDA WHERE TIENDA_ID = ? ";
        resultSet = paramConexionPosgresql.executeQueryPS(query, new Object[]{idtienda});
        resultado = parseResultSetToClass(resultSet);
        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }
        return resultado.isEmpty() ? null : resultado.get(0);
        
    }
}

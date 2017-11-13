/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeans;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esparta_86
 */
public class UsuarioFacade extends AbstractFacade {

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
    public Object parseResultSetToClass(ResultSet paramResultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> parseResultSetToClass(ResultSet paramResultSet, String paramString) throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            while (paramResultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(paramResultSet.getString("USUARIO"));
                usuario.setPassword(paramResultSet.getString("PASSWORD"));
                usuario.setUltimoUsuario(paramResultSet.getString("ULTIMO_USUARIO"));
                usuario.setFum(paramResultSet.getDate("FUM"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaUsuarios;
    }
}

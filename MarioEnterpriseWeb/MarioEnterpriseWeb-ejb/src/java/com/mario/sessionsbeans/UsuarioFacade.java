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
    public List<Usuario> parseResultSetToClass(ResultSet paramResultSet) throws Exception {
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

    public Usuario getUsuario(String usuarioString, ConexionPosgresql paramConexionPosgresql) throws Exception {
        List<Usuario> resultado;
        ResultSet resultSet;
        String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";

        resultSet = paramConexionPosgresql.executeQueryPS(query, new Object[]{usuarioString != null ? usuarioString.trim() : ""});
        resultado = parseResultSetToClass(resultSet);

        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }

        return !resultado.isEmpty() ? resultado.get(0) : null;

    }

    public Usuario getUsuarioValidacion(String usuarioString, String password, ConexionPosgresql paramConexionPosgresql) throws Exception {
        List<Usuario> resultado;
        ResultSet resultSet;
        String query = "SELECT * FROM USUARIO WHERE USUARIO=? and MD5(?) = password;";

        resultSet = paramConexionPosgresql.executeQueryPS(query,
                new Object[]{usuarioString != null ? usuarioString.trim() : "",
                    password != null ? password.trim() : ""});
        resultado = parseResultSetToClass(resultSet);

        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }

        return !resultado.isEmpty() ? resultado.get(0) : null;

    }

    public List<Usuario> getUsuarios(ConexionPosgresql paramConexionPosgresql) throws Exception {
        List<Usuario> resultado;
        ResultSet resultSet;
        String query = "SELECT * FROM USUARIO ORDER BY USUARIO";

        resultSet = paramConexionPosgresql.executeQueryPS(query,
                new Object[]{});
        resultado = parseResultSetToClass(resultSet);

        if (paramConexionPosgresql.isError()) {
            throw new Exception(paramConexionPosgresql.getMensaje() + " \nSQL: " + query);
        }

        return resultado;

    }

}

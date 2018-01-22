/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeansJDBC;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.Usuario;
import com.mario.sessionsbeans.UsuarioFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author rcolocho
 */
@Stateless
public class UsuarioFacadeJDBC extends AbstractFacadeJDBC {

    public Usuario obtenerUsuario(String usuario, String password, String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            return usuarioFacade.getUsuarioValidacion(usuario, password,conexionPosgresql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }
    
    public List<Usuario> obtenerListaUsuarios(String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            return usuarioFacade.getUsuarios(conexionPosgresql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }
    
     public void guardarUsuario(Usuario usuario,String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            usuarioFacade.create(usuario, conexionPosgresql);
            conexionPosgresql.commit();
        } catch (Exception e) {
            conexionPosgresql.rollback();
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }
     
}

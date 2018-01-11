/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeansJDBC;

import com.core.ConexionPosgresql;
import com.mario.dao.entities.Usuario;
import com.mario.sessionsbeans.UsuarioFacade;
import javax.ejb.Stateless;

/**
 *
 * @author rcolocho
 */
@Stateless
public class UsuarioFacadeJDBC extends AbstractFacadeJDBC {

    public Usuario obtenerUsuario(String usuario, String empresa) throws Exception {
        ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            return usuarioFacade.getUsuario(usuario, conexionPosgresql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexionPosgresql.cerrarConn();
        }
    }
}

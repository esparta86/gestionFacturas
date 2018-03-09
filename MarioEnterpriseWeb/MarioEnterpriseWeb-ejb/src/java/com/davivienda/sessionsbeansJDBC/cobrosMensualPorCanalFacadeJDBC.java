/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davivienda.sessionsbeansJDBC;

import com.core.ConexionPosgresql;
import com.davivienda.entities.cobrosMensualPorCanal;
import com.davivienda.sessionsbeans.cobrosMensualPorCanalFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Esparta_86
 */
@Stateless
@LocalBean
public class cobrosMensualPorCanalFacadeJDBC extends  AbstractFacadeJDBC{

   public void crearRegistro(String empresa,List<cobrosMensualPorCanal> lista) throws Exception{
      ConexionPosgresql conexionPosgresql = new ConexionPosgresql();
        try {
            conexionPosgresql.setConn(getJNDIConnection(empresa));
            cobrosMensualPorCanalFacade cobrosMensualPorCanalFacade1 = new cobrosMensualPorCanalFacade();
            cobrosMensualPorCanalFacade1.create(lista, conexionPosgresql);
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

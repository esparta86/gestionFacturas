/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.sessionsbeansJDBC;

import com.mario.util.Parametros.ParametrosReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author rcolocho
 */
public class AbstractFacadeJDBC {

    private SimpleDateFormat sdf;
    private SimpleDateFormat sdfFechaHora;
    private String jndiName;

    public AbstractFacadeJDBC() {
        sdf = new SimpleDateFormat("ddMMyyyy");
        sdfFechaHora = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
    }

    protected SimpleDateFormat getSdf() {
        return sdf;
    }

    protected void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    protected SimpleDateFormat getSdfFechaHora() {
        return sdfFechaHora;
    }

    protected void setSdfFechaHora(SimpleDateFormat sdfFechaHora) {
        this.sdfFechaHora = sdfFechaHora;
    }

    protected Connection getJNDIConnection(String codigoEmpresa) {
        jndiName = ParametrosReader.getParametroString("POOL_EMPRESA_" + codigoEmpresa);
        return getJNDIConnection();
    }

    protected Connection getJNDIConnectionByName(String jndiName) {
        this.jndiName = jndiName;
        return getJNDIConnection();
    }

    private Connection getJNDIConnection() {
        String DATASOURCE_CONTEXT = jndiName;

        Connection result = null;
        try {
            Context initialContext = new InitialContext();
            if (initialContext == null) {
                log("JNDI problem. Cannot get InitialContext.");
            }
            DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
            if (datasource != null) {
                result = datasource.getConnection();
                result.setAutoCommit(false);
            } else {
                log("Failed to lookup datasource.");
            }
        } catch (NamingException ex) {
            log("Cannot get connection: " + ex);
        } catch (SQLException ex) {
            log("Cannot get connection: " + ex);
        }

        return result;
    }

    private void log(Object aObject) {
        System.out.println(aObject);
    }

    protected String convertToInsertableSQL(String query) {
        query = query.replaceAll("^to_date('','yyyyMMdd')$", "null");
        query = query.replaceAll("^to_date('','yyyyMMdd HH24:MI:SS')$", "null");
        query = query.replaceAll("^''$", "null");

        return query;
    }

    protected void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }
}

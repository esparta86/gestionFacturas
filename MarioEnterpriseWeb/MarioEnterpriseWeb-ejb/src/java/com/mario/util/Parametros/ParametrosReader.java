/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.util.Parametros;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author gfclaros
 */
public class ParametrosReader {

    public static String getParametroString(String nombre) {
        String ARCHIVO_CONFIGURACION = "com.mario.util.Parametros.Parametros";
        ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
        String retorno = "";
        try {
            retorno = rb.getString(nombre);
        } catch (Exception e) {
            System.err.println("No se logro recuperar el parametro " + nombre + " del archivo Parametros.properties");
        } finally {
            return retorno;
        }
    }

    public static int getParametroInteger(String nombre) {
        String ARCHIVO_CONFIGURACION = "com.mario.util.Parametros.Parametros";
        ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
        int retorno = -1;
        try {
            retorno = Integer.parseInt(rb.getString(nombre));
        } catch (Exception e) {
            System.err.println("No se logro recuperar el parametro " + nombre + " del archivo Parametros.properties");
        } finally {
            return retorno;
        }
    }

    public static float getParametroFloat(String nombre) {
        String ARCHIVO_CONFIGURACION = "com.mario.util.Parametros.Parametros";
        ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
        float retorno = -1;
        try {
            retorno = Float.parseFloat(rb.getString(nombre));
        } catch (Exception e) {
            System.err.println("No se logro recuperar el parametro " + nombre + " del archivo Parametros.properties");
        } finally {
            return retorno;
        }
    }

    public static double getParametroDouble(String nombre) {
        String ARCHIVO_CONFIGURACION = "com.mario.util.Parametros.Parametros";
        ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
        double retorno = -1;
        try {
            retorno = Double.parseDouble(rb.getString(nombre));
        } catch (Exception e) {
            System.err.println("No se logro recuperar el parametro " + nombre + " del archivo Parametros.properties");
        } finally {
            return retorno;
        }
    }

    public static Date getParametroFecha(String nombre) {
        String ARCHIVO_CONFIGURACION = "com.mario.util.Parametros.Parametros";
        ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
        Date retorno = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            retorno = sdf.parse(rb.getString(nombre));
        } catch (Exception e) {
            System.err.println("No se logro recuperar el parametro " + nombre + " del archivo Parametros.properties");
        } finally {
            return retorno;
        }
    }
}

package com.davivienda.sessionsbeans;


import com.core.ConexionPosgresql;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractFacade
{
  private SimpleDateFormat sdf;
  private SimpleDateFormat sdfFechaHora;
  
  public AbstractFacade()
  {
    this.sdf = new SimpleDateFormat("ddMMyyyy");
    this.sdfFechaHora = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
  }
  
  protected SimpleDateFormat getSdf()
  {
    return this.sdf;
  }
  
  protected void setSdf(SimpleDateFormat sdf)
  {
    this.sdf = sdf;
  }
  
  protected SimpleDateFormat getSdfFechaHora()
  {
    return this.sdfFechaHora;
  }
  
  protected void setSdfFechaHora(SimpleDateFormat sdfFechaHora)
  {
    this.sdfFechaHora = sdfFechaHora;
  }
  
  public abstract void create(Object paramObject, ConexionPosgresql paramConexionPosgresql)
    throws Exception;
  
  public abstract void remove(Object paramObject, ConexionPosgresql paramConexionPosgresql)
    throws Exception;
  
  public abstract void edit(Object paramObject,ConexionPosgresql paramConexionPosgresql)
    throws Exception;
  
  public abstract Object find(Object paramObject,ConexionPosgresql paramConexionPosgresql)
    throws Exception;
  
  public abstract Object parseResultSetToClass(ResultSet paramResultSet)
    throws Exception;
  
 
  
  protected Object[] parseResultSetToObjectMatrix(ResultSet rs)
    throws Exception
  {
    ArrayList<Object> result = new ArrayList();
    if (rs.next())
    {
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 1; i <= rsmd.getColumnCount(); i++)
      {
        Object object = new Object();
        object = rs.getObject(i);
        result.add(object);
      }
    }
    return result.toArray();
  }
  
  public Date truncateDate(Date fecha)
  {
    try
    {
      if (fecha != null) {
        return this.sdf.parse(this.sdf.format(fecha));
      }
      return null;
    }
    catch (Exception e) {}
    return fecha;
  }
}

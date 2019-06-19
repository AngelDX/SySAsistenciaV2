/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.common;
import java.sql.*;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.frmLogin;
/**
 *
 * @author AngelDX
 */
public class ConectarDB {
  public Connection cn=null;
  public Statement st=null;
  public ResultSet rs=null;  
 
  public Connection conectar() throws Exception{
    try{      
      //String servidor="127.0.0.1";
      String servidor=frmLogin.ipdb;  
      String puerto="3306";
      String usuario="root";
      String password="";
      String basedatos="db_asistencia2";
      String driver="com.mysql.jdbc.Driver";
      String cadenaconexion="jdbc:mysql://"+servidor+":"+puerto+"/"+basedatos;
     System.out.println(cadenaconexion);
      Class.forName(driver);
      cn=DriverManager.getConnection(cadenaconexion,usuario,password);    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de conexion a la Base de Datos");
    }finally{ 
      return cn;
    }
  }
  
  public ResultSet ejecutarConsulta(String sql) throws Exception{
      st=cn.createStatement();
      rs=st.executeQuery(sql);
      return rs;
  }
  
  public void ejecutarActualizacion(String sql) throws Exception{
      st=cn.createStatement();
      st.executeUpdate(sql);
  }
  
  public void desconectar() throws Exception{
      cn.close();
  }
 
}

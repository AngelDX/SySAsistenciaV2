/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.common.Funciones;
import sysasistencia.angeldx.to.EventoTO;

/**
 *
 * @author AngelDX
 */
public class EventoManager {
  ConectarDB cnn=new ConectarDB();
  
  public ArrayList<EventoTO> listar() throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT * FROM evento ORDER BY id DESC";
        System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            EventoTO p=new EventoTO();
            p.setId(rs.getInt(1));
            p.setDescripcion(rs.getString(2));
            p.setFechaini(rs.getString(3));
            p.setFechafin(rs.getString(4));
            p.setUbicacion(rs.getString(5));
            p.setCosto1(rs.getDouble(6));
            p.setCosto2(rs.getDouble(7));
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    }
  
   public boolean registarEvento(EventoTO data) {
        try {
            String sql="INSERT INTO evento(descripcion,fechaini,fechafin,ubicación,costo1,costo2,costo3) VALUES(?,?,?,?,?,?,?)";
            System.out.println(sql);
            //cnn.conectar();
            int i=0;
            PreparedStatement ps=cnn.conectar().prepareStatement(sql);
            //ps.setInt(i++, data.getId());
            ps.setString(1, data.getDescripcion());
            ps.setString(2, Funciones.fechaMysql(data.getFechaini()));
            ps.setString(3, Funciones.fechaMysql(data.getFechafin()));
            ps.setString(4, data.getUbicacion());
            ps.setDouble(5, data.getCosto1());
            ps.setDouble(6, data.getCosto2());
            ps.setDouble(7, data.getCosto3());
                        
            if(ps.executeUpdate()==1){
                return true;
            }
            cnn.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return false;
    }
}

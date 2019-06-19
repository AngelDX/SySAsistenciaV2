/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.to.EstudianteTO;

/**
 *
 * @author AngelDX
 */
public class EstudianteManager {
   ConectarDB cnn=new ConectarDB();
   
   public ArrayList<EstudianteTO> listar(String codigo,String nombre) throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT * FROM estudiante WHERE codigo LIKE '"+codigo+"%'"
                + "AND nombre LIKE '"+nombre+"%' ORDER BY nombre";
        //System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            EstudianteTO p=new EstudianteTO();
            p.setId(rs.getInt(1));
            p.setCodigo(rs.getString(2));
            p.setNombre(rs.getString(3));
            p.setCarrera(rs.getString("carrera"));
            p.setCiclo(rs.getString("ciclo"));
            p.setGrupo(rs.getString("grupo"));
            
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    } 
   
   public ArrayList<EstudianteTO> listarCarreras() throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT DISTINCT carrera FROM estudiante GROUP BY carrera";
        //System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            EstudianteTO p=new EstudianteTO();           
            p.setCarrera(rs.getString(1));
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    } 
   
    public ArrayList<EstudianteTO> listarCiclo() throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT DISTINCT ciclo FROM estudiante GROUP BY ciclo ORDER BY ciclo ASC";
        //System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            EstudianteTO p=new EstudianteTO();           
            p.setCiclo(rs.getString(1));
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    } 
    
     public ArrayList<EstudianteTO> listarGrupo() throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT DISTINCT grupo FROM estudiante GROUP BY grupo ORDER BY grupo ASC";
        //System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            EstudianteTO p=new EstudianteTO();           
            p.setGrupo(rs.getString(1));
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    } 

    public EstudianteTO buscarPorId(Object id) {
        EstudianteTO est=null;
        try {
            cnn.conectar();
            String sql="SELECT * FROM estudiante WHERE id="+id;
            //System.out.println(sql);            
            ResultSet rs = cnn.ejecutarConsulta(sql);
           
            if(rs.next()){                
                est = new EstudianteTO();
                est.setId(rs.getInt(1));
                est.setCodigo(rs.getString(2));
                est.setNombre(rs.getString(3));
                est.setCarrera(rs.getString(4));
                est.setCiclo(rs.getString(5));
                est.setGrupo(rs.getString(6));
            }
            cnn.desconectar();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }        
        return est;
    }

    public void actualizar(EstudianteTO data) {
        try {
            Connection p = cnn.conectar();
            String sql="UPDATE estudiante SET voucher=?, importe=?, pago=? WHERE id=?";
            PreparedStatement ps = p.prepareStatement(sql);
            ps.setString(1, data.getVoucher());
            ps.setDouble(2, data.getImporte());
            ps.setBoolean(3, data.getPago());
            ps.setInt(4, data.getId());
            ps.executeUpdate();
            ps.close();
            cnn.desconectar();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
}

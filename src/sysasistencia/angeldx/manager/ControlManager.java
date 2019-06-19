/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.to.ControlTO;
import sysasistencia.angeldx.to.EstudianteTO;
import sysasistencia.angeldx.to.ParticipanteTO;

/**
 *
 * @author AngelDX
 */
public class ControlManager {
    ConectarDB cnn=new ConectarDB();
    
    public boolean registarControl(ControlTO data) {
        try {
            String sql="INSERT INTO control(estudiante_id,evento_id,fechahora,tipo) VALUES(?,?,?,?)";
            System.out.println(sql);
            //cnn.conectar();
            int i=0;
            PreparedStatement ps=cnn.conectar().prepareStatement(sql);
            //ps.setInt(i++, data.getId());
            ps.setInt(1, data.getEstudiante_id());
            ps.setInt(2, data.getEvento_id());
            ps.setString(3, data.getFechahora());
            ps.setString(4, data.getTipo());
            if(ps.executeUpdate()==1){
                return true;
            }
            cnn.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return false;
    }

    public EstudianteTO buscarEstudiante(String codigo) {
        EstudianteTO data=new EstudianteTO();
        try {            
            String sql="SELECT * FROM estudiante WHERE codigo='"+codigo+"'";            
            cnn.conectar();
            ResultSet rs = cnn.ejecutarConsulta(sql);
            if(rs.next()){  
                data.setId(rs.getInt("id"));
                data.setNombre(rs.getString("nombre"));
                data.setCodigo(rs.getString("codigo"));
                data.setCarrera(rs.getString("carrera"));
                                                   
            }else{
                data.setId(0);
            }
            cnn.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return data;
    }
    
    public Boolean verificarRegistro(int idEst,int idEve, String tipo){        
        try {            
            String sql="SELECT * FROM control WHERE estudiante_id="+idEst+" AND evento_id="+idEve+" AND tipo='"+tipo+"'";
            cnn.conectar();
            ResultSet rs=cnn.ejecutarConsulta(sql);
            if(rs.next()){
                return true;
            }else{
                return false;
            }         
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }      
        return false;
    }

    public ParticipanteTO buscarParticipante(String codigo) {
        ParticipanteTO data=new ParticipanteTO();
        try {            
            String sql="SELECT * FROM participante WHERE id='"+codigo+"'";            
            cnn.conectar();
            ResultSet rs = cnn.ejecutarConsulta(sql);
            if(rs.next()){  
                data.setId(rs.getInt("id"));
                data.setNombre(rs.getString("nombre"));
                data.setEmail(rs.getString("email"));
                data.setCelular(rs.getString("celular"));
                data.setTipo(rs.getString("tipo"));
                data.setEntidad(rs.getString("entidad"));
            }else{
                data.setId(0);
            }
            cnn.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return data;
    }
    
    public Boolean verificarRegistroPart(int idEst,int idEve, String tipo){        
        try {            
            String sql="SELECT * FROM control WHERE participante_id="+idEst+" AND evento_id="+idEve+" AND tipo='"+tipo+"'";
            cnn.conectar();
            ResultSet rs=cnn.ejecutarConsulta(sql);
            if(rs.next()){
                return true;
            }else{
                return false;
            }         
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }      
        return false;
    }
    
    public boolean registarControlPart(ControlTO data) {
        try {
            String sql="INSERT INTO control(evento_id,fechahora,tipo,participante_id) VALUES(?,?,?,?)";           
            //cnn.conectar();
            //int i=0;
            PreparedStatement ps=cnn.conectar().prepareStatement(sql);
            //ps.setInt(i++, data.getId());            
            ps.setInt(1, data.getEvento_id());
            ps.setString(2, data.getFechahora());
            ps.setString(3, data.getTipo());
            ps.setInt(4, data.getParticipante_id());
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

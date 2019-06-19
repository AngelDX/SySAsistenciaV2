/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sysasistencia.angeldx.manager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.to.EventoTO;
import sysasistencia.angeldx.to.VoucherTO;

/**
 *
 * @author AngelDX
 */
public class VoucherManager {
    ConectarDB cnn=new ConectarDB();
    
     public boolean registarVoucher(VoucherTO data) {
        try {
            String sql="INSERT INTO voucher(estudiante_id,evento_id,numero,importe,tipo)  VALUES(?,?,?,?,?)";
            System.out.println(sql);
            //cnn.conectar();
            int i=0;
            PreparedStatement ps=cnn.conectar().prepareStatement(sql);
            //ps.setInt(i++, data.getId());
            ps.setInt(1, data.getEstudiante_id());
            ps.setInt(2, data.getEvento_id());
            ps.setString(3, data.getNumero());
            ps.setDouble(4, data.getImporte());
            ps.setString(5, data.getTipo());
            if(ps.executeUpdate()==1){
                return true;
            }
            cnn.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return false;
    }

   public ArrayList<VoucherTO> listarVoucherId(int id) throws Exception{
        ArrayList data=new ArrayList();
        String sql="SELECT * FROM voucher v,evento e WHERE v.evento_id=e.id AND estudiante_id="+id;
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        while(rs.next()){
            VoucherTO p=new VoucherTO();
            EventoTO pp=new EventoTO();
            p.setId(rs.getInt(1));
            p.setEstudiante_id(rs.getInt(2));
            p.setEvento_id(rs.getInt(3));
            p.setNumero(rs.getString(4));
            p.setImporte(rs.getDouble(5));
            p.setTipo(rs.getString(6));
            pp.setDescripcion(rs.getString("descripcion"));
            p.setEventoData(pp);
            data.add(p);
        }        
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return data;
    }     
    
}

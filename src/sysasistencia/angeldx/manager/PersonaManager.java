/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.manager;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.to.PersonaTO;

/**
 *
 * @author Alumno
 */
public class PersonaManager {
    ConectarDB cnn=new ConectarDB();    
    
    public PersonaTO verificarLogin(String usu,String pas){
        ArrayList data=new ArrayList();
        PersonaTO p = null;
        String sql="SELECT * FROM persona WHERE usu_pe='"+usu+"' AND pas_pe='"+pas+"'";
        //System.out.println(sql);
      try{
        cnn.conectar();
        ResultSet rs=cnn.ejecutarConsulta(sql);
        if(rs.next()){
            p=new PersonaTO();
            p.setId_persona(rs.getString(1));            
            p.setNom_pe(rs.getString(2));
            p.setDni_pe(rs.getString(3));
            p.setDir_pe(rs.getString(4));
            p.setCel_pe(rs.getString(5));
            p.setEma_pe(rs.getString(6));
            p.setNiv_pe(rs.getString(7));
            p.setUsu_pe(rs.getString(8));
            p.setPas_pe(rs.getString(9));
            p.setAct_pe(rs.getString(10));
            p.setFec_pe(rs.getString(11));
        }else{
           p=new PersonaTO();
           p.setNom_pe(""); 
        }       
        rs.close();
        cnn.desconectar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
        return p;
    }
}

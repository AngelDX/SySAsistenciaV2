/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.reportes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.common.Funciones;

/**
 *S
 * @author AngelDX
 */
public class ReporteAsistentes {
    ConectarDB cnn=new ConectarDB();
    
    public void ver_reporte(){
     try{
         String rutaInforme="reportes\\reporteasistencia.jasper";
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,null,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Estudiantes");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }
    public void reporteEventos(String evento, String carrera, String tipo){
     try{     
         //JOptionPane.showMessageDialog(null, evento+"  "+carrera);
         String rutaInforme="reportes\\reporteasistencia.jasper";
         Map parametros=new HashedMap();
         parametros.put("evento",evento);
         parametros.put("carrera",carrera);
         parametros.put("tipo", tipo);
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);         
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Estudiantes");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }
    public void imprimirCertificados(){
     try{     
         //JOptionPane.showMessageDialog(null, evento+"  "+carrera);
         String rutaInforme="reportes\\reportecertificado.jasper";
         //Map parametros=new HashedMap();
 
        JasperPrint informe=JasperFillManager.fillReport(rutaInforme,null,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Imprimir Certificados");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }
    public void imprimirCodigoBarras(){
     try{     
         //JOptionPane.showMessageDialog(null, evento+"  "+carrera);
         String rutaInforme="reportes\\reportebarras.jasper";
         //Map parametros=new HashedMap();
 
        JasperPrint informe=JasperFillManager.fillReport(rutaInforme,null,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Imprimir Codigo de Barras");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }    
    public void reporteCajaMes(String anio, String mes) {
       try{         
         String rutaInforme="reportes\\cajames.jasper";
         Map parametros=new HashedMap();
         System.out.println(Funciones.mesNumeros(mes));
         parametros.put("anio",anio);
         parametros.put("mes",Funciones.mesNumeros(mes));
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);         
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Caja");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      } 
    }
    
    public void reporteEntreFechas(String fecini, String fecfin) {
       try{         
         String rutaInforme="reportes\\cajafechas.jasper";
         Map parametros=new HashedMap();                  
         
         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd"); //Permiete convertir String en Date
         String strFecha1 = Funciones.fechaMysql(fecini);
         String strFecha2 = Funciones.fechaMysql(fecfin);
         
         Date fecha1 = formatoDelTexto.parse(strFecha1);
         Date fecha2 = formatoDelTexto.parse(strFecha2);
         
         parametros.put("fechaini",fecha1);
         parametros.put("fechafin",fecha2);
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);         
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Caja");
         ventanvisor.setVisible(true);
      }catch (Exception e){
         JOptionPane.showMessageDialog(null,e.getMessage());
      } 
    }    

    public void imprimirListaEstudiantes() {
        try{
         String rutaInforme="reportes\\reporteestudiantes.jasper";
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,null,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Estudiantes");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }

    public void reporteAsistenciaGeneral(String evento, String tipo) {
    try{     
         //JOptionPane.showMessageDialog(null, evento+"  "+carrera);
         String rutaInforme="reportes\\reporteasistentes.jasper";
         Map parametros=new HashedMap();
         parametros.put("evento",evento);
         parametros.put("tipo", tipo);
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);         
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Estudiantes");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }

    public void reporteNoAsistenciaGeneral(String evento) {
    try{     
         //JOptionPane.showMessageDialog(null, evento+"  "+carrera);
         String rutaInforme="reportes\\reportenoasistentes.jasper";
         Map parametros=new HashedMap();
         parametros.put("evento",evento);
         JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,cnn.conectar());
         //JasperPrintManager.printReport(informe, true);         
         JasperViewer ventanvisor=new JasperViewer(informe,false);
         ventanvisor.setTitle("Reporte de Estudiantes");
         ventanvisor.setVisible(true);
      }catch (Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
    }
}

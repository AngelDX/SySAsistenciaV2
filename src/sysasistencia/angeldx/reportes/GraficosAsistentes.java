/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.reportes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;
import sysasistencia.angeldx.common.ConectarDB;
import sysasistencia.angeldx.common.Funciones;
/**
 *
 * @author AngelDX
 */
public class GraficosAsistentes { 
 ConectarDB cnn=new ConectarDB(); 
  public void graficoCircular(){  
    DefaultPieDataset data=new DefaultPieDataset();
        try {            
            cnn.conectar();
            String sql="SELECT sexo,COUNT(sexo) as cantidad  FROM sd_paciente GROUP BY sexo";
            ResultSet rs=cnn.ejecutarConsulta(sql);
            //data.setValue("Categoria 1", 43.2);
            //data.setValue("Categoria 2", 27.9);            
            //data.setValue("Categoria 3", 79.5);
            while(rs.next()){
                data.setValue(rs.getString("sexo"), Double.parseDouble(rs.getString("cantidad")));
            }            
            JFreeChart grafico=ChartFactory.createPieChart("Grafico de Pacientes", data, true, true, true);    
            ChartFrame frame=new ChartFrame("Reporte Grafico por Género", grafico);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       

  }
  
  public void graficoTorres(){
      //Crear el dataset...
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try{
        cnn.conectar();
        String sql="SELECT fecha,SUM(debito)as debito,SUM(credito) as credito  FROM sd_pagos GROUP BY fecha";
        ResultSet rs=cnn.ejecutarConsulta(sql);
	//dataset.addValue(1.0, "Fila 1", "Columna 1");
        //dataset.addValue(2.0, "Fila 2", "Columna 1");
	//dataset.addValue(5.0, "Fila 1", "Columna 2");
        //dataset.addValue(3.0, "Fila 2", "Columna 2");
	//dataset.addValue(3.0, "Fila 1", "Columna 3");		
	//dataset.addValue(2.0, "Fila 2", "Columna 3");
        while(rs.next()){        
            dataset.addValue(Double.parseDouble(rs.getString("debito")),"Debito",Funciones.fechaNormal(rs.getString("fecha").substring(0,10)));
            dataset.addValue(Double.parseDouble(rs.getString("credito")),"Credito",Funciones.fechaNormal(rs.getString("fecha").substring(0,10)));
        }        
	//Crear el gráfico...
	JFreeChart chart = ChartFactory.createBarChart("Gráfico de Pagos y deudas por dia","Días","Nuevos Soles",dataset,	//Dataset
			PlotOrientation.VERTICAL,
			true,
			true,
			false);
	//crear y visualizar una ventana...
	ChartFrame frame = new ChartFrame("First", chart);
	frame.pack();
        frame.setLocationRelativeTo(null);
	frame.setVisible(true);	
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
  }
}

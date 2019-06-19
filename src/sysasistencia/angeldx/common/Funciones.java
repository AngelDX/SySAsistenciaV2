/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AngelDX
 */
public class Funciones {
    
    public static String calcularEdad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String[] dat1 = fecha_nac.split("/");
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            anos = anos - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                anos = anos - 1;
            }
        }
        return String.valueOf(anos);
    }
    
    public static String fechaMysql(String fechaNormal){
        String [] fechac = fechaNormal.split("/");
        String fechaMySql = fechac[2]+"-"+ fechac[1]+"-"+fechac[0];
        return fechaMySql;  
    }
    
    public static String fechaNormal(String fechaMysql){
        String [] fechac = fechaMysql.split("-");
        String fechaNormal = fechac[2]+"/"+ fechac[1]+"/"+fechac[0];
        return fechaNormal;
    }
    
    public static String mesLetras(String mes){        
        String m = null;
        switch(mes){
            case "1":m="Enero";break;
            case "2":m="Febrero";break;
            case "3":m="Marzo";break;   
            case "4":m="Abril";break;    
            case "5":m="Mayo";break;
            case "6":m="Junio";break;    
            case "7":m="Julio";break;    
            case "8":m="Agosto";break;    
            case "9":m="Septiembre";break;
            case "10":m="Octubre";break;    
            case "11":m="Noviembre";break;    
            case "12":m="Diciembre";break;    
            default: m="error";break;
        }
        return m;
    }
    
    public static String mesNumeros(String mes){        
        String m = null;
        switch(mes){
            case "Enero":m="1";break;
            case "Febrero":m="2";break;
            case "Marzo":m="3";break;   
            case "Abril":m="4";break;    
            case "Mayo":m="5";break;
            case "Junio":m="6";break;    
            case "Julio":m="7";break;    
            case "Agosto":m="8";break;    
            case "Septiembre":m="9";break;
            case "Octubre":m="10";break;    
            case "Noviembre":m="11";break;    
            case "Diciembre":m="12";break;    
            default: m="error";break;
        }
        return m;
    }
    
    public static String diaLetras(String dia){        
        String d = null;
        switch(dia){
            case "1":d="Domingo";break;
            case "2":d="Lunes";break;
            case "3":d="Martes";break;   
            case "4":d="Miercoles";break;    
            case "5":d="Jueves";break;
            case "6":d="Viernes";break;    
            case "7":d="Sabado";break;               
        }
        return d;
    }
    
    public static double redondear(double numero,int digitos){
        int cifras=(int) Math.pow(10, digitos);
        return  Math.rint(numero*cifras)/cifras;
    }
    
    public static String carreraFull(String carrera){
      if(carrera!=null){  
        switch(carrera){
            case "Adm.":carrera="ADMINISTRACION";break;
            case "Adm. Neg. Int":carrera="ADMINISTRACION Y NEGOCIOS INTERNACIONALES";break;
            case "AG.Jul.":carrera="ASISTENCIA GERENCIAL";break;
            case "Cont.":carrera="CONTABILIDAD";break;
            case "Cont.Gest":carrera="CONTABILIDAD Y GESTION TRIBUTARIA";break;
            case "":carrera="SIN CARRERA";
            default: carrera="SIN CARRERA";
        }
      }  
        return carrera;
    }
}

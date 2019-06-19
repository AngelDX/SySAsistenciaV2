/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.to;

/**
 *
 * @author AngelDX
 */
public class EventoTO {
    private int id;
    private String descripcion;
    private String fechaini;
    private String fechafin;
    private String ubicacion;
    private Double costo1;
    private Double costo2;
    private Double costo3;

    public Double getCosto1() {
        return costo1;
    }

    public void setCosto1(Double costo1) {
        this.costo1 = costo1;
    }

    public Double getCosto2() {
        return costo2;
    }

    public void setCosto2(Double costo2) {
        this.costo2 = costo2;
    }

    public Double getCosto3() {
        return costo3;
    }

    public void setCosto3(Double costo3) {
        this.costo3 = costo3;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}

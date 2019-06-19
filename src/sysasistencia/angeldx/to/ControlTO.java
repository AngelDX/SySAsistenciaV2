/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.to;

/**
 *
 * @author AngelDX
 */
public class ControlTO {
    private Integer id;
    private Integer estudiante_id;
    private Integer evento_id;
    private String fechahora;
    private String tipo; //Entrada o Salida
    private EstudianteTO estudiante; //Relacion de asociación
    private EventoTO evento;
    private Integer participante_id;

    public Integer getParticipante_id() {
        return participante_id;
    }

    public void setParticipante_id(Integer participante_id) {
        this.participante_id = participante_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Integer estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Integer getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstudianteTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteTO estudiante) {
        this.estudiante = estudiante;
    }

    public EventoTO getEvento() {
        return evento;
    }

    public void setEvento(EventoTO evento) {
        this.evento = evento;
    }
    
    
    
}

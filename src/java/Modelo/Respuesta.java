/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rae
 */


@Entity
@Table(name="Respuesta")
public class Respuesta implements Serializable {
    
    @Id @Column(name="IDRespuesta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_respuesta;
    
    @Column(name="Descripcion")
    private String descripcion;
    
    @Column(name="Evaluacion")
    private int evaluacion;
    
    @Column(name="Reportada")
    private int reportada;
    
    @ManyToOne
    @JoinColumn(name="UsuarioNombre_usuario")
    private Usuario login;
    
    @ManyToOne
    @JoinColumn(name="PreguntaIDPregunta")
    private Pregunta id_pregunta;

    @OneToOne(mappedBy="id_respuesta_satisfactoria")
    private Pregunta pregunta;
    
    public int getId_respuesta() {
        return id_respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEvaluacion() {
        return evaluacion;
    }

    public int getReportada() {
        return reportada;
    }

    public Usuario getLogin() {
        return login;
    }

    public Pregunta getId_pregunta() {
        return id_pregunta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setReportada(int reportada) {
        this.reportada = reportada;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public void setId_pregunta(Pregunta id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

}

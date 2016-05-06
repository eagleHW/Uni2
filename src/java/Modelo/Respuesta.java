/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rae
 */


@Entity
@Table(name="Respuesta")
public class Respuesta {
    
    @Id @Column(name="IDRespuesta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_respuesta;
    
    @Column(name="Descripcion")
    private String descripcion;
    
    @Column(name="Evaluacion")
    private int evaluacion;
    
    @Column(name="Reportada")
    private int reportada;
    
    @Column(name="UsuarioNombre_usuario")
    private String login;
    
    @Column(name="PreguntaIDPregunta")
    private int id_pregunta;

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

    public String getLogin() {
        return login;
    }

    public int getId_pregunta() {
        return id_pregunta;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }
    
    
}

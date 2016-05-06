/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
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
@Table(name = "Pregunta")
public class Pregunta {

   @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "IDPregunta")
   private int id_pregunta;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Desactivada")
    private int desactivada;

    @Column(name = "Reportada")
    private int reportada;

    @Column(name = "Revisada")
    private int revisada;

    @Column(name = "SatisfactoriaIDrespuesta")
    private int id_respuesta_satisfactoria;

    @Column(name = "UsuarioNombre_usuario")
    private String login;

    @Column(name = "CarreraIDCarrera")
    private int carrera;

    public int getId_pregunta() {
        return id_pregunta;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDesactivada() {
        return desactivada;
    }

    public int getReportada() {
        return reportada;
    }

    public int getRevisada() {
        return revisada;
    }

    public int getId_respuesta_satisfactoria() {
        return id_respuesta_satisfactoria;
    }

    public String getLogin() {
        return login;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDesactivada(int desactivada) {
        this.desactivada = desactivada;
    }

    public void setReportada(int reportada) {
        this.reportada = reportada;
    }

    public void setRevisada(int revisada) {
        this.revisada = revisada;
    }

    public void setId_respuesta_satisfactoria(int id_respuesta_satisfactoria) {
        this.id_respuesta_satisfactoria = id_respuesta_satisfactoria;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
    
    

}

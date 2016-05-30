/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name = "Pregunta")
public class Pregunta implements Serializable {

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

    @OneToOne
    @JoinColumn(name = "SatisfactoriaIDrespuesta")
    private Respuesta id_respuesta_satisfactoria;

    @ManyToOne
    @JoinColumn(name = "UsuarioNombre_usuario")
    private Usuario login;

    @ManyToOne
    @JoinColumn(name = "CarreraIDCarrera")
    private Carrera carrera;

    @OneToMany(mappedBy="id_pregunta")
    @OrderBy("id_respuesta")
    private List<Respuesta> respuestas = new LinkedList();

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

    public Respuesta getId_respuesta_satisfactoria() {
        return id_respuesta_satisfactoria;
    }

    public Usuario getLogin() {
        return login;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
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

    public void setId_respuesta_satisfactoria(Respuesta id_respuesta_satisfactoria) {
        this.id_respuesta_satisfactoria = id_respuesta_satisfactoria;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
}

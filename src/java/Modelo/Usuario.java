/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

    @Id @Column(name="Nombre_usuario")
    private String login;
    
    @Column(name="Contrasenia")
    private String contraseña;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="ApellidoPat")
    private String apellido_paterno;
    
    @Column(name="ApellidoMat")
    private String apellido_materno;
    
    @Column(name="Correo")
    private String correo;
    
    @Column(name="Facebook")
    private String facebook;
    
    @Column(name="Whatsapp")
    private BigInteger whatsapp;
    
    @Column(name="Rango")
    private String rango;
    
    @Column(name="Bloqueado")
    private int bloqueado;
    
    @ManyToOne
    @JoinColumn(name="CarreraIDCarrera")
    private Carrera carrera;

    @OneToMany(mappedBy="login")
    private List<Pregunta> preguntas = new LinkedList<Pregunta>(); 

    @OneToMany(mappedBy="login")
    private List<Respuesta> respuestas = new LinkedList<Respuesta>(); 
    
    // Cuidado con que se cierre la sesion antes de obtener los datos
    //http://stackoverflow.com/questions/21944868/failed-to-lazily-initialize-a-collection-due-to-no-session
    @OneToOne(mappedBy="login", fetch=FetchType.LAZY)
    private Monitor monitor;
    
    // Cuidado con que se cierre la sesion antes de obtener los datos
    //http://stackoverflow.com/questions/21944868/failed-to-lazily-initialize-a-collection-due-to-no-session
    @OneToOne(mappedBy="login", fetch=FetchType.LAZY)
    private Administrador administrador;

    public String getLogin() {
        return login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFacebook() {
        return facebook;
    }

    public BigInteger getWhatsapp() {
        return whatsapp;
    }

    public String getRango() {
        return rango;
    }

    public int getBloqueado() {
        return bloqueado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setWhatsapp(BigInteger whatsapp) {
        this.whatsapp = whatsapp;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}

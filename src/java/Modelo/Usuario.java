/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name="Usuario")
public class Usuario{

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
    
    @Column(name="CarreraIDCarrera")
    private int id_carrera;

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

    public int getId_carrera() {
        return id_carrera;
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

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    
    
    
    
}

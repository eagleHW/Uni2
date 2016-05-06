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
@Table(name="Administrador")
public class Administrador {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDAdmon")
    private int id_administrador;
    
    @Column(name="Rol")
    private String rol;
    
    @Column(name="UsuarioNombre_usuario")
    private String login;

    public int getId_administrador() {
        return id_administrador;
    }

    public String getRol() {
        return rol;
    }

    public String getLogin() {
        return login;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
    
    
    
    
}

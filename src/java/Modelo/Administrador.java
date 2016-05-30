/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name="Administrador")
public class Administrador implements Serializable {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDAdmon")
    private int id_administrador;
    
    @Column(name="Rol")
    private String rol;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UsuarioNombre_usuario")
    private Usuario login;

    public int getId_administrador() {
        return id_administrador;
    }

    public String getRol() {
        return rol;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

}

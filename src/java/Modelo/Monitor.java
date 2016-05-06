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
@Table(name="Monitor")
public class Monitor {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDMonitor")
    private int id_monitor;
    
    @Column(name="Aceptado")
    private int aceptado;
    
    @Column(name="UsuarioNombre_usuario")
    private String login;

    public int getId_monitor() {
        return id_monitor;
    }

    public int getAceptado() {
        return aceptado;
    }

    public String getLogin() {
        return login;
    }

    public void setId_monitor(int id_monitor) {
        this.id_monitor = id_monitor;
    }

    public void setAceptado(int aceptado) {
        this.aceptado = aceptado;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
    
}

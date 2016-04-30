/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

/**
 *
 * @author rae
 */
public class Usuario {

    private String login;
    private String password;
    private String nombre;
    private String correo;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
}

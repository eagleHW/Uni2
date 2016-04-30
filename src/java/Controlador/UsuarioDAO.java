/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import javax.sql.DataSource;

/**
 *
 * @author rae
 */
public interface UsuarioDAO {
    
    public void setDataSource(DataSource ds);
    
    public void create(String login, String password, String nombre, String correo);
    
}

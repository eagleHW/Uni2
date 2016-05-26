/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import javax.sql.DataSource;
import Modelo.Usuario;

/**
 *
 * @author rae
 */
public interface UsuarioDAO {
    
    public void create(Usuario usuario, int id_carrera);
    
    public void update(String login, String[] columnas, String[] valores);
 
    public void update(String login, Usuario usuario);
    
    public Usuario get(String login);
    
    public boolean login(String login, String password);
    
}

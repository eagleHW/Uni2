/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rae
 */
public class UsuarioJDBCTemplate implements UsuarioDAO{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    @Override
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public void create(String login, String password, String nombre, String correo) {
        
        String SQL = "insert into usuario values (?,?,?,?)";
        jdbcTemplateObject.update(SQL, login, password, nombre, correo);
        
    }
    
}

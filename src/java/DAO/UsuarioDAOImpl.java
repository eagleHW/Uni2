/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Usuario;
import java.math.BigInteger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 *
 * @author rae
 */
public class UsuarioDAOImpl implements UsuarioDAO{

    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Usuario usuario) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(usuario);
        tx.commit();
        session.close();
        
    }

    @Override
    public void update(String login, String[] columnas, String[] valores) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Usuario usuario = (Usuario)session.get(Usuario.class, login);
        int num_valor = 0;
        
        for (String columna : columnas) {
        
            switch(columna){
                
                case "login":
                    usuario.setLogin(valores[num_valor]);
                    break;
                
                case "contraseña":
                    usuario.setContraseña(valores[num_valor]);
                    break;
                
                case "nombre":
                    usuario.setNombre(valores[num_valor]);
                    break;
                
                case "apellido_paterno":
                    usuario.setApellido_paterno(valores[num_valor]);
                    break;
                    
                case "apellido_materno":
                    usuario.setApellido_materno(valores[num_valor]);
                    break;
                
                case "correo":
                    usuario.setCorreo(valores[num_valor]);
                    break;
                    
                case "facebook":
                    usuario.setFacebook(valores[num_valor]);
                    break;
                        
                case "whatsapp":
                    usuario.setWhatsapp(new BigInteger(valores[num_valor]));
                    break;
                        
                case "rango":
                    usuario.setRango(valores[num_valor]);
                    break;
                    
                case "bloqueado":
                    usuario.setBloqueado(Integer.parseInt(valores[num_valor]));         
                    break;
                
                case "id_carrera":
                     usuario.setId_carrera(Integer.parseInt(valores[num_valor]));       
                    break;
                
                    
            }
            
            num_valor++;
            
        }
        
        session.update(usuario); 
        tx.commit();
        session.close();
    
    }

    public void update(String login, Usuario usuario){
    
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Usuario datos_usuario = (Usuario)session.get(Usuario.class, login);
        
        datos_usuario.setLogin(usuario.getLogin());
        datos_usuario.setNombre(usuario.getNombre());
        datos_usuario.setApellido_materno(usuario.getApellido_materno());
        datos_usuario.setApellido_paterno(usuario.getApellido_paterno());
        datos_usuario.setCorreo(usuario.getCorreo());
        datos_usuario.setFacebook(usuario.getFacebook());
        datos_usuario.setWhatsapp(usuario.getWhatsapp());
        datos_usuario.setRango(usuario.getRango());
        datos_usuario.setBloqueado(usuario.getBloqueado());
        datos_usuario.setId_carrera(usuario.getId_carrera());
        
        session.update(datos_usuario);
        tx.commit();
        session.close();
        
    }
    
    @Override
    public boolean login(String login, String password) {
     
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Usuario usuario = (Usuario)session.get(Usuario.class, login);
        tx.commit();
        session.close();
        
        Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        
        if(usuario == null || !( encoderMD5.isPasswordValid(usuario.getContraseña(),password,"aes2016-1")) ){
            return false;
        }
        
        return true;
    
    }

    @Override
    public Usuario get(String login) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Usuario usuario = (Usuario)session.get(Usuario.class, login);
        tx.commit();
        session.close();
        
        return usuario;
        
    }

    
}

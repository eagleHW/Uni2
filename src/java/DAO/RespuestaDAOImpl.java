/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Carrera;
import Modelo.Pregunta;
import Modelo.Respuesta;
import Modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rae
 */
public class RespuestaDAOImpl implements RespuestaDAO{

    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void create(Respuesta respuesta, String login, int id_pregunta) {
      
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Usuario usuario = (Usuario)session.get(Usuario.class,login);
        Pregunta pregunta = (Pregunta)session.get(Pregunta.class,id_pregunta);
    
        respuesta.setLogin(usuario);
        respuesta.setId_pregunta(pregunta);
        
        usuario.getRespuestas().add(respuesta);
        pregunta.getRespuestas().add(respuesta);
        
        session.persist(respuesta);
        session.save(usuario);
        session.save(pregunta);
        
        tx.commit();
        session.close();
        
    }

    @Override
    public void aceptar_repuesta(int id_pregunta, int id_respuesta) {
    
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
     
        Pregunta pregunta = (Pregunta)session.get(Pregunta.class,id_pregunta);
        Respuesta respuesta = (Respuesta)session.get(Respuesta.class, id_respuesta);
        
        Respuesta respuesta_aceptada_anterior;
        
        if(pregunta.getId_respuesta_satisfactoria() == null ){
            pregunta.setId_respuesta_satisfactoria(respuesta);
            respuesta.setId_pregunta_satisfactoria(pregunta);
        }else{
            
            respuesta_aceptada_anterior = pregunta.getId_respuesta_satisfactoria();
            respuesta_aceptada_anterior.setId_pregunta_satisfactoria(null);
            pregunta.setId_respuesta_satisfactoria(respuesta);
            respuesta.setId_pregunta_satisfactoria(pregunta);
            
            session.save(respuesta_aceptada_anterior);
        }
               
        session.save(pregunta);
        session.save(respuesta);
        
        tx.commit();
        session.close();
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Carrera;
import Modelo.Pregunta;
import Modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rae
 */
public class PreguntaDAOImpl implements PreguntaDAO{

    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Pregunta pregunta, String login, int id_carrera) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Usuario usuario = (Usuario)session.get(Usuario.class,login);
        Carrera carrera = (Carrera)session.get(Carrera.class,id_carrera);
        
        pregunta.setLogin(usuario);
        pregunta.setCarrera(carrera);
        
        usuario.getPreguntas().add(pregunta);
        carrera.getPreguntas().add(pregunta);
        
        
        session.persist(pregunta);
        session.save(usuario);
        session.save(carrera);
                
        tx.commit();
        session.close();
    }

    @Override
    public Pregunta get(int pregunta_id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Pregunta pregunta = (Pregunta)session.get(Pregunta.class, pregunta_id);
        tx.commit();
        session.close();
    
        return pregunta;
        
    }

    @Override
    public List<Pregunta> get(int offset, int limit) {
        
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Pregunta P ORDER BY P.id_pregunta DESC";
        Query query = session.createQuery(hql);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<Pregunta> results = query.list();
        
        session.close();
        
    return results;
    
    }
    
    
}

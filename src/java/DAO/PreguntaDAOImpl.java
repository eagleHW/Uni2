/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Pregunta;
import Modelo.Usuario;
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
    public void create(Pregunta pregunta) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(pregunta);
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Carrera;
import Modelo.Pregunta;
import Modelo.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
        Hibernate.initialize(pregunta.getRespuestas());
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

    @Override
    public int num_answers(int id_pregunta) {
      
        Session session = this.sessionFactory.openSession();
        String hql = "SELECT count(R.id_respuesta) FROM Respuesta R WHERE R.id_pregunta.id_pregunta = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id_pregunta);
        Number num_answers = (Number)query.uniqueResult();
        
        session.close();
    
        return num_answers.intValue();
    
    }

    @Override
    public void reportar_pregunta(int id_pregunta) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Pregunta pregunta = (Pregunta)session.get(Pregunta.class, id_pregunta);
        
        pregunta.setReportada( pregunta.getReportada() + 1);
        
        session.update(pregunta);
        
        tx.commit();
        session.close();
    
    }

    @Override
    public List<Pregunta> buscar(String palabra_clave, String usuario, Date fecha, int id_carrera) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
    
        Criteria criteria = session.createCriteria(Pregunta.class);
        Conjunction and = Restrictions.conjunction();
        
        if(!palabra_clave.equals("")){
            Criterion restriccion_titulo_palabra_clave = Restrictions.ilike("titulo", "%"+palabra_clave+"%");
            Criterion restriccion_descripcion_palabra_clave = Restrictions.ilike("descripcion","%"+palabra_clave+"%");
            Criterion restriccion_palabra_clave = Restrictions.or(restriccion_titulo_palabra_clave, 
                                                                  restriccion_descripcion_palabra_clave);
            and.add(restriccion_palabra_clave);
        }
        
        if(!usuario.equals("")){
           Criterion restriccion_usuario = Restrictions.ilike("login.login","%"+usuario+"%");
           and.add(restriccion_usuario);
        }
        
        if(fecha != null){
            Criterion restriccion_fecha = Restrictions.eq("fecha", fecha);
            and.add(restriccion_fecha);
        }
        
        if(id_carrera != -1){
            Criterion restriccion_id_carrera = Restrictions.eq("carrera.id_carrera", id_carrera);
            and.add(restriccion_id_carrera);
        }
        
        criteria.add(and);
        criteria.addOrder(Order.desc("id_pregunta"));
        
        List<Pregunta> results = criteria.list();
        
        tx.commit();
        session.close();
    
        return results;
        
    }
    
    
}

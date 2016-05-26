/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Carrera;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author rae
 */
public class CarreraDAOImpl implements CarreraDAO {
    
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Carrera> getCarreras() {
        
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Carrera";
        Query query = session.createQuery(hql);
        List results = query.list();
        session.close();
       
        return results;
    }
    
}

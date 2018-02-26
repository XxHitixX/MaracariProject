/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.GradoDao;
import com.Util.HibernateUtil;
import com.pojo.Grado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ana Sofia
 */
public class GradoDaoImp implements GradoDao {

    @Override
    public List<Grado> BuscarTodos() {
        List<Grado> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Grado";

        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void crear(Grado g) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(g);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public void editar(Grado g) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(g);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Grado g) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(g);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public Grado BuscarID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Grado WHERE id = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        
        return (Grado) q.uniqueResult();
    }
    
    
}

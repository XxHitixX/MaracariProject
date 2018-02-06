/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Util.HibernateUtil;
import com.pojo.Alumnogrado;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Dao.GradoAlumnoDao;

/**
 *
 * @author Ana Sofia
 */
public class GradoAlumnoDaoImp implements GradoAlumnoDao {

    @Override
    public List<Alumnogrado> BuscarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Alumnogrado";
        List<Alumnogrado> lista = null;

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void insertar(Alumnogrado a) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void editar(Alumnogrado a) {
       Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void elimiar(Alumnogrado a) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(a);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

}

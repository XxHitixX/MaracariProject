/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.MateriaDao;
import com.Util.HibernateUtil;
import com.pojo.Materia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ana Sofia
 */
public class MateriaDaoImp implements MateriaDao {

    @Override
    public List<Materia> BuscarTodos() {
        List<Materia> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Materia";
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
    public void crear(Materia p) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        
    }

    @Override
    public void editar(Materia p) {
       Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Materia p) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public Materia BuscarID(Integer id) {
        String hql = "FROM Materia WHERE id = :id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery(hql);
        q.setParameter("id", id);
        
        return (Materia) q.uniqueResult();
    }

}

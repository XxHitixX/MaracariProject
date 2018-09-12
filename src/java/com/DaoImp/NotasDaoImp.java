/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.NotasDao;
import com.Util.HibernateUtil;
import com.pojo.Notas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ana Sofia
 */
public class NotasDaoImp implements NotasDao{

    @Override
    public List<Notas> buscarnotas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from * Notas";
        List<Notas> lista = null;
        Transaction t = session.beginTransaction();
        
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        
        return lista;
    }

    @Override
    public void crear(Notas n) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            session.save(n);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Notas n) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            session.update(n);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Notas n) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            session.delete(n);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public Notas BuscarNotaxIDAlumnno(Integer idAlumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Notas WHERE idalumnogrado = :idAlumno";
        Query q = session.createQuery(hql);
        q.setParameter("idAlumno", idAlumno);
        
        return (Notas) q.uniqueResult();
    }

    
}

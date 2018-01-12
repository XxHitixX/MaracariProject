/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.AlumnoDao;
import com.Util.HibernateUtil;
import com.pojo.Alumno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ana Sofia
 */
public class AlumnoDaoImp implements AlumnoDao {

    @Override
    public List<Alumno> BuscarTodos() {
        List<Alumno> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Alumno";

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
    public void crear(Alumno alumno) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(alumno);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public void editar(Alumno alumno) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(alumno);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Alumno alumno) {
        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(alumno);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            sesion.getTransaction().rollback();
        }
    }

    @Override
    public Alumno BuscarID(Integer id) {
        String hql = "FROM Alumno WHERE id = :id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery(hql);
        q.setParameter("id", id);

        return (Alumno) q.uniqueResult();
    }

}

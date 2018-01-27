/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.MateriaProfesorDao;
import com.Util.HibernateUtil;
import com.pojo.Materiaprofesor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ana Sofia
 */
public class MateriaProfesorDaoImp implements MateriaProfesorDao {

    @Override
    public List<Materiaprofesor> BuscarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Materiaprofesor> lista = null;
        Transaction t = session.beginTransaction();
        String hql = "FROM Materiaprofesor";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void insertar(Materiaprofesor m) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(m);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void editar(Materiaprofesor m) {
       Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(m);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Materiaprofesor m) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(m);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

}

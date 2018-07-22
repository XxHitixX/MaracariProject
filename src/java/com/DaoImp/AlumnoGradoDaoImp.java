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
import com.Dao.AlumnoGradoDao;
import java.util.Calendar;
import org.hibernate.Query;

/**
 *
 * @author Ana Sofia
 */
public class AlumnoGradoDaoImp implements AlumnoGradoDao {

    @Override
    public List<Alumnogrado> BuscarTodos() {
        List<Alumnogrado> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Alumnogrado";

        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
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

    @Override
    public List<Alumnogrado> listaAlumnoGrado() {
        Calendar anio = Calendar.getInstance();
        Integer y = anio.get(Calendar.YEAR);
        List<Alumnogrado> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Alumnogrado WHERE idgrado = 1 AND ano ="+ y +"";
        
        try{
            lista = session.createQuery(hql).list();
            t.commit();
        }catch(Exception e){
            t.rollback();
        }

        return lista;
    }
    
    public Alumnogrado BuscarAlumnoGrado(int idalumnogrado){
        String hql = "from Alumnogrado where id = :idalumnogrado"; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery(hql);
        q.setParameter("idalumnogrado", idalumnogrado);
        
        return (Alumnogrado) q.uniqueResult();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;

import com.Dao.UsuarioDao;
import com.Util.HibernateUtil;
import com.pojo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ana Sofia
 */
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public Usuario ObtenerDatos(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Usuario where nombreUsuario = :nombreUsuario";
        Query q = session.createQuery(hql);
        q.setParameter("nombreUsuario", usuario.getNombreUsuario());
        
        return (Usuario) q.uniqueResult();
    }

    @Override
    public Usuario Comprobar(Usuario usuario) {
        
        Usuario user = this.ObtenerDatos(usuario);
        if(user!=null){
            if(!user.getClave().equals(usuario.getClave())){
                user = null;
            }
        }
        return user;
    }
    
    
}

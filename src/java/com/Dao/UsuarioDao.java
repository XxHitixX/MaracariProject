/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Usuario;

/**
 *
 * @author Ana Sofia
 */
public interface UsuarioDao {
    
    public Usuario ObtenerDatos(Usuario usuario);
    
    public Usuario Comprobar(Usuario usuario);
    
}

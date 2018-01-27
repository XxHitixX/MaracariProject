/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Grado;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface GradoDao {
    
     public List<Grado> BuscarTodos();

    public void crear(Grado g);

    public void editar(Grado g);

    public void eliminar(Grado g);

}

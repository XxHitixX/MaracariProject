/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Profesor;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface ProfesorDao {
    
    public List<Profesor> BuscarTodos();
    
    public void crear(Profesor p);

    public void editar(Profesor p);

    public void eliminar(Profesor p);

    public Profesor BuscarID(Integer id);
}

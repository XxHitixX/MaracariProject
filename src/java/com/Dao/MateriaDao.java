/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Materia;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface MateriaDao {
    
    public List<Materia> BuscarTodos();
    
    
    public void crear(Materia p);

    public void editar(Materia p);

    public void eliminar(Materia p);
    
    public Materia BuscarID(Integer id);

}

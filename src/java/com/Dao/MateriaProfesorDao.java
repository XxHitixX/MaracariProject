/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Materiaprofesor;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface MateriaProfesorDao {
    
    public List<Materiaprofesor> BuscarTodos();
    
    public void insertar(Materiaprofesor m);
    
    public void editar(Materiaprofesor m);
    
    public void eliminar(Materiaprofesor m);
    
    public Materiaprofesor BuscarMateriaProfesor(int idmateriaprofesor);
    
    public Materiaprofesor buscarProfesorXid(int idProfesor);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Alumnogrado;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface AlumnoGradoDao {
    
    public List<Alumnogrado> BuscarTodos();
    
    public void insertar(Alumnogrado a);
    
    public void editar(Alumnogrado a);
    
    public void elimiar(Alumnogrado a);
    
    public List<Alumnogrado> listaAlumnoGrado();
    
    public List<Alumnogrado> listaAlumnoGradoPrimero();
    
    public Alumnogrado BuscarAlumnoGrado(int idalumnogrado);
    
}

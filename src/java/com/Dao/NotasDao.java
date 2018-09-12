/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.pojo.Notas;
import java.util.List;

/**
 *
 * @author Ana Sofia
 */
public interface NotasDao {
    
    public List<Notas> buscarnotas();
    
    public void crear(Notas n);
    
    public void actualizar(Notas n);
    
    public void eliminar(Notas n);
    
    public Notas BuscarNotaxIDAlumnno(Integer idAlumno);
    
    
}

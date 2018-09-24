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
    
    public List<Alumnogrado> listaAlumnoGradoSegundo();
    
    public List<Alumnogrado> listaAlumnoGradoTercero();
    
    public List<Alumnogrado> listaAlumnoGradoCuarto();
    
    public List<Alumnogrado> listaAlumnoGradoQuinto();
    
    public List<Alumnogrado> listaAlumnoGradoSexto();
    
    public List<Alumnogrado> listaAlumnoGradoSeptimo();
    
    public List<Alumnogrado> listaAlumnoGradoOctavo();
    
    public List<Alumnogrado> listaAlumnoGradoNoveno();
    
    public List<Alumnogrado> listaAlumnoGradoDecimo();
    
    public List<Alumnogrado> listaAlumnoGradoOnce();
    
    public Alumnogrado BuscarAlumnoGrado(int idalumnogrado);
    
}

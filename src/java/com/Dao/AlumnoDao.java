/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

//IMports
import java.util.List;
import com.pojo.Alumno;

/**
 *
 * @author Ana Sofia
 */
public interface AlumnoDao {

    public List<Alumno> BuscarTodos();

    public void crear(Alumno alumno);

    public void editar(Alumno alumno);

    public void eliminar(Alumno alumno);

    public Alumno BuscarID(Integer id);

}

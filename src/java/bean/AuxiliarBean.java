/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoGradoDao;
import com.Dao.MateriaProfesorDao;
import com.DaoImp.AlumnoGradoDaoImp;
import com.DaoImp.MateriaProfesorDaoImp;
import com.pojo.Alumnogrado;
import com.pojo.Materiaprofesor;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "auxiliarBean")
@ViewScoped
public class AuxiliarBean implements Serializable{

    /**
     * Creates a new instance of AuxiliarBean
     */
    
    //Aqui va lo de alumnogrado la parte derecha de la base de datos 
    private Integer IdMateriaProfesor;
    private Integer IdAlumnoGrado;
    private Alumnogrado alumnogrado;
    private Materiaprofesor materiaprofesor;
    
    
    public AuxiliarBean() {
        this.alumnogrado = new Alumnogrado();
        this.materiaprofesor = new Materiaprofesor();
    }

    public Integer getIdMateriaProfesor() {
        return IdMateriaProfesor;
    }

    public void setIdMateriaProfesor(Integer IdMateriaProfesor) {
        this.IdMateriaProfesor = IdMateriaProfesor;
    }

    public Integer getIdAlumnoGrado() {
        return IdAlumnoGrado;
    }

    public void setIdAlumnoGrado(Integer IdAlumnoGrado) {
        this.IdAlumnoGrado = IdAlumnoGrado;
    }

    public Alumnogrado getAlumnogrado() {
        return alumnogrado;
    }

    public void setAlumnogrado(Alumnogrado alumnogrado) {
        this.alumnogrado = alumnogrado;
    }

    public Materiaprofesor getMateriaprofesor() {
        return materiaprofesor;
    }

    public void setMateriaprofesor(Materiaprofesor materiaprofesor) {
        this.materiaprofesor = materiaprofesor;
    }
    
    
    
    
    /**
    @param idalumnogrado
    * 
    METODO PARA BUSCAR EL IDMATERIAPROFESOR Y IDALUMNOGRADO
    */
    public void gestion(){
        //Hago la implementacion de la interface AlumnogradoDao
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        //Hago la implementacion de la interface MateriaProfesor
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        
        this.alumnogrado =  agDao.BuscarAlumnoGrado(this.IdAlumnoGrado);
        this.materiaprofesor = mpDao.BuscarMateriaProfesor(this.IdMateriaProfesor);
        
       // System.out.println("Este es el ID del alumnogrado: " + this.alumnogrado.getId());
       // System.out.println(" Este es el año: " + this.alumnogrado.getAno());
    }
    
    
    
}

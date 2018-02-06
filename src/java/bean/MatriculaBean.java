/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoDao;
import com.Dao.GradoAlumnoDao;
import com.Dao.GradoDao;
import com.DaoImp.AlumnoDaoImp;
import com.DaoImp.GradoAlumnoDaoImp;
import com.DaoImp.GradoDaoImp;
import com.pojo.Alumno;
import com.pojo.Alumnogrado;
import java.io.Serializable;
import java.util.Calendar;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Ana Sofia
 */
@Named(value="matriculaBean")
@ViewScoped
public class MatriculaBean implements Serializable{
    
    private Alumno alumno;
    private Integer IDgrado;
    private Alumnogrado alumnogrado;
    
    
    public MatriculaBean(){
    this.alumno = new Alumno();
    this.alumnogrado = new Alumnogrado();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getIDgrado() {
        return IDgrado;
    }

    public void setIDgrado(Integer IDgrado) {
        this.IDgrado = IDgrado;
    }

    public Alumnogrado getAlumnogrado() {
        return alumnogrado;
    }

    public void setAlumnogrado(Alumnogrado alumnogrado) {
        this.alumnogrado = alumnogrado;
    }

    
    public void insertar(){
        AlumnoDao aDao = new AlumnoDaoImp();
        GradoDao gDao = new GradoDaoImp();
        GradoAlumnoDao gaDao = new GradoAlumnoDaoImp();
        Calendar c = Calendar.getInstance();
        Integer año = c.get(Calendar.YEAR);
        
        aDao.crear(this.alumno);
        this.alumnogrado.setGrado(gDao.BuscarID(IDgrado));
        this.alumnogrado.setAlumno(this.alumno);
        this.alumnogrado.setAno(año);
        
        gaDao.insertar(this.alumnogrado);
        this.alumno = new Alumno();
        this.alumnogrado = new Alumnogrado();
    }
    
    
    
}

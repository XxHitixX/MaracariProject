/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoDao;
import com.Dao.AlumnoGradoDao;
import com.Dao.GradoDao;
import com.DaoImp.AlumnoDaoImp;
import com.DaoImp.AlumnoGradoDaoImp;
import com.DaoImp.GradoDaoImp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.pojo.Alumnogrado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "alumnoGradoBean")
@ViewScoped
public class AlumnoGradoBean implements Serializable{

    /**
     * Creates a new instance of AlumnoGradoBean
     */
    private List<Alumnogrado> lista;
    private Alumnogrado alumnogrado;
    private Integer IDAlumno;
    private Integer IDGrado;
    
    public AlumnoGradoBean() {
        this.alumnogrado = new Alumnogrado();
    }

    public List<Alumnogrado> getLista() {
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        lista = agDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Alumnogrado> lista) {
        this.lista = lista;
    }

    public Alumnogrado getAlumnogrado() {
        return alumnogrado;
    }

    public void setAlumnogrado(Alumnogrado alumnogrado) {
        this.alumnogrado = alumnogrado;
    }

    public Integer getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(Integer IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public Integer getIDGrado() {
        return IDGrado;
    }

    public void setIDGrado(Integer IDGrado) {
        this.IDGrado = IDGrado;
    }
    
    public void insertar(){
        Calendar anio = Calendar.getInstance();
        Integer y = anio.get(Calendar.YEAR);
        
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        GradoDao gDao = new GradoDaoImp();
        AlumnoDao aDao = new AlumnoDaoImp();
        this.alumnogrado.setGrado(gDao.BuscarID(IDGrado));
        this.alumnogrado.setAlumno(aDao.BuscarID(IDAlumno));
        this.alumnogrado.setAno(y);
        
        try {
            agDao.insertar(alumnogrado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito!", "SE HA ASIGNADO UN ALUMNO A UN GRADO"));
            this.alumnogrado = new Alumnogrado();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR!", "NO SE HA ASIGNADO UN ESTUDIANTE"));
        }
        
        
    }
    
}

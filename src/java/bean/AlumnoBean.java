/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoDao;
import com.DaoImp.AlumnoDaoImp;
import com.pojo.Alumno;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "alumnoBean")
@ViewScoped
public class AlumnoBean implements Serializable {

    /**
     * Creates a new instance of AlumnoBean
     */
    private Alumno alumno;

    public AlumnoBean() {
        this.alumno = new Alumno();
    }

    /*
    Desde aqui comienzan los getter and setter de la clase AlumnoBean 
     */
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void insertar() {
        AlumnoDao aDao = new AlumnoDaoImp();
        try {
            this.alumno.getNombre().toUpperCase();
            this.alumno.getApellido().toUpperCase();
            this.alumno.getComunidad().toUpperCase();
            this.alumno.getAcudiente().toUpperCase();
            aDao.crear(this.alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", this.alumno.getNombre() + " "
                    + "ha sido matriculado satisfactoriamente"));
            this.alumno = new Alumno();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "No se pudo agregar al estudiante"));
            this.alumno = new Alumno();
        }
    }

}

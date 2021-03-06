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
import java.util.List;
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
    private List<Alumno> lista;

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

    public List<Alumno> getLista() {
        AlumnoDao aDao = new AlumnoDaoImp();
        this.lista = aDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Alumno> lista) {
        this.lista = lista;
    }

    /*
    Desde aqui comienzan los metodos de la clase AlumnoBean 
     */
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

    public void actualizar() {
        AlumnoDao aDao = new AlumnoDaoImp();
        try {
            aDao.editar(this.alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bien!!", "Alumno actualizado"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/alumno/index.xhtml");
            this.alumno = new Alumno();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha podido actualizar el alumno"));
            this.alumno = new Alumno();
        }

    }

    public void eliminar() {
        AlumnoDao aDao = new AlumnoDaoImp();
        try {
            aDao.eliminar(this.alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bien!!", "Alumno eliminado"));
            this.alumno = new Alumno();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/alumno/index.xhtml");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el alumno"));
            this.alumno = new Alumno();
        }
       
    }

    
    public void redireccion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/alumno/index.xhtml");
        } catch (Exception e) {
            System.out.println("Esto no sirvio");
        }
    }
    
}

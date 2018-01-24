/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.ProfesorDao;
import com.DaoImp.ProfesorDaoImp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import com.pojo.Profesor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "profesorBean")
@ViewScoped
public class ProfesorBean implements Serializable {

    /**
     * Creates a new instance of ProfesorBean
     */
    private List<Profesor> lista;
    private Profesor profesor;

    public ProfesorBean() {
        this.profesor = new Profesor();
    }

    /*
    Aqui comienzan los getter and setter
     */
    public List<Profesor> getLista() {
        ProfesorDao pDao = new ProfesorDaoImp();
        lista = pDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Profesor> lista) {
        this.lista = lista;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /*
    A continuacion los metodos 
     */
    public void insertar() {
        ProfesorDao pDao = new ProfesorDaoImp();
        
        try {
            pDao.crear(this.profesor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", this.profesor.getNombre() + " "
                    + "ha sido registrado satisfactoriamente"));
            this.profesor = new Profesor();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", this.profesor.getNombre() + " "
                    + "No se pudo registrar el profesor"));
        }
    }
    
    public void editar() {
        ProfesorDao pDao = new ProfesorDaoImp();
        
        try {
            pDao.editar(this.profesor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", this.profesor.getNombre() + " "
                    + "ha sido registrado satisfactoriamente"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/profesor/index.xhtml");
            this.profesor = new Profesor();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", this.profesor.getNombre() + " "
                    + "No se pudo registrar el profesor"));
        }
    }
    
   public void eliminar() {
        ProfesorDao pDao = new ProfesorDaoImp();
        try {
            pDao.eliminar(this.profesor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bien!!", "Profesor eliminado"));
            this.profesor = new Profesor();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/profesor/index.xhtml");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el alumno"));
            this.profesor = new Profesor();
        }
       
    }
    
    public void redireccion() throws Exception{
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/profesor/index.xhtml");
    }

}

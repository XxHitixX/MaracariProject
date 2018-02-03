/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.MateriaProfesorDao;
import com.DaoImp.MateriaProfesorDaoImp;
import com.pojo.Materia;
import com.pojo.Materiaprofesor;
import com.pojo.Profesor;
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
@Named(value = "materiaProfesorBean")
@ViewScoped
public class MateriaProfesorBean implements Serializable{

    /**
     * Creates a new instance of MateriaProfesorBean
     */
    
    private List<Materiaprofesor> lista;
    private Materiaprofesor materiaprofesor;
    
    public MateriaProfesorBean() {
        this.materiaprofesor = new Materiaprofesor();
    
    }
    
    /*
    Aqui van los getter and setter
    */

    public List<Materiaprofesor> getLista() {
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp(); 
        lista = mpDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Materiaprofesor> lista) {
        this.lista = lista;
    }

    public Materiaprofesor getMateriaprofesor() {
        return materiaprofesor;
    }

    public void setMateriaprofesor(Materiaprofesor materiaprofesor) {
        this.materiaprofesor = materiaprofesor;
    }

    
    
    /*
    En esta parte van los metodos que se van a realizar
    */
    public void insertar(){
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        try {
            mpDao.insertar(this.materiaprofesor);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/asigdocente/index.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito!", "SE HA ASIGNADO UNA MATERIA A UN DOCENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR!", "NO SE HA ASIGNADO UNA MATERIA A UN DOCENTE"));
        }
    }
    
}

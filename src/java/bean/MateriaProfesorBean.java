/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.MateriaDao;
import com.Dao.MateriaProfesorDao;
import com.Dao.ProfesorDao;
import com.DaoImp.MateriaDaoImp;
import com.DaoImp.MateriaProfesorDaoImp;
import com.DaoImp.ProfesorDaoImp;
import com.pojo.Materiaprofesor;
import java.io.Serializable;
import java.util.Calendar;
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
    private Integer IDProfesor;
    private Integer IDMateria;
    
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

    public Integer getIDProfesor() {
        return IDProfesor;
    }

    public void setIDProfesor(Integer IDProfesor) {
        this.IDProfesor = IDProfesor;
    }

    public Integer getIDMateria() {
        return IDMateria;
    }

    public void setIDMateria(Integer IDMateria) {
        this.IDMateria = IDMateria;
    }
    
    

    
    
    /*
    En esta parte van los metodos que se van a realizar
    */
    public void insertar(){
        Calendar anio = Calendar.getInstance();
        Integer year = anio.get(Calendar.YEAR);
        
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        MateriaDao mDao = new MateriaDaoImp();
        ProfesorDao pDao = new ProfesorDaoImp();
        this.materiaprofesor.setMateria(mDao.BuscarID(IDMateria));
        this.materiaprofesor.setProfesor(pDao.BuscarID(IDProfesor));
        this.materiaprofesor.setAno(year.toString());
 
        try {
            mpDao.insertar(this.materiaprofesor);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Maracari/faces/vistas/asigdocente/index.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito!", "SE HA ASIGNADO UNA MATERIA A UN DOCENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR!", "NO SE HA ASIGNADO UNA MATERIA A UN DOCENTE"));
        }
    }
    
}

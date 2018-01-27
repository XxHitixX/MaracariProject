/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.MateriaProfesorDao;
import com.DaoImp.MateriaProfesorDaoImp;
import com.pojo.Materiaprofesor;
import java.io.Serializable;
import java.util.List;
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
    
    
    
}

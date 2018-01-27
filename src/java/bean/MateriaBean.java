/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.MateriaDao;
import com.DaoImp.MateriaDaoImp;
import com.pojo.Materia;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "materiaBean")
@ViewScoped
public class MateriaBean implements Serializable{

    /**
     * Creates a new instance of MateriaBean
     */
    
    private List<Materia> lista;
    private Materia materia;
    
    public MateriaBean() {
        this.materia = new Materia();
    }
    
    
    /*
    Aqui van los getter and Setter
    */

    public List<Materia> getLista() {
        MateriaDao mDao = new MateriaDaoImp();
        lista = mDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Materia> lista) {
        this.lista = lista;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
    
}

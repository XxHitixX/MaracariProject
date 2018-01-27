/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.GradoDao;
import com.DaoImp.GradoDaoImp;
import com.pojo.Grado;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "gradoBean")
@ViewScoped
public class GradoBean implements Serializable{

    /**
     * Creates a new instance of GradoBean
     */
    
    private List<Grado> lista;
    private Grado grado;
    
    public GradoBean() {
        this.grado = new Grado();
    }
    
    /*
    Aqui vienen los Getter and Setter
    */

    public List<Grado> getLista() {
        GradoDao gDao = new GradoDaoImp();
        lista = gDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Grado> lista) {
        this.lista = lista;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    
}

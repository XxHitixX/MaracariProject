/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoGradoDao;
import com.Dao.MateriaProfesorDao;
import com.DaoImp.AlumnoGradoDaoImp;
import com.DaoImp.MateriaProfesorDaoImp;
import com.pojo.Alumnogrado;
import com.pojo.Materiaprofesor;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import com.pojo.Notas;
import com.Dao.NotasDao;
import com.DaoImp.NotasDaoImp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "auxiliarBean")
@ViewScoped
public class AuxiliarBean implements Serializable {

    /**
     * Creates a new instance of AuxiliarBean
     */
    //Aqui va lo de alumnogrado la parte derecha de la base de datos 
    private Integer IdMateriaProfesor;
    private Integer IdAlumnoGrado;
    private Alumnogrado alumnogrado;
    private Materiaprofesor materiaprofesor;
    private Notas notas;
    
    String nota1=""; 
    String nota2=""; 
    String nota3=""; 
    String nota4="";

    @Inject
    private UserLoginView userlogin;

    public AuxiliarBean() {
        this.alumnogrado = new Alumnogrado();
        this.materiaprofesor = new Materiaprofesor();
        this.notas = new Notas();
    }

    public Integer getIdMateriaProfesor() {
        return IdMateriaProfesor;
    }

    public void setIdMateriaProfesor(Integer IdMateriaProfesor) {
        this.IdMateriaProfesor = IdMateriaProfesor;
    }

    public Integer getIdAlumnoGrado() {
        return IdAlumnoGrado;
    }

    public void setIdAlumnoGrado(Integer IdAlumnoGrado) {
        this.IdAlumnoGrado = IdAlumnoGrado;
    }

    public Alumnogrado getAlumnogrado() {
        return alumnogrado;
    }

    public void setAlumnogrado(Alumnogrado alumnogrado) {
        this.alumnogrado = alumnogrado;
    }

    public Materiaprofesor getMateriaprofesor() {
        return materiaprofesor;
    }

    public void setMateriaprofesor(Materiaprofesor materiaprofesor) {
        this.materiaprofesor = materiaprofesor;
    }

    public UserLoginView getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLoginView userlogin) {
        this.userlogin = userlogin;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    /**
     * @param idalumnogrado
     *
     * METODO PARA BUSCAR EL IDMATERIAPROFESOR Y IDALUMNOGRADO
     */
    public void gestion() {
        //Hago la implementacion de la interface AlumnogradoDao
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        //Hago la implementacion de la interface MateriaProfesor
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        //Hago la implementacion de la interface NOtasDao
        NotasDao nDao = new NotasDaoImp();
        
        
        this.alumnogrado = agDao.BuscarAlumnoGrado(this.IdAlumnoGrado);
        this.materiaprofesor = mpDao.buscarProfesorXid(this.userlogin.getUsuario().getProfesor().getId());
        this.notas = nDao.BuscarNotaxIDAlumnno(IdAlumnoGrado);

        this.notas.setAno("2018");
        this.notas.setEstado("REPROBADO");
        this.notas.setAlumnogrado(this.alumnogrado);
        this.notas.setMateriaprofesor(this.materiaprofesor);
        this.notas.setDefinitiva("2");
        /* System.out.println("Este es el materia profesor: " + this.materiaprofesor.getMateria().getNombre()
       + "asignadoa al profesor: " + this.materiaprofesor.getProfesor().getNombre());
       // System.out.println(" Este es el año: " + this.alumnogrado.getAno());*/
    }

    public String salvarNota() {
        //NotasDao nDao = new NotasDaoImp();
        //nDao.actualizar(this.notas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nota", this.nota1));
        return "/Maracari/faces/vistas/notas/preescolar";
    }

}

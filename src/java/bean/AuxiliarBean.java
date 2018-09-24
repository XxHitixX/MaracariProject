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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
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
        
        
        //Variable para sacar el calendario para obtener el año
        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        
        
        //Hago la implementacion de la interface AlumnogradoDao
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        //Hago la implementacion de la interface MateriaProfesor
        MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        //Hago la implementacion de la interface NOtasDao
        NotasDao nDao = new NotasDaoImp();
        
        
        this.alumnogrado = agDao.BuscarAlumnoGrado(this.IdAlumnoGrado);
        this.materiaprofesor = mpDao.buscarProfesorXid(this.userlogin.getUsuario().getProfesor().getId());
        this.notas = nDao.BuscarNotaxIDAlumnno(IdAlumnoGrado);
        
        //VAriable para recibir el estado del estudiante
        String estado = comprobarEstado(this.notas);
        
        //Variable apra recibir la definitiva del estudiante
        String definitiva = comprobarDefinitiva(this.notas);
        
        this.notas.setAno(""+ano);
        this.notas.setEstado(estado);
        this.notas.setAlumnogrado(this.alumnogrado);
        this.notas.setMateriaprofesor(this.materiaprofesor);
        this.notas.setDefinitiva(definitiva);
        /* System.out.println("Este es el materia profesor: " + this.materiaprofesor.getMateria().getNombre()
       + "asignadoa al profesor: " + this.materiaprofesor.getProfesor().getNombre());
       // System.out.println(" Este es el año: " + this.alumnogrado.getAno());*/
    }

    /**
     * Metodo que guarda las modificaciones realizadas en UpdateNotas
     * @return ruta
     */
    public String salvarNota() {
        NotasDao nDao = new NotasDaoImp();
        nDao.actualizar(this.notas);
        return "/vistas/notas/";
    }
    
    
    /**
     *@param nota
     * @return estado
     * Este metodo devuelve un String con el estado actual, si el estado es menor que 6.9, devolverá reprobado
     * 
     */
    public String comprobarEstado(Notas nota){
        String estado = null;
        double resultado = Double.parseDouble(nota.getPeriodoi()) + Double.parseDouble(nota.getPeriodoii()) + 
                Double.parseDouble(nota.getPeriodoiii()) + Double.parseDouble(nota.getPeriodoiv());
        resultado = resultado / 4;
        
        if(resultado <= 5.9){
            estado = "REPROBADO";
        }else{
            estado = "APROBADO";
        }
        return estado;
    }
    
     /**
     *@param nota
     * @return estado
     * Este metodo devuelve un String con la nota definitiva del estudiante
     * 
     */
    public String comprobarDefinitiva(Notas nota){
        String definitiva = null;
        double resultado = Double.parseDouble(nota.getPeriodoi()) + Double.parseDouble(nota.getPeriodoii()) + 
                Double.parseDouble(nota.getPeriodoiii()) + Double.parseDouble(nota.getPeriodoiv());
        
        resultado = resultado / 4;
        definitiva = "" +resultado;
        
      
        return definitiva;
    }
}

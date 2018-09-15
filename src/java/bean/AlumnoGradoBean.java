/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.AlumnoDao;
import com.Dao.AlumnoGradoDao;
import com.Dao.GradoDao;
import com.Dao.MateriaProfesorDao;
import com.DaoImp.AlumnoDaoImp;
import com.DaoImp.AlumnoGradoDaoImp;
import com.DaoImp.GradoDaoImp;
import com.DaoImp.MateriaProfesorDaoImp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.pojo.Alumnogrado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ana Sofia
 */
@Named(value = "alumnoGradoBean")
@ViewScoped
public class AlumnoGradoBean implements Serializable{

    /*Estas variables son requeridas por los metodos principales de la aplicacion 
    lo CRUD y BuscarTodos()
    */
    private List<Alumnogrado> lista;
    private Alumnogrado alumnogrado;
    private Integer IDAlumno;
    private Integer IDGrado;
    
    //Aqui va lo de alumnogrado la parte derecha de la base de datos 
    private Integer IdMateriaProfesor;
    private Integer IdAlumnoGrado;
  
    
    
    /*
    Estas variables que vienen a continuacion son para la cosulta de los estudiantes por grado 
    y son otra operacion utilziacion el mismo Bean
    */
    private List<Alumnogrado> estudiantesPre;
    private List<Alumnogrado> estudiantesPri;
    
    public AlumnoGradoBean() {
        this.alumnogrado = new Alumnogrado();
    }

    public List<Alumnogrado> getLista() {
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        lista = agDao.BuscarTodos();
        return lista;
    }

    public void setLista(List<Alumnogrado> lista) {
        this.lista = lista;
    }

    public Alumnogrado getAlumnogrado() {
        return alumnogrado;
    }

    public void setAlumnogrado(Alumnogrado alumnogrado) {
        this.alumnogrado = alumnogrado;
    }

    public Integer getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(Integer IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public Integer getIDGrado() {
        return IDGrado;
    }

    public void setIDGrado(Integer IDGrado) {
        this.IDGrado = IDGrado;
    }

    public List<Alumnogrado> getEstudiantesPre() {
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        estudiantesPre = agDao.listaAlumnoGrado();
        return estudiantesPre;
    }

    public void setEstudiantesPre(List<Alumnogrado> estudiantesPre) {
        this.estudiantesPre = estudiantesPre;
    }

    public List<Alumnogrado> getEstudiantesPri() {
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        estudiantesPri = agDao.listaAlumnoGradoPrimero();
        return estudiantesPri;
    }

    public void setEstudiantesPri(List<Alumnogrado> estudiantesPri) {
        this.estudiantesPri = estudiantesPri;
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

    
    
    //Asignacion de alumnos a grados
    public void insertar(){
        Calendar anio = Calendar.getInstance();
        Integer y = anio.get(Calendar.YEAR);
        
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        GradoDao gDao = new GradoDaoImp();
        AlumnoDao aDao = new AlumnoDaoImp();
        this.alumnogrado.setGrado(gDao.BuscarID(IDGrado));
        this.alumnogrado.setAlumno(aDao.BuscarID(IDAlumno));
        this.alumnogrado.setAno(y);
        
        try {
            agDao.insertar(alumnogrado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito!", "SE HA ASIGNADO UN ALUMNO A UN GRADO"));
            this.alumnogrado = new Alumnogrado();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR!", "NO SE HA ASIGNADO UN ESTUDIANTE"));
        }
        
        
    }
    
    /*
    @param idalumnogrado
    * 
    METODO PARA BUSCAR EL IDMATERIAPROFESOR Y IDALUMNOGRADO
    
    
    public void gestion(){
        //Hago la implementacion de la interface AlumnogradoDao
        AlumnoGradoDao agDao = new AlumnoGradoDaoImp();
        //Hago la implementacion de la interface MateriaProfesor
       // MateriaProfesorDao mpDao = new MateriaProfesorDaoImp();
        
        this.alumnogrado =  agDao.BuscarAlumnoGrado(this.IdAlumnoGrado);
        
        System.out.println("Este es el ID de l alumnogrado" + this.alumnogrado.getId());
        System.out.println(" Este es el año" + this.alumnogrado.getAno());
    }
    */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.Dao.UsuarioDao;
import com.DaoImp.UsuarioDaoImp;
import com.pojo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Ana Sofia
 */
@Named(value = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable{

    /**
     * Creates a new instance of UserLoginView
     */
    
    private Usuario usuario;
    
    
    
    public UserLoginView() {
        this.usuario = new Usuario();
    }
    
     private String username;
     
    private String password;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        RequestContext OTRO = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";
        
        
        UsuarioDao uDao = new UsuarioDaoImp();
        this.usuario = uDao.Comprobar(this.usuario);
        System.out.println("El usuario es: " + this.usuario.getNombreUsuario());
        
        if(this.usuario != null) {
            loggedIn = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido(a)", this.usuario.getNombreUsuario()));
            ruta = "/Maracari/faces/index.xhtml";
        } else {
            loggedIn = false;
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Hay problemas con el usuario y la contraseña"));
           this.usuario = new Usuario();
        }
         
        //PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("loggedIn", loggedIn);
        OTRO.addCallbackParam("ruta", ruta);
    }   
    
    public String cerrarSession(){
        this.username = null;
        this.password = null;
        
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();//Borro la session
        return "/Login.xhtml";
    }
    
}



package tareologo.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alvaro Gili
 */

@ManagedBean(name = "ResponsableBean")
@RequestScoped
public class ResponsableBean {
      
    @EJB
    //private IResponsableDAO responsableDAO;

    private String nombre;
    private String apodo;
    private String email;
    private String pathFoto;

    public ResponsableBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    
    public void guardarResponsable() {
        //agrego el responsable a la lista
//        Responsable responsable = new Responsable();
//        responsable.setApodo(getApodo());
//        responsable.setEmail(getEmail());
//        responsable.setNombre(getNombre());
//        responsable.setPathFoto(getPathFoto());
//        responsableDAO.insertResponsable(responsable);
    }
}

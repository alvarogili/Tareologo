

package tareologo.beans.responsables;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.model.Responsable;

/**
 *
 * @author Alvaro Gili
 */

@ManagedBean(name = "ResponsableBean")
@RequestScoped
public class ResponsableBean {
      
    private ResponsableManager responsableManager = new ResponsableManager();

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
        Responsable responsable = new Responsable();
        responsable.setApodo(getApodo());
        responsable.setEmail(getEmail());
        responsable.setNombre(getNombre());
        responsable.setPathFoto(getPathFoto());
        try {
            responsableManager.create(responsable);
        } catch (Exception ex) {
            Logger.getLogger(ResponsableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

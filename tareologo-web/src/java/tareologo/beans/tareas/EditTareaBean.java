package tareologo.beans.tareas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import tareologo.business.managers.CategoriaManager;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.managers.TareaManager;
import tareologo.business.model.Tarea;

/**
 *
 * @author Alvaro Gili
 */
@ManagedBean(name = "EditTareaBean")
@SessionScoped
public class EditTareaBean {

    private final TareaManager tareaManager = new TareaManager();
    private Tarea tarea;

    public EditTareaBean() {
    }

    public String edit(Tarea tarea) {
        this.tarea = tarea;
        return "edit";
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Tarea getTarea() {
        return tarea;
    }
    
    public void update(){
        try {
            tareaManager.update(tarea);
        } catch (Exception ex) {
            Logger.getLogger(EditTareaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

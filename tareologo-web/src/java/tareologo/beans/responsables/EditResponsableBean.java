package tareologo.beans.responsables;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.model.Responsable;

/**
 * Bean to edit a responsable
 * @author alvaro
 */
@ManagedBean(name = "EditResponsableBean")
@SessionScoped
public class EditResponsableBean {
    
    private ResponsableManager responsableManager = new ResponsableManager();
    private Responsable responsable;

    /**
     * Creates a new instance of EditResponsableBean
     */
    public EditResponsableBean() {
    }
    
    public String edit(Responsable responsable){
        this.responsable = responsable;
        return "edit";
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Responsable getResponsable() {
        return responsable;
    }
    
    public void update(){
        try {
            responsableManager.update(responsable);
        } catch (Exception ex) {
            Logger.getLogger(EditResponsableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

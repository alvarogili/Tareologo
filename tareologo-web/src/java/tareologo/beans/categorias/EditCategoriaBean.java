package tareologo.beans.categorias;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tareologo.business.managers.CategoriaManager;
import tareologo.business.model.Categoria;

/**
 * Bean to edit a categoria
 * @author alvaro
 */
@ManagedBean(name = "EditCategoriaBean")
@SessionScoped
public class EditCategoriaBean {
    
    private CategoriaManager categoriaManager = new CategoriaManager();
    private Categoria categoria;

    /**
     * Creates a new instance of EditCategoriaBean
     */
    public EditCategoriaBean() {
    }
    
    public String edit(Categoria categoria){
        this.categoria = categoria;
        return "edit";
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    public String update(){
        try {
            categoriaManager.update(categoria);
        } catch (Exception ex) {
            Logger.getLogger(EditCategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "categorias";
    }
    
}

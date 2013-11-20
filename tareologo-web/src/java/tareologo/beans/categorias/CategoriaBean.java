package tareologo.beans.categorias;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tareologo.business.managers.CategoriaManager;
import tareologo.business.model.Categoria;


/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "CategoriaBean")
@RequestScoped
public class CategoriaBean {
    
    private CategoriaManager categoriaManager = new CategoriaManager();
    private String nombre;
    private String descripcion;

    public CategoriaBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void guardarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        try {
            categoriaManager.create(categoria);
        } catch (Exception ex) {
            //verque hagocon esto
            Logger.getLogger(CategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

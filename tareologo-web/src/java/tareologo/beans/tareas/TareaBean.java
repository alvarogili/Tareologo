

package tareologo.beans.tareas;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tareologo.business.managers.TareaManager;
import tareologo.business.model.Categoria;
import tareologo.business.model.Responsable;

/**
 *
 * @author Alvaro Gili
 */

@ManagedBean(name = "TareaBean")
@RequestScoped
public class TareaBean {
      
    private TareaManager tareaManager = new TareaManager();

    private String titulo;
    private String texto;
    private int prioridad;
    private Date vencimiento;
    private float completado;
    private Categoria categoria;
    private Responsable responsable;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public float getCompletado() {
        return completado;
    }

    public void setCompletado(float completado) {
        this.completado = completado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }        
    
    public void guardarTarea() {
        
    }
}



package tareologo.beans.tareas;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tareologo.business.managers.CategoriaManager;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.managers.TareaManager;
import tareologo.business.model.Tarea;

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
    private String prioridad;
    private Date vencimiento;
    private float completado;
    private String categoria;
    private String responsable;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws UnsupportedEncodingException {
        this.titulo = new String(titulo.getBytes("ISO-8859-1"));
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) throws UnsupportedEncodingException {
        this.texto = new String(texto.getBytes("ISO-8859-1"));
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }          
    
    public void guardarTarea() throws Exception {
        Tarea tarea = new Tarea();
         CategoriaManager categoriaManager = new CategoriaManager();
        tarea.setCategoria(categoriaManager.retrieve(new Integer(categoria)));
        tarea.setCompletado(completado);
        tarea.setPrioridad(prioridad);
        ResponsableManager responsableManager = new ResponsableManager();
        tarea.setResponsable(responsableManager.retrieve(new Integer(responsable)));
        tarea.setTexto(texto);
        tarea.setTitulo(titulo);
        tarea.setVencimiento(vencimiento);
        tareaManager.create(tarea);
    }
    
    public void editarTarea(){
        
    }
}

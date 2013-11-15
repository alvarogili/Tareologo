package tareologo.business.model;

import java.util.Date;
import tareologo.persistence.entities.TareaEntity;

/**
 * Tarea's business object
 * @author Alvaro
 */
public class Tarea extends BOBase<TareaEntity> implements Comparable{
    
    private Responsable responsable;
    private Categoria categoria;

    public Tarea() {
        entity = new TareaEntity();
    }
    
    public int getID(){
        return entity.getId();
    }
    
     public String getTitulo() {
        return entity.getTitulo();
    }

    public void setTitulo(String titulo) {
        entity.setTitulo(titulo);
    }

    public String getTexto() {
        return entity.getTexto();
    }

    public void setTexto(String texto) {
        entity.setTexto(texto);
    }

    public int getPrioridad() {
        return entity.getPrioridad();
    }

    public void setPrioridad(int prioridad) {
        entity.setPrioridad(prioridad);
    }

    public Date getVencimiento() {
        return entity.getVencimiento();
    }

    public void setVencimiento(Date vencimiento) {
        entity.setVencimiento(vencimiento);
    }

    public float getCompletado() {
        return entity.getCompletado();
    }

    public void setCompletado(float completado) {
        entity.setCompletado(completado);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        entity.setCategoria(categoria.getEntity());
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
        entity.setResponsable(responsable.getEntity());
    }
    
    @Override
    public int compareTo(Object o) {
        return getID() - ((Tarea) o).getID();
    }
    
}

package tareologo.business.model;

import java.text.SimpleDateFormat;
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

    public String getPrioridad() {
        return entity.getPrioridad();
    }

    public void setPrioridad(String prioridad) {
        entity.setPrioridad(prioridad);
    }

    public String getVencimiento() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	String resultado = formato.format(entity.getVencimiento());
        return resultado;
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
        Categoria c = new Categoria();
        c.setEntity(entity.getCategoria());
        return c;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        entity.setCategoria(categoria.getEntity());
    }

    public Responsable getResponsable() {
        Responsable r = new Responsable();
        r.setEntity(entity.getResponsable());
        return r;
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

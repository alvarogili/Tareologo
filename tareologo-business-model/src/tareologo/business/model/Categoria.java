package tareologo.business.model;

import tareologo.persistence.entities.CategoriaEntity;

/**
 * Categoria's business object
 * @author Alvaro
 */
public class Categoria extends BOBase<CategoriaEntity> implements Comparable{

    public Categoria() {
        entity = new CategoriaEntity();
    }
    
    public Integer getId() {
        return entity.getId();
    }

    public String getNombre() {
        return entity.getNombre();
    }

    public void setNombre(String nombre) {
        entity.setNombre(nombre);
    }

    public String getDescripcion() {
        return entity.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        entity.setDescripcion(descripcion);
    }

    @Override
    public int compareTo(Object o) {
        return getId() - ((Categoria)o).getId();
    }
    
}

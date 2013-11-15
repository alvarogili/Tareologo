package tareologo.business.model;

import tareologo.persistence.entities.ResponsableEntity;

/**
 * Responsable's business object
 *
 * @author Alvaro
 */
public class Responsable extends BOBase<ResponsableEntity> implements Comparable {

    public Responsable() {
        entity = new ResponsableEntity();
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

    public String getApodo() {
        return entity.getApodo();
    }

    public void setApodo(String apodo) {
        entity.setApodo(apodo);
    }

    public String getEmail() {
        return entity.getEmail();
    }

    public void setEmail(String email) {
        entity.setEmail(email);
    }

    public String getPathFoto() {
        return entity.getPathFoto();
    }

    public void setPathFoto(String pathFoto) {
        entity.setPathFoto(pathFoto);
    }

    @Override
    public int compareTo(Object o) {
        return getId() - ((Responsable) o).getId();
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tareologo.model;

import java.io.Serializable;

/**
 *
 * @author Alvaro Gili
 */
public class Responsable implements Serializable {
    private Integer id;
    private String nombre;
    private String apodo;
    private String email;
    private String pathFoto;
   
    public Responsable() {
    }

    public Responsable(Integer id) {
        this.id = id;
    }

    public Responsable(Integer id, String nombre, String apodo, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apodo = apodo;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


}

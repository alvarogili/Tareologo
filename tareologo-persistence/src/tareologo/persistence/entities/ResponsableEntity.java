/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tareologo.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro Gili
 */
@Entity
@Table(name = "Responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsableEntity.findAll", query = "SELECT r FROM ResponsableEntity r"),
    @NamedQuery(name = "ResponsableEntity.findById", query = "SELECT r FROM ResponsableEntity r WHERE r.id = :id"),
    @NamedQuery(name = "ResponsableEntity.findByNombre", query = "SELECT r FROM ResponsableEntity r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "ResponsableEntity.findByApodo", query = "SELECT r FROM ResponsableEntity r WHERE r.apodo = :apodo"),
    @NamedQuery(name = "ResponsableEntity.findByEmail", query = "SELECT r FROM ResponsableEntity r WHERE r.email = :email")})
public class ResponsableEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apodo")
    private String apodo;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "PathFoto")
    private String pathFoto;
    

    public ResponsableEntity() {
    }

    public ResponsableEntity(Integer id) {
        this.id = id;
    }

    public ResponsableEntity(Integer id, String nombre, String apodo, String email) {
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
        if (!(object instanceof ResponsableEntity)) {
            return false;
        }
        ResponsableEntity other = (ResponsableEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tareologo.persistence.entities.ResponsableEntity[ id=" + id + " ]";
    }

}

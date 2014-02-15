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
@Table(name = "Categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaEntity.findAll", query = "SELECT c FROM CategoriaEntity c"),
    @NamedQuery(name = "CategoriaEntity.findById", query = "SELECT c FROM CategoriaEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaEntity.findByNombre", query = "SELECT c FROM CategoriaEntity c WHERE c.nombre like :nombre")})
public class CategoriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")   
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
   

    public CategoriaEntity() {
    }

    public CategoriaEntity(Integer id) {
        this.id = id;
    }

    public CategoriaEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof CategoriaEntity)) {
            return false;
        }
        CategoriaEntity other = (CategoriaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tareologo.persistence.entities.CategoriaEntity[ id=" + id + " ]";
    }

}

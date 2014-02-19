/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro Gili
 */
@Entity
@Table(name = "Tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaEntity.findAll", query = "SELECT t FROM TareaEntity t"),
    @NamedQuery(name = "TareaEntity.findById", query = "SELECT t FROM TareaEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TareaEntity.findByTitulo", query = "SELECT t FROM TareaEntity t WHERE t.titulo like :titulo"),
    @NamedQuery(name = "TareaEntity.findByPrioridad", query = "SELECT t FROM TareaEntity t WHERE t.prioridad = :prioridad"),
    @NamedQuery(name = "TareaEntity.findByVencimiento", query = "SELECT t FROM TareaEntity t WHERE t.vencimiento = :vencimiento"),
    @NamedQuery(name = "TareaEntity.findByCompletado", query = "SELECT t FROM TareaEntity t WHERE t.completado = :completado"),
    @NamedQuery(name = "TareaEntity.findByResponsable", query = "SELECT t FROM TareaEntity t WHERE t.responsable.nombre = :responsable")})
public class TareaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Texto")
    private String texto;
    @Basic(optional = false)
    @Column(name = "Prioridad")
    private String prioridad;
    @Column(name = "Vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimiento;
    @Basic(optional = false)
    @Column(name = "Completado")
    private float completado;
    @JoinColumn(name = "Categoria_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaEntity categoria;
    @JoinColumn(name = "Responsable_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResponsableEntity responsable;

    public TareaEntity() {
    }

    public TareaEntity(Integer id) {
        this.id = id;
    }

    public TareaEntity(Integer id, String titulo, String prioridad, float completado) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.completado = completado;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
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
    
    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
    
    public ResponsableEntity getResponsable() {
        return responsable;
    }

    public void setResponsable(ResponsableEntity responsable) {
        this.responsable = responsable;
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
        if (!(object instanceof TareaEntity)) {
            return false;
        }
        TareaEntity other = (TareaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tareologo.persistence.entities.TareaEntity[ id=" + id + " ]";
    }

}

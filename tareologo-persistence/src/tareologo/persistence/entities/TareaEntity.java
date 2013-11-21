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
    @NamedQuery(name = "TareaEntity.findByCompletado", query = "SELECT t FROM TareaEntity t WHERE t.completado = :completado")})
public class TareaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String titulo;
    private String texto;
    private int prioridad;
    private Date vencimiento;
    private float completado;
    private CategoriaEntity categoria;
    private ResponsableEntity responsable;

    public TareaEntity() {
    }

    public TareaEntity(Integer id) {
        this.id = id;
    }

    public TareaEntity(Integer id, String titulo, int prioridad, float completado) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.completado = completado;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(name = "Titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "Texto")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Basic(optional = false)
    @Column(name = "Prioridad")
    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Column(name = "Vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    @Basic(optional = false)
    @Column(name = "Completado")
    public float getCompletado() {
        return completado;
    }

    public void setCompletado(float completado) {
        this.completado = completado;
    }

    @JoinColumn(name = "Categoria_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    @JoinColumn(name = "Responsable_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

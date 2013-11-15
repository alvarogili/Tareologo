/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tareologo.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alvaro Gili
 */
public class Tarea implements Serializable {   
    private Integer id;    
    private String titulo;    
    private String texto;
    private int prioridad;
    private Date vencimiento;
    private float completado;
    private Categoria categoria;
    private Responsable responsable;

    public Tarea() {
    }

    public Tarea(Integer id) {
        this.id = id;
    }

    public Tarea(Integer id, String titulo, int prioridad, float completado) {
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getVancimiento() {
        return vencimiento;
    }

    public void setVancimiento(Date vancimiento) {
        this.vencimiento = vancimiento;
    }

    public float getCompletado() {
        return completado;
    }

    public void setCompletado(float completado) {
        this.completado = completado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
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
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   

}

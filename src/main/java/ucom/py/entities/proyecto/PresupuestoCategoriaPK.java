package ucom.py.entities.proyecto;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author jhony
 */
@Embeddable
public class PresupuestoCategoriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_presupuesto")
    private int idPresupuesto;
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private int idCategoria;

    public PresupuestoCategoriaPK() {
    }

    public PresupuestoCategoriaPK(int idPresupuesto, int idCategoria) {
        this.idPresupuesto = idPresupuesto;
        this.idCategoria = idCategoria;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPresupuesto;
        hash += (int) idCategoria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PresupuestoCategoriaPK)) {
            return false;
        }
        PresupuestoCategoriaPK other = (PresupuestoCategoriaPK) object;
        if (this.idPresupuesto != other.idPresupuesto) {
            return false;
        }
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.ucom.entities.proyecto.PresupuestoCategoriaPK[ idPresupuesto=" + idPresupuesto + ", idCategoria=" + idCategoria + " ]";
    }

}
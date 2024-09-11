package ucom.py.entities.proyecto;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categoria.findByCodigo", query = "SELECT c FROM Categoria c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Categoria.findByDescripcion", query = "SELECT c FROM Categoria c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Categoria.findByTipoCategoria", query = "SELECT c FROM Categoria c WHERE c.tipoCategoria = :tipoCategoria")
})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    @JsonIgnore // Ignoro este campo en el JSON
    private Integer idCategoria;

    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "tipo_categoria")
    private String tipoCategoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonIgnore // Ignoro esta relación en las respuestas JSON
    private List<PresupuestoCategoria> presupuestoCategoriaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    @JsonIgnore // Ignoro esta relación en las respuestas JSON
    private List<Movimientos> movimientosList;

    // Constructor vacío
    public Categoria() {
    }

    // Constructor completo (sin listas)
    public Categoria(String codigo, String descripcion, String tipoCategoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoCategoria = tipoCategoria;
    }

    // Getters y Setters

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public List<PresupuestoCategoria> getPresupuestoCategoriaList() {
        return presupuestoCategoriaList;
    }

    public void setPresupuestoCategoriaList(List<PresupuestoCategoria> presupuestoCategoriaList) {
        this.presupuestoCategoriaList = presupuestoCategoriaList;
    }

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    // hashCode, equals y toString

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucom.py.entities.proyecto.Categoria[ idCategoria=" + idCategoria + " ]";
    }
}

package ucom.py.repository.proyecto;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ucom.py.entities.proyecto.PresupuestoMensual;

@ApplicationScoped
public class PresupuestoRepository implements PanacheRepositoryBase<PresupuestoMensual, Integer> {

}

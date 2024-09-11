package ucom.py.services.proyecto;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ucom.py.config.GenericDAO;
import ucom.py.entities.proyecto.PresupuestoMensual;
import ucom.py.repository.proyecto.PresupuestoRepository;

@ApplicationScoped
public class PresupuestoService implements GenericDAO<PresupuestoMensual, Integer> {

    private final PresupuestoRepository repository;

    public PresupuestoService(PresupuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PresupuestoMensual> listar() {
        return this.repository.findAll().list();
    }

    @Override
    public PresupuestoMensual obtener(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public PresupuestoMensual modificar(PresupuestoMensual param) {
        return this.repository.getEntityManager().merge(param);
    }

    @Override
    @Transactional
    public PresupuestoMensual agregar(PresupuestoMensual param) {
        this.repository.persist(param);
        return param;
    }
}

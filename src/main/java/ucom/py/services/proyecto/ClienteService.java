package ucom.py.services.proyecto;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ucom.py.config.GenericDAO;
import ucom.py.entities.proyecto.Cliente;
import ucom.py.repository.proyecto.ClienteRepository;

@ApplicationScoped
public class ClienteService implements GenericDAO<Cliente, Integer> {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> listar() {
        return this.repository.findAll().list();
    }

    @Override
    public Cliente obtener(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public Cliente modificar(Cliente param) {

        return this.repository.getEntityManager().merge(param);
    }

    @Override
    @Transactional
    public Cliente agregar(Cliente param) {
        this.repository.persist(param);
        return null;
    }
}

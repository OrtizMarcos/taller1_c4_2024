package ucom.py.services.proyecto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ucom.py.entities.proyecto.Categoria;
import ucom.py.repository.proyecto.CategoriaRepository;

import java.util.List;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    // Obtener una categoría por ID
    public Categoria obtenerPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Listar todas las categorías
    public List<Categoria> listarTodas() {
        return categoriaRepository.listAll();
    }

    // Agregar una nueva categoría
    public void agregar(Categoria categoria) {
        categoriaRepository.persist(categoria);
    }

    // Modificar una categoría existente
    public void modificar(Categoria categoria) {
        categoriaRepository.persist(categoria);
    }

    // Eliminar una categoría por ID
    public boolean eliminarPorId(Integer id) {
        return categoriaRepository.deleteById(id);
    }
}

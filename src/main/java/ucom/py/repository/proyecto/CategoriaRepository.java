package ucom.py.repository.proyecto;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ucom.py.entities.proyecto.Categoria;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Integer> {

}
package ucom.py.controllers.proyecto;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ucom.py.entities.proyecto.Categoria;
import ucom.py.services.proyecto.CategoriaService;

import java.util.List;

@Path("categorias") // Añadí 'api' para indicar que es un recurso de API
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaService categoriaService;

    @GET
    @Path("/listar") // Clarifico que este endpoint devuelve una lista de categorías
    public List<Categoria> listarCategorias() {
        return categoriaService.listarTodas();
    }

    @GET
    @Path("/detalle/{id}") // Más claro que se trata del detalle de una categoría por su ID
    public Categoria obtenerCategoria(@PathParam("id") Integer id) {
        return categoriaService.obtenerPorId(id);
    }

    @POST
    @Path("/crear") // Específico para la creación de una nueva categoría
    public Response agregarCategoria(Categoria categoria) {
        categoriaService.agregar(categoria);
        return Response.ok(categoria).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/modificar/{id}") // Aclaro que se trata de una modificación
    public Response modificarCategoria(@PathParam("id") Integer id, Categoria categoria) {
        Categoria existente = categoriaService.obtenerPorId(id);
        if (existente != null) {
            categoria.setIdCategoria(id); // Aseguramos que el ID esté correctamente asignado
            categoriaService.modificar(categoria);
            return Response.ok(categoria).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/eliminar/{id}") // Aclaro que el endpoint es para eliminar una categoría
    public Response eliminarCategoria(@PathParam("id") Integer id) {
        boolean eliminado = categoriaService.eliminarPorId(id);
        if (eliminado) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

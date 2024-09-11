package ucom.py.controllers.proyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ucom.py.entities.proyecto.PresupuestoMensual;

import java.util.List;

@Path("presupuestos") 
public class PresupuestoResource {

    @PersistenceContext
    private EntityManager entityManager;

    // Endpoint para crear un nuevo presupuesto
    @POST
    @Path("/crear") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createPresupuesto(PresupuestoMensual presupuestoMensual) {
        try {
            entityManager.persist(presupuestoMensual);
            return Response.status(Response.Status.CREATED).entity(presupuestoMensual).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("No se pudo agregar el presupuesto.")
                        .build();
        }
    }

    // Endpoint para obtener el detalle de un presupuesto por su ID
    @GET
    @Path("/detalle/{id}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPresupuesto(@PathParam("id") Integer idPresupuesto) {
        PresupuestoMensual presupuesto = entityManager.find(PresupuestoMensual.class, idPresupuesto);
        if (presupuesto != null) {
            return Response.ok(presupuesto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                        .entity("Presupuesto no encontrado.")
                        .build();
        }
    }

    // Endpoint para listar todos los presupuestos
    @GET
    @Path("/listar") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPresupuestos() {
        List<PresupuestoMensual> presupuestos = entityManager.createNamedQuery("PresupuestoMensual.findAll", PresupuestoMensual.class)
        .getResultList();
        return Response.ok(presupuestos).build();
    }

    // Endpoint para actualizar un presupuesto existente
    @PUT
    @Path("/actualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updatePresupuesto(@PathParam("id") Integer idPresupuesto, PresupuestoMensual presupuestoMensual) {
        PresupuestoMensual existingPresupuesto = entityManager.find(PresupuestoMensual.class, idPresupuesto);
        if (existingPresupuesto != null) {
            try {
                // Actualizar campos
                existingPresupuesto.setFechaIncio(presupuestoMensual.getFechaIncio());
                existingPresupuesto.setFechaFin(presupuestoMensual.getFechaFin());
                existingPresupuesto.setSaldoInicial(presupuestoMensual.getSaldoInicial());
                existingPresupuesto.setSaldoFinal(presupuestoMensual.getSaldoFinal());
                existingPresupuesto.setEstado(presupuestoMensual.getEstado());
                // Persistir cambios
                entityManager.merge(existingPresupuesto);
                return Response.ok(existingPresupuesto).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity("No se pudo actualizar el presupuesto.")
                            .build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                        .entity("Presupuesto no encontrado.")
                        .build();
        }
    }

    // Endpoint para eliminar un presupuesto por su ID
    @DELETE
    @Path("/eliminar/{id}") // Aclaro que es para eliminar un presupuesto por su ID
    @Transactional
    public Response deletePresupuesto(@PathParam("id") Integer idPresupuesto) {
        PresupuestoMensual presupuesto = entityManager.find(PresupuestoMensual.class, idPresupuesto);
        if (presupuesto != null) {
            try {
                entityManager.remove(presupuesto);
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity("No se pudo eliminar el presupuesto.")
                            .build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                        .entity("Presupuesto no encontrado.")
                        .build();
        }
    }
}

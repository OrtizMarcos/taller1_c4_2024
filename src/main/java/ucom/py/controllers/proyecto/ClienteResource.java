package ucom.py.controllers.proyecto;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ucom.py.entities.proyecto.Cliente;
import ucom.py.model.response.ApiResponse;
import ucom.py.services.proyecto.ClienteService;

@Path("cliente")
public class ClienteResource {
    private final ClienteService service;

    public ClienteResource(ClienteService service) {
        this.service = service;
    }

    @GET
    @Path("detalle/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Cliente> obtenerPorId(@PathParam("id") Integer id) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<Cliente> respuesta = new ApiResponse();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente.");
            respuesta.setData(service.obtener(id));
        } catch (Exception e) {
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo la entidad con id :" + id);
            respuesta.setData(null);
        }

        return respuesta;
    }

    @GET
    @Path("listar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<List<Cliente>> listar() {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<List<Cliente>> respuesta = new ApiResponse();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente el listado.");
            respuesta.setData(service.listar());
        } catch (Exception e) {
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo el listado.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @POST
    @Path("crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Cliente> agregar(Cliente param) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<Cliente> respuesta = new ApiResponse();

        try {
            this.service.agregar(param);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se agregó exitosamente.");
            respuesta.setData(param);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo agregar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @PUT
    @Path("modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Cliente> modificar(Cliente param, @PathParam("id") Integer id) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<Cliente> respuesta = new ApiResponse();

        try {
            this.service.modificar(param);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se modificó exitosamente.");
            respuesta.setData(param);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo modificar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @DELETE
    @Path("eliminar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Object> eliminar(@PathParam("id") Integer id) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<Object> respuesta = new ApiResponse();

        try {
            this.service.eliminar(id);
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se eliminó exitosamente.");
            respuesta.setData(null);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se pudo eliminar la entidad.");
            respuesta.setData(null);
        }

        return respuesta;
    }

}

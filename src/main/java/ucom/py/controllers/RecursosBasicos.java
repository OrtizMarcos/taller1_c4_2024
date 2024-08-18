package ucom.py.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/recursos-basicos")
public class RecursosBasicos {

    @GET
    @Path("/Chau")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Op i'm a new resource";
    }

    @GET
    @Path("/Suma")
    @Produces(MediaType.TEXT_PLAIN)
    public int Suma(@QueryParam("a") int a, @QueryParam("b") int b) {
    return a + b;}
    
    @GET
    @Path("/saludar/{nombre}")
    @Produces(MediaType.TEXT_PLAIN)
    public String saludar(@PathParam("nombre") String nombre) {
        return "Hola, " + nombre;
}





}

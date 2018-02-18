package my.home.contact_manager.controller;

import my.home.contact_manager.entity.GetApplicationResponse;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/contact")
public interface ContactRestController {
    @GET
    @Path("/{contactId}/application/json")
    @Produces(MediaType.APPLICATION_JSON)
    GetApplicationResponse getLastApplicationJson(@PathParam("contactId") String contactId);

    @GET
    @Path("/{contactId}/application/xml")
    @Produces(MediaType.APPLICATION_XML)
    GetApplicationResponse getLastApplicationXml(@PathParam("contactId") String contactId);

}
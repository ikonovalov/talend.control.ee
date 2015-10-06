package ru.codeunited;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/tcee")
public interface LaunchControlService {

    @GET
    @Path("echo")
    @Produces("application/json")
    TalendJobServiceDescriptor echo();

}
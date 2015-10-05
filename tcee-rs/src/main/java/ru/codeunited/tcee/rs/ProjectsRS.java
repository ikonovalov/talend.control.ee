package ru.codeunited.tcee.rs;

import ru.codeunited.api.JobService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 05.10.15.
 */
@Path("/p")
@Stateless
public class ProjectsRS {

    @EJB
    private JobService jobService;

    @GET
    @Path("list")
    @Produces("text/plain")
    public Response getProjectsList() {
        //return Response.status(200).entity( "YES").build();
        String s = jobService.getProjects().stream().map(p -> p.getName()).collect(toList()).toString();
        return Response.status(200).entity(s).build();
    }

    /*@GET
    @Path("{project}")
    @Produces("application/xml")
    public List<Project> getCustomersByCity(@PathParam("project") String project) {
        return jobService.getProjects();
    }*/

}

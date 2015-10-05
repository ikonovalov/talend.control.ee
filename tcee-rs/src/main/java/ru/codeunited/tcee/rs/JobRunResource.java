package ru.codeunited.tcee.rs;

import ru.codeunited.api.Log;
import ru.codeunited.api.LogCatcherService;
import ru.codeunited.api.StatisticCatcherService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 05.10.15.
 */
@Path("/project/{project}/{job}/{pid}")
@Stateless
public class JobRunResource {

    @EJB
    private StatisticCatcherService statisticService;

    @EJB
    private LogCatcherService logService;

    @GET
    @Path("logs")
    @Produces("application/json")
    public List<Log> getLog(@PathParam("project") String projectName, @PathParam("job") String jobName, @PathParam("pid") String runPid) {
        return Optional.ofNullable(logService.getLogs(runPid)).orElse(null);
    }
}

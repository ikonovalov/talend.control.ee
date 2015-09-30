package ru.codeunited.ejb;

import ru.codeunited.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Stateless
public class StatisticCatcherBeanFacade extends AbstractEntityFacade<Statistic> implements StatisticCatcherServiceLocal, StatisticCatcherService {

    public StatisticCatcherBeanFacade() {
        super(Statistic.class);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<Statistic> allStatistics() {
        return super.findAll();
    }

    @Override
    public List<JobRun> allJobRuns() {
        Query query = getEntityManager().createQuery(
                "SELECT a, b from Statistic a, Statistic b " +
                        "where " +
                        "a.pid = b.pid and" +
                        " a.messageType = 'begin' and b.messageType = 'end' " +
                        "and (a.message is null or a.message='') " +
                        "order by a.moment desc "
        );
        List<Object[]> resultsList = query.getResultList();
        List<JobRun> jobRuns = resultsList.stream().map((resultRow) -> {
            JobRun jr = new JobRun();
            jr.setStart((Statistic)resultRow[0]);
            jr.setEnd((Statistic) resultRow[1]);
            return jr;
        }).collect(toList());
        return jobRuns;
    }

    @Override
    public List<JobRun> runsForJob(Job job) {
        throw new NotImplementedException();
    }

}

package ru.codeunited.ejb;

import ru.codeunited.api.*;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<JobRun> runsForJob(Job job) {
        Query query = getEntityManager().createQuery(
                "SELECT a, b from Statistic a, Statistic b " +
                        "where " +
                        "a.job = :jobName and " +
                        "a.pid = b.pid and " +
                        "a.messageType = 'begin' and b.messageType = 'end' " +
                        "and a.origin is null and b.origin is null " +
                        "order by a.moment desc")
                .setParameter("jobName", job.getName());

        List<Object[]> stats = query.getResultList();
        return stats
                .stream()
                .map(pair -> new JobRun((Statistic)pair[0], (Statistic)pair[1]))
                .collect(toList());
    }

}

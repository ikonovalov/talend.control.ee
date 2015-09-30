package ru.codeunited;

import javax.ejb.Remote;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Remote
public interface StatisticCatcherService {

    List<Statistic> allStatistics();

    int count();

    List<JobRun> allJobRuns();

    List<JobRun> runsForJob(Job job);
}

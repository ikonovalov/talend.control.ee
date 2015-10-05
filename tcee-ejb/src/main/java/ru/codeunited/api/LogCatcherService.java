package ru.codeunited.api;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 22.09.15.
 */
@Remote
public interface LogCatcherService {

    /**
     * Returns log records for specified JobRun only.
     * (similar as <code>getLog(JobRun)</code>)
     * @param jobPid
     * @return
     */
    List<Log> getLogs(String jobPid);

    /**
     * Returns all log records for job.
     * @param job
     * @return
     */
    List<Log> getLogs(Job job);

    /**
     * Returns log records for specified JobRun only.
     * @param jobRun
     * @return
     */
    List<Log> getLogs(JobRun jobRun);

    /**
     * Count all log records in store.
     * @return
     */
    int count();

    /**
     * Get last log update.
     * @return
     */
    Date getLastDate();


}

package ru.codeunited;

import javax.ejb.Local;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Local
public interface LogCatcherServiceLocal {

    List<Log> rootLogs();

    int count();

}

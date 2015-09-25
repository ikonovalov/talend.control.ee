package ru.codeunited;

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

    List<Log> allLog();

    int count();

    Date getLastDate();

}
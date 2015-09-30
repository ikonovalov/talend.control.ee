package ru.codeunited.tcee.web.beans;


import ru.codeunited.Log;
import ru.codeunited.LogCatcherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 24.09.15.
 */
@ManagedBean(name = "talendLog")
@RequestScoped
public class TalendLogManagedBean {

    @EJB
    private LogCatcherService logCatcherService;

    public int getCount() {
        return logCatcherService.count();
    }

    public List<Log> getLog() {
        return logCatcherService.allLog();
    }

    public Date getLastDate() {
        return logCatcherService.getLastDate();
    }

}

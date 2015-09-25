package ru.codeunited.tcee.web.beans;


import ru.codeunited.LogCatcherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 24.09.15.
 */
@ManagedBean(name = "talendLog")
public class TalendLogManagedBean {

    @EJB
    private LogCatcherService ejb;

    public String getBusiness() {
        return "Log records : " + ejb.count();
    }

}

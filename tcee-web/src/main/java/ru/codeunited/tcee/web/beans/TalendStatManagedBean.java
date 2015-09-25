package ru.codeunited.tcee.web.beans;

import ru.codeunited.StatCatcherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@ManagedBean(name = "talendStat")
@SessionScoped
public class TalendStatManagedBean {

    @EJB
    private StatCatcherService statCatcherService;

    public int getCount() {
        return statCatcherService.count();
    }

}

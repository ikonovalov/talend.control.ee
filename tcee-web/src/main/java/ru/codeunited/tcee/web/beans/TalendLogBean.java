package ru.codeunited.tcee.web.beans;


import ru.codeunited.NewSessionBusiness;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 24.09.15.
 */
@ManagedBean(name = "talendLog")
public class TalendLogBean {

    @EJB
    private NewSessionBusiness ejb;

    public String getBusiness() {
        return ejb.businessMethod();
    }

}

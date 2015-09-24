package ru.codeunited.ejb;

import ru.codeunited.NewSessionBusiness;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;


@Stateless
public class NewSessionBean implements NewSessionBusiness {

    //@Resource( lookup = "java:/jdbc/talend") /* WORKS */
    @Resource(name = "jdbc/talend") /* WORK with jboss-ejb3.xml mapping */
    private DataSource talendDs;

    @Override
    public String businessMethod() {
        return "BACK AGAIN";
    }
}
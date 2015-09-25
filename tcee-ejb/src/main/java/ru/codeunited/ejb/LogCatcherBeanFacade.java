package ru.codeunited.ejb;

import ru.codeunited.Log;
import ru.codeunited.LogCatcherService;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;


@Stateless
public class LogCatcherBeanFacade extends AbstractEntityFacade<Log> implements LogCatcherService {

    //@Resource( lookup = "java:/jdbc/talend") /* WORKS */
    @Resource(name = "jdbc/talend") /* WORK with jboss-ejb3.xml mapping */
    private DataSource talendDs;

    @PersistenceContext(unitName = "tcee-ejb-entity-unit")
    private EntityManager em;

    public LogCatcherBeanFacade() {
        super(Log.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<Log> rootLogs() {
        return null;
    }
}
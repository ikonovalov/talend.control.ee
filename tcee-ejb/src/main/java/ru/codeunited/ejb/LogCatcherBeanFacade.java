package ru.codeunited.ejb;

import ru.codeunited.Log;
import ru.codeunited.LogCatcherService;
import ru.codeunited.LogCatcherServiceLocal;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.Date;
import java.util.List;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

@Stateless
public class LogCatcherBeanFacade extends AbstractEntityFacade<Log> implements LogCatcherServiceLocal, LogCatcherService {

    public LogCatcherBeanFacade() {
        super(Log.class);
    }

    @Override
    @TransactionAttribute(NOT_SUPPORTED)
    public int count() {
        return super.count();
    }

    @Override
    public Date getLastDate() {
        return (Date) getEntityManager().createQuery("select max(log.moment) from Log log").getSingleResult();
    }

    @Override // TODO move it to LOCAL on even remove
    @TransactionAttribute(NOT_SUPPORTED)
    public List<Log> allLog() {
        return super.findAll();
    }
}
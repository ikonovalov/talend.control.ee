package ru.codeunited.ejb;

import ru.codeunited.Statistic;
import ru.codeunited.StatCatcherService;
import ru.codeunited.StatCatcherServiceLocal;

import javax.ejb.Stateless;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Stateless
public class StatCatcherBeanFacade extends AbstractEntityFacade<Statistic> implements StatCatcherServiceLocal, StatCatcherService {

    public StatCatcherBeanFacade() {
        super(Statistic.class);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<Statistic> allStatistics() {
        return super.findAll();
    }

}

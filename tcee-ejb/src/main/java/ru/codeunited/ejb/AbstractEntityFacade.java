package ru.codeunited.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
public abstract class AbstractEntityFacade<T> {

    @PersistenceContext(unitName = "tcee-ejb-entity-unit")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    private Class<T> entityClass;

    @Deprecated /** DON'T USE IT **/
    public AbstractEntityFacade() {

    }

    public AbstractEntityFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private CriteriaQuery<Object> createCriteriaQuery() {
        return getEntityManager().getCriteriaBuilder().createQuery();
    }

    public int count() {
        CriteriaQuery cq = createCriteriaQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> findAll() {
        CriteriaQuery cq = createCriteriaQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }


    public List<T> findRange(int[] range) {
        CriteriaQuery cq = createCriteriaQuery();
        cq.select(cq.from(entityClass));

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

}

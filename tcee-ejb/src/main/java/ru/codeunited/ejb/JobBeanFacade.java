package ru.codeunited.ejb;

import ru.codeunited.api.Job;
import ru.codeunited.api.JobService;
import ru.codeunited.api.JobServiceLocal;
import ru.codeunited.api.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
@Stateless
public class JobBeanFacade implements JobService, JobServiceLocal {

    @PersistenceContext(unitName = "tcee-ejb-entity-unit")
    private EntityManager em;

    @Override
    public List<Job> getJobs(Project project) {
        return em.createQuery(
                "select distinct s.job from Statistic as s where s.project = :p", String.class
        ).setParameter("p", project.getName()).getResultList()
                .stream()
                .map(Job::new)
                .sorted()
                .collect(toList());
    }

    @Override
    public List<Project> getProjects() {
        return em.createQuery(
                "select distinct s.project from Statistic as s", String.class
        ).getResultList()
                .stream()
                .map(Project::new)
                .sorted()
                .collect(toList());
    }

}

package ru.codeunited.tcee.web.beans;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ru.codeunited.Job;
import ru.codeunited.JobService;
import ru.codeunited.Project;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 30.09.15.
 */
@ManagedBean(name = "jobBean")
@SessionScoped
public class TalendJobManagedBean {

    @EJB
    private JobService jobService;

    private MenuModel projectMenu = new DefaultMenuModel();

    @PostConstruct
    public void initModel() {
        List<Project> projectList = jobService.getProjects();
        projectList /* Initialize projects menu */
                .stream()
                .forEach(project -> {
                    DefaultSubMenu subMenu = new DefaultSubMenu(project.getName());
                    jobService.getJobs(project).stream().forEach(job -> {
                        DefaultMenuItem item = new DefaultMenuItem(job);
                        item.setCommand("#{jobBean.onJobSelect}");
                        subMenu.addElement(item);
                    });
                    projectMenu.addElement(subMenu);
                });
    }

    public MenuModel getProjectMenu() {
        return projectMenu;
    }

    public void onJobSelect(MenuActionEvent actionEvent) {
        addMessage(((Job)actionEvent.getMenuItem().getValue()).getName(), "Job selected");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}



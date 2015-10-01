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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 30.09.15.
 */
@ManagedBean(name = "jobController")
@SessionScoped
public class TalendJobManagedBean {

    @EJB
    private JobService jobService;

    @ManagedProperty(value = "#{talendLog}")
    private TalendLogManagedBean logBean;

    @ManagedProperty(value = "#{talendStat}")
    private TalendStatManagedBean statBean;

    private final MenuModel projectMenu = new DefaultMenuModel();

    private Job selectedJob = null;

    public void setLogBean(TalendLogManagedBean logBean) {
        this.logBean = logBean;
    }

    public void setStatBean(TalendStatManagedBean statBean) {
        this.statBean = statBean;
    }

    public boolean isJobSelected() {
        return selectedJob != null;
    }

    public Job getCurrentJob() {
        return selectedJob;
    }

    @PostConstruct
    public void initModel() {
        List<Project> projectList = jobService.getProjects();
        projectList /* Initialize projects menu */
                .stream()
                .forEach(project -> {
                    DefaultSubMenu subMenu = new DefaultSubMenu(project.getName());
                    jobService.getJobs(project).stream().forEach(job -> {
                        DefaultMenuItem item = new DefaultMenuItem(job);
                        item.setCommand("#{jobController.onJobSelect}");
                        item.setUpdate("details"); //  it update nested clients -> details:panel:logTable details:panel:jobRunTable
                        subMenu.addElement(item);
                    });
                    projectMenu.addElement(subMenu);
                });
    }

    public MenuModel getProjectMenu() {
        return projectMenu;
    }

    public void onJobSelect(MenuActionEvent actionEvent) {
        selectedJob = (Job)actionEvent.getMenuItem().getValue();
        logBean.reloadLog(selectedJob);
        statBean.reloadJobRuns(selectedJob);
        notification(selectedJob.getName(), "Job selected");
    }

    public void onPidSelected(String pid) {
        logBean.reloadLog(statBean.findJobRunForPID(pid));
        notification(pid, "Job selected");
    }

    public void notification(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}



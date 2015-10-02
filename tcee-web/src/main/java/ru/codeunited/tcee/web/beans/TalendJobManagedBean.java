package ru.codeunited.tcee.web.beans;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ru.codeunited.Job;
import ru.codeunited.JobRun;
import ru.codeunited.JobService;
import ru.codeunited.Project;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 30.09.15.
 */
@ManagedBean(name = "jobController")
@SessionScoped
public class TalendJobManagedBean implements FacesNotificationTraits {

    @EJB
    private JobService jobService;

    @ManagedProperty(value = "#{talendLog}")
    private TalendLogManagedBean logBean;

    @ManagedProperty(value = "#{talendStat}")
    private TalendStatManagedBean statBean;

    private final MenuModel projectMenuModel = new DefaultMenuModel();

    private Job selectedJob = null;

    private JobRun selectedJobRun = null;

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

    public JobRun getCurrentJobRun() {
        return selectedJobRun;
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
                    projectMenuModel.addElement(subMenu);
                });
    }

    public MenuModel getProjectMenuModel() {
        return projectMenuModel;
    }

    public BarChartModel getJobDurationsModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        model.addSeries(boys);
        model.addSeries(girls);

        model.setTitle("Bar Chart");
        model.setLegendPosition("ne");

        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Gender");

        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);

        return model;
    }

    public void onJobSelect(MenuActionEvent actionEvent) {
        selectedJob = (Job)actionEvent.getMenuItem().getValue();
        logBean.reloadLog(selectedJob);
        statBean.reloadJobRuns(selectedJob);
        notification(selectedJob.getName(), "Job selected");
    }

    public void onJobRunSelected(String pid) {
        selectedJobRun = statBean.findJobRunForPID(pid);
        logBean.reloadLog(selectedJobRun);
        notification(pid, "JobRun selected");
    }

}



package ru.codeunited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Entity
@Table(name = "TAB_TALEND_LOG") // TODO Implements custom naming strategy and remove annotations
public class Log implements Serializable, Comparable<Log> {

    @Id
    private Long id;

    private Date moment;

    private String pid;

    @Column(name = "root_pid")
    private String rootPid;

    @Column(name = "father_pid")
    private String fatherPid;

    private String project;

    private String job;

    private String context;

    private int priority;

    private String type;

    private String message;

    private int code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRootPid() {
        return rootPid;
    }

    public void setRootPid(String rootPid) {
        this.rootPid = rootPid;
    }

    public String getFatherPid() {
        return fatherPid;
    }

    public void setFatherPid(String fatherPid) {
        this.fatherPid = fatherPid;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (priority != log.priority) return false;
        if (code != log.code) return false;
        if (!moment.equals(log.moment)) return false;
        if (!pid.equals(log.pid)) return false;
        if (!rootPid.equals(log.rootPid)) return false;
        if (!fatherPid.equals(log.fatherPid)) return false;
        if (project != null ? !project.equals(log.project) : log.project != null) return false;
        if (job != null ? !job.equals(log.job) : log.job != null) return false;
        return !(context != null ? !context.equals(log.context) : log.context != null);

    }

    @Override
    public int hashCode() {
        int result = moment.hashCode();
        result = 31 * result + pid.hashCode();
        result = 31 * result + rootPid.hashCode();
        result = 31 * result + fatherPid.hashCode();
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + priority;
        result = 31 * result + code;
        return result;
    }


    @Override
    public int compareTo(Log o) {
        return getMoment().compareTo(o.getMoment());
    }
}

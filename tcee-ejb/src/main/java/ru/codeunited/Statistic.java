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
@Table(name = "TAB_TALEND_STAT")
public class Statistic implements Serializable {

    @Id
    private Long id;

    private Date moment;

    private String pid;

    @Column(name = "root_pid")
    private String rootPid;

    @Column(name = "father_pid")
    private String fatherPid;

    @Column(name = "system_pid")
    private String systemPid;

    private String project;

    private String job;

    @Column(name = "job_repository_id")
    private String jobRepositoryId;

    @Column(name = "job_version")
    private String jobVersion;

    private String context;

    private String origin;

    @Column(name = "message_type")
    private String messageType;

    private String message;

    private Long duration;


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

    public String getSystemPid() {
        return systemPid;
    }

    public void setSystemPid(String systemPid) {
        this.systemPid = systemPid;
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

    public String getJobRepositoryId() {
        return jobRepositoryId;
    }

    public void setJobRepositoryId(String jobRepositoryId) {
        this.jobRepositoryId = jobRepositoryId;
    }

    public String getJobVersion() {
        return jobVersion;
    }

    public void setJobVersion(String jobVersion) {
        this.jobVersion = jobVersion;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}

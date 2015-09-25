package ru.codeunited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@Entity
@Table(name = "TAB_TALEND_STAT")
public class Statistic {

    private Long id;

    private Date moment;

    private String pid;

    @Column(name = "root_pid")
    private String rootPid;

    @Column(name = "father_pid")
    private String fatcherPid;

    @Column(name = "system_pid")
    private String systemPid;

    private String project;

    private String jod;

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

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

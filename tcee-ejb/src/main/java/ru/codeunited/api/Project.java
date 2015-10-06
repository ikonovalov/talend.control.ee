package ru.codeunited.api;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 30.09.15.
 */
@XmlRootElement(name = "project", namespace = Constants.XML_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Serializable, Comparable<Project> {

    @NotNull
    private final String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Project o) {
        return getName().compareTo(o.getName());
    }
}

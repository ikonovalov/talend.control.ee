package ru.codeunited;

import java.io.Serializable;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 30.09.15.
 */
public class Project implements Serializable, Comparable<Project> {

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

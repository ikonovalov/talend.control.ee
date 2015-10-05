package ru.codeunited.api;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This is a fully synthetic object not from db's world/
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
public class Job implements Serializable, Comparable<Job> {

    @NotNull
    private final String name;

    public Job(String name) {
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
    public int compareTo(Job o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return name.equals(job.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

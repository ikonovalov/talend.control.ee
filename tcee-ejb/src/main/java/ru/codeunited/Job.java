package ru.codeunited;

import java.io.Serializable;

/**
 * This is a fully synthetic object not from db's world/
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
public class Job implements Serializable, Comparable<Job> {

    private final String name;


    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Job{")
        .append(name)
        .append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Job o) {
        return getName().compareTo(o.getName());
    }
}

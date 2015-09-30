package ru.codeunited;

import java.io.Serializable;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
public class JobRun implements Serializable {

    private Statistic start;

    private Statistic end;

    public Statistic getStart() {
        return start;
    }

    public void setStart(Statistic start) {
        this.start = start;
    }

    public Statistic getEnd() {
        return end;
    }

    public void setEnd(Statistic end) {
        this.end = end;
    }
}

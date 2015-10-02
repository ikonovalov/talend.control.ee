package ru.codeunited.tcee.web.beans.models;

import ru.codeunited.JobRun;

import java.util.Collections;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 02.10.15.
 */
public class LazyJobRunDataModel extends SimpleLazyDataModel<JobRun>  {

    public static final LazyJobRunDataModel EMPTY = new LazyJobRunDataModel(Collections.emptyList());

    public LazyJobRunDataModel(List<JobRun> list) {
        super(list);
    }

}

package ru.codeunited.tcee.web.beans.models;

import ru.codeunited.api.Log;

import java.util.Collections;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 02.10.15.
 */
public class LazyLogDataModel extends SimpleLazyDataModel<Log> {

    public static LazyLogDataModel EMPTY = new LazyLogDataModel(Collections.emptyList());

    public LazyLogDataModel(List<Log> logs) {
        super(logs);
    }

    @Override
    public Log getRowData(String rowKey) {
        return getData().stream().filter(log -> log.getId().equals(Long.valueOf(rowKey))).findFirst().orElse(null);
    }

    @Override
    public Object getRowKey(Log log) {
        return log.getId();
    }
}

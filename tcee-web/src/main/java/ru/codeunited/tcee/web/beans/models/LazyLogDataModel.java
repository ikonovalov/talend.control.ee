package ru.codeunited.tcee.web.beans.models;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ru.codeunited.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 02.10.15.
 */
public class LazyLogDataModel extends LazyDataModel<Log> {

    private List<Log> data;

    public static LazyLogDataModel EMPTY = new LazyLogDataModel(new ArrayList<>(0));

    public LazyLogDataModel(List<Log> logs) {
        this.data = logs;
        this.setRowCount(logs.size());
    }

    @Override
    public List<Log> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        int dataSize = data.size();

        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }

    @Override
    public Log getRowData(String rowKey) {
        return data.stream().filter(log -> log.getId().equals(Long.valueOf(rowKey))).findFirst().orElse(null);
    }

    @Override
    public Object getRowKey(Log car) {
        return car.getId();
    }
}

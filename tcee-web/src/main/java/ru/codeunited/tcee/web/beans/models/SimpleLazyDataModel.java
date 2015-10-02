package ru.codeunited.tcee.web.beans.models;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 02.10.15.
 */
public class SimpleLazyDataModel<T> extends LazyDataModel<T> {

    private List<T> data;

    public SimpleLazyDataModel(List<T> list) {
        this.data = list;
        this.setRowCount(list.size());
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
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

}

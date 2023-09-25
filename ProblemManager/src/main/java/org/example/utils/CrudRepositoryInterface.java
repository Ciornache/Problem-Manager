package org.example.utils;

import java.io.Serializable;
import java.util.List;

public interface CrudRepositoryInterface <T extends Model> {

    void addItem(T t);

    void deleteItem(T t);

    void deleteItem(int id);

    void updateItem(T t, int id);

    List<T> selectAll();

    T findById(int id);

    T findByName(String name);

    void reset();

}

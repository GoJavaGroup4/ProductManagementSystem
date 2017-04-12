package ua.goit.java.jdbc;

import java.util.List;

/**
 * Created by Mala on 4/12/2017.
 */
public interface GenericDao<T, ID> {

    T getByID(ID id);
    List<T> getAll(ID id);
}

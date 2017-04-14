package ua.goit.java.dao;

import ua.goit.java.model.Product;

import java.util.List;

/**
 * Created by Mala on 4/12/2017.
 */
public interface ProductDao {
    Product getByID(long id);

    List<Product> getAll();


}

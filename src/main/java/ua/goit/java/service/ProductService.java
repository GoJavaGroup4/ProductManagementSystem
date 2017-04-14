package ua.goit.java.service;

import ua.goit.java.model.Product;

import java.util.List;

/**
 * Created by Mala on 4/14/2017.
 */
public interface ProductService {
    Product getByID(long id);


    List<Product> getAll();
}

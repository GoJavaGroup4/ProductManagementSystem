package ua.goit.java.service;

import ua.goit.java.dao.ProductDao;
import ua.goit.java.model.Product;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Mala on 4/12/2017.
 */

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Override
    @Transactional
    public Product getByID(long id) {
        return this.productDao.getByID(id);

    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return this.productDao.getAll();
    }


}

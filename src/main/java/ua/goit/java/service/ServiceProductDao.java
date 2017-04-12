package ua.goit.java.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.jdbc.ProductDao;
import ua.goit.java.model.Product;

import java.util.List;


/**
 * Created by Mala on 4/12/2017.
 */

public class ServiceProductDao implements ProductDao {

    private static Logger LOGGER= LoggerFactory.getLogger(ServiceProductDao.class);
    private SessionFactory sessionFactory;

    public ServiceProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getByID(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class,id);
        }
    }


    @Override
    public List<Product> getAll(Long id) {
        try(Session session=sessionFactory.openSession()) {
            return (List<Product>) session.createQuery("FROM Product ").list();
        }
    }
}

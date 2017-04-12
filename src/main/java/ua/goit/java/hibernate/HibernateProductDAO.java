package ua.goit.java.hibernate;


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
public class HibernateProductDAO implements ProductDao {

    private static Logger LOGGER = LoggerFactory.getLogger(HibernateProductDAO.class);
    private SessionFactory sessionFactory;

    public HibernateProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product getByID(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class,id);
        }
    }


    public List<Product> getAll(Long id) {
        try(Session session=sessionFactory.openSession()) {
            return (List<Product>) session.createQuery("FROM Product ").list();
        }
    }
}

package ua.goit.java.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.model.Product;

import java.util.List;

public class ProductDaoImp implements ProductDao {
    private static Logger LOGGER = LoggerFactory.getLogger(ProductDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getByID(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.load(Product.class, new Long(id));
        LOGGER.info("Product successfully loaded. " + product);
        return product;
    }



    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productList = (List<Product>) session.createQuery("FROM Product ").list();
        for (Product product : productList) {
            LOGGER.info("Product list: " + product);
        }
        return productList;
    }
}

package ua.goit.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.goit.java.dao.ProductDao;
import ua.goit.java.model.Product;

@Service
public class ProductService {

	@Autowired
    private ProductDao productDao;
	
	public void save(Product product) {
		productDao.save(product);
	}
}

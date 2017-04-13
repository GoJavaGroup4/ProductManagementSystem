package ua.goit.java.dao;

import ua.goit.java.model.Product;

public class ProductDaoImp extends BasicDao implements ProductDao {

	@Override
	public void save(Product product) {
		save(product);
	}
}

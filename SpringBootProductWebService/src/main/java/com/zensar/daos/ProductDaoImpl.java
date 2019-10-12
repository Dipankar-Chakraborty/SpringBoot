package com.zensar.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.entities.Product;

/**
 * @author Dipankar Chakraborty
 * @creation_date 4th Oct 2019 10:27AM
 * @modification_date 12th Oct 2019 03:42PM
 * @version 4.0
 * @copyright Zensar Technologies. All rights reserved
 * @description It is a Dao Interface and used in persistence layer.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return (List<Product>) hibernateTemplate.find("from Product");
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Product.class, productId);
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(product);
	}
}

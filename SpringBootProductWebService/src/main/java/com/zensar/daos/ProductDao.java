package com.zensar.daos;

import java.util.List;

import com.zensar.entities.Product;

/**
 * @author Dipankar Chakraborty
 * @creation_date 4th Oct 2019 10:08AM
 * @modification_date 12th Oct 2019 03:41PM
 * @version 3.0
 * @copyright Zensar Technologies. All rights reserved
 * @description It is a Dao Interface and used in persistence layer.
 */
public interface ProductDao {
	List<Product> getAll();

	Product getById(int productId);

	void insert(Product product);

	void update(Product product);

	void delete(Product product);
}

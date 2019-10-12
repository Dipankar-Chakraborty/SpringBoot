package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.daos.ProductDao;
import com.zensar.daos.ProductDaoImpl;
import com.zensar.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	@Override
	public Product findProductId(int productId) {
		// TODO Auto-generated method stub
		return productDao.getById(productId);
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.insert(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void removeProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	@Override
	public List<Product> findProductsByPriceRange(double priceMin, double priceMax) {
		// TODO Auto-generated method stub
		List<Product> listOfAllProducts = productDao.getAll();
		List<Product> listOfProductsPriceRange = new ArrayList<Product>();
		for (Product currentProduct : listOfAllProducts) {
			if (currentProduct.getPrice() <= priceMax && currentProduct.getPrice() >= priceMin) {
				listOfProductsPriceRange.add(currentProduct);
			}
		}
		return listOfProductsPriceRange;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		// TODO Auto-generated method stub
		List<Product> listOfAllProducts = productDao.getAll();
		List<Product> listOfProductsName = new ArrayList<Product>();
		for (Product currentProduct : listOfAllProducts) {
			if (currentProduct.getName().contains(productName)) {
				listOfProductsName.add(currentProduct);
			}
		}
		return listOfProductsName;
	}

	@Override
	public List<Product> findProductByBrand(String productBrand) {
		// TODO Auto-generated method stub
		List<Product> listOfAllProducts = productDao.getAll();
		List<Product> listOfProductsByBrand = new ArrayList<Product>();
		for (Product currentProduct : listOfAllProducts) {
			if (currentProduct.getBrand().equals(productBrand)) {
				listOfProductsByBrand.add(currentProduct);
			}
		}
		return listOfProductsByBrand;
	}

	@Override
	public long getProductCount() {
		// TODO Auto-generated method stub
		List<Product> listOfAllProducts = productDao.getAll();
		int count = 0;
		for (Product currentProduct : listOfAllProducts) {
			count++;
		}
		return count;
	}

}

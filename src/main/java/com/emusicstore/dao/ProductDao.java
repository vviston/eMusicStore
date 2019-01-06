package com.emusicstore.dao;

import com.emusicstore.model.Product;
import java.util.List;

public interface ProductDao {



    void addProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);
}

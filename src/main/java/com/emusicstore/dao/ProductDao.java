package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 1/2/2016.
 */
public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Guitar1");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("This is a fender strat guitar!");
        product1.setProductPrice(1200);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Piano");
        product2.setProductCategory("Instrument");
        product2.setProductDescription("Used piano");
        product2.setProductPrice(120000);
        product2.setProductCondition("used");
        product2.setProductStatus("Active");
        product2.setUnitInStock(11);
        product2.setProductManufacturer("Petrof");

        Product product3 = new Product();
        product3.setProductId("3");
        product3.setProductName("Drum set");
        product3.setProductCategory("Instrument");
        product3.setProductDescription("Fantastic Drum Set");
        product3.setProductPrice(1200);
        product3.setProductCondition("Brand New!");
        product3.setProductStatus("Active");
        product3.setUnitInStock(11);
        product3.setProductManufacturer("Perl");

        Product product4 = new Product();
        product4.setProductId("4");
        product4.setProductName("Bass Guitar");
        product4.setProductCategory("Instrument");
        product4.setProductDescription("This is a fender bass guitar!");
        product4.setProductPrice(1200);
        product4.setProductCondition("new");
        product4.setProductStatus("Active");
        product4.setUnitInStock(11);
        product4.setProductManufacturer("Fender");

        Product product5 = new Product();
        product5.setProductId("5");
        product5.setProductName("Combo");
        product5.setProductCategory("Accessories");
        product5.setProductDescription("This is used VOX combo from 1960!");
        product5.setProductPrice(1200);
        product5.setProductCondition("used");
        product5.setProductStatus("Active");
        product5.setUnitInStock(11);
        product5.setProductManufacturer("VOX");

        productList=new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        return productList;
    }

    public Product getProductById(String productId ) throws IOException{
        for (Product product: getProductList()) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }   throw new IOException("No product found:");
    }

}

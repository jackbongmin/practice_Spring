package org.example.practice_spring.day05_jpa.data.dao;

import org.example.practice_spring.day05_jpa.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}

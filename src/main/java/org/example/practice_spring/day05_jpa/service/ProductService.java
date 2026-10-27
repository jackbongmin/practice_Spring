package org.example.practice_spring.day05_jpa.service;

import org.example.practice_spring.day05_jpa.data.dto.ProductDto;
import org.example.practice_spring.day05_jpa.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}

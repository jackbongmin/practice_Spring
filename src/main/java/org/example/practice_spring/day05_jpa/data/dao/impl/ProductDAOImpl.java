package org.example.practice_spring.day05_jpa.data.dao.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import org.example.practice_spring.day05_jpa.data.dao.ProductDAO;
import org.example.practice_spring.day05_jpa.data.entity.Product;
import org.example.practice_spring.day05_jpa.data.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    // 생성자가 하나뿐이면 @Autowired없이도 주입된다.(Day 01)
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 저장: save 한 번
    @Override
    public Product insertProduct(Product product){
        return productRepository.save(product);
    }

    // 조회: 프록시를 돌려주는 방식(값이 없을 수도 있음을 타입으로 드러내지 않는다.)
    @Override
    public Product selectProduct(Long number) {
        return productRepository.getReferenceById(number);
    }

    // 수정: 조회(findById) -> 값 변경 -> 저장(save), 호출이 두 번
    @Override
    public Product updateProductName(Long number, String name) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    // 삭제: 조회(findById) → 삭제(delete), 호출이 두 번
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            productRepository.delete(selectedProduct.get());
        } else {
            throw new Exception();
        }
    }
}

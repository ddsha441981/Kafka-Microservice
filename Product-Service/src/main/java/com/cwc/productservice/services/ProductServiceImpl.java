package com.cwc.productservice.services;

import com.cwc.productservice.dto.ProductRequest;
import com.cwc.productservice.dto.ProductResponse;
import com.cwc.productservice.model.Product;
import com.cwc.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        Product savedProduct = productRepository.save(product);
        log.info("Product {} is saved", savedProduct.getName());
        return savedProduct;
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = products.stream().map(product -> mapToProductResponse(product)).toList();
        return productResponses;
    }

    private ProductResponse mapToProductResponse(Product product) {
    return   ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
}

package com.cwc.productservice.services;

import com.cwc.productservice.dto.ProductRequest;
import com.cwc.productservice.dto.ProductResponse;
import com.cwc.productservice.model.Product;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
public interface ProductService {

    public Product createProduct(ProductRequest productRequest);
    public Product updateProduct(ProductRequest productRequest, Long id);
    public void deleteProduct(Long id);
    public Product getProductById(Long id);
    public Product getProductByName(String name);
    public List<ProductResponse> getAllProducts();

}

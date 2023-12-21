package com.cwc.productservice.controller;

import com.cwc.productservice.dto.ProductRequest;
import com.cwc.productservice.dto.ProductResponse;
import com.cwc.productservice.model.Product;
import com.cwc.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = this.productService.createProduct(productRequest);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> allProducts = this.productService.getAllProducts();
        return new ResponseEntity<List<ProductResponse>>(allProducts, HttpStatus.OK);
    }
}

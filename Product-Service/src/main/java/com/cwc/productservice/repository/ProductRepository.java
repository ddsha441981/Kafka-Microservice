package com.cwc.productservice.repository;

import com.cwc.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Deendayal Kumawat
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

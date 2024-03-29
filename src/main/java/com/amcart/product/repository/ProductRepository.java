package com.amcart.product.repository;

import com.amcart.product.model.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    Optional<ProductEntity> findByProductId(String productId);

}

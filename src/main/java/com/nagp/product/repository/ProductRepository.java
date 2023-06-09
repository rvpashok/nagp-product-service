package com.nagp.product.repository;

import com.nagp.product.model.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}

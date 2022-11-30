package org.niit.BEJ_C2_S3_MongoDB_Practice.repository;

import org.niit.BEJ_C2_S3_MongoDB_Practice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface CustomerRepository extends MongoRepository<Customer,Integer>{
        @Query("{'customerProduct.productName': {$in:[?0]} }")
        List<Customer> customerByProductName(String productName);
    }

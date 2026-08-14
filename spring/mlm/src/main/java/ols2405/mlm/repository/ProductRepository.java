package ols2405.mlm.repository;

import org.springframework.data.repository.CrudRepository;

import ols2405.mlm.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    // This interface will automatically provide CRUD operations for the Product entity
    // No additional methods are needed unless you want to define custom queries
}
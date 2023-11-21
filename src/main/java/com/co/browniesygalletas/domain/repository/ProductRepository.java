package com.co.browniesygalletas.domain.repository;

import com.co.browniesygalletas.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}

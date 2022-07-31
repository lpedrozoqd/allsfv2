package co.clarape.al.allsfv2.domain.repository;

import java.util.List;
import java.util.Optional;

import co.clarape.al.allsfv2.domain.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCagegory(int categoryId);
    Optional<List<Product>> getScoreProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}

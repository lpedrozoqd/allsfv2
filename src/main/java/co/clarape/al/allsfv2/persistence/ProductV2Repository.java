package co.clarape.al.allsfv2.persistence;

import java.util.List;
import java.util.Optional;

import co.clarape.al.allsfv2.domain.Product;
import co.clarape.al.allsfv2.domain.repository.ProductRepository;
import co.clarape.al.allsfv2.persistence.crud.ProductoCrudRepository;
import co.clarape.al.allsfv2.persistence.entity.Producto;
import co.clarape.al.allsfv2.persistence.mapper.ProductMapper;

public class ProductV2Repository implements ProductRepository{
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCagegory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
       Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, "true");
       return productos.map(prods-> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return  mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
    
}

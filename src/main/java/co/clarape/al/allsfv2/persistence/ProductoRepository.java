package co.clarape.al.allsfv2.persistence;

import java.util.List;

import co.clarape.al.allsfv2.persistence.crud.ProductoCrudRepository;
import co.clarape.al.allsfv2.persistence.entity.Producto;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>)productoCrudRepository.findAll();
    }
}

package co.clarape.al.allsfv2.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.clarape.al.allsfv2.persistence.crud.ProductoCrudRepository;
import co.clarape.al.allsfv2.persistence.entity.Producto;

@Service
public class ProductoRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    
    public List<Producto> getProductosByCategoriaOrderedAsc(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
}



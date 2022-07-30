package co.clarape.al.allsfv2.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.clarape.al.allsfv2.persistence.entity.*;;

@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer>{
    
    @Query(value = "SELECT * from productos where id_categoria =? order by nombre asc", nativeQuery = true)
    public List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, String estado);

    
    
}

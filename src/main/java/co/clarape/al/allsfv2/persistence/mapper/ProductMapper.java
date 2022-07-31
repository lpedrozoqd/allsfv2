package co.clarape.al.allsfv2.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.clarape.al.allsfv2.domain.Product;
import co.clarape.al.allsfv2.persistence.entity.Producto;

@Mapper(componentModel =  "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source="idProducto", target = "productId"),
        @Mapping(source="nombre", target = "name"),
        @Mapping(source="idCategoria", target = "categoryId"),
        @Mapping(source="precioVenta", target = "price"),
        @Mapping(source="cantidadStock", target = "stock"),
        @Mapping(source="estado", target = "active"),
        @Mapping(source="categoria", target = "category"),  //En este caso usará el Mapper ya definido en 'CategoryMapper'
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);  //En este método no hay que declarar Mappings puesto que tomará la definición del método anterior.

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}

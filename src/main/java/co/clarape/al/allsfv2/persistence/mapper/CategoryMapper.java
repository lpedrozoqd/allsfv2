package co.clarape.al.allsfv2.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.clarape.al.allsfv2.domain.Category;
import co.clarape.al.allsfv2.persistence.entity.Categoria;

@Mapper(componentModel =  "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source="idCategoria", target = "categoryId"),
        @Mapping(source="descripcion", target = "category"),
        @Mapping(source="estado", target = "active"),
    })
    Category toCategory(Categoria catetoria);

    @InheritInverseConfiguration  //Permite establecer que el mapeo es exacatamente el opuesto a la primera definición de Mapping
    @Mapping(target = "productos", ignore = true)  //permite confirmar que no se debe mapear el campo "productos"
    Categoria toCategoria(Category category);
}

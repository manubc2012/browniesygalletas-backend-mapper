package com.co.browniesygalletas.persistence.mapper;

import com.co.browniesygalletas.domain.Category;
import com.co.browniesygalletas.persistence.entity.CategoriaProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "categoriaNombre", target = "category"),
    })
    Category toCategory(CategoriaProducto categoriaProducto);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    CategoriaProducto toCategoria(Category category);

}

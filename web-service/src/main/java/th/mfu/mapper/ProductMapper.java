package th.mfu.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import th.mfu.Product;
import th.mfu.dto.ProductDto;

@Mapper(componentModel = "spring", uses = {ProductMapper.class })
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "reviews", source = "reviews")
    ProductDto toDto(Product product);

    
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "saleOrderItems", ignore = true)
    Product toEntity(ProductDto dto);

    List<ProductDto> toDtoList(List<Product> products);
}
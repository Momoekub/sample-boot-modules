package th.mfu.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import th.mfu.ProductReview;
import th.mfu.dto.ProductReviewDto;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, ProductMapper.class })
public interface ProductReviewMapper {

    ProductReviewMapper INSTANCE = Mappers.getMapper(ProductReviewMapper.class);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "product", source = "product")
    ProductReviewDto toDto(ProductReview productReview);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "product", ignore = true)
    ProductReview toEntity(ProductReviewDto dto);

    List<ProductReviewDto> toDtoList(List<ProductReview> productReviews);
}
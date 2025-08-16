package th.mfu.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import th.mfu.SaleOrderItem;
import th.mfu.dto.SaleOrderItemDto;

@Mapper(componentModel = "spring", uses = {SaleOrderMapper.class, ProductMapper.class})

public interface SaleOrderItemMapper {
    SaleOrderItemMapper INSTANCE = Mappers.getMapper(SaleOrderItemMapper.class);
    
    // @Mapping(target = "saleOrder", ignore = true)
    @Mapping(target = "product", source = "product")
    SaleOrderItemDto toDto(SaleOrderItem saleOrderItem);
    
    @Mapping(target = "saleOrder", ignore = true)
    @Mapping(target = "product", ignore = true)
    SaleOrderItem toEntity(SaleOrderItemDto dto);
    
    List<SaleOrderItemDto> toDtoList(List<SaleOrderItem> saleOrderItems);
}
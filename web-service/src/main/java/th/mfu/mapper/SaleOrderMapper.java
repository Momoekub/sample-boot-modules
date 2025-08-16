package th.mfu.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import th.mfu.SaleOrder;
import th.mfu.dto.SaleOrderDto;

@Mapper(componentModel = "spring", uses = {SaleOrderItemMapper.class, CustomerMapper.class})
public interface SaleOrderMapper {
    
    SaleOrderMapper INSTANCE = Mappers.getMapper(SaleOrderMapper.class);
    
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "items", source = "items")
    SaleOrderDto toDto(SaleOrder saleOrder);
    
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "items", ignore = true)
    SaleOrder toEntity(SaleOrderDto dto);
    
    List<SaleOrderDto> toDtoList(List<SaleOrder> saleOrders);
}
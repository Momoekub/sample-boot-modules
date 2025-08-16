package th.mfu.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import th.mfu.Customer;
import th.mfu.dto.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    // @Mapping(target = "saleOrders", ignore = true)
    // @Mapping(target = "reviews", ignore = true)
    CustomerDto toDto(Customer customer);

    // @Mapping(target = "saleOrders", ignore = true)
    // @Mapping(target = "reviews", ignore = true)
    Customer toEntity(CustomerDto dto);

    List<CustomerDto> toDtoList(List<Customer> customers);

    // void updateEntityFromDto(CustomerDto customerDto, Customer existingCustomer);
}
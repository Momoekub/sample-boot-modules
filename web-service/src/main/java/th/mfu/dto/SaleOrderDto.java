package th.mfu.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import th.mfu.jackson.LocalDateDeserializer;
import th.mfu.jackson.LocalDateSerializer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderDto {
    private Long id;
    private CustomerDto customer;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;
    private List<SaleOrderItemDto> items;
    private Double totalAmount;


}

package th.mfu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderItemDto {
    private Long id;
    private ProductDto product;
    private Integer quantity;
    private Double price;

}

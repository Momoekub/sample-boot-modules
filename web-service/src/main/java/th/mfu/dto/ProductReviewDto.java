package th.mfu.dto;

import java.time.LocalDate;

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
public class ProductReviewDto {
    private Long id;
    private int rating;
    private String comment;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate reviewDate;
    private CustomerDto customer;
    private ProductDto product;

}

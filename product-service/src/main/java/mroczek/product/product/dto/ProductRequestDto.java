package mroczek.product.product.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class ProductRequestDto {
    String id;
    String name;
    String description;
    BigDecimal price;
}

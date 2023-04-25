package mroczek.product.product.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

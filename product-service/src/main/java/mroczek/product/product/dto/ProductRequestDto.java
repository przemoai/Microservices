package mroczek.product.product.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequestDto(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}

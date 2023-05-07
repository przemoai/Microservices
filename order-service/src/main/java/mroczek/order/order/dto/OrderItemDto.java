package mroczek.order.order.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long id,
        String skuCode,
        BigDecimal price,
        int quantity
) {
}

package mroczek.order.order.dto;

import java.util.List;

public record OrderDto(
        List<OrderItemDto> orderItemsDto
) {
}

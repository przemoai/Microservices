package mroczek.order.order.domain;

import mroczek.order.order.dto.OrderItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
interface OrderMapper {
    OrderItem toEntity(OrderItemDto orderItemDto);
    List<OrderItem> toEntity(List<OrderItemDto> orderItemsDto);
}

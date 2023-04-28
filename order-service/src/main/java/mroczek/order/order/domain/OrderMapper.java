package mroczek.order.order.domain;

import mroczek.order.order.dto.OrderItemDto;
import mroczek.order.order.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
interface OrderMapper {
//    Order toEntity(OrderDto orderDto);
    OrderItem toEntity(OrderItemDto orderItemDto);
    List<OrderItem> toEntity(List<OrderItemDto> orderItemsDto);
}

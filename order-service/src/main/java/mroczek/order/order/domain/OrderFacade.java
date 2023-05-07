package mroczek.order.order.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mroczek.order.order.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public void placeOrder(OrderDto orderDto) {

        List<OrderItem> orderItems = orderMapper.toEntity(orderDto.orderItemsDto());

        Order order = Order
                .builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderItems(orderItems)
                .build();

        Order save = orderRepository.save(order);
        log.info("Save order {}", save.getId());
    }

}

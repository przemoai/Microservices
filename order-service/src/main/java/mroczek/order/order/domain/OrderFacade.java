package mroczek.order.order.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mroczek.order.order.dto.InventoryResponseDto;
import mroczek.order.order.dto.OrderDto;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final WebClient.Builder webClientBuilder;
    private final Tracer tracer;

    @Transactional
    public String placeOrder(OrderDto orderDto) {

        List<OrderItem> orderItems = orderMapper.toEntity(orderDto.orderItemsDto());

        Order order = Order
                .builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderItems(orderItems)
                .build();


        List<String> skuCodes = order.getOrderItems().stream()
                .map(OrderItem::getSkuCode)
                .toList();


        Span inventoryFacadeLookup = tracer.nextSpan().name("InventoryFacadeLookup ");
        try (Tracer.SpanInScope spanInScope = tracer.withSpan(inventoryFacadeLookup.start())) {

            InventoryResponseDto[] inventoryResponse = webClientBuilder.build().get()
                    .uri("http://inventory-service/api/v1/inventory",
                            uriBuilder -> uriBuilder.queryParam("sku-code", skuCodes).build())
                    .retrieve()
                    .bodyToMono(InventoryResponseDto[].class)
                    .block();

            boolean allProductsInStock = Arrays.stream(inventoryResponse)
                    .allMatch(InventoryResponseDto::isInStock);

            if (allProductsInStock) {
                Order save = orderRepository.save(order);
                log.info("Save order {}", save.getId());
                return "Order placed successfully!";
            } else {
                return "Product out of stock";
            }

        } finally {
            inventoryFacadeLookup.end();
        }


    }

}

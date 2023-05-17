package mroczek.order.order.dto;

public record InventoryResponseDto(
        String skuCode,
        boolean isInStock
) {
}

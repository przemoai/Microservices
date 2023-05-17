package mroczek.inventory.inventory.dto;

public record InventoryResponseDto(
        String skuCode,
        boolean isInStock
) {
}

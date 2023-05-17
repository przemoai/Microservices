package mroczek.inventory.inventory.dto;

public record InventoryDto(
        Long id,
        String skuCode,
        int quantity
) {
}

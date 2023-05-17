package mroczek.inventory.inventory.domain;

import mroczek.inventory.inventory.dto.InventoryDto;
import org.mapstruct.Mapper;

@Mapper
interface InventoryMapper {
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

}

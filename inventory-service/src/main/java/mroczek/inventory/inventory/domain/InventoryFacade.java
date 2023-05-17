package mroczek.inventory.inventory.domain;


import lombok.RequiredArgsConstructor;
import mroczek.inventory.inventory.dto.InventoryDto;
import mroczek.inventory.inventory.dto.InventoryResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryFacade {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public List<InventoryResponseDto> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        new InventoryResponseDto(inventory.getSkuCode(), inventory.getQuantity() > 0)
                ).toList();
    }

    public ResponseEntity<InventoryDto> addInventory(InventoryDto inventoryDto) {

        Inventory savedInventory = inventoryRepository.save(inventoryMapper.toEntity(inventoryDto));
        return new ResponseEntity<>(inventoryMapper.toDto(savedInventory), HttpStatus.CREATED);
    }
}

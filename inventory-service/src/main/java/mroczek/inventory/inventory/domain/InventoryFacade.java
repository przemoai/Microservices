package mroczek.inventory.inventory.domain;


import lombok.RequiredArgsConstructor;
import mroczek.inventory.inventory.dto.InventoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryFacade {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    public ResponseEntity<InventoryDto> addInventory(InventoryDto inventoryDto) {

        Inventory savedInventory = inventoryRepository.save(inventoryMapper.toEntity(inventoryDto));
        return new ResponseEntity<>(inventoryMapper.toDto(savedInventory), HttpStatus.CREATED);
    }
}

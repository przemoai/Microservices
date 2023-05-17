package mroczek.inventory.inventory.resource;


import lombok.RequiredArgsConstructor;
import mroczek.inventory.inventory.domain.InventoryFacade;
import mroczek.inventory.inventory.dto.InventoryDto;
import mroczek.inventory.inventory.dto.InventoryResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
class InventoryController {

    private final InventoryFacade inventoryFacade;

    @GetMapping()
    public List<InventoryResponseDto> isInStock(@RequestParam("sku-code") List<String> skuCode) {
        return inventoryFacade.isInStock(skuCode);
    }

    @PostMapping()
    ResponseEntity<InventoryDto> addInventory(@RequestBody InventoryDto inventoryDto) {
        return inventoryFacade.addInventory(inventoryDto);
    }
}

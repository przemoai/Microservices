package mroczek.inventory.inventory.resource;


import lombok.RequiredArgsConstructor;
import mroczek.inventory.inventory.domain.InventoryFacade;
import mroczek.inventory.inventory.dto.InventoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
class InventoryController {

    private final InventoryFacade inventoryFacade;

    @GetMapping("/{sku-code}")
    public boolean isInStock(@PathVariable("sku-code") String skuCode){
        return inventoryFacade.isInStock(skuCode);
    }

    @PostMapping()
    ResponseEntity<InventoryDto> addInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryFacade.addInventory(inventoryDto);
    }
}

package mroczek.product.product.resource;


import lombok.RequiredArgsConstructor;
import mroczek.product.product.domain.ProductFacade;
import mroczek.product.product.dto.ProductRequestDto;
import mroczek.product.product.dto.ProductResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
class ProductController {

    private final ProductFacade productFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productFacade.createProduct(productRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts() {
        return productFacade.getAllProducts();
    }
}

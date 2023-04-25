package mroczek.product.product.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mroczek.product.product.dto.ProductRequestDto;
import mroczek.product.product.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFacade {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);

        productRepository.save(product);
        log.info("Product {} saved", product.getId());
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}

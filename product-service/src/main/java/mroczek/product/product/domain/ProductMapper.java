package mroczek.product.product.domain;

import mroczek.product.product.dto.ProductRequestDto;
import mroczek.product.product.dto.ProductResponseDto;
import org.mapstruct.Mapper;


@Mapper
interface ProductMapper {

    Product toEntity(ProductRequestDto productRequestDto);

    ProductResponseDto toDto(Product product);
}

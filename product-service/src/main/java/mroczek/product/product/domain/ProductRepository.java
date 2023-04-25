package mroczek.product.product.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductRepository extends MongoRepository<Product, String> {
}

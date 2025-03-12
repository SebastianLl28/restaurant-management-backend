package com.app.backend.persistence.repository;

import com.app.backend.persistence.entity.ProductLocationStock;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLocationStockRepository extends JpaRepository<ProductLocationStock, Long> {

  Optional<ProductLocationStock> findByLocationIdAndProductId(Long locationId, Long productId);
}

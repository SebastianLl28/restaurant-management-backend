package com.app.backend.presentation.controller.product;

import com.app.backend.persistence.entity.ProductLocationStock;
import com.app.backend.persistence.repository.ProductLocationStockRepository;
import com.app.backend.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductLocationStockController {

  @Autowired
  private ProductLocationStockRepository productLocationStockRepository;

  @GetMapping(AppConstant.PUBLIC_BASE_ENDPOINT
      + "/product-location-stock/location/{locationId}/product/{productId}")
  public ProductLocationStock findProductLocationStock(@PathVariable Long locationId, @PathVariable Long productId) {
    return productLocationStockRepository.findByLocationIdAndProductId(locationId, productId)
        .orElseThrow(() -> new RuntimeException("Product location stock not found"));
  }
}

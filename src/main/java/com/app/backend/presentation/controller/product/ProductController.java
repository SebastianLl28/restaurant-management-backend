package com.app.backend.presentation.controller.product;

import com.app.backend.persistence.entity.Product;
import com.app.backend.persistence.repository.ProductRepository;
import com.app.backend.service.product.ProductService;
import com.app.backend.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductRepository productRepository;

  @GetMapping(AppConstant.PUBLIC_BASE_ENDPOINT + "/product")
  public Page<Product> findProducts(Pageable pageable, @RequestParam(required = false) Long categoryId, @RequestParam(required = false) String name) {
    return productService.findProducts(pageable, categoryId, name);
  }

  @GetMapping(AppConstant.PUBLIC_BASE_ENDPOINT + "/product/{id}")
  public Product findById (@PathVariable Long id){
    return productRepository.findByIdAndStatus(id, Boolean.TRUE).orElseThrow(
        () -> new RuntimeException("Product not found")
    );
  }
}

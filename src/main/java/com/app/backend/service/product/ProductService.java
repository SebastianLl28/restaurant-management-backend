package com.app.backend.service.product;

import com.app.backend.persistence.specification.ProductSpecification;
import com.app.backend.persistence.entity.Product;
import com.app.backend.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Page<Product> findProducts(Pageable pageable, Long categoryId, String name) {

    Specification<Product> specification = Specification.where(null);

    if (name != null) {
      specification = specification.and(ProductSpecification.hasName(name));
    }

    if (categoryId != null) {
      specification = specification.and(ProductSpecification.hasCategory(categoryId));
    }

    specification = specification.and(ProductSpecification.hasStatus(Boolean.TRUE));

    return productRepository.findAll(specification, pageable);

  }

}

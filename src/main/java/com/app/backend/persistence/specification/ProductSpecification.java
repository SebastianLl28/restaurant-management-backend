package com.app.backend.persistence.specification;

import com.app.backend.persistence.entity.Product;
import com.app.backend.persistence.entity.ProductCategory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

  public static Specification<Product> hasName(String name) {
    return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
  }

  public static Specification<Product> hasCategory(Long categoryId) {
    return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
      if (categoryId == null) {
        return criteriaBuilder.conjunction();
      }
      Join<Product, ProductCategory> productCategoryJoin = root.join("productCategoryList");
      return criteriaBuilder.equal(productCategoryJoin.get("category").get("id"), categoryId);
    };
  }

  public static Specification<Product> hasStatus(Boolean status) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get("status"), status);
  }
}

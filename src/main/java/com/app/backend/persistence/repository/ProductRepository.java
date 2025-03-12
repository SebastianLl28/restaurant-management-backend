package com.app.backend.persistence.repository;

import com.app.backend.persistence.entity.Product;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
    JpaSpecificationExecutor<Product> {

  Optional<Product> findByIdAndStatus(Long id, Boolean status);

}

package com.app.backend.persistence.repository;

import com.app.backend.persistence.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  List<Category> findAllByStatus(Boolean status);

}

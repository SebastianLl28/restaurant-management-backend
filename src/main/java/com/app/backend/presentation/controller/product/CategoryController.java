package com.app.backend.presentation.controller.product;


import com.app.backend.persistence.entity.Category;
import com.app.backend.persistence.repository.CategoryRepository;
import com.app.backend.util.AppConstant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping(AppConstant.PUBLIC_BASE_ENDPOINT + "/category")
  public List<Category> findAllCategory() {
    return categoryRepository.findAllByStatus(true);
  }
}

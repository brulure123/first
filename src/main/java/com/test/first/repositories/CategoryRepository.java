package com.test.first.repositories;

import org.springframework.data.repository.CrudRepository;
import com.test.first.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
}

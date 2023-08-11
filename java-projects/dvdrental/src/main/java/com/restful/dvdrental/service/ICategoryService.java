package com.restful.dvdrental.service;

import com.restful.dvdrental.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAllCategories();
    Optional<Category> findCategoryById(int categoryId);
}

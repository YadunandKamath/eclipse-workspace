package com.restful.dvdrental.service;

import com.restful.dvdrental.dao.ICategoryDAO;
import com.restful.dvdrental.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private ICategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(int categoryId) {
        return categoryDAO.findById(categoryId);
    }
}

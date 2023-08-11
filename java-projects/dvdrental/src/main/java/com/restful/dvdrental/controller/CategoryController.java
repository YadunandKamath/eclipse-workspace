package com.restful.dvdrental.controller;

import com.restful.dvdrental.entity.Category;
import com.restful.dvdrental.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/dvdrental")
public class CategoryController {

    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategory(Model model){

        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("category", categoryList);
        return "dvdrental/list-category";
    }
}

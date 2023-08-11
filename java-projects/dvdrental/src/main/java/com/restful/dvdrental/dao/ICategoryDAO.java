package com.restful.dvdrental.dao;

import com.restful.dvdrental.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDAO extends JpaRepository<Category, Integer> {
}

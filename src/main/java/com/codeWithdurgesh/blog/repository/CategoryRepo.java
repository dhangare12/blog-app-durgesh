package com.codeWithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeWithdurgesh.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

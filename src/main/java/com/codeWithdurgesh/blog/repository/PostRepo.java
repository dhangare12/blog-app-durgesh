package com.codeWithdurgesh.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codeWithdurgesh.blog.entities.Category;
import com.codeWithdurgesh.blog.entities.Post;
import com.codeWithdurgesh.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String titel);
	
	@Query("select p from Post p where p.title like:key")
	List<Post> searchByTitle(@Param("key") String title);
}


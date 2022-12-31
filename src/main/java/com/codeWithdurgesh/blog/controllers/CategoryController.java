package com.codeWithdurgesh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithdurgesh.blog.payloads.ApiResponse;
import com.codeWithdurgesh.blog.payloads.CategoryDto;
import com.codeWithdurgesh.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	/**
	 * @author JYOTI 
	 * @apiNote This is create category
	 * @param cateogDto
	 * 
	 * 
	 * @return
	 */
	//create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateogDto){
	
		CategoryDto createCategory = this.categoryService.createCategory(cateogDto);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	
	}
	/**
	 * @author JYOTI
	 * @param categoryDto
	 * @param catId
	 * @apiNote This is update category
	 * @return
	 */
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			               @PathVariable Integer catId){
	
		CategoryDto createCategory = this.categoryService.updateCategory(categoryDto,catId);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.OK);
	
	}
	//delete
	/**
	 * @author JYOTI
	 * @apiNote This is delete category
	 * @param catId
	 * @
	 * @return
	 */
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
	
      this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted Sussessfully !!", true ), HttpStatus.OK);
	
	}

	/**
	 * @author JYOTI
	 * @apiNote this is a get category
	 * @param catId
	 * @return
	 */
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
	
      CategoryDto categoryDto = this.categoryService.getCategory(catId);
      
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	
	}
	//get all
	/**
	 * @author JYOTI
	 * @apiNote this is get all category
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	
      List<CategoryDto> categories = this.categoryService.getCategories();
      
		
		return ResponseEntity.ok(categories) ;
	
	}
}

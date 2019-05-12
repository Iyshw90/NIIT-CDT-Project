package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.CategoryDAO;
import com.web.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value ="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute(categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory")
	public String insertCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		Category category = new Category();
		category.setCatName(categoryName);
		category.setCatDesc(categoryDesc);
		categoryDAO.addCategory(category);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList",categoryList);
		
		return "Category";
		
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId, Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList",categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method = RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId, @RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		category.setCatName(categoryName);
		category.setCatDesc(categoryDesc);
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList",categoryList);
		
		return "Category";
	}
	

}

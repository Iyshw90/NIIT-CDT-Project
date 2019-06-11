package com.web.dao;

import java.util.List;

import com.web.model.Category;

/*CategoryDAO Interface - Blueprint of "CategoryDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/
public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategory();

}

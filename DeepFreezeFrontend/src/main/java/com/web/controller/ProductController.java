package com.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.dao.CategoryDAO;
import com.web.dao.ProductDAO;
import com.web.dao.SupplierDAO;
import com.web.model.Category;
import com.web.model.Product;
import com.web.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		
		//create a product object with no values and send it to the jsp page
		Product product= new Product();
		m.addAttribute("product", product);
		
		List<Product> productList= productDAO.listProduct();
		m.addAttribute("productList",productList);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSuplierList(supplierList));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String>  listCategory = new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<categoryList.size())
		{
			Category category = categoryList.get(i);
			listCategory.put(category.getCatId(),category.getCatName());
			i++;
		}
		
		return listCategory;
		
	}
	
	public LinkedHashMap<Integer,String> getSuplierList(List<Supplier> supplierList)
	{
		LinkedHashMap<Integer,String>  listSupplier = new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<supplierList.size())
		{
			Supplier supplier = supplierList.get(i);
			listSupplier.put(supplier.getSupId(),supplier.getSupName());
			i++;
		}
		
		return listSupplier;
		
	}
	
	@RequestMapping(value="/InsertProduct", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product prod,@RequestParam("pimage")MultipartFile fileImage,Model m)
	{
		productDAO.addProduct(prod);
		
		//Adding image of the product
		String path ="D:\\NIITProject\\DeepFreezeFrontend\\src\\main\\webapp\\resources\\images\\";
		path = path+String.valueOf(prod.getProdId())+".jpg";
		
		File imageFile= new File(path);
		
		if(!fileImage.isEmpty())
		{
			try {
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arised"+e);
			}
		}
		else
		{
			System.out.println("Error occured");
		}
		
				
		List<Product> productList= productDAO.listProduct();
		m.addAttribute("productList",productList);
		
		//create a product object with no values and send it to the jsp page
		Product product= new Product();
		m.addAttribute("product", product);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSuplierList(supplierList));
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product prod= productDAO.getProduct(productId);
		productDAO.deleteProduct(prod);
		List<Product> productList= productDAO.listProduct();
		m.addAttribute("productList",productList);
				
		//create a product object with no values and send it to the jsp page
		Product product = new Product();
		m.addAttribute("product", product);
		
				
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSuplierList(supplierList));
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId, Model m)
	{
		Product product= productDAO.getProduct(productId);
		m.addAttribute("product", product);
		
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSuplierList(supplierList));
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/UpdateProduct", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product prod,Model m)
	{
		productDAO.updateProduct(prod);
		List<Product> productList= productDAO.listProduct();
		m.addAttribute("productList",productList);
				
		//create a product object with no values and send it to the jsp page
		Product product = new Product();
		m.addAttribute("product", product);
		
				
		List<Category> categoryList = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSuplierList(supplierList));
		
		return "Product";
	}
	
	@RequestMapping(value="/productsPage")
	public String displayProductPage(Model m)
	{
		List<Product> productList= productDAO.listProduct();
		m.addAttribute("productList",productList);
		return "ProductsPage";
	}
	
	@RequestMapping(value="/singleProductDisplay/{productId}")
	public String singleProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product= productDAO.getProduct(productId);
		m.addAttribute("product", product);
		return "SingleProductPage";
	}


}

package com.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.SupplierDAO;
import com.web.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/supplier")
	public String showSupplierPage(Model m)
	{
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute(supplierList);
		return "Supplier";
	}
	
	@RequestMapping(value="/InsertSupplier")
	public String insertSupplier(@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr,Model m)
	{
		Supplier supplier = new Supplier();
		supplier.setSupName(supplierName);
		supplier.setSupAddr(supplierAddr);
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		System.out.println("Inside edit supplier.........................############");
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier", supplier);
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		System.out.println("Inside delte supplier.........................############");
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier", method = RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId")int supplierId, @RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr,Model m)
	{
		System.out.println("Inside Update supplier.........................############");
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		supplier.setSupAddr(supplierAddr);
		supplier.setSupName(supplierName);
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> supplierList = supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
		return "Supplier";
	}

}

package com.web.dao;

import java.util.List;

import com.web.model.Supplier;

/*SupplierDAO Interface - Blueprint of "SupplierDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier();

}

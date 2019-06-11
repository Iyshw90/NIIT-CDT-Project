package com.web.dao;

import com.web.model.OrderDetail;

/*OrderDAO Interface - Blueprint of "OrderDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/
public interface OrderDAO {
	
	public boolean paymentProcess(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String userName, int orderId);

}

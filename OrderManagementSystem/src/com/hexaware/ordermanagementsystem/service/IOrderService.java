package com.hexaware.ordermanagementsystem.service;

import java.util.List;

import com.hexaware.ordermanagementsystem.entity.OrderTable;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;

public interface IOrderService {
	
	boolean createUser(User user);
	boolean createProduct(Product product) throws Exception;
	List<Product> getAllProducts();
	boolean createOrder(OrderTable order) throws Exception;
	boolean cancelOrder(int orderId) throws Exception;
	List<OrderTable> getOrderByUser(User user) throws Exception;

}

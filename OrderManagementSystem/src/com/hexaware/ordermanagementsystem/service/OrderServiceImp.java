package com.hexaware.ordermanagementsystem.service;

import java.util.List;

import com.hexaware.ordermanagementsystem.dao.IOrderManagementRepository;
import com.hexaware.ordermanagementsystem.dao.OrderProcessor;
import com.hexaware.ordermanagementsystem.entity.OrderTable;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;

public class OrderServiceImp implements IOrderService{
	
	private IOrderManagementRepository orderManagementRepository;
	
	public OrderServiceImp() {
        this.orderManagementRepository = new OrderProcessor();
    }

	@Override
	public boolean createUser(User user) {
		return orderManagementRepository.createUser(user);
	}

	@Override
	public boolean createProduct(Product product) throws Exception {
		return orderManagementRepository.createProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
	    return orderManagementRepository.getAllProducts();
	}

	@Override
	public boolean createOrder(OrderTable order) throws Exception {
		return orderManagementRepository.createOrder(order);
	}

	@Override
	public boolean cancelOrder(int orderId) throws Exception {
		return orderManagementRepository.cancelOrder(orderId);
	}

	@Override
	public List<OrderTable> getOrderByUser(User user) throws Exception {
		return orderManagementRepository.getOrderByUser(user);
	}


}

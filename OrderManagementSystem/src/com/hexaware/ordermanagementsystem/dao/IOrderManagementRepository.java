package com.hexaware.ordermanagementsystem.dao;

import java.util.List;

import com.hexaware.ordermanagementsystem.entity.OrderTable;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public interface IOrderManagementRepository {
	
	boolean createOrder(OrderTable order) throws Exception;
    boolean cancelOrder(int orderId) throws Exception;
    boolean createProduct(Product product) throws Exception;
    boolean createUser(User user);
    List<Product> getAllProducts();
    List<OrderTable> getOrderByUser(User user) throws Exception;

}

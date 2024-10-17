package com.hexaware.ordermanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.ordermanagementsystem.entity.OrderTable;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;
import com.hexaware.ordermanagementsystem.util.DBConnection;



public class OrderProcessor implements IOrderManagementRepository{
	
	private Connection conn;
	
	public OrderProcessor() {
		conn = DBConnection.getConnection();
		
	}

	@Override
	public boolean createUser(User user) {
		
		 if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
		        System.out.println("Username cannot be empty.");
		        return false;
		    }
		 
		 String query = "INSERT INTO User (userId, username, password, role) VALUES (?, ?, ?, ?)";
		    try (PreparedStatement stmt = conn.prepareStatement(query)) {
		        stmt.setInt(1, user.getUserId());
		        stmt.setString(2, user.getUsername());
		        stmt.setString(3, user.getPassword());
		        stmt.setString(4, user.getRole());
		        return stmt.executeUpdate() > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
	}


	@Override
	public boolean createOrder(OrderTable order) throws Exception {
		String query = "INSERT INTO OrderTable (orderId, productId, userId) VALUES (?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, order.getOrderId());
	        stmt.setInt(2, order.getProductId());
	        stmt.setInt(3, order.getUserId());
	        
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

		

	@Override
	public boolean cancelOrder(int orderId) throws Exception {
		try {
            String query = "DELETE FROM OrderTable WHERE orderId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, orderId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
	}

	@Override
	public boolean createProduct(Product product) throws Exception {
		String query = "INSERT INTO Product (productId, productName, description, price, quantityInStock, type) VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, product.getProductId());
	        stmt.setString(2, product.getProductName());
	        stmt.setString(3, product.getDescription());
	        stmt.setDouble(4, product.getPrice());
	        stmt.setInt(5, product.getQuantityInStock());
	        stmt.setString(6, product.getType());

	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public List<Product> getAllProducts() {
	    List<Product> products = new ArrayList<>();
	    String query = "SELECT * FROM Product";

	    try (PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Product product = new Product();
	            product.setProductId(rs.getInt("productId"));
	            product.setProductName(rs.getString("productName"));
	            product.setDescription(rs.getString("description"));
	            product.setPrice(rs.getDouble("price"));
	            product.setQuantityInStock(rs.getInt("quantityInStock"));
	            product.setType(rs.getString("type"));
	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}



	@Override
	public List<OrderTable> getOrderByUser(User user) throws Exception {
		List<OrderTable> order = new ArrayList<>();		
		String query = "SELECT * FROM OrderTable";
		try (PreparedStatement stmt = conn.prepareStatement(query);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		            OrderTable orders = new OrderTable();
		            orders.setOrderId(rs.getInt("orderId"));
		            orders.setProductId(rs.getInt("productId"));
		            orders.setUserId(rs.getInt("userId"));
		            
		            order.add(orders);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return order;
		}


}

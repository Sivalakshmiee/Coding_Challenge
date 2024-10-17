package com.hexaware.ordermanagementsystem.app;

import com.hexaware.ordermanagementsystem.entity.OrderTable;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;
import com.hexaware.ordermanagementsystem.service.IOrderService;
import com.hexaware.ordermanagementsystem.service.OrderServiceImp;

import java.util.List;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws Exception {
		
		IOrderService service = new OrderServiceImp();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Add Product");
            System.out.println("3. Get All Products");
            System.out.println("4. Add Order");
            System.out.println("5. Cancel Order");
            System.out.println("6. Order by user");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	createUser(service, scanner);
                    break;
                    
                case 2:
                	createProduct(service, scanner);
                	break;
                	
                case 3:
                	listofproducts(service, scanner);
                	break;
                    
                case 4:
                	createOrder(service, scanner);
                	break;
                	
                case 5:
                	cancelOrder(service, scanner);
                	break;
                	
                case 6:
                	getorderbyuser(service, scanner);
                	break;
                	
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                	
                default:
                    System.out.println("Invalid choice");
            }
        }

	}



	private static void listofproducts(IOrderService service, Scanner scanner) {
		
//		System.out.print("Enter Product ID: ");
//		int productId = scanner.nextInt();
		List<Product> products = service.getAllProducts();
		if (products.isEmpty()) {
		    System.out.println("No products found.");
		} else {
		    for (Product product : products) {
		        System.out.println("ID: " + product.getProductId() +
		                           ", Name: " + product.getProductName() +
		                           ", Price: " + product.getPrice() +
		                           ", Quantity: " + product.getQuantityInStock());
		    }
		}
		
	}
	
	private static void getorderbyuser(IOrderService service, Scanner scanner) throws Exception {
//		System.out.print("Enter Order ID: ");
//		int orderId = scanner.nextInt();
		List<OrderTable> order = service.getOrderByUser(null);
		
		if (order.isEmpty()) {
		    System.out.println("No products found.");
		} else {
		    for (OrderTable orders : order) {
		        System.out.println("Order ID: " + orders.getOrderId() +
		                           ", Product ID: " + orders.getProductId() +
		                           ", User ID " + orders.getUserId());
		    }
		}
		
		
	}

	private static void createProduct(IOrderService service, Scanner scanner) throws Exception {
		Product product = new Product();
		System.out.print("Enter product Id: ");
		int productId = scanner.nextInt();
        product.setProductId(productId);
        
        System.out.print("Enter product Name: ");
		String productName = scanner.next();
        product.setProductName(productName);
        
        System.out.print("Enter description: ");
		String description = scanner.next();
        product.setDescription(description);
        
        System.out.print("Enter price: ");
		Double price = scanner.nextDouble();
        product.setPrice(price);
        
        System.out.print("Enter QuantityInStock: ");
		int quantityInStock = scanner.nextInt();
        product.setQuantityInStock(quantityInStock);
        
        
        System.out.print("Enter type: ");
		String type = scanner.next();
        product.setType(type);
        
        if (service.createProduct(product)) {
            System.out.println("product added successfully.");
        } else {
            System.out.println("Failed to add product.");
        }
		
		
	}

	private static void createUser(IOrderService service, Scanner scanner) {
		
		User user = new User();
		
		System.out.print("Enter User Id: ");
        int userId = scanner.nextInt();
        user.setUserId(userId);
        
        System.out.print("Enter User Name: ");
        String userName = scanner.next();
        user.setUsername(userName);
        
        
        System.out.print("Enter Password: ");
        String password = scanner.next();
        user.setPassword(password); 
        
        System.out.print("Enter role: ");
        String role = scanner.next();
        user.setRole(role); 
        
        if (service.createUser(user)) {
            System.out.println("user added successfully.");
        } else {
            System.out.println("Failed to add user.");
        }
		
	}
	
	private static void createOrder(IOrderService service, Scanner scanner) throws Exception {
		OrderTable order = new OrderTable();
		
		System.out.println("Enter Order id: ");
		int orderId = scanner.nextInt();
		order.setOrderId(orderId);
		
		System.out.println("Enter Product id: ");
		int productId = scanner.nextInt();
		order.setProductId(productId);
		
		System.out.println("Enter user id: ");
		int userId = scanner.nextInt();
		order.setUserId(userId);
		
		if (service.createOrder(order)) {
            System.out.println("order added successfully.");
        } else {
            System.out.println("Failed to add order.");
        }
		
	}
	
	private static void cancelOrder(IOrderService service, Scanner scanner) throws Exception {
		System.out.print("Enter Order ID to delete: ");
	    int orderId = scanner.nextInt();

	    if (service.cancelOrder(orderId)) {
	        System.out.println("order deleted successfully.");
	    } else {
	        System.out.println("Failed to delete order. Ensure the ID is correct.");
	    }
		
		
	}


}

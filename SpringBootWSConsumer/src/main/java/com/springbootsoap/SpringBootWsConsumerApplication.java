package com.springbootsoap;

import allapis.springbootsoap.com.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWsConsumerApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(ProductClient productClient){
		return args -> {
			ProductInfo productInfo;
			ServiceStatus serviceStatus;

//			// get product by id
//			System.out.println("--- Get Product by Id ---");
//			GetProductByIdResponse productByIdResponse = productClient.getProductById(1);
//			productInfo = productByIdResponse.getProductInfo();
//			System.out.println(productInfo.getProductId() + ", "+ productInfo.getName()
//					+ ", " + productInfo.getPrice()+", "+ productInfo.getQuantity());

			// get all product
			System.out.println("---Get all Product---");
			GetAllProductsResponse allProductsResponse = productClient.getAllProducts();
			allProductsResponse.getProductInfo().stream()
					.forEach(e -> System.out.println(e.getProductId() + ", "+ e.getName() + ", "
							+ e.getPrice() +", "+ e.getQuantity()));


//			// Add Product
//			System.out.println("--- Add Product ---");
//			String name = "Plane";
//			int price = 20000;
//			int quantity = 5;
//			AddProductResponse addProductResponse = productClient.addProduct(name, price, quantity);
//			//productInfo.getName(), productInfo.getPrice(), productInfo.getQuantity()
//			productInfo = addProductResponse.getProductInfo();
//			if (productInfo != null) {
//				System.out.println(productInfo.getProductId() + ", "+ productInfo.getName()
//						+ ", " + productInfo.getPrice() +", "+ productInfo.getQuantity());
//			}
//			serviceStatus = addProductResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatus() +
//					", Message: " + serviceStatus.getMessage());


//			// Update Product
//			System.out.println("--- Update Product ---");
//			productInfo = new ProductInfo();
//			productInfo.setProductId(4);
//			productInfo.setName("train");
//			productInfo.setPrice(15000);
//			productInfo.setQuantity(10);
//			UpdateProductResponse updateProductResponse = productClient.updateProduct(productInfo);
//			serviceStatus = updateProductResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatus() +
//					", Message: " + serviceStatus.getMessage());

//			// Delete Product
//			System.out.println("--- Delete Product ---");
//			long productId = 7;
//			DeleteProductResponse deleteArticleResponse = productClient.deleteProduct(productId);
//			serviceStatus = deleteArticleResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatus() +
//					", Message: " + serviceStatus.getMessage());
		};
	}

}

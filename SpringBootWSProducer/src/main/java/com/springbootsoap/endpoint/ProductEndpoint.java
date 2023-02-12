package com.springbootsoap.endpoint;

import allapis.springbootsoap.com.*;
import com.springbootsoap.model.Product;
import com.springbootsoap.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://com.springbootsoap.allapis";
    @Autowired
    private ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts() {
        GetAllProductsResponse response = new GetAllProductsResponse();
        List<ProductInfo> productInfoList = new ArrayList<>();
        List<Product> productList = productService.getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            ProductInfo ob = new ProductInfo();
            BeanUtils.copyProperties(productList.get(i), ob);
            productInfoList.add(ob);
        }
        response.getProductInfo().addAll(productInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProductRequest")
    @ResponsePayload
    public AddProductResponse addProduct(@RequestPayload AddProductRequest request) {
        AddProductResponse response = new AddProductResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(product, productInfo);
        productService.addProduct(product);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProduct(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productService.getProductById(request.getProductId()), productInfo);
        response.setProductInfo(productInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    @ResponsePayload
    public UpdateProductResponse updateProduct(@RequestPayload UpdateProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request.getProductInfo(), product);
        productService.updateProduct(product);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateProductResponse response = new UpdateProductResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    public DeleteProductResponse deleteProduct(@RequestPayload DeleteProductRequest request) {
        productService.deleteProduct(request.getProductId());
        ServiceStatus serviceStatus = new ServiceStatus();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Deleted Successfully");
        DeleteProductResponse response = new DeleteProductResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}

package com.springbootsoap;

import allapis.springbootsoap.com.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;



public class ProductClient extends WebServiceGatewaySupport {

    public GetProductByIdResponse getProductById(long productId) {
        GetProductByIdRequest request = new GetProductByIdRequest();
        request.setProductId(productId);
        GetProductByIdResponse response = (GetProductByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/allService/getProductByIdRequest"));
        return response;
    }

    public GetAllProductsResponse getAllProducts() {
        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = (GetAllProductsResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/allService/getAllProductsRequest"));
        return response;
    }
    public AddProductResponse addProduct(String name, int price, int quantity) {
        AddProductRequest request = new AddProductRequest();
        request.setName(name);
        request.setPrice(price);
        request.setQuantity(quantity);
        AddProductResponse response = (AddProductResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/allService/addProductRequest"));
        return response;
    }
    public UpdateProductResponse updateProduct(ProductInfo productInfo) {
        UpdateProductRequest request = new UpdateProductRequest();
        request.setProductInfo(productInfo);
        UpdateProductResponse response = (UpdateProductResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/allService/updateProductRequest"));
        return response;
    }
    public DeleteProductResponse deleteProduct(long productId) {
        DeleteProductRequest request = new DeleteProductRequest();
        request.setProductId(productId);
        DeleteProductResponse response = (DeleteProductResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/allService/deleteProductRequest"));
        return response;
    }
}

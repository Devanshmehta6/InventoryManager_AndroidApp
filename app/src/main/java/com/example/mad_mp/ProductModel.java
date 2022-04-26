package com.example.mad_mp;

public class ProductModel {
    private String productName;
    private String productQuantity;
    private int id;

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductQuantity(){
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity){
        this.productQuantity = productQuantity;
    }

    public int getId(){
        return id;
    }

    public ProductModel(String productName, String productQuantity){
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

}

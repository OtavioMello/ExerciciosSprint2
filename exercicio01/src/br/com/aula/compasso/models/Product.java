package br.com.aula.compasso.models;

public class Product {

    private Integer productID;
    private String productName;
    private String productDescription;
    private Integer productAmount;
    private double productPrice;

    //Constructor method.
    public Product(String inputProductName, String inputProductDescription,
                   Integer inputProductAmount, double inputProductPrice){

        this.productName = inputProductName;
        this.productDescription = inputProductDescription;
        this.productAmount = inputProductAmount;
        this.productPrice = inputProductPrice;
    }

    //Getters and Setters
    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public double getProductPrice() {
        return productPrice;
    }
}

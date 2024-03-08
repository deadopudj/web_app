package org.example;

import java.util.Date;

public class Sale {
    private int saleId;
    private int buyerId;
    private int productId;
    private int quantitySold;
    private Date saleDate;
    private int quantity;

    public Sale(int productId, int buyerId, int quantity) {
    }

    public Sale(int buyerId, int productId, int quantitySold, Date saleDate) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantitySold = quantity;
        this.saleDate = new Date();
        this.quantity = quantity;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public int getQuantity() {
        return quantity;
    }
}


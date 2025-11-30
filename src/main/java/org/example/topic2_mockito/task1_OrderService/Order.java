package org.example.topic2_mockito.task1_OrderService;

public class Order {
    private String productId;
    private int quantity;
    private double pricePerUnit;

    public Order(String productId, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double calculateTotalPrice() {
        return quantity * pricePerUnit;
    }
}

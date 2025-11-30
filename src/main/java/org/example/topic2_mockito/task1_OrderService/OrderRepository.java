package org.example.topic2_mockito.task1_OrderService;

public class OrderRepository {
    public void saveOrder(Order order) {
        // Заглушка для сохранения заказа в БД
        System.out.println("Заказ сохранен: " + order.getProductId());
    }
}
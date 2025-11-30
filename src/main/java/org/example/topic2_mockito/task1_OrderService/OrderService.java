package org.example.topic2_mockito.task1_OrderService;

public class OrderService {
    private InventoryService inventoryService;
    private OrderRepository orderRepository;

    public OrderService(InventoryService inventoryService, OrderRepository orderRepository) {
        this.inventoryService = inventoryService;
        this.orderRepository = orderRepository;
    }

    public boolean processOrder(Order order) {
        if (inventoryService.isProductAvailable(order.getProductId(), order.getQuantity())) {
            orderRepository.saveOrder(order);
            return true;
        }
        return false;
    }
}
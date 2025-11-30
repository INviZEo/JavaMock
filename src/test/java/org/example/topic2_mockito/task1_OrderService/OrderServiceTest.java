package org.example.topic2_mockito.task1_OrderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private InventoryService inventoryService;

    @Test
    @DisplayName("Возвращает true и успешно сохраняет заказ, когда товар в наличии")
    void whenProductInStock() {
        Order order = new Order("144", 1, 1500);
        when(inventoryService.isProductAvailable("144", 1)).thenReturn(true);

        boolean result = orderService.processOrder(order);

        Assertions.assertTrue(result);
        verify(inventoryService).isProductAvailable("144", 1);
        verify(orderRepository).saveOrder(order);
    }

    @Test
    @DisplayName("Возвращает false и не сохраняет заказ, когда товара нет в наличии")
    void whenProductOutOfStock() {
        Order order = new Order("231", 0, 2300);
        when(inventoryService.isProductAvailable("231", 0)).thenReturn(false);

        boolean result = orderService.processOrder(order);

        Assertions.assertFalse(result);
        verify(inventoryService).isProductAvailable("231", 0);
        verify(orderRepository, Mockito.never()).saveOrder(order);
    }
}
package app.service;

import app.model.Category;
import app.model.Order;
import app.model.OrderStatus;
import app.storage.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void addOrder() {
        Order order1 = new Order(1,1,1,"2021-10-10",1, OrderStatus.APPROVED,true);
        Order save = orderRepository.save(order1);
        assertEquals(order1,save);
    }

    @Test
    void getOrderById() {
        Order order1 = new Order(1,1,1,"2021-10-10",1, OrderStatus.APPROVED,true);
        orderRepository.save(order1);
        orderRepository.getOne(1L);

    }

    @Test
    void deleteOrderById() {
        Order order1 = new Order(1,1,1,"2021-10-10",1, OrderStatus.APPROVED,true);
        orderRepository.save(order1);
        orderRepository.deleteById(1L);
        orderRepository.findById(1L);
    }
}
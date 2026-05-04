package com.orderms.config;

import com.orderms.entity.Order;
import com.orderms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample orders
        Order order1 = new Order();
        order1.setCustomerName("Rajesh Kumar");
        order1.setEmail("rajesh@example.com");
        order1.setPhone("9876543210");
        order1.setProduct("Laptop");
        order1.setQuantity(1);
        order1.setUnitPrice(new BigDecimal("50000"));
        order1.setTotalPrice(new BigDecimal("50000"));
        order1.setStatus(Order.OrderStatus.CONFIRMED);
        order1.setShippingAddress("123 Main St, Delhi");

        Order order2 = new Order();
        order2.setCustomerName("Priya Singh");
        order2.setEmail("priya@example.com");
        order2.setPhone("9876543211");
        order2.setProduct("Mouse");
        order2.setQuantity(5);
        order2.setUnitPrice(new BigDecimal("500"));
        order2.setTotalPrice(new BigDecimal("2500"));
        order2.setStatus(Order.OrderStatus.SHIPPED);
        order2.setShippingAddress("456 Oak Ave, Mumbai");

        Order order3 = new Order();
        order3.setCustomerName("Amit Patel");
        order3.setEmail("amit@example.com");
        order3.setPhone("9876543212");
        order3.setProduct("Keyboard");
        order3.setQuantity(2);
        order3.setUnitPrice(new BigDecimal("2000"));
        order3.setTotalPrice(new BigDecimal("4000"));
        order3.setStatus(Order.OrderStatus.PENDING);
        order3.setShippingAddress("789 Pine Rd, Bangalore");

        // Save orders
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        System.out.println("Sample orders initialized successfully!");
    }
}

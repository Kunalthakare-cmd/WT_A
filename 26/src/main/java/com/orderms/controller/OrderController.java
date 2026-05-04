package com.orderms.controller;

import com.orderms.entity.Order;
import com.orderms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Create a new order
     * POST /api/orders
     */
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    /**
     * Get all orders
     * GET /api/orders
     */
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Get order by ID
     * GET /api/orders/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("Order not found with id: " + id),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get orders by customer name
     * GET /api/orders/customer/{customerName}
     */
    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<Order>> getOrdersByCustomerName(@PathVariable String customerName) {
        List<Order> orders = orderService.getOrdersByCustomerName(customerName);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Get orders by status
     * GET /api/orders/status/{status}
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getOrdersByStatus(@PathVariable String status) {
        try {
            Order.OrderStatus orderStatus = Order.OrderStatus.valueOf(status.toUpperCase());
            List<Order> orders = orderService.getOrdersByStatus(orderStatus);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    new ErrorResponse("Invalid status: " + status),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Update an order
     * PUT /api/orders/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(id, orderDetails);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("Order not found with id: " + id),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete an order
     * DELETE /api/orders/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            return new ResponseEntity<>(
                    new SuccessResponse("Order deleted successfully"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("Order not found with id: " + id),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete all orders
     * DELETE /api/orders
     */
    @DeleteMapping
    public ResponseEntity<SuccessResponse> deleteAllOrders() {
        orderService.deleteAllOrders();
        return new ResponseEntity<>(
                new SuccessResponse("All orders deleted successfully"),
                HttpStatus.OK);
    }

    // Inner class for error responses
    public static class ErrorResponse {
        public String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // Inner class for success responses
    public static class SuccessResponse {
        public String message;

        public SuccessResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}

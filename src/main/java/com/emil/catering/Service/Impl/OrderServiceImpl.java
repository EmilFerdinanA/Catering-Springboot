package com.emil.catering.Service.Impl;

import com.emil.catering.Dto.Request.OrderRequest;
import com.emil.catering.Entity.Order;
import com.emil.catering.Repository.OrderRepository;
import com.emil.catering.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order create(OrderRequest order) {
        try {
            String id = UUID.randomUUID().toString();
            String name = order.getName();
            String phone = order.getPhone();
            Date orderDate = order.getOrderDate();
            Date orderForDate = order.getOrderForDate();
            LocalTime time = LocalTime.parse(order.getTime());
            Integer qty = order.getQty();
            String note = order.getNote();
            orderRepository.createOrder(id, name, phone, orderDate, orderForDate, time, qty, note);
            return Order.builder()
                    .id(id)
                    .name(name)
                    .phone(phone)
                    .orderDate(orderDate)
                    .orderForDate(orderForDate)
                    .time(time)
                    .qty(qty)
                    .note(note)
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "failed to create order");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order update(OrderRequest order) {
        orderRepository.findOrder(order.getId());

        String id = order.getId();
        String name = order.getName();
        String phone = order.getPhone();
        Date orderDate = order.getOrderDate();
        Date orderForDate = order.getOrderForDate();
        LocalTime time = LocalTime.parse(order.getTime());
        Integer qty = order.getQty();
        String note = order.getNote();
        orderRepository.updateOrder(id, name, phone, orderDate, orderForDate, time, qty, note);
        return Order.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .orderDate(orderDate)
                .orderForDate(orderForDate)
                .time(time)
                .qty(qty)
                .note(note)
                .build();
    }

    @Override
    public Order findById(String id) {
        return orderRepository.findOrder(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "failed to find order"));
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAllOrder();
        return orders;
    }
}

package tech.savchenko.orders.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.savchenko.orders.persistence.OrderEntity;
import tech.savchenko.orders.persistence.OrderRepository;

import java.util.List;

@Service
public class OrderProcessor {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Mapper mapper;

    public OrderProcessor(OrderRepository orderRepository, Mapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public void processOrder(Order order) {
        OrderEntity orderEntity = switch (order) {
            case ClientOrder clientOrder -> mapper.mapToEntity(clientOrder);
            case GuestOrder guestOrder -> mapper.mapToEntity(guestOrder);
        };
        orderRepository.save(orderEntity);
    }

    public List<Order> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntities.stream().map(mapper::mapToDto).toList();
    }

}

package tech.savchenko.orders.controller;

public record ClientOrder(String orderDetails, String deliveryDetails, Long clientId) implements Order {
}

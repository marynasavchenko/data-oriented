package tech.savchenko.orders.controller;

public record GuestOrder(String orderDetails, String deliveryDetails) implements Order {
}

package tech.savchenko.orders.controller;

public record ClientOrder(String orderDetails, String deliveryDetails, Long clientId) implements Order {
    public ClientOrder {
        var clientIdStr = String.valueOf(clientId);
        if (clientIdStr.length() > 10 || clientIdStr.length() < 3) {
            throw new IllegalArgumentException("clientId must be no more than 10 and no less than 3 digits long");
        }
    }
}

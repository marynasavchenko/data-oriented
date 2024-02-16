package tech.savchenko.orders.controller;

import org.springframework.stereotype.Component;
import tech.savchenko.orders.persistence.ClientOrderEntity;
import tech.savchenko.orders.persistence.GuestOrderEntity;
import tech.savchenko.orders.persistence.OrderEntity;

@Component
public class Mapper {

    public OrderEntity mapToEntity(Order order) {
        return switch (order) {
            case ClientOrder clientOrder -> mapToEntity(clientOrder);
            case GuestOrder guestOrder -> mapToEntity(guestOrder);
        };
    }

    public Order mapToDto(OrderEntity entity) {
        return switch (entity) {
            case ClientOrderEntity clientOrderEntity -> map(clientOrderEntity);
            case GuestOrderEntity guestOrderEntity -> map(guestOrderEntity);
            case null, default -> throw new OrderNotFoundException();
        };
    }

    private Order map(ClientOrderEntity clientOrder) {
        return new ClientOrder(clientOrder.getOrderDetails(), clientOrder.getDeliveryDetails(), clientOrder.getClientId());
    }

    private Order map(GuestOrderEntity guestOrder) {
        return new GuestOrder(guestOrder.getOrderDetails(), guestOrder.getDeliveryDetails());
    }

    private OrderEntity mapToEntity(GuestOrder toMap) {
        return new GuestOrderEntity(toMap.orderDetails(), toMap.deliveryDetails());
    }

    private OrderEntity mapToEntity(ClientOrder toMap) {
        return new ClientOrderEntity(toMap.clientId(), toMap.orderDetails(), toMap.deliveryDetails());
    }
}

package tech.savchenko.orders.persistence;

import jakarta.persistence.Entity;

@Entity
public class GuestOrderEntity extends OrderEntity {

    private String orderDetails;
    private String deliveryDetails;

    public GuestOrderEntity() {
    }

    public GuestOrderEntity(String orderDetails, String deliveryDetails) {
        this.orderDetails = orderDetails;
        this.deliveryDetails = deliveryDetails;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }
}

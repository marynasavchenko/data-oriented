package tech.savchenko.orders.persistence;

import jakarta.persistence.Entity;

@Entity
public class ClientOrderEntity extends OrderEntity {

    private Long clientId;
    private String orderDetails;
    private String deliveryDetails;

    public ClientOrderEntity() {
    }

    public ClientOrderEntity(Long clientId, String orderDetails, String deliveryDetails) {
        this.clientId = clientId;
        this.orderDetails = orderDetails;
        this.deliveryDetails = deliveryDetails;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }
}

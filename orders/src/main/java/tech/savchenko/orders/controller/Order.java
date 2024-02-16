package tech.savchenko.orders.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClientOrder.class, name = "ClientOrder"),
        @JsonSubTypes.Type(value = GuestOrder.class, name = "GuestOrder")
})
public sealed interface Order permits ClientOrder, GuestOrder {
}

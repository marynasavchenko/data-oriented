package tech.savchenko.orders.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientOrderTest {

    @Test
    void validClientIdTest() {
        assertDoesNotThrow(() -> new ClientOrder("Order details", "Delivery details", 1234567L), "Should not throw an exception for a valid clientId length.");
    }

    @Test
    void clientIdTooShortTest() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new ClientOrder("Order details", "Delivery details", 12L), "Should throw an exception for clientId being too short.");
        assertEquals("clientId must be no more than 10 and no less than 3 digits long", thrown.getMessage());
    }

    @Test
    void clientIdTooLongTest() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new ClientOrder("Order details", "Delivery details", 12345678901L), "Should throw an exception for clientId being too long.");
        assertEquals("clientId must be no more than 10 and no less than 3 digits long", thrown.getMessage());
    }

}
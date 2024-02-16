package tech.savchenko.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.savchenko.orders.controller.ClientOrder;
import tech.savchenko.orders.controller.GuestOrder;
import tech.savchenko.orders.controller.Order;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    public void testCreateClientOrder() {
        final String baseUrl = "http://localhost:" + port + "/orders";
        Order clientOrder = new ClientOrder("Order details client", "Adress client", 123L);

        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, clientOrder, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void testCreateGuestOrder() {
        final String baseUrl = "http://localhost:" + port + "/orders";
        Order guestOrder = new GuestOrder("Order details guest", "Adress guest");

        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, guestOrder, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void getOrders() {
        final String baseUrl = "http://localhost:" + port + "/orders";

        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
}

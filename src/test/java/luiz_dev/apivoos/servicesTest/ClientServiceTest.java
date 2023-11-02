package luiz_dev.apivoos.servicesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.services.ClientService;

@SpringBootTest
public class ClientServiceTest {
    
    @Autowired
    private ClientService service;

    Client testClient = new Client(null, "Client For Test", "client@gmail.com", 90856743268L, LocalDate.of(2023, 10, 10));
    
    @Test
    private void clientMustIsAnAdult(){
        assertTrue(testClient.getAge());
    }
}

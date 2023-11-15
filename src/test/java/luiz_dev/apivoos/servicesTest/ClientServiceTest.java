package luiz_dev.apivoos.servicesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.exceptions.ObjectNotFoundException;
import luiz_dev.apivoos.model.repositories.ClientRepository;
import luiz_dev.apivoos.model.services.ClientService;

@SpringBootTest
class ClientServiceTest {
    
    @InjectMocks
    @Autowired
    private ClientService service;
    @Mock
    @Autowired
    private ClientRepository repository;

    Client testClient = new Client(null, "Client For Test", "client@gmail.com", 90856793262L, LocalDate.of(2023, 10, 10));

    Client testClient2 = new Client(null, "Client For Test 2", "client2@gmail.com", 55563315172L, LocalDate.of(1997, 10, 10));
    
    @Test
    void mustBeAdult(){
        // Verifica se o cliente é um adulto
        assertFalse(testClient.getIfIsAnAdult());
    }

    @Test
    void mustSaveOneClient(){
        // Verifica se um cliente está sendo salvo no banco de dados
        Client result = service.insertClient(testClient);
        assertNotNull(result);
        assertEquals(testClient, result);
    }

    @Test
    void mustReturnClient(){
        // Verifica se os métodos que retornam clientes funcionam
        Client goodResult = service.searchClientById(4L);
        assertNotNull(goodResult);
        assertSame(Client.class, goodResult.getClass());
    }

    @Test
    void mustReturnNotFoundException(){
        // Verifica se há o devido tratamento de exceções para um usuário não encontrado
        assertThatExceptionOfType(ObjectNotFoundException.class).isThrownBy(() -> service.searchClientById(89L));
    }

    @Test
    void mustDeleteClient(){
        // Insere e deleta um usuário de teste
        service.insertClient(testClient2);
        Long deletedId = service.deleteClientById(5L);
        // Garante que um cliente foi realmente deletado do banco de dados
         assertThatExceptionOfType(ObjectNotFoundException.class).isThrownBy(() -> service.searchClientById(deletedId));
    }
}

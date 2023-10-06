package luiz_dev.apivoos.model.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.repositories.ClientRepository;

@Configuration
public class DataBaseConfig implements CommandLineRunner{

    @Autowired
    private ClientRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client(null, "Client 1", "client1@gmail.com", 90856743268L, LocalDate.of(1985, 10, 10));
        Client c2 = new Client(null, "Client 2", "client2@gmail.com", 96425562715L, LocalDate.of(1995, 9, 17));

        repository.saveAll(Arrays.asList(c1, c2));
    }
    
}

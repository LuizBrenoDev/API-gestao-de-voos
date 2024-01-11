package luiz_dev.apivoos.model.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import luiz_dev.apivoos.model.domain.Airplane;
import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.domain.Flight;
import luiz_dev.apivoos.model.repositories.ClientRepository;
import luiz_dev.apivoos.model.repositories.FlightRepository;

@Configuration
public class DataBaseConfig implements CommandLineRunner{

    @Autowired
    private ClientRepository repository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        repository.flush();
        flightRepository.flush();

        Client c1 = new Client(null, "Client 1", "client1@gmail.com",  90856743268L, LocalDate.of(1985, 10, 10));
        Client c2 = new Client(null, "Client 2", "client2@gmail.com", 96425562715L, LocalDate.of(1995, 9, 17));
        Client c3 = new Client(null, "Client 3", "client3@gmail.com", 45567445199L, LocalDate.of(1985, 10, 10));
        Client c4 = new Client(null, "Client 4", "client4@gmail.com", 8877442143L, LocalDate.of(1995, 9, 17));

        repository.saveAll(Arrays.asList(c1, c2, c3, c4));

        Flight f1 = new Flight(null, "Incrível voo para a Disney", "Parque da Disney, California, EUA","Uma Incrível viagem para a Disney!!", new HashSet<>(Arrays.asList(c1, c2)), new Airplane(123L, "Airplane 123", "Secure Flights", 150, 30.0));
        Flight f2 = new Flight(null, "Incrível voo para o Parque da Universal", "Parque da Universal, EUA","Uma maravilhosa viagem ao parque da universal!!", new HashSet<>(Arrays.asList(c3, c4)), new Airplane(335L, "Airplane 335", "Secure Flights", 200, 40.0));

        flightRepository.saveAll(Arrays.asList(f1, f2));
    }
    
}

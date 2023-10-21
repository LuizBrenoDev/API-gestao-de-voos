package luiz_dev.apivoos.model.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz_dev.apivoos.model.domain.Flight;
import luiz_dev.apivoos.model.repositories.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    private FlightRepository repository;

    public List<Flight> searchAllFlights(){
        return repository.findAll();
    }

    public Flight searchById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ERROR: Client Not Found"));
    }

    public Flight insertFlight(Flight flight){
        return repository.save(flight);
    }

    public Long deleteFlight (Long id){
        Flight f = repository.findById(id).orElseThrow(
           () -> new RuntimeException("ERROR: Flight not Found")
        );
        
        if (f != null){
            repository.deleteById(id);
            return id;
        }else{
            throw new RuntimeException("ERROR: Flight not be null");
        }
    }
}

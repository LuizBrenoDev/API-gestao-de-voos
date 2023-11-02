package luiz_dev.apivoos.model.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz_dev.apivoos.model.domain.Flight;
import luiz_dev.apivoos.model.exceptions.ObjectNotFoundException;
import luiz_dev.apivoos.model.repositories.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    private FlightRepository repository;

    public List<Flight> searchAllFlights(){
        return repository.findAll();
    }

    public Flight searchById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Flight Not Found. Try modify the id in URI."));
    }

    public List<Flight> searchByDestiny(String destiny){
        List<Flight> flights = repository.findByDestiny(destiny);
        if (flights.isEmpty() == true) {
            throw new ObjectNotFoundException("Flight Not Found. Try modify the destiny in URI.");
        }else{
            return flights;
        }
    }

    public Flight insertFlight(Flight flight){
        return repository.save(flight);
    }

    public Long deleteFlight (Long id){
        Flight f = repository.findById(id).orElseThrow(
           () -> new ObjectNotFoundException("Flight not Found. Try modify the id in URI.")
        );
        
        if (f != null){
            repository.deleteById(id);
            return id;
        }else{
            throw new ObjectNotFoundException("The Flight founded is null");
        }
    }
}

package luiz_dev.apivoos.model.domain.dto;

import java.util.Set;

import jakarta.persistence.Embedded;
import luiz_dev.apivoos.model.domain.Airplane;
import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.domain.Flight;

public record FlightDTO(
    Long id,
    String name,
    String destiny,
    Set<Client> passengers,
    @Embedded
    Airplane airplane
) {
    
    public Flight toFlight(){
        return new Flight(this.id, this.name, this.destiny, this.passengers, this.airplane);
    }
}

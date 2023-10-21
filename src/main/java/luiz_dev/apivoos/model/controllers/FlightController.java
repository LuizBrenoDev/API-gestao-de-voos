package luiz_dev.apivoos.model.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luiz_dev.apivoos.model.domain.Flight;
import luiz_dev.apivoos.model.domain.dto.FlightDTO;
import luiz_dev.apivoos.model.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
    
    @Autowired
    private FlightService service;

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> searchFlightById(@PathVariable Long id){
        FlightDTO dto = service.searchById(id).toDTO();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> searchAllFlights(){
        List<Flight> flights = service.searchAllFlights();
        List<FlightDTO> dtos = flights.stream()
                            .map(f -> f.toDTO())
                            .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/admin/create_flight")
    public ResponseEntity<Long> insertFlight(@RequestBody FlightDTO dto){
        Flight flight = dto.toFlight();
        service.insertFlight(flight);
        return ResponseEntity.ok().body(flight.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(Long id){
        service.deleteFlight(id);
        return ResponseEntity.ok().body("Flight deleted. id = " + id);
    }
}

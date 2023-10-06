package luiz_dev.apivoos.model.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<FlightDTO>> searchAllClients(){
        List<Flight> flights = service.searchAllFlights();
        List<FlightDTO> dtos = flights.stream()
                            .map(f -> f.toDTO())
                            .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}

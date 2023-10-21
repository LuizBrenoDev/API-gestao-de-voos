package luiz_dev.apivoos.model.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.domain.dto.ClientDTO;
import luiz_dev.apivoos.model.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    
    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> searchAllClients(){
        List<Client> clients = service.searchAllClients();
        List<ClientDTO> dtos = clients.stream()
                                    .map(c -> c.toDTO())
                                    .collect(Collectors.toList());


        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> searchClientById(@PathVariable Long id){
        ClientDTO c = service.searchClientById(id).toDTO();
        return ResponseEntity.ok().body(c);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO dto){
        Client c = dto.toClient();
        Client newClient = service.insertClient(c);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.ok().body(newClient.toDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id){
        service.deleteClientById(id);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody ClientDTO dto){
        Client c = dto.toClient();
        String msg = service.updateClientById(id, c);
        return ResponseEntity.ok().body(msg);
    }

}

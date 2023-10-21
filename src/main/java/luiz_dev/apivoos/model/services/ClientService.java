package luiz_dev.apivoos.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz_dev.apivoos.model.domain.Client;
import luiz_dev.apivoos.model.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    // Insert Client
    public Client insertClient(Client client){
        return repository.save(client);
    }

    public List<Client> searchAllClients(){
        return repository.findAll();
    }

    // Find Client By Id
    public Client searchClientById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ERROR: Client not found"));
    }

    //Delete Client By Id
    public Long deleteClientById(Long id){
        Client c = repository.findById(id).orElseThrow(() -> new RuntimeException("ERROR: Client not found"));
        if(c != null){
            repository.delete(c);
            return id;
        }else{
            throw new RuntimeException("ERROR: Client not found");
        }
    }

    //Update Client By Id
    public String updateClientById(Long id, Client newClient){
        Client c = repository.findById(id).orElseThrow(() -> new RuntimeException("ERROR: Client not found"));
        if(c != null){
           repository.delete(c);
           repository.save(newClient);
           return "Client updated!! id =" + newClient.getId();
        }else{
            throw new RuntimeException("ERROR: Client not found");
        }
    }
}

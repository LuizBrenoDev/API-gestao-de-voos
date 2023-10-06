package luiz_dev.apivoos.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luiz_dev.apivoos.model.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}

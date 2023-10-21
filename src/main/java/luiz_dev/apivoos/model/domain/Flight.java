package luiz_dev.apivoos.model.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import luiz_dev.apivoos.model.domain.dto.FlightDTO;

@Entity
@Table(name = "flights")
public class Flight implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 50)
    private String destiny;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Client> passengers = new HashSet<>();
    @Embedded
    private Airplane airplane;

    

    public Flight(Long id, String name, String destiny, Set<Client> passengers, Airplane airplane) {
        this.id = id;
        this.name = name;
        this.destiny = destiny;
        this.passengers = passengers;
        this.airplane = airplane;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDestiny() {
        return destiny;
    }
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public void addPassenger(Client client){
        passengers.add(client);
    }
    public void removePassenger(Client client){
        passengers.remove(client);
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public FlightDTO toDTO(){
        return new FlightDTO(this.id, this.name, this.destiny, this.passengers, this.airplane);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((destiny == null) ? 0 : destiny.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (destiny == null) {
            if (other.destiny != null)
                return false;
        } else if (!destiny.equals(other.destiny))
            return false;
        return true;
    }

    
    
}

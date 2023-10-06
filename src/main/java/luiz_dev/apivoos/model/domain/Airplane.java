package luiz_dev.apivoos.model.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Airplane implements Serializable{

    private Long airplane_id;
    private String model;
    private String company;
    private Integer capacity;
    private Double velocity;

    
    public Airplane(Long airplane_id, String model, String company, Integer capacity, Double velocity) {
        this.airplane_id = airplane_id;
        this.model = model;
        this.company = company;
        this.capacity = capacity;
        this.velocity = velocity;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public Integer getCapacity() {
        return capacity;
    }


    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public Double getVelocity() {
        return velocity;
    }


    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((airplane_id == null) ? 0 : airplane_id.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
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
        Airplane other = (Airplane) obj;
        if (airplane_id == null) {
            if (other.airplane_id != null)
                return false;
        } else if (!airplane_id.equals(other.airplane_id))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        return true;
    }

    

}

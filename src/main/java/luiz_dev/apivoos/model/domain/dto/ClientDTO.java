package luiz_dev.apivoos.model.domain.dto;

import java.time.LocalDate;

import luiz_dev.apivoos.model.domain.Client;

public record ClientDTO(
    Long id,
    String name,
    String email,
    Long cpf,
    LocalDate birthDate
) {

    public Client toClient(){
        return new Client(null, this.name, this.email, this.cpf, this.birthDate);
    }
}

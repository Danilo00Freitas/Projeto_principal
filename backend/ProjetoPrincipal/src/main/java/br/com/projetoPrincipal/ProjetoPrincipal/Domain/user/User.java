package br.com.projetoPrincipal.ProjetoPrincipal.Domain.user;

/*import br.com.projetoPrincipal.ProjetoPrincipal.Domain.address.Address;*/
import br.com.projetoPrincipal.ProjetoPrincipal.Domain.address.Address;
import br.com.projetoPrincipal.ProjetoPrincipal.dto.Register.RegisterRequestData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    @Embedded
    private Address address;

    /*//ACREDITO QUE NÃO SEJA NECESSÁRIO POIS COMO GERAMOS OS GETTERS E SETTERS, ESTAMOS UTILIZANDO ELES AO INVES DO CONSTRUTOR PARA GERAR A CLASSE NO AUTH CONTROLLER
    public User(RegisterRequestData registerRequestData){
        this.name = registerRequestData.name();
        this.email = registerRequestData.email();
        this.password = registerRequestData.password();
        this.address = new Address(registerRequestData.addressData());
    }*/
}

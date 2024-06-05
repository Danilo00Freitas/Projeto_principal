package br.com.projetoPrincipal.ProjetoPrincipal.Domain.address;

import br.com.projetoPrincipal.ProjetoPrincipal.dto.Address.AddressData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String zipCode;
    private String address;
    private String addressNumber;
    private String neighbourhood;
    private String city;
    private String state;

    public Address (AddressData addressData){
        this.zipCode = addressData.zipCode();
        this.address = addressData.address();
        this.addressNumber = addressData.addressNumber();
        this.neighbourhood = addressData.neighbourhood();
        this.city = addressData.city();
        this.state = addressData.state();
    }
}

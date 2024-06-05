package br.com.projetoPrincipal.ProjetoPrincipal.dto.Register;

import br.com.projetoPrincipal.ProjetoPrincipal.dto.Address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterRequestData(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "^\\d{11}$")
        String cellphone,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$")
        String password,
        @NotNull @Valid
        AddressData addressData
) {
}

package br.com.projetoPrincipal.ProjetoPrincipal.dto.Address;

import jakarta.validation.constraints.NotBlank;

public record AddressData(
        @NotBlank
        String zipCode,
        @NotBlank
        String address,
        String addressNumber,
        @NotBlank
        String neighbourhood,
        @NotBlank
        String city,
        @NotBlank
        String state
) {
}

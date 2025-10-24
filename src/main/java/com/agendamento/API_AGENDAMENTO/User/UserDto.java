package com.agendamento.API_AGENDAMENTO.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank String name,
        @Email(message = "Insira um email valido") @NotBlank String email,
        @NotBlank String department
) {
}

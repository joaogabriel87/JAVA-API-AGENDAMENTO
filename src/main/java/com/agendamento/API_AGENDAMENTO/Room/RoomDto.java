package com.agendamento.API_AGENDAMENTO.Room;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RoomDto(
        @NotBlank String room,
        @NotBlank @Email(message = "Insira um email valido") String emailUser
) {
}

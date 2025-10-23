package com.agendamento.API_AGENDAMENTO.Room;

import jakarta.validation.constraints.NotBlank;

public record RoomDto(
        @NotBlank String room
) {
}
